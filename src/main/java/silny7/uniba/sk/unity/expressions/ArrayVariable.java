package silny7.uniba.sk.unity.expressions;

import java.util.List;

public class ArrayVariable extends Variable{
    List<Expression> elements;

    public ArrayVariable(String varName, List<Expression> elements){
        this.elements = elements;
        this.variableName = varName;
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
