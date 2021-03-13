package silny7.uniba.sk.unity.variables;

import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.expressions.Expression;

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
