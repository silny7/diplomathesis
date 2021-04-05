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
        int[] arrayLength = new int[arrayRanges.size()];
        for (int i = 0; i < arrayRanges.size(); i++) {
            ArrayRange range = arrayRanges.get(i);
            arrayLength[i] = range.getUpperBound().evaluate() - range.getLowerBound().evaluate() + 1;
        }
        if (valuesType.getType().equals(SimpleType.Type.Integer)) {
            Object array = Array.newInstance(Integer.class, arrayLength);
            fillArrayWithValues(array, 0, arrayLength);
            return array;
        } else {
            Object array = Array.newInstance(Boolean.class, arrayLength);
            fillArrayWithValues(array, false, arrayLength);
            return array;
        }
    }

    /**
     * fills multidimensional array with value
     * @param array
     * @param value
     * @param lengths
     */
    private void fillArrayWithValues(Object array, Object value, int... lengths) {
        for (int i = 0; i < lengths[0]; i++)
        if (lengths.length == 1){
            if (value instanceof Integer){
                ((Integer[]) array)[i] = (Integer) value;
            } else if (value instanceof Boolean){
                ((Boolean[]) array)[i] = (Boolean) value;
            }
        } else {
            fillArrayWithValues(Array.get(array, i), value, tail(lengths));
        }
    }

    private int[] tail(int[] array) {
        return Arrays.copyOfRange(array, 1, array.length);
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
