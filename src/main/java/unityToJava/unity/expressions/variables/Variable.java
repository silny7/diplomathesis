package unityToJava.unity.expressions.variables;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.expressions.Expression;

public abstract class Variable extends Expression {

    private String variableName;

    public Variable(String variableName) {this.variableName = variableName;}

    public String getVariableName() {return this.variableName;}

    public abstract void setValue(Object variableValue) throws ProgramRunException;

}
