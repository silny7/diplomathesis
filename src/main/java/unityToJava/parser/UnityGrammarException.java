package unityToJava.parser;

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

    public String getErrorMessages(){
        StringBuilder string = new StringBuilder();
        boolean first = true;
        for (UnityGrammarError error : errors){
            if (!first) string.append("\n");
            else first = false;
            string.append(error.toString());
        }
        return string.toString();
    }
}
