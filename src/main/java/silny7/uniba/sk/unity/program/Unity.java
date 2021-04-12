package silny7.uniba.sk.unity.program;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import silny7.uniba.sk.UnityGrammarLexer;
import silny7.uniba.sk.UnityGrammarParser;
import silny7.uniba.sk.parser.UnityGrammarErrorListener;
import silny7.uniba.sk.parser.UnityGrammarException;
import silny7.uniba.sk.parser.UnityGrammarVisitor;
import silny7.uniba.sk.unity.program.configuration.Configuration;
import silny7.uniba.sk.unity.program.logger.LogManager;
import silny7.uniba.sk.unity.thread.ThreadManager;

import javax.swing.*;

public class Unity {
    private final LogManager logManager;
    private UnityProgram unityProgram;
    private ThreadManager threadManager;


    public Unity(JTextArea errorTA, JTextArea programOutputTA) {
        this.logManager = new LogManager(programOutputTA, errorTA);
        if (Configuration.isMultithreading()) {
            this.threadManager = new ThreadManager();
        }
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

    private ThreadManager getThreadManager() {
        return this.threadManager;
    }

    public UnityProgram getUnityProgram() { return this.unityProgram; }

    public LogManager getLogManager() {return this.logManager; }

}
