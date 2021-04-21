package unityToJava.unity.expressions.variables;

import unityToJava.unity.exceptions.NonExistingVariableException;
import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.exceptions.UnsupportedOperationException;
import unityToJava.unity.expressions.Expression;
import unityToJava.unity.program.UnityProgram;
import unityToJava.unity.program.UnityProgramMemory;

import java.util.List;

public class ArrayVariable extends Variable{

    //holding the indexes of arrayVariable, e.g. A[elements[0]][elements[1]]...
    List<Expression> elements;

    public ArrayVariable(String varName, List<Expression> elements){
        super(varName);
        this.elements = elements;
    }

    @Override
    public synchronized void setValue(Object variableValue) throws ProgramRunException {
        if (UnityProgramMemory.getMemory().variableExists(getVariableName())){
            int[] arrayIndexes = getArrayIndexes();
            Object[] arrayVariable = (Object[]) UnityProgramMemory.getMemory().getVariableValue(getVariableName());
            Object currentValue = getArrayElementAtIndexes(arrayVariable, arrayIndexes);
            if (!currentValue.equals(variableValue)) {
                UnityProgram.getUnityProgram().setFixedPoint(false);
            }
            Object[] array = setArrayElementAtIndexes(arrayVariable, arrayIndexes, variableValue);
            UnityProgramMemory.getMemory().setVariable(getVariableName(), array);
        } else {
            throw new NonExistingVariableException("Array variable " + getVariableName() + " referenced before declaration!");
        }
    }


    @Override
    public Object resolve() throws ProgramRunException {
        //if variable varName exists
        if (UnityProgramMemory.getMemory().variableExists(getVariableName())){
            int[] arrayIndexes = getArrayIndexes();
            Object[] array = (Object[]) UnityProgramMemory.getMemory().getVariableValue(getVariableName());
            return getArrayElementAtIndexes(array, arrayIndexes);
        } else {
            throw new NonExistingVariableException("Array variable " + getVariableName() + " referenced before declaration!");
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
            } catch (ProgramRunException exception) {
                UnityProgram.errorLog(exception);
            }
        }
        arrayVar.append("]");
        return arrayVar.toString();
    }

    @Override
    public Integer lowestAcceptableValue() throws ProgramRunException {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public Integer highestAcceptableValue() throws ProgramRunException {
        throw new UnsupportedOperationException("Unsupported operation");
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
