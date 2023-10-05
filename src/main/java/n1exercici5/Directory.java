package n1exercici5;

import java.io.*;


public class Directory {

    private final String serPath;
    private final Person person;

    public Directory(String serPath){

       this.serPath = serPath;
       this.person = new Person("Pere", 43, "64987632G");

    }


    void serialize() throws IOException {

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(serPath));
        out.writeObject(person);
        out.close();
    }

    void deserialize() throws IOException, ClassNotFoundException {

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(serPath));
        Person recuperated_person = (Person)in.readObject();
        in.close();
        System.out.println(recuperated_person);
    }
}
