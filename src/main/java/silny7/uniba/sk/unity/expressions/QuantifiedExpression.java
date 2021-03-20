package silny7.uniba.sk.unity.expressions;

import silny7.uniba.sk.unity.exceptions.IllegalProgramStateException;
import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.expressions.operators.BinaryOperator;
import silny7.uniba.sk.unity.program.memory.MemoryCopy;
import silny7.uniba.sk.unity.statements.Quantification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public Object resolve() throws ProgramRunException {
        quantification.initVariables();
        quantification.evaluate();

        //collect results of expression as Constants
        //based on memCopies from quantification
        List<Constant> quantResults = new ArrayList();
        for (MemoryCopy memCopy : quantification.getMemorySnapshots()){
            memCopy.loadIntoProgramMemory();
            quantResults.add(new Constant(expression.resolve()));
        }

        if (quantResults.isEmpty()) {
            //no results, return base value of operator
            quantification.destroy();
            if (operator instanceof BinaryOperator) {
                return BinaryOperator.getDefaultOperatorValue((BinaryOperator) operator);
            } else if (operator instanceof String){
                //operator is a method
                return new Function(operator.toString(), new ArrayList<Expression>()).resolve();
            } else {
                throw new IllegalProgramStateException("Invalid QuantifiedExpression operator: " + operator);
            }
        } else if (quantResults.size() == 1) {
            //only one results
            quantification.destroy();
            return quantResults.get(0).resolve();
        } else {
            //use all results as values for Operator or method
            Expression result = quantResults.get(0);
            for (int i = 1; i < quantResults.size(); i++){
                if (operator instanceof BinaryOperator){
                    result = new Constant(new BinaryExpression((BinaryOperator) operator, result, quantResults.get(i)));
                } else if (operator instanceof String){
                    result = new Constant(new Function(operator.toString(), Arrays.asList(result, quantResults.get(i))));
                } else {
                    throw new IllegalProgramStateException("Invalid QuantifiedExpression operator: " + operator);
                }
            }
            quantification.destroy();
            return result.resolve();
        }
    }

    @Override
    public String toString() {
        return "<<" + operator.toString() + " " + quantification.toString() + " " + expression.toString() + ">>";
    }
}
