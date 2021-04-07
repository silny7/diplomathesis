package silny7.uniba.sk.unity.program.logger;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Logger implements Runnable {

    private final JTextArea logArea;
    BlockingQueue<String> logs;

    private volatile boolean run = true;
    private int sleepMilis;

    public Logger(JTextArea logArea, int queueCapacity, int sleepMilis){
        this.logArea = logArea;
        this.sleepMilis = sleepMilis;
        logs = new ArrayBlockingQueue<>(queueCapacity, true);
        if (logArea != null) {
            DefaultCaret caret = (DefaultCaret) this.logArea.getCaret();
            caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        }
    }

    @Override
    public void run() {
        while (run){
            try {
                processLog(logs.take());
                Thread.sleep(sleepMilis);
            } catch (InterruptedException e) {
                //todo
            }
        }
    }

    private void processLog(String logMessage) {
        if (!logArea.getText().isEmpty()) logArea.append("\n");
        logArea.append(logMessage);
    }

    public void queueLog(String logText){
        if (logArea == null) {
            System.out.println(logText);
        } else {
            logs.offer(logText);
        }
    }

    public void stop() {
        run = false;
    }
}
