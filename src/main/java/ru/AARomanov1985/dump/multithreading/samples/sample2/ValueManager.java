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
public class ValueManager implements Runnable {

    private int value;
    private Server server;

    public ValueManager(int value, Server server) {
        this.value = value;
        this.server = server;
    }

    @Override
    public void run() {
        while (true) {
            if (server.setValue(value) != value) {
                System.out.println(this.hashCode()+": Значение изменено!");
                return;
            }
        }
    }
}
