package silny7.uniba.sk.parser.exceptions;

public class MultipleDeclarationException extends Exception{
    private String name;

    public MultipleDeclarationException(String name){
        this.name = name;
    }
}
