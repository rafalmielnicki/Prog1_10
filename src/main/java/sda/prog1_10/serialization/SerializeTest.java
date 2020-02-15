package sda.prog1_10.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeTest {

    public static void main(String[] args) {
        Person person = new Person("Jan", "Kowalski", 24);

        try {
            FileOutputStream fileOutputStream =
                    new FileOutputStream("PersonSerialized.data");
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);

            oos.writeObject(person);
            oos.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
