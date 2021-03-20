package silny7.uniba.sk.unity.statements;

import silny7.uniba.sk.unity.exceptions.ProgramRunException;

public abstract class Statement {


    public abstract void execute() throws ProgramRunException;

    public abstract void evaluateQuantifiers() throws ProgramRunException;

    public abstract String toString();
}
