package sda.prog1_10.threads.messages;

import java.util.Random;

public class ThreadTalks {

    public static void main(String[] args) {
        Message message = new Message();
        (new Thread(new Writer(message))).start();//wywołania anonimowe
        (new Thread(new Reader(message))).start();//wywołania anonimowe
    }
}

class Message {
    private String message;
    private boolean empty;

    public synchronized String read() {//synchronized wrzucamy na najmniejszym możliwym kawałku kodu
        while(empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Błąd odczytu");
            }
        }
        empty = true;
        notifyAll();//jeden wątek z drugim komunikuje się
        return message;
    }

    public synchronized void write(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Błąd zapisu");
            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}

//producer
class Writer implements Runnable {
    private Message message;
    private String[] messages = {
      "Line1", "Line2", "Line3", "Line4"
    };

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(4000)); //czekamy jakiś okres czasu,
                // ale nie więcej niż 2000ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        message.write("FIN!");
    }


}

//consumer
class Reader implements Runnable {
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();//obiekt pozwalający na zwrócenie losowej wartości
        for (String latestMessage = message.read(); latestMessage != "FIN!";
        latestMessage = message.read()) {
            System.out.println("Odczytano: " + latestMessage);
            try {
                Thread.sleep(random.nextInt(6000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}













