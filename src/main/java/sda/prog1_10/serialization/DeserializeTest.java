package sda.prog1_10.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeTest {

    public static void main(String[] args) {
        Person person = null;

        try {
            FileInputStream file = new FileInputStream("PersonSerialized.data");
            ObjectInputStream ois = new ObjectInputStream(file);//zamiana obiektu na strumień
            person = (Person) ois.readObject();
            ois.close();
            file.close();
            System.out.println(person.getName() + " " + person.getSurname());
            System.out.println(person.getAge());
            System.out.println(person.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
