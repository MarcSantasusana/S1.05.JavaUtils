package n1exercici2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Directory {
    private final File directory;

    public Directory(String directoryPath)
    {
        directory = new File(directoryPath);

    }

    public File getDirectory() {
        return directory;
    }

    public void sortDirectory(File directory)
    {
        if(directory.exists())
        {
            String[] names_files = directory.list();

            if(names_files != null) {

                Arrays.sort(names_files);

                for (String name : names_files)
                {
                    File file = new File(directory.getAbsolutePath(),name);

                    Date lastModified = new Date(file.lastModified());
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    String formattedDateString = formatter.format(lastModified);

                    if (file.isDirectory())
                    {
                        System.out.println(file.getName() + " (D) " + formattedDateString);
                        sortDirectory(file);
                    }

                    else
                    {
                        System.out.println(file.getName() + " (F) " + formattedDateString);
                    }
                }
            }

        }

        else
        {
            System.out.println("This directory does not exist");
        }

    }
}
