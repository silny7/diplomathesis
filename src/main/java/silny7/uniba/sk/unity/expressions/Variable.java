package silny7.uniba.sk.unity.expressions;

public abstract class Variable extends Expression{

    public String variableName;

    public abstract boolean setValue(Object variableValue);
}
