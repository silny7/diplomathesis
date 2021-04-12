package silny7.uniba.sk.unity.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadManager {

    private ExecutorService executorService;

    public ThreadManager(){
        executorService = Executors.newFixedThreadPool(10);
    }

    public void addTask(Runnable runnable){
        executorService.execute(runnable);
    }

    public void shutdown() throws InterruptedException {
        executorService.shutdown();
        executorService.awaitTermination(10_000L, TimeUnit.MILLISECONDS);
    }
}
