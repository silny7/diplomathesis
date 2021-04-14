package unityToJava.unity.statements;

import unityToJava.unity.exceptions.ProgramRunException;

public abstract class Statement {


    public abstract void execute() throws ProgramRunException;

    public abstract void evaluateQuantifiers() throws ProgramRunException;

    public abstract String toString();
}
