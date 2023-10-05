package n1exercici3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Directory {

    private final File directory;
    private final PrintWriter txtFileWriter;

    public Directory(String inFilePath, String outFilePath) throws FileNotFoundException {

        directory = new File(inFilePath);
        txtFileWriter = new PrintWriter(outFilePath);

    }

    public File getDirectory() {
        return directory;
    }

    public PrintWriter getTxtFileWriter() {
        return txtFileWriter;
    }

    public void sortDirectory(File directory) throws FileNotFoundException
    {
        if(directory.exists())
        {
            String[] files_names = directory.list();

            if(files_names != null) {

                Arrays.sort(files_names);

                for (String name : files_names)
                {
                    File file = new File(directory.getAbsolutePath(),name);

                    Date lastModified = new Date(file.lastModified());
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    String formattedDateString = formatter.format(lastModified);

                    if (file.isDirectory())
                    {
                        txtFileWriter.println(file.getName() + " (D) " + formattedDateString);
                        sortDirectory(file);
                    }

                    else
                    {
                        txtFileWriter.println(file.getName() + " (F) " + formattedDateString);
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
