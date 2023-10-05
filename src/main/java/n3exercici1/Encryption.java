package n3exercici1;
import javax.crypto.*;
import java.io.*;
import java.security.*;
import java.util.Scanner;

public class Encryption {

   private SecretKey secretKey;
   private String plainText;
   private byte[] cipherText;

   private File file;

    public Encryption() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException {


    }
    public  String askString(String message)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println(message);

        String info = scanner.nextLine();

        return info;
    }


    public void chooseFile() throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, IOException, InvalidKeyException {

        String plainTextPath = askString("Enter the file path");

        readFile(plainTextPath);
        generateSecretKey();

    }
    public void generateSecretKey() throws NoSuchAlgorithmException {

        KeyGenerator kGen = KeyGenerator.getInstance("AES");
        kGen.init(128);
        secretKey = kGen.generateKey();

    }

    public void encryptText() throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, IOException, IllegalBlockSizeException, BadPaddingException {

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] input = plainText.getBytes("UTF8");

         cipherText = cipher.doFinal(input);


        writeFile(cipherText);

        System.out.println("The file has been encrypted successfully!");
    }

    public void decryptText() throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, IOException, IllegalBlockSizeException, BadPaddingException
    {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decipheredText = cipher.doFinal(cipherText);


        writeFile(decipheredText);

        System.out.println("The file has been decrypted successfully!");

    }

    public void readFile(String plainTextFilePath) throws IOException
    {
        plainText ="";

        file = new File(plainTextFilePath);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;

        while ((line = br.readLine()) != null) {

            plainText += line + "\n";


        }

    }

    public void writeFile(byte[] text) throws IOException {

        FileWriter myWriter = new FileWriter(file);

        myWriter.write(new String(text, "UTF8"));

        myWriter.close();

    }

}
