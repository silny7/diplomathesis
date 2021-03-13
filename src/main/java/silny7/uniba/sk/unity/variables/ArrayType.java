package silny7.uniba.sk.unity.variables;

import silny7.uniba.sk.unity.exceptions.ProgramRunException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayType extends BaseType {
    private SimpleType valuesType;
    private List<ArrayRange> arrayRanges;

    public ArrayType(){}

    public ArrayType(SimpleType valuesType, List<ArrayRange> arrayRange){
        this.valuesType = valuesType;
        this.arrayRanges = arrayRange;
    }

    public void addRanges(List<ArrayRange> arrayRange){
        if (this.arrayRanges == null) this.arrayRanges = new ArrayList<ArrayRange>();
        Collections.reverse(arrayRange);
        for (ArrayRange range : arrayRange){
            this.arrayRanges.add(0, range);
        }
    }

    @Override
    public Object getNewTypeObject() throws ProgramRunException {
        //Collections.reverse(arrayRanges);
        int[] arrayLength = new int[arrayRanges.size()];
        for (int i = 0; i < arrayRanges.size(); i++) {
            ArrayRange range = arrayRanges.get(i);
            arrayLength[i] = range.getUpperBound().evaluate() - range.getLowerBound().evaluate() + 1;
        }
        if (valuesType.getType().equals(SimpleType.Type.Integer)) {
            return Array.newInstance(Integer.class, arrayLength);
        } else {
            return Array.newInstance(Boolean.class, arrayLength);
        }
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append("array [");
        boolean first = true;
        for (ArrayRange range : arrayRanges){
            if (!first) string.append(", ");
            else first = false;
            string.append(range.toString());
        }
        string.append("] of ").append(valuesType.toString());
        return string.toString();
    }

}
