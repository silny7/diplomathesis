package silny7.uniba.sk.unity.expressions;

import silny7.uniba.sk.unity.exceptions.IllegalArgumentTypeException;
import silny7.uniba.sk.unity.exceptions.ProgramRunException;

public abstract class Expression {


    public abstract Object resolve() throws ProgramRunException;

    public abstract String toString();

    protected Integer objectToInteger(Object object) throws IllegalArgumentTypeException {
        if (!(object instanceof Integer)) {
            throw new IllegalArgumentTypeException("Expression value is not of type Integer");
        }
        return (Integer) object;
    }

    protected Boolean objectToBoolean(Object object) throws IllegalArgumentTypeException {
        if (!(object instanceof Boolean)) {
            throw new IllegalArgumentTypeException("Expression value is not of type Boolean");
        }
        return (Boolean) object;
    }


}
