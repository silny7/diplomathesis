package silny7.uniba.sk.parser;

import java.util.List;

public class UnityGrammarException extends Exception {

    private List<UnityGrammarError> errors;

    public List<UnityGrammarError> getErrors() { return errors; }

    public UnityGrammarException(List<UnityGrammarError> errors){
        System.out.println("There are " + String.format("%d errors", errors.size()));
        this.errors = errors;
        for (UnityGrammarError error : errors){
            System.out.println(error.toString());
        }
    }
}
