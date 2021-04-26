package unityToJava.unity.thread.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedMemoryLock extends MyLock {
    private final Lock accessLock = new ReentrantLock(true);

    @Override
    public void lock(){
        accessLock.lock();
        System.out.println("Locking memory by " + Thread.currentThread().getName());
    }

    @Override
    public void unlock(){
        accessLock.unlock();
        System.out.println("Unlocking memory by " + Thread.currentThread().getName());
    }
}
