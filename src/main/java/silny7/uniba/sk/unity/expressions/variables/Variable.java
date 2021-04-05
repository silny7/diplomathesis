package silny7.uniba.sk.unity.expressions.variables;

import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.expressions.Expression;

public abstract class Variable extends Expression {

    private String variableName;

    public Variable(String variableName) {this.variableName = variableName;}

    public String getVariableName() {return this.variableName;}

    public abstract void setValue(Object variableValue) throws ProgramRunException;
}
