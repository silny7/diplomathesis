package silny7.uniba.sk.unity.statements;

import silny7.uniba.sk.unity.exceptions.ProgramRunException;

public abstract class Assignment {

    public abstract String toString();

    public abstract void evaluateQuantifiers() throws ProgramRunException;

    public abstract void assign() throws ProgramRunException;


}
