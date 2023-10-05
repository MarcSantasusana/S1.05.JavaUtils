package n1exercici4;

import java.io.*;


public class Directory {

    private final File txtFile;

    public Directory(String filePath)  {

        txtFile = new File(filePath);

    }


    void readFile() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(txtFile));

        String line;

        while ((line = br.readLine()) != null) {

            System.out.println(line);
        }

        br.close();
    }
}
