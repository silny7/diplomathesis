package silny7.uniba.sk.unity.expressions;

import silny7.uniba.sk.unity.exceptions.IllegalOperatorException;
import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.expressions.operators.BinaryOperator;

public class BinaryExpression extends Expression{

    private Expression expr1;
    private Expression expr2;
    private BinaryOperator operator;


    public BinaryExpression(BinaryOperator operator, Expression expr1, Expression expr2){
        this.operator = operator;
        this.expr1 = expr1;
        this.expr2 = expr2;
    }


    @Override
    public Object resolve() throws ProgramRunException {
        Object value1 = expr1.resolve();
        Object value2 = expr2.resolve();

        switch (operator){
            case PLUS: return objectToInteger(value1) + objectToInteger(value2);
            case MINUS: return objectToInteger(value1) - objectToInteger(value2);
            case TIMES: return objectToInteger(value1) * objectToInteger(value2);
            case DIV: return objectToInteger(value1) / objectToInteger(value2);
            case MOD: return objectToInteger(value1) % objectToInteger(value2);
            case POWER: return Math.pow(objectToInteger(value1), objectToInteger(value2));
            case AND: return objectToBoolean(value1) && objectToBoolean(value2);
            case OR: return objectToBoolean(value1) || objectToBoolean(value2);
            case GREATER_OR_EQUAL: return objectToInteger(value1) >= objectToInteger(value2);
            case GREATER_THAN: return objectToInteger(value1) > objectToInteger(value2);
            case LESS_OR_EQUAL: return objectToInteger(value1) <= objectToInteger(value2);
            case LESS_THAN: return objectToInteger(value1) < objectToInteger(value2);
            case EQUAL: return objectToInteger(value1).equals(objectToInteger(value2));
            case NOT_EQUAL: return !objectToInteger(value1).equals(objectToInteger(value2));
            default: throw new IllegalOperatorException("Illegal operator type: " + operator.toString());
        }
    }

    @Override
    public String toString() {
        return expr1.toString() + " " + operator.toString() + " " + expr2.toString();
    }
}
