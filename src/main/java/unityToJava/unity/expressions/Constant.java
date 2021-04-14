package unityToJava.unity.expressions;

import unityToJava.unity.exceptions.IllegalArgumentTypeException;
import unityToJava.unity.exceptions.ProgramRunException;

public class Constant extends Expression{
    private Object constantValue;

    public Constant(Object constantValue){
        this.constantValue = constantValue;
    }

    public Object getConstantValue() {
        return constantValue;
    }

    public void setConstantValue(Object constantValue) {
        this.constantValue = constantValue;
    }

    @Override
    public Object resolve() throws IllegalArgumentTypeException {
        return objectToInteger(constantValue);
    }

    @Override
    public String toString() {
        return "" + constantValue;
    }

    @Override
    public Integer lowestAcceptableValue() throws ProgramRunException {
        return objectToInteger(constantValue);
    }

    @Override
    public Integer highestAcceptableValue() throws ProgramRunException {
        return objectToInteger(constantValue);
    }
}

