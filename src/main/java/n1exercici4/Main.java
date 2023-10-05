package n1exercici4;


import java.io.IOException;


public class Main {

    public static void main(String[] args) {

        try {

            if (args.length == 1) {

                Directory directory = new Directory(args[0]);

                directory.readFile();


            } else {

                System.out.println("The class argument has not been correctly specified");
            }

        }

        catch(IOException e)
        {
            System.out.println("Error when trying to read the file");
        }


    }

}

