package silny7.uniba.sk.parser;

import java.util.List;

public class UnityGrammarException extends Exception {

    private List<UnityGrammarError> errors;

    public List<UnityGrammarError> getErrors() { return errors; }

    public UnityGrammarException(List<UnityGrammarError> errors){
        super("There are " + String.format("%d errors", errors.size()));
        this.errors = errors;
    }
}
