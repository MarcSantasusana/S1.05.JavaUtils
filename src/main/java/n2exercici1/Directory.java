package n2exercici1;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

public class Directory {

    private final File directory;
    private final PrintWriter txtFileWriter;

    private final Properties properties;



    public Directory(String propertiesPath) throws IOException {

         properties = new Properties();

         properties.load(new FileInputStream(propertiesPath));

        directory = new File(properties.getProperty("inDirectory"));

        txtFileWriter = new PrintWriter(properties.getProperty("outDirectory") + properties.getProperty("outName"));

    }

    public File getDirectory() {
        return directory;
    }

    public PrintWriter getTxtFileWriter() {
        return txtFileWriter;
    }

    public void sortDirectory(File directory) throws FileNotFoundException {

        if (directory.exists()) {

            String[] files_names = directory.list();

            if (files_names != null) {

                Arrays.sort(files_names);

                for (String nom : files_names) {
                    File file = new File(directory.getAbsolutePath(), nom);

                    Date lastModified = new Date(file.lastModified());
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    String formattedDateString = formatter.format(lastModified);

                    if (file.isDirectory()) {
                        txtFileWriter.println(file.getName() + " (D) " + formattedDateString);
                        sortDirectory(file);
                    } else {
                        txtFileWriter.println(file.getName() + " (F) " + formattedDateString);
                    }
                }
            }

        } else {
            System.out.println("This directory does not exist");
        }

    }

}