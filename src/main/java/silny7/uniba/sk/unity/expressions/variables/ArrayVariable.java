package silny7.uniba.sk.unity.expressions.variables;

import silny7.uniba.sk.unity.exceptions.NonExistingVariableException;
import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.expressions.Expression;
import silny7.uniba.sk.unity.program.Unity;
import silny7.uniba.sk.unity.program.UnityProgram;
import silny7.uniba.sk.unity.program.UnityProgramMemory;

import java.util.List;

public class ArrayVariable extends Variable{

    //holding the indexes of arrayVariable, e.g. A[elements[0]][elements[1]]...
    List<Expression> elements;

    public ArrayVariable(String varName, List<Expression> elements){
        super(varName);
        this.elements = elements;
    }

    @Override
    public void setValue(Object variableValue) throws ProgramRunException {
        UnityProgramMemory memory = UnityProgram.getUnityProgram().getMemory();
        if (memory.variableExists(getVariableName())){
            int[] arrayIndexes = getArrayIndexes();
            Object[] arrayVariable = (Object[]) memory.getVariableValue(getVariableName());
            Object currentValue = getArrayElementAtIndexes(arrayVariable, arrayIndexes);
            if (!currentValue.equals(variableValue)) {
                UnityProgram.getUnityProgram().setFixedPoint(false);
            }
            Object[] array = setArrayElementAtIndexes(arrayVariable, arrayIndexes, variableValue);
            memory.setVariable(getVariableName(), array);
        } else {
            throw new NonExistingVariableException("Array variable " + getVariableName() + " does not exists!");
        }
    }


    @Override
    public Object resolve() throws ProgramRunException {
        UnityProgramMemory memory = UnityProgram.getUnityProgram().getMemory();
        //if variable varName exists
        if (memory.variableExists(getVariableName())){
            int[] arrayIndexes = getArrayIndexes();
            Object[] array = (Object[]) memory.getVariableValue(getVariableName());
            return getArrayElementAtIndexes(array, arrayIndexes);
        } else {
            throw new NonExistingVariableException("Array variable " + getVariableName() + " does not exists!");
        }
    }

    @Override
    public String toString() {
        StringBuilder arrayVar = new StringBuilder();
        arrayVar.append(getVariableName() + "[");
        boolean first = true;
        for (Expression element : elements){
            if (!first) arrayVar.append(", ");
            else first = false;
            try {
                arrayVar.append(element.resolve());
            } catch (ProgramRunException programRunException) {
                UnityProgram.errorLog(programRunException);
            }
        }
        arrayVar.append("]");
        return arrayVar.toString();
    }

    @Override
    public Integer lowestAcceptableValue() throws ProgramRunException {
        return 0;
    }

    @Override
    public Integer highestAcceptableValue() throws ProgramRunException {
        return 0;
    }

    private Object getArrayElementAtIndexes(Object[] array, int... indexes) throws NonExistingVariableException {
        try {
            Object arrayElement = null;
            for (int index : indexes){
                arrayElement = array[index];
                if (arrayElement.getClass().isArray()) {
                    array = (Object[]) arrayElement;
                }
            }
            return arrayElement;
        } catch (IndexOutOfBoundsException ex) {
            throw new NonExistingVariableException("Index out of bounds of variable " + getVariableName());
        }
    }

    private Object[] setArrayElementAtIndexes(Object[] arrayVariable, int[] arrayIndexes, Object variableValue) throws NonExistingVariableException {
        Object[] array = arrayVariable;
        try {
            Object arrayElement;
            for (int i = 0; i < arrayIndexes.length - 1; i++){
                int index = arrayIndexes[i];
                arrayElement = array[index];
                if (arrayElement.getClass().isArray()) {
                    array = (Object[]) arrayElement;
                }
            }
            array[arrayIndexes[arrayIndexes.length - 1]] = variableValue;
            return arrayVariable;
        } catch (IndexOutOfBoundsException ex) {
            throw new NonExistingVariableException("Index " + arrayIndexes.toString() + " out of bounds of variable " + getVariableName());
        }
    }

    private int[] getArrayIndexes() throws ProgramRunException {
        int[] arrayIndexes = new int[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            arrayIndexes[i] =  objectToInteger(elements.get(i).resolve());
        }
        return arrayIndexes;
    }
}
