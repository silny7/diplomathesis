package silny7.uniba.sk.unity.statements;

import silny7.uniba.sk.unity.exceptions.IllegalProgramStateException;
import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.expressions.Expression;
import silny7.uniba.sk.unity.expressions.variables.Variable;
import silny7.uniba.sk.unity.program.UnityProgram;
import silny7.uniba.sk.unity.program.UnityProgramMemory;
import silny7.uniba.sk.unity.program.memory.MemoryCopy;
import silny7.uniba.sk.unity.program.memory.MemoryType;

import java.util.ArrayList;
import java.util.List;

public class Quantification {

    List<Variable> boundedVars;
    Expression booleanExpr;
    List<MemoryCopy> memorySnapshots = new ArrayList<MemoryCopy>();

    public Quantification(List<Variable> boundedVars, Expression boolExpr) {
        this.booleanExpr = boolExpr;
        this.boundedVars = boundedVars;
    }

    public void initVariables(){
        UnityProgramMemory memory = UnityProgram.getUnityProgram().getMemory();
        for (Variable var : boundedVars){
            memory.initBoundedVariable(var.getVariableName(), 0);
        }
    }

    public void evaluate() throws ProgramRunException {
        List<BoundedVariable> boundedVarsWithRanges = new ArrayList<BoundedVariable>();
        for (Variable variable : boundedVars){
            String variableName = variable.getVariableName();
            boundedVarsWithRanges.add(new BoundedVariable(variable.getVariableName(), searchVariableMinValue(variableName), searchVariableMaxValue(variableName)));
        }

        /**
         * one dimensional array with boundedVars.size()
         */
        int[] boundedVarsValues = new int[boundedVars.size()];
        createVarsValsCombs(boundedVarsWithRanges, boundedVarsValues, 0, memorySnapshots);
    }

    private void createVarsValsCombs(List<BoundedVariable> boundedVarsWithRanges, int[] boundedVarsValues, int currentVar, List<MemoryCopy> memorySnapshots) throws ProgramRunException {
        UnityProgramMemory memory = UnityProgram.getUnityProgram().getMemory();

        //we have been thru all boundedVars
        if (currentVar == boundedVars.size()){

            //set variableName -> boundedVarsWithRanges.get(varialbeIndex) = boundedVarsValues[variableIndex]
            for (int variableIndex = 0; variableIndex < boundedVarsValues.length; variableIndex++){
                String variableName = boundedVarsWithRanges.get(variableIndex).getVariableName();
                if (memory.isBoundedVariable(variableName)){
                    memory.setVariable(variableName, boundedVarsValues[variableIndex]);
                } else {
                    throw new IllegalProgramStateException("Bounded variable " + variableName + " accessed before initialization");
                }
                Boolean boolExpResult = (Boolean) booleanExpr.resolve();
                if (boolExpResult){
                    MemoryCopy memCopy = memory.createMemoryCopy(MemoryType.LOCAL);
                    memorySnapshots.add(memCopy);
                }
            }
        } else {
            //recursively combine combine current variable range with others
            BoundedVariable boundedVariable = boundedVarsWithRanges.get(currentVar);
            for (int varValue = boundedVariable.getVarMinValue(); varValue <= boundedVariable.getVarMaxValue(); varValue++){
                boundedVarsValues[currentVar] = varValue;
                createVarsValsCombs(boundedVarsWithRanges, boundedVarsValues, currentVar + 1, memorySnapshots);
            }
        }
    }

    public void destroyVariables(){
        UnityProgramMemory memory = UnityProgram.getUnityProgram().getMemory();
        for (Variable var : boundedVars) {
            memory.destroyBoundedVariable(var.getVariableName());
        }
    }

    public void destroy() {
        memorySnapshots.clear();
        destroyVariables();
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        boolean first = true;
        for (Variable var : boundedVars){
            if (!first) string.append(", ");
            else first = false;
            string.append(var.toString());
        }
        string.append(": ");
        string.append(booleanExpr.toString());
        return string.toString();
    }

    public List<MemoryCopy> getMemorySnapshots() {
        return memorySnapshots;
    }


    //TODO
    /**
     * @param variableName
     * @return maximum int value of variableName at which booleanExpr is satisfied
     */
    private int searchVariableMaxValue(String variableName) {
        return 50;
    }

    //TODO
    /**
     * @param variableName
     * @return minimum int value of variableName at which booleanExpr is satisfied
     */
    private int searchVariableMinValue(String variableName) {
        return -50;
    }

    /**
     * class holds information about variable
     * it's minimum value at which booleanExpression is satisfied
     * it's maximum value at which booleanExpression is satisfied
     */
    private class BoundedVariable{
        private String variableName;
        private int varMinValue;
        private int varMaxValue;

        public BoundedVariable(String variableName, int varMinValue, int varMaxValue) {
            this.variableName = variableName;
            this.varMinValue = varMinValue;
            this.varMaxValue = varMaxValue;
        }

        public String getVariableName() { return variableName; }
        public void setVariableName(String variableName) { this.variableName = variableName; }
        public int getVarMinValue() { return varMinValue; }
        public void setVarMinValue(int varMinValue) { this.varMinValue = varMinValue; }
        public int getVarMaxValue() { return varMaxValue; }
        public void setVarMaxValue(int varMaxValue) { this.varMaxValue = varMaxValue; }
    }
}
