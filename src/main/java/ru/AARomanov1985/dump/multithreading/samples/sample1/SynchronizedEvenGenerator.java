/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.AARomanov1985.dump.multithreading.samples.sample1;

import ru.AARomanov1985.dump.multithreading.Sample;

/**
 *
 * @author raan
 */
public class SynchronizedEvenGenerator extends IntGenerator implements Sample {

    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield(); // Cause failure faster
        ++currentEvenValue;
        return currentEvenValue;
    }

    @Override
    public String getName() {
        return "SynchronizedEvenGenerator";
    }

    @Override
    public void run() {
        EvenChecker.test(this);
    }

}
