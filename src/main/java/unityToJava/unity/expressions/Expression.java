package unityToJava.unity.expressions;

import unityToJava.unity.exceptions.IllegalArgumentTypeException;
import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.program.memory.MemoryCopy;

public abstract class Expression {

    public abstract Object resolve() throws ProgramRunException;

    public abstract String toString();

    protected Integer objectToInteger(Object object) throws IllegalArgumentTypeException {
        if (!(object instanceof Integer)) {
            throw new IllegalArgumentTypeException("Expression value is not of type Integer, but of type " + object.getClass());
        }
        return (Integer) object;
    }

    protected Boolean objectToBoolean(Object object) throws IllegalArgumentTypeException {
        if (!(object instanceof Boolean)) {
            throw new IllegalArgumentTypeException("Expression value is not of type Boolean, but of type " + object.getClass());
        }
        return (Boolean) object;
    }

    public abstract Integer lowestAcceptableValue() throws ProgramRunException;
    public abstract Integer highestAcceptableValue() throws ProgramRunException;


}
