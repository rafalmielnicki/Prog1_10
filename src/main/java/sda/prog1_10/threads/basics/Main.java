package sda.prog1_10.threads.basics;

import static sda.prog1_10.threads.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE+ " Main thread in action");

        Thread otherThread = new OtherThread();
        otherThread.setName("==== OTHER THREAD====");
        otherThread.start(); //zawsze startujemy tak wątek (metoda start()) [do zainicjowania nowego wątku]
        // przy rozszerzeniu klasy Thread mimo implementacji metody run
        //otherThread.run(); //to nie powołuje nowego wątku

        Thread runnableSample = new Thread(new RunnableSample());
        runnableSample.start(); //zawsze startujemy tak wątek (metoda start())
        // przy rozszerzeniu klasy Thread mimo implementacji metody run
        System.out.println(ANSI_PURPLE + " End of main");

        //korzystamy z klas anonimowych jako tymczasowych dla małych rzeczy, jednorazowa akcja
        //wątek na klasie anonimowej - 3 sposób utworzenia nowego wątku
        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Anonymous class based thread");
            }
        }.start();

        runnableSample = new Thread(new RunnableSample() {//klasa anonimowa
            @Override
            public void run() {
                System.out.println(ANSI_RED + " overridden RunnableSample");
                try {
                    otherThread.join(); //jeden wątek czeka na drugi
                    System.out.println(ANSI_RED + "Other thread terminated" +
                            " so I work again");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "overridden Runnable terminated");
                }
            }
        });
        runnableSample.start();
        otherThread.interrupt();//włączenie/wyłączenie

    }

}
