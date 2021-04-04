package silny7.uniba.sk.unity.expressions;

import silny7.uniba.sk.unity.exceptions.IllegalArgumentTypeException;
import silny7.uniba.sk.unity.exceptions.ProgramRunException;

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

