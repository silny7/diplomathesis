package silny7.uniba.sk.unity.expressions;

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
    public Object resolve() {
        return this.constantValue;
    }
}

