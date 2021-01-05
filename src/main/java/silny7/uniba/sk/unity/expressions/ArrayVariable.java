package silny7.uniba.sk.unity.expressions;

import java.util.List;

public class ArrayVariable extends Variable{
    List<Expression> elements;

    public ArrayVariable(String varName, List<Expression> elements){
        super(varName);
        this.elements = elements;
    }

    @Override
    public boolean setValue(Object variableValue) {
        return false;
    }

    @Override
    public Object resolve() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder arrayVar = new StringBuilder();
        arrayVar.append(getVariableName() + "[");
        boolean first = true;
        for (Expression element : elements){
            if (!first) arrayVar.append(", ");
            else first = false;
            arrayVar.append(element.toString());
        }
        arrayVar.append("]");
        return arrayVar.toString();
    }
}
