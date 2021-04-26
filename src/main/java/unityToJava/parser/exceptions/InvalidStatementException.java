package unityToJava.parser.exceptions;

public class InvalidStatementException extends Exception {
   String statement;
    public InvalidStatementException(String text) { statement = text; }
}
