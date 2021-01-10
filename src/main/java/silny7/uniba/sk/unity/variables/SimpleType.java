package silny7.uniba.sk.unity.variables;

import silny7.uniba.sk.unity.exceptions.IllegalArgumentTypeException;
import silny7.uniba.sk.unity.exceptions.ProgramRunException;

public class SimpleType extends BaseType {

    private Type valueType;

    public SimpleType(){
    }

    public Type getType() {
        return this.valueType;
    }

    public Object getNewTypeObject() throws ProgramRunException {
        switch (valueType){
            case Bool: return Boolean.FALSE;
            case Integer: return 0;
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
