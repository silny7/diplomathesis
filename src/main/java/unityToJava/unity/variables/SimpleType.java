package unityToJava.unity.variables;

import unityToJava.unity.exceptions.IllegalArgumentTypeException;
import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.expressions.functions.Functions;

public class SimpleType extends BaseType {

    private Type valueType;

    public SimpleType(){
    }

    public Type getType() {
        return this.valueType;
    }

    public Object getNewTypeObject() throws ProgramRunException {
        switch (valueType){
            case Bool: return true; //randomBool();
            case Integer: return Functions.random(0, 100);
        }
        throw new IllegalArgumentTypeException("Illegal SimpleType " + valueType.toString());
    }

    public String toString(){
        return valueType.toString();
    }

    public void setValueTypeToBoolean(){
        this.valueType = Type.Bool;
    }

    public void setValueTypeToInteger(){
        this.valueType = Type.Integer;
    }

    public enum Type {
        Bool,
        Integer
    }
}
