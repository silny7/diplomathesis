package unityToJava.unity.expressions;

import unityToJava.unity.exceptions.IllegalOperatorException;
import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.expressions.operators.UnaryOperator;

public class UnaryExpression extends Expression {

    UnaryOperator operator;
    Expression expr;

    public UnaryExpression(UnaryOperator operator, Expression expr){
        this.operator = operator;
        this.expr = expr;
    }

    @Override
    public Object resolve() throws ProgramRunException {
        Object value = expr.resolve();

        switch (operator) {
            case MINUS:
                return -objectToInteger(value);
            case PLUS:
                return objectToInteger(value);
            case NOT:
                return !objectToBoolean(value);
            default: throw new IllegalOperatorException("Illegal operator type: " + operator.toString());
        }
    }

    @Override
    public String toString() {
        return operator.toString() + expr.toString();
    }

    @Override
    public Integer lowestAcceptableValue() throws ProgramRunException {
        return expr.lowestAcceptableValue();
    }

    @Override
    public Integer highestAcceptableValue() throws ProgramRunException {
        return expr.highestAcceptableValue();
    }
}
