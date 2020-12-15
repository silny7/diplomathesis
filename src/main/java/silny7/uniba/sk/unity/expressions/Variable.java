package silny7.uniba.sk.unity.expressions;

public abstract class Variable extends Expression{

    private String variableName;

    public Variable(String variableName) {this.variableName = variableName;}

    public String getVariableName() {return this.variableName;}

    public abstract boolean setValue(Object variableValue);
}
