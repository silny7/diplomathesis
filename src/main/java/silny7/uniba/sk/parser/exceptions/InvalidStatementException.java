package silny7.uniba.sk.parser.exceptions;

public class InvalidStatementException extends Exception {
   String statement;
    public InvalidStatementException(String text) { statement = text; }
}
