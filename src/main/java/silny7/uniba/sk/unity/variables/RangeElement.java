package silny7.uniba.sk.unity.variables;

import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.program.Unity;
import silny7.uniba.sk.unity.program.UnityProgram;

public class RangeElement {

    private Object value;

    public RangeElement(Object value){
        this.value = value;
    }

    public int evaluate() throws ProgramRunException {
        if (Integer.class.isInstance(this.value)) {
            return ((Integer) this.value);
        }
        if (String.class.isInstance(this.value)) {
            return (Integer) UnityProgram.getUnityProgram().getMemory().getUnboundedVariable((String) value);
        }
        else {
            return 0; //throw exception
        }

    }

    public String toString(){
        return value.toString();
    }

}
