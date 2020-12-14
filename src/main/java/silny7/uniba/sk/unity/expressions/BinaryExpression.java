package silny7.uniba.sk.unity.expressions;

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
    public Object resolve() {
        return null;
    }
}
