/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.AARomanov1985.dump.multithreading.samples.sample2;

/**
 *
 * @author raan
 */
public class Server {
    private volatile int value = 10;

    public synchronized int setValue(int value) {
        this.value = value;
        Thread.yield();
        return this.value;
    }
}
