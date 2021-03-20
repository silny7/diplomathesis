package silny7.uniba.sk.unity.expressions;

import silny7.uniba.sk.unity.exceptions.IllegalArgumentTypeException;
import silny7.uniba.sk.unity.exceptions.IllegalMethodCallException;
import silny7.uniba.sk.unity.exceptions.NonExistingFunctionException;
import silny7.uniba.sk.unity.exceptions.ProgramRunException;

import java.util.ArrayList;
import java.util.List;

import static silny7.uniba.sk.unity.expressions.functions.Functions.*;

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
        if (functionExists(methodName.toLowerCase())) {
            if (ADD.equals(methodName.toLowerCase())) {
                return resolveAdd();
            } else if (MIN.equals(methodName.toLowerCase())) {
                return resolveMin();
            } else if (MAX.equals(methodName.toLowerCase())) {
                return resolveMax();
            } else if (ODD.equals(methodName.toLowerCase())) {
                return resolveOdd();
            } else if (EVEN.equals(methodName.toLowerCase())) {
                return resolveEven();
            } else if (RANDOM.equals(methodName.toLowerCase())) {
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
            argsValues = new ArrayList<Object>();
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

    private Object resolveRandom() throws IllegalArgumentTypeException, IllegalMethodCallException {
        if (args.isEmpty()) {
            return random();
        } else if (args.size() == 1) {
            return random(objectToInteger(argsValues.get(0)));
        } else if (args.size() == 2) {
            return random(objectToInteger(argsValues.get(0)), objectToInteger(argsValues.get(1)));
        } else {
            throw new IllegalMethodCallException("There is no implementation for " + methodName + " with " + args.size() + " arguments!");
        }
    }

    private Boolean resolveOdd() throws IllegalArgumentTypeException {
        if (args.size() != 1) throw new IllegalArgumentTypeException("There is no implementantion for " + methodName + " with " + args.size() + " arguments!");
        return odd(objectToInteger(argsValues.get(0)));
    }

    private Boolean resolveEven() throws IllegalArgumentTypeException {
        if (args.size() != 1) throw new IllegalArgumentTypeException("There is no implementantion for " + methodName + " with " + args.size() + " arguments!");
        return even(objectToInteger(argsValues.get(0)));
    }

    private Integer resolveMax() throws IllegalArgumentTypeException {
        int[] values = new int[args.size()];
        for (int i = 0; i < args.size(); i++) {
            values[i] = objectToInteger(argsValues.get(i));
        }
        return max(values);
    }

    private Integer resolveMin() throws IllegalArgumentTypeException {
        int[] values = new int[args.size()];
        for (int i = 0; i < args.size(); i++) {
            values[i] = objectToInteger(argsValues.get(i));
        }
        return min(values);
    }

    private Integer resolveAdd() throws IllegalArgumentTypeException {
        if (args.size() == 0) return add();
        else if (args.size() == 2) {
            Integer value1 = objectToInteger(argsValues.get(0));
            Integer value2 = objectToInteger(argsValues.get(1));
            return add(value1, value2);
        } else {
            throw new IllegalArgumentTypeException("There is no implementation for method " + methodName + " with 1 argument: " + args.toString());
        }
    }
}
