package silny7.uniba.sk.unity.variables;

public class SimpleType extends BaseType {

    private Type valueType;

    public SimpleType(){
    }

    public void setValueTypeToBoolean(){
        this.valueType = Type.Bool;
    }

    public void setValueTypeToInteger(){
        this.valueType = Type.Integer;
    }

    private enum Type {
        Bool,
        Integer
    }
}
