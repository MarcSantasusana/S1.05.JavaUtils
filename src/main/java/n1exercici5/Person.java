package n1exercici5;

import java.io.Serializable;

public class Person implements Serializable {

    private String name;
    private int age;

    private String ID;

    public Person(String name, int age, String ID) {
        this.name = name;
        this.age = age;
        this.ID = ID;
    }

}
