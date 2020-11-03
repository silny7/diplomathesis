package silny7.uniba.sk.parser;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;
import java.util.List;

public class UnityGrammarErrorListener extends BaseErrorListener {

    private final List<UnityGrammarError> errors = new ArrayList();

    public List<UnityGrammarError> getErrors() { return errors; }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e){
        errors.add(new UnityGrammarError(line, charPositionInLine, msg));
    }

    public boolean hasErrors() { return !errors.isEmpty(); }

}
