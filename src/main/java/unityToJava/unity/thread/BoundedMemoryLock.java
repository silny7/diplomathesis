package unityToJava.unity.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedMemoryLock {
    private final Lock accessLock = new ReentrantLock(true);

    public void lock(){
        accessLock.lock();
        System.out.println("Locking memory by " + Thread.currentThread().getName());
    }

    public void unlock(){
        accessLock.unlock();
        System.out.println("Unlocking memory by " + Thread.currentThread().getName());
    }
}
