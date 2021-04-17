package unityToJava.unity.program;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import unityToJava.UnityGrammarLexer;
import unityToJava.UnityGrammarParser;
import unityToJava.parser.UnityGrammarErrorListener;
import unityToJava.parser.UnityGrammarException;
import unityToJava.parser.UnityGrammarVisitor;
import unityToJava.unity.program.configuration.Configuration;
import unityToJava.unity.program.logger.LogManager;
import unityToJava.unity.thread.ThreadManager;

import javax.swing.*;

public class Unity {
    private final LogManager logManager;
    private UnityProgram unityProgram;
    
    public Unity(JTextArea errorTA, JTextArea programOutputTA) {
        this.logManager = new LogManager(programOutputTA, errorTA);
    }

    public void startLogging(){
        this.logManager.startLogging();
    }

    public void startErrorLogging() {
        this.logManager.startErrorLogging();
    }

    public void startProgramLogging() {
        this.logManager.startProgramLogging();
    }

    public void createProgramFromString(String programToParse) throws UnityGrammarException {
        this.unityProgram = createProgram(CharStreams.fromString(programToParse));
    }

    private UnityProgram createProgram(CharStream input) throws UnityGrammarException {
        UnityGrammarErrorListener errorListener = new UnityGrammarErrorListener();

        UnityGrammarLexer lexer = new UnityGrammarLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        UnityGrammarParser parser = new UnityGrammarParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);

        ParseTree tree = parser.program();
        if (errorListener.hasErrors()) throw new UnityGrammarException(errorListener.getErrors());

        UnityGrammarVisitor visitor = new UnityGrammarVisitor();
        UnityProgram unityProgram = visitor.transform(tree);
        if (visitor.hasErrors()) throw new UnityGrammarException(visitor.getErrors());

        return unityProgram;
    }

    public void startProgram(){
        unityProgram.setUnityLogger(getLogManager());
        //unityProgram.setThreadManager(getThreadManager());
        //start program logging
        startProgramLogging();
        unityProgram.interpret();
    }

    public UnityProgram getUnityProgram() { return this.unityProgram; }

    public LogManager getLogManager() {return this.logManager; }

}
