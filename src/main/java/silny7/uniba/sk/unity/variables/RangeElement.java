package silny7.uniba.sk.unity.variables;

public class RangeElement {

    Object value;

    public RangeElement(Object value){
        this.value = value;
    }

    public int evaluate(){
        if (Integer.class.isInstance(this.value)) {
            return ((Integer) this.value);
        }
        if (String.class.isInstance(this.value)) {
            //is a variable
            //get value from memory
            return 0;
        }
        else {
            return 0; //throw exception
        }

    }
}
