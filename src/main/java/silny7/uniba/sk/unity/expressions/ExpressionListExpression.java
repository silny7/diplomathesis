package silny7.uniba.sk.unity.expressions;

import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.exceptions.UnsupportedOperationException;

import java.util.List;

/*
todo delete
not used anywhere
 */
public class ExpressionListExpression extends Expression{
    List<Expression> expressionList;

    public ExpressionListExpression(List<Expression> expressions){
        this.expressionList = expressions;
    }


    @Override
    public Object resolve() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        boolean first = true;
        for (Expression expression : expressionList){
            if (!first) string.append(", ");
            else first = false;
            string.append(expression.toString());
        }
        string.append("]");
        return string.toString();
    }

    @Override
    public Integer lowestAcceptableValue() throws ProgramRunException {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public Integer highestAcceptableValue() throws ProgramRunException {
        throw new UnsupportedOperationException("Unsupported operation");
    }
}
