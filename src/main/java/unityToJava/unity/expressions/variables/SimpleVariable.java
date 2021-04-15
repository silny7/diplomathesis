package unityToJava.unity.expressions.variables;

import unityToJava.unity.exceptions.IllegalArgumentTypeException;
import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.program.UnityProgram;
import unityToJava.unity.program.UnityProgramMemory;

public class SimpleVariable extends Variable{

    public SimpleVariable(String varName){
        super(varName);
    }

    @Override
    public void setValue(Object variableValue) throws ProgramRunException {
        boolean isBounded = UnityProgramMemory.getMemory().isBoundedVariable(getVariableName());

        Object recentValue = UnityProgramMemory.getMemory().getVariableValue(getVariableName());

        //check if new value is the same type as recent value
        if (!recentValue.getClass().equals(variableValue.getClass())) {
            throw new IllegalArgumentTypeException("Error while assigning " + variableValue.getClass() + " value to variable " + getVariableName() + " of type " + recentValue.getClass());
        }
        if (!isBounded && !recentValue.equals(variableValue)) {
            //value changes, fixedPoints not reached
            UnityProgram.getUnityProgram().setFixedPoint(false);
        }
        UnityProgramMemory.getMemory().setVariable(getVariableName(), variableValue);
    }

    @Override
    public Object resolve() throws ProgramRunException {
        return UnityProgramMemory.getMemory().getVariableValue(getVariableName());
    }

    @Override
    public String toString() {
        return getVariableName();
    }

    @Override
    public Integer lowestAcceptableValue() throws ProgramRunException {
        return objectToInteger(resolve());
    }

    @Override
    public Integer highestAcceptableValue() throws ProgramRunException {
        return objectToInteger(resolve());
    }
}
