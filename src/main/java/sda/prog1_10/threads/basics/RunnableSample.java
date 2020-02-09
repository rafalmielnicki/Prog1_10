package sda.prog1_10.threads.basics;

import static sda.prog1_10.threads.ThreadColor.ANSI_RED;

public class RunnableSample implements Runnable { //utworzenie nowego wątku 2 sposób
                                                //używamy przy użyciu w klasie dziedziczenia,
                                                // bo nie możemy dziedziczyć po 2 klasach

    @Override
    public void run() {
        System.out.println(ANSI_RED+ " Runnable sample working " );
    }
}
