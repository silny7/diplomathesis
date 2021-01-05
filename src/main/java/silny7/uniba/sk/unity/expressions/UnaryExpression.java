package silny7.uniba.sk.unity.expressions;

import silny7.uniba.sk.unity.exceptions.IllegalOperatorException;
import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.expressions.operators.UnaryOperator;

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
}
