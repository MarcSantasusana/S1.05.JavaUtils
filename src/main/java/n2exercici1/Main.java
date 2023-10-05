package n2exercici1;


import java.io.IOException;


public class Main {

    public static void main(String[] args) {

        try {

            String propertiesPath = "n2exercici1/Properties.properties";

                Directory directory = new Directory(propertiesPath);

                directory.sortDirectory(directory.getDirectory());

                directory.getTxtFileWriter().close();


        }

        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }


    }

}

