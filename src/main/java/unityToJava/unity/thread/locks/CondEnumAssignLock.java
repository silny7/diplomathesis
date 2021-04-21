package unityToJava.unity.thread.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CondEnumAssignLock extends MyLock {

    private final Lock accessLock = new ReentrantLock(true);

    @Override
    public void lock(){
        accessLock.lock();
        System.out.println("Locking ConditionalEnumeratedAssignment.resolveExpressions() by " + Thread.currentThread().getName());
    }

    @Override
    public void unlock() {
        System.out.println("Unlocking ConditionalEnumeratedAssignment.resolveExpressions() by " + Thread.currentThread().getName());
        accessLock.unlock();
    }
}
