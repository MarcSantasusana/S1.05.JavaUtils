package n3exercici1;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int option;
        boolean quit = false;

        try {

            Encryption encryption = new Encryption();

            while (!quit) {



                option = askInt("Menu: \n" +
                        "1.choose file \n" +
                        "2.Encrypt file \n" +
                        "3.Decrypt file \n" +
                        "4.Quit \n");

                switch (option) {

                    case 1:

                        encryption.chooseFile();

                        break;

                    case 2:

                        encryption.encryptText();
                        break;

                    case 3:
                        encryption.decryptText();
                        break;

                    case 4:
                        quit = true;
                        break;

                    default:
                        System.out.println("This is not a valid option");
                }

            }

        }catch(NoSuchPaddingException | IllegalBlockSizeException | IOException | NoSuchAlgorithmException | BadPaddingException | InvalidKeyException |
               InputMismatchException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static int askInt(String message)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println(message);

        int info = scanner.nextInt();

        return info;
    }



}
