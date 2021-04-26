package unityToJava.unity.variables;

import unityToJava.unity.exceptions.ProgramRunException;

public abstract class BaseType {

    public abstract Object getNewTypeObject() throws ProgramRunException;
}
