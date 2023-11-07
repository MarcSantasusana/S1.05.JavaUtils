package n1exercici5;

import java.io.IOException;


public class Main {

    public static void main(String[] args) {

        try {

            String serFilePath = "person.ser";

               Directory directory = new Directory(serFilePath);

                directory.serialize();

                directory.deserialize();




        }

        catch(IOException | ClassNotFoundException e)
        {
            System.out.println(e.getMessage());

        }


    }

}

