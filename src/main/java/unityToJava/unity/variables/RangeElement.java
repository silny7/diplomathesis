package unityToJava.unity.variables;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.expressions.Expression;

public class RangeElement {

    private Expression value;

    public RangeElement(Expression value){
        this.value = value;
    }

    public Integer evaluate() throws ProgramRunException {
        return (Integer) value.resolve();
    }

    public String toString(){
        return value.toString();
    }

}
