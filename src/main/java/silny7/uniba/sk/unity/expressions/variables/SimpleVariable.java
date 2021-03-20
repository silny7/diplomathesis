package silny7.uniba.sk.unity.expressions.variables;

import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.program.UnityProgram;
import silny7.uniba.sk.unity.program.UnityProgramMemory;

public class SimpleVariable extends Variable{

    public SimpleVariable(String varName){
        super(varName);
    }

    @Override
    public void setValue(Object variableValue) throws ProgramRunException {
        UnityProgram unityProgram = UnityProgram.getUnityProgram();
        UnityProgramMemory memory = unityProgram.getMemory();
        boolean isBounded = memory.isBoundedVariable(getVariableName());

        Object recentValue = memory.getVariableValue(getVariableName());

        //check if new value is the same type as recent value
        if (!recentValue.getClass().equals(variableValue.getClass())) {
            //todo
            //throw exception
        }
        if (!isBounded && !recentValue.equals(variableValue)) {
            //value changes, fixedPoints not reached
            unityProgram.setFixedPoint(false);
        }
        memory.setVariable(getVariableName(), variableValue);
    }

    @Override
    public Object resolve() throws ProgramRunException {
        UnityProgramMemory memory = UnityProgram.getUnityProgram().getMemory();
        return memory.getVariableValue(getVariableName());
    }

    @Override
    public String toString() {
        return getVariableName();
    }
}
