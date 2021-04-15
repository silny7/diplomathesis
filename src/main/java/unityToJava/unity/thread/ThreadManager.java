package unityToJava.unity.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadManager {

    private ExecutorService executorService;
    List<Future<?>> submittedTasks = new ArrayList<>();

    public ThreadManager(){
        executorService = Executors.newScheduledThreadPool(10);
    }

    public void addTask(Runnable runnable){
        Future<?> submittedTask = executorService.submit(runnable);
        submittedTasks.add(submittedTask);
        System.out.println("Submitted tasks: " + submittedTasks.size());
    }

    public void shutdown() throws InterruptedException {
        executorService.shutdown();
        if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)){
            executorService.shutdownNow();
        }
        if (executorService.isShutdown()) System.out.println("Executor service terminated");
    }

    public boolean allDone(){
        boolean allDone = true;
        for (Future<?> task : submittedTasks){
            allDone &= task.isDone();
        }
        System.out.println("ALl tasks done: " + allDone);
        return allDone;
    }


}
