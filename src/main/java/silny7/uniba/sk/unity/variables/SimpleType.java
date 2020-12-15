package silny7.uniba.sk.unity.variables;

public class SimpleType extends BaseType {

    private Type valueType;

    public SimpleType(){
    }

    public Type getType() {
        return this.valueType;
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
