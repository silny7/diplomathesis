package silny7.uniba.sk.unity.variables;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArrayType extends BaseType {
    private BaseType valuesType;
    private List<ArrayRange> arrayRange;

    public ArrayType(){}

    public ArrayType(BaseType valuesType, List<ArrayRange> arrayRange){
        this.valuesType = valuesType;
        this.arrayRange = arrayRange;
    }

    public void addRanges(List<ArrayRange> arrayRange){
        if (this.arrayRange == null) arrayRange = new ArrayList<ArrayRange>();
        Collections.reverse(arrayRange);
        for (ArrayRange range : arrayRange){
            this.arrayRange.add(0, range);
        }
    }

    @Override
    public Object getNewTypeObject() {
        return new Integer[5];
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append("array [");
        boolean first = true;
        for (ArrayRange range : arrayRange){
            if (!first) string.append(", ");
            else first = false;
            string.append(range.toString());
        }
        string.append("] of ").append(valuesType.toString());
        return string.toString();
    }

}
