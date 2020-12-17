package silny7.uniba.sk.unity.expressions;

import java.util.List;

public class ExpressionListExpression extends Expression{
    List<Expression> expressionList;

    public ExpressionListExpression(List<Expression> expressions){
        this.expressionList = expressions;
    }


    @Override
    public Object resolve() {
        return null;
    }
}
