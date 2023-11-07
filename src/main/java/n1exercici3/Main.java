package n1exercici3;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        try {

            String outFilePath = "directories.txt";

            if (args.length == 1) {

                Directory directory = new Directory(args[0], outFilePath);

                directory.sortDirectory(directory.getDirectory());

                directory.getTxtFileWriter().close();

            } else {

                System.out.println("The class argument has not been correctly specified");
            }

        }

        catch(FileNotFoundException e)
        {
            System.out.println("This file does not exist");
        }


    }
}

