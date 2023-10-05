package n1exercici1;

import java.io.File;
import java.util.Arrays;

public class Directory {

    private  final File directory;

    public Directory(String directoryPath)
    {
       directory = new File(directoryPath);

    }

    public void sortDirectory()
    {
        if(directory.exists())
        {
            String[] files_names = directory.list();

            if(files_names != null) {

                Arrays.sort(files_names);

                for (String name : files_names)
                {
                    System.out.println(name);
                }

            }
            else {

                System.out.println("This directory is empty");
            }

        }

        else
        {
            System.out.println("This directory does not exist");
        }

    }
}
