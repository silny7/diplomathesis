package unityToJava.unity.exceptions;

public class MultipleDeclarationException extends ProgramRunException{
    private String name;

    public MultipleDeclarationException(String varName, String message) {
        super(message);
        this.name = varName;
    }
}
