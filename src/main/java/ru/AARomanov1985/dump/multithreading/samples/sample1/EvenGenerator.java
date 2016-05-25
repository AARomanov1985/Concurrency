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
public class EvenGenerator extends IntGenerator implements Sample {

    private int currentEventValue = 0;

    @Override
    public int next() {
        ++currentEventValue;
        ++currentEventValue;
        return currentEventValue;
    }

    @Override
    public String getName() {
        return "EventGenerator";
    }

    @Override
    public void run() {
        EvenChecker.test(this);
    }

}
