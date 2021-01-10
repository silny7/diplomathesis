package silny7.uniba.sk.unity.variables;

import silny7.uniba.sk.unity.exceptions.ProgramRunException;

public abstract class BaseType {

    public abstract Object getNewTypeObject() throws ProgramRunException;
}
