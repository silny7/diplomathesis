package silny7.uniba.sk.unity.expressions;

import silny7.uniba.sk.unity.statements.Quantification;

public class QuantifiedExpression extends Expression{

    Object operator;
    Quantification quantification;
    Expression expression;

    public QuantifiedExpression(Object operator, Quantification quantification, Expression expression) {
        this.operator = operator;
        this.quantification = quantification;
        this.expression = expression;
    }


    @Override
    public Object resolve() {
        return null;
    }

    @Override
    public String toString() {
        return operator.toString() + " " + quantification.toString() + " " + expression.toString();
    }
}
