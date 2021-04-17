package unityToJava.unity.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadManager {

    private static final ThreadManager instance = new ThreadManager();

    private ExecutorService executorService;
    private final Integer NUMBER_OF_THREADS_IN_POOL = 50;
    List<Future<?>> submittedTasks = new ArrayList<>();

    private final BoundedMemoryLock boundedMemoryLock;

    private ThreadManager(){
        this.executorService = Executors.newScheduledThreadPool(NUMBER_OF_THREADS_IN_POOL);
        this.boundedMemoryLock = new BoundedMemoryLock();
    }

    public static ThreadManager getInstance() {
        return instance;
    }

    public Future<?> addTask(Runnable runnable){
        Future<?> submittedTask = executorService.submit(runnable);
        submittedTasks.add(submittedTask);
        return submittedTask;
        //System.out.println("Submitted tasks: " + submittedTasks.size());
    }

    public void shutdown() throws InterruptedException {
        executorService.shutdown();
        if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)){
            executorService.shutdownNow();
        }
        if (executorService.isShutdown()) System.out.println("Executor service terminated");
    }

    /**
     * make this section locked -- cause too many submittedTasks slows down the program. Let the assignment (place where tasks are submitted)
     * check if the assignment is all done only on submitted tasks by itself.
     * @return
     */
    public boolean allDone(){
        boolean allDone = true;
        for (Future<?> task : submittedTasks){
            allDone &= task.isDone();
        }
        //System.out.println("All tasks done: " + allDone);
        return allDone;
    }


    public BoundedMemoryLock getLock() {
        return this.boundedMemoryLock;
    }

    public boolean allDone(List<Future<?>> tasks) {
        boolean allDone = true;
        for (Future<?> task : tasks){
            allDone &= task.isDone();
        }
        //System.out.println("All tasks done: " + allDone);
        return allDone;
    }
}
