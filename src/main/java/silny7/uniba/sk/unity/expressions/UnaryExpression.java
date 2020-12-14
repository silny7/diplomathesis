package silny7.uniba.sk.unity.expressions;

import silny7.uniba.sk.unity.expressions.Expression;
import silny7.uniba.sk.unity.expressions.operators.UnaryOperator;

public class UnaryExpression extends Expression {

    UnaryOperator operator;
    Expression expr;

    public UnaryExpression(UnaryOperator operator, Expression expr){
        this.operator = operator;
        this.expr = expr;
    }

    @Override
    public Object resolve() {
        return null;
    }
}
