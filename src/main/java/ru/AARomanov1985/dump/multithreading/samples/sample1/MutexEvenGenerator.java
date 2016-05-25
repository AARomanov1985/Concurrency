package ru.AARomanov1985.dump.multithreading.samples.sample1;

import ru.AARomanov1985.dump.multithreading.Sample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Alexandr Romanov
 */
public class MutexEvenGenerator extends IntGenerator implements Sample {

    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String getName() {
        return "MutexEvenGenerator";
    }

    @Override
    public void run() {
        EvenChecker.test(this);
    }
}
