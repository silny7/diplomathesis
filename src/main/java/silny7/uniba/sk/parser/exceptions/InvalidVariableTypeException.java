package silny7.uniba.sk.parser.exceptions;

public class InvalidVariableTypeException extends Exception {
    String type;

    public InvalidVariableTypeException(String type){
        this.type = type;
    }
}
