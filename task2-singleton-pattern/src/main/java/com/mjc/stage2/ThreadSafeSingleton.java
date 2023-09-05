package com.mjc.stage2;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeSingleton {
    // Write your code here!
    private static AtomicReference<ThreadSafeSingleton> instance = new AtomicReference<>();
    private static final ReentrantLock lock = new ReentrantLock();

    private ThreadSafeSingleton() {
    }

    public static ThreadSafeSingleton getInstance() {
        lock.lock();
        if (instance == null || instance.get() == null){
            instance = new AtomicReference<>(new ThreadSafeSingleton());
        }
        var result = instance.get();
        lock.unlock();
        return result;
    }

}
