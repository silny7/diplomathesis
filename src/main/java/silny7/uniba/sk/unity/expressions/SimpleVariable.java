package silny7.uniba.sk.unity.expressions;

public class SimpleVariable extends Variable{

    public SimpleVariable(String varName){
        super(varName);
    }

    @Override
    public boolean setValue(Object variableValue) {
        return false;
    }

    @Override
    public Object resolve() {
        return null;
    }
}
