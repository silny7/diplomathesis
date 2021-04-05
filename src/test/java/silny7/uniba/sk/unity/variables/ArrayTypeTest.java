package silny7.uniba.sk.unity.variables;

import com.ibm.icu.impl.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.expressions.Constant;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * testing class for ArrayType class
 * testing creation of new object of ArrayType
 */
public class ArrayTypeTest {

    @Test
    public void oneDimensionalArrayWithIntegerValues() throws ProgramRunException {
        ArrayRange range = new ArrayRange(createRangeElement(new Constant(0)), createRangeElement(new Constant(10)));
        ArrayType arrayType = new ArrayType(getSimpleType(false), Arrays.asList(range));

        Integer[] createdArray = (Integer[]) arrayType.getNewTypeObject();
        assertEquals(createdArray.length, 11);
        for (int i = 0; i < createdArray.length; i++){
            assertEquals(0, createdArray[i]);
        }
    }

    @Test
    public void oneDimensionalArrayWithBooleanValues() throws ProgramRunException {
        ArrayRange range = new ArrayRange(createRangeElement(new Constant(0)), createRangeElement(new Constant(10)));
        ArrayType arrayType = new ArrayType(getSimpleType(true), Arrays.asList(range));

        Boolean[] createdArray = (Boolean[]) arrayType.getNewTypeObject();
        assertEquals(createdArray.length, 11);
        for (int i = 0; i < createdArray.length; i++){
            assertEquals(false, createdArray[i]);
        }
    }

    @Test
    public void twoDimensionalArrayWithIntegerValues() throws ProgramRunException {
        ArrayRange range1 = new ArrayRange(createRangeElement(new Constant(0)), createRangeElement(new Constant(10)));
        ArrayRange range2 = new ArrayRange(createRangeElement(new Constant(0)), createRangeElement(new Constant(5)));
        ArrayType arrayType = new ArrayType(getSimpleType(false), Arrays.asList(range1, range2));

        Integer[][] createdArray = (Integer[][]) arrayType.getNewTypeObject();

        assertEquals(createdArray.length, 11);
        for (int i =0; i < createdArray.length; i++){
            assertEquals(createdArray[i].length, 6);
            for (int j = 0; j < createdArray[i].length; j++) {
                assertEquals(createdArray[i][j], 0);
            }
        }
    }

    @Test
    public void twoDimensionalArrayWithBooleanValues() throws ProgramRunException {
        ArrayRange range1 = new ArrayRange(createRangeElement(new Constant(0)), createRangeElement(new Constant(10)));
        ArrayRange range2 = new ArrayRange(createRangeElement(new Constant(0)), createRangeElement(new Constant(5)));
        ArrayType arrayType = new ArrayType(getSimpleType(true), Arrays.asList(range1, range2));

        Boolean[][] createdArray = (Boolean[][]) arrayType.getNewTypeObject();

        assertEquals(createdArray.length, 11);
        for (int i =0; i < createdArray.length; i++){
            assertEquals(createdArray[i].length, 6);
            for (int j = 0; j < createdArray[i].length; j++) {
                assertEquals(createdArray[i][j], false);
            }
        }
    }

    private RangeElement createRangeElement(Constant constant){
        return new RangeElement(constant);
    }

    private SimpleType getSimpleType(boolean bool){
        SimpleType type = new SimpleType();
        if (bool) {
            type.setValueTypeToBoolean();
        } else {
            type.setValueTypeToInteger();
        }
        return type;
    }
}
