package n1exercici2;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        if(args.length == 1)
        {
            Directory directory = new Directory(args[0]);

            directory.sortDirectory(directory.getDirectory());

        }
        else
        {

            System.out.println("The class argument has not been correctly specified");
        }


    }
}