package sda.prog1_10.serialization;

import java.io.Serializable;

public class Person implements Serializable {//klasa immutable (wygodna klasa dla wielowątkowości)
    private String name;
    private String surname;
    private transient int age; //transient oznaczamy, których danych nie przenosimy za pomocą serializacji

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
