package unityToJava.unity.expressions;

import unityToJava.unity.exceptions.UnsupportedOperationException;
import unityToJava.unity.exceptions.*;
import unityToJava.unity.expressions.functions.Functions;

import java.util.ArrayList;
import java.util.List;

public class Function extends Expression{


    private String methodName;
    private List<Expression> args;
    private List<Object> argsValues;
    public Function(String methodName, List<Expression> args) {
        this.methodName = methodName;
        this.args = args;
    }


    @Override
    public Object resolve() throws ProgramRunException {
        resolveArgs();
        if (Functions.functionExists(methodName.toLowerCase())) {
            if (Functions.ADD.equals(methodName.toLowerCase())) {
                return resolveAdd();
            } else if (Functions.MIN.equals(methodName.toLowerCase())) {
                return resolveMin();
            } else if (Functions.MAX.equals(methodName.toLowerCase())) {
                return resolveMax();
            } else if (Functions.ODD.equals(methodName.toLowerCase())) {
                return resolveOdd();
            } else if (Functions.EVEN.equals(methodName.toLowerCase())) {
                return resolveEven();
            } else if (Functions.RANDOM.equals(methodName.toLowerCase())) {
                return resolveRandom();
            } else {
                throw new NonExistingFunctionException("Function " + this.methodName + " does not exists");
            }
        } else {
            throw new NonExistingFunctionException("Function " + this.methodName + " does not exists");
        }
    }

    private void resolveArgs() throws ProgramRunException {
        if (!args.isEmpty()){
            argsValues = new ArrayList<>();
            for (Expression arg : args){
                argsValues.add(arg.resolve());
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(methodName);
        boolean first = true;
        for (Expression arg : args){
            if (!first) string.append(", ");
            else first = false;
            string.append(arg.toString());
        }
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

    private Object resolveRandom() throws IllegalArgumentTypeException, IllegalMethodCallException {
        if (args.isEmpty()) {
            return Functions.random();
        } else if (args.size() == 1) {
            return Functions.random(objectToInteger(argsValues.get(0)));
        } else if (args.size() == 2) {
            return Functions.random(objectToInteger(argsValues.get(0)), objectToInteger(argsValues.get(1)));
        } else {
            throw new IllegalMethodCallException("There is no implementation for " + methodName + " with " + args.size() + " arguments!");
        }
    }

    private Boolean resolveOdd() throws IllegalArgumentTypeException {
        if (args.size() != 1) throw new IllegalArgumentTypeException("There is no implementantion for " + methodName + " with " + args.size() + " arguments!");
        return Functions.odd(objectToInteger(argsValues.get(0)));
    }

    private Boolean resolveEven() throws IllegalArgumentTypeException {
        if (args.size() != 1) throw new IllegalArgumentTypeException("There is no implementantion for " + methodName + " with " + args.size() + " arguments!");
        return Functions.even(objectToInteger(argsValues.get(0)));
    }

    private Integer resolveMax() throws IllegalArgumentTypeException {
        int[] values = new int[args.size()];
        for (int i = 0; i < args.size(); i++) {
            values[i] = objectToInteger(argsValues.get(i));
        }
        return Functions.max(values);
    }

    private Integer resolveMin() throws IllegalArgumentTypeException {
        int[] values = new int[args.size()];
        for (int i = 0; i < args.size(); i++) {
            values[i] = objectToInteger(argsValues.get(i));
        }
        return Functions.min(values);
    }

    private Integer resolveAdd() throws IllegalArgumentTypeException {
        if (args.size() == 0) return Functions.add();
        else if (args.size() == 2) {
            Integer value1 = objectToInteger(argsValues.get(0));
            Integer value2 = objectToInteger(argsValues.get(1));
            return Functions.add(value1, value2);
        } else {
            throw new IllegalArgumentTypeException("There is no implementation for method " + methodName + " with 1 argument: " + args.toString());
        }
    }
}
