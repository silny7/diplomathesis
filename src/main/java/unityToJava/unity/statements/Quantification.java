package unityToJava.unity.statements;

import unityToJava.unity.exceptions.IllegalProgramStateException;
import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.exceptions.UnsupportedOperationException;
import unityToJava.unity.expressions.Expression;
import unityToJava.unity.expressions.variables.Variable;
import unityToJava.unity.program.UnityProgramMemory;
import unityToJava.unity.program.configuration.Configuration;
import unityToJava.unity.program.memory.MemoryCopy;
import unityToJava.unity.program.memory.MemoryType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quantification {

    List<Variable> boundedVars;
    Expression booleanExpr;
    List<MemoryCopy> memorySnapshots = new ArrayList<MemoryCopy>();

    private volatile boolean evaluated = false;

    public Quantification(List<Variable> boundedVars, Expression boolExpr) {
        this.booleanExpr = boolExpr;
        this.boundedVars = boundedVars;
    }

    public void initVariables(){
        for (Variable var : boundedVars){
            UnityProgramMemory.getMemory().initBoundedVariable(var.getVariableName(), 0);
        }
    }

    public void evaluate() throws ProgramRunException {
        List<BoundedVariable> boundedVarsWithRanges = new ArrayList<BoundedVariable>();
        for (Variable variable : boundedVars){
            boundedVarsWithRanges.add(new BoundedVariable(variable.getVariableName(), searchVariableMinValue(), searchVariableMaxValue()));
        }

        /**
         * one dimensional array with boundedVars.size()
         */
        int[] boundedVarsValues = new int[boundedVars.size()];
        combineVariableValuesAndCheckBoolExpr(boundedVarsWithRanges, boundedVarsValues, 0, memorySnapshots);

        evaluated = true;
    }

    private void combineVariableValuesAndCheckBoolExpr(List<BoundedVariable> boundedVarsWithRanges, int[] boundedVarsValues, int currentVar, List<MemoryCopy> memorySnapshots) throws ProgramRunException {

        //we have been thru all boundedVars
        if (currentVar == boundedVars.size()){

            //set variableName -> boundedVarsWithRanges.get(varialbeIndex) = boundedVarsValues[variableIndex]
            for (int variableIndex = 0; variableIndex < boundedVarsValues.length; variableIndex++){
                String variableName = boundedVarsWithRanges.get(variableIndex).getVariableName();
                if (UnityProgramMemory.getMemory().isBoundedVariable(variableName)){
                    UnityProgramMemory.getMemory().setVariable(variableName, boundedVarsValues[variableIndex]);
                } else {
                    throw new IllegalProgramStateException("Bounded variable " + variableName + " accessed before initialization");
                }
                Boolean boolExpResult = (Boolean) booleanExpr.resolve();
                if (boolExpResult){
                    MemoryCopy memCopy = UnityProgramMemory.getMemory().createMemoryCopy(MemoryType.LOCAL);
                    memorySnapshots.add(memCopy);
                }
            }
        } else {
            //recursively combine combine current variable range with others
            BoundedVariable boundedVariable = boundedVarsWithRanges.get(currentVar);
            for (int varValue = boundedVariable.getVarMinValue(); varValue <= boundedVariable.getVarMaxValue(); varValue++){
                boundedVarsValues[currentVar] = varValue;
                combineVariableValuesAndCheckBoolExpr(boundedVarsWithRanges, boundedVarsValues, currentVar + 1, memorySnapshots);
            }
        }
    }

    public void destroyVariables(){
        for (Variable var : boundedVars) {
            UnityProgramMemory.getMemory().destroyBoundedVariable(var.getVariableName());
        }
    }

    public void destroy() {
        memorySnapshots.clear();
        destroyVariables();
        evaluated = false;
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
        Collections.shuffle(memorySnapshots);
        return memorySnapshots;
    }


    /**
     * @return maximum int value at which booleanExpr is satisfied
     */
    private int searchVariableMaxValue() throws ProgramRunException {
        try {
            return booleanExpr.highestAcceptableValue();
        } catch (UnsupportedOperationException e) {
            return Configuration.getMaxValue();
        }
    }

    /**
     * @return minimum int value at which booleanExpr is satisfied
     */
    private int searchVariableMinValue() throws ProgramRunException {
        try {
            return booleanExpr.lowestAcceptableValue();
        } catch (UnsupportedOperationException e) {
            return Configuration.getMinValue();
        }
    }

    public boolean isEvaluated() {
        return evaluated;
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
