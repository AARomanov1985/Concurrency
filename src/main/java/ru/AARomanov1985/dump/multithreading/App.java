package ru.AARomanov1985.dump.multithreading;

import java.util.*;
import ru.AARomanov1985.dump.multithreading.samples.sample1.EvenGenerator;
import ru.AARomanov1985.dump.multithreading.samples.sample1.MutexEvenGenerator;
import ru.AARomanov1985.dump.multithreading.samples.sample1.SynchronizedEvenGenerator;
import ru.AARomanov1985.dump.multithreading.samples.sample2.ValManagerTester;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        while (true) {
            App app = new App();
            System.out.println("Выберите пример:");
            List<Sample> modules = app.getModules();
            app.listModules(modules);
            System.out.print(">");
            Sample curr_module = app.getCurrentModule(modules);
            if (curr_module != null) {
                curr_module.run();
            }
            System.out.println("==================================");
        }
    }

    private List<Sample> getModules() {
        List<Sample> modules = new ArrayList<>();
        modules.add(new EvenGenerator());
        modules.add(new SynchronizedEvenGenerator());
        modules.add(new ValManagerTester());
        modules.add(new MutexEvenGenerator());
        return modules;
    }

    private void listModules(List<Sample> modules) {
        for (int i = 0; i < modules.size(); i++) {
            System.out.println(i + ". " + modules.get(i).getName());
        }
    }

    private Sample getCurrentModule(List<Sample> modules) {
        Scanner sc = new Scanner(System.in);
        Sample curr_module = null;
        try {
            curr_module = modules.get(Integer.parseInt(sc.nextLine()));
        } catch (NullPointerException | IndexOutOfBoundsException ingonre) {
            System.out.println("Неверное значение");
        }
        return curr_module;
    }
}
