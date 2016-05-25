/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.AARomanov1985.dump.multithreading.samples.sample2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ru.AARomanov1985.dump.multithreading.Sample;

/**
 *
 * @author raan
 */
public class ValManagerTester implements Sample {

    @Override
    public String getName() {
        return "ValManagerTester";
    }

    @Override
    public void run() {
        Server server = new Server();
        ExecutorService ex = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            ex.execute(new ValueManager((int) (Math.random()*1000), server));
        }
        ex.shutdown();
    }

}
