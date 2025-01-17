package unityToJava.parser;

public class UnityGrammarError {

    /**
     * number of line on which error occured
     */
    private int lineNumber;

    /**
     * index of character in line where error occured
     */
    private int charPositionInLine;

    /**
     * whole error message
     * format:
     * errorMessage 'at line' lineNumber 'at position' charPositionInLine
     */
    private String fullErrorMessage;

    public UnityGrammarError(int lineNumber, int charPositionInLine, String errorMessage){
        this.lineNumber = lineNumber;
        this.charPositionInLine = charPositionInLine;
        this.fullErrorMessage = errorMessage + " at line " + this.lineNumber + " at position " + this.charPositionInLine;
    }

    public String toString(){
        return fullErrorMessage;
    }
}
