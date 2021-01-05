package silny7.uniba.sk.unity.expressions;

import silny7.uniba.sk.unity.exceptions.IllegalArgumentTypeException;

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
}

