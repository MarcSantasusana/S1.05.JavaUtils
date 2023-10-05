package n1exercici1;

public class Main {

    public static void main(String[] args) {

        if(args.length == 1)
        {
            Directory directory = new Directory(args[0]);

            directory.sortDirectory();
        }
        else
        {

            System.out.println("The class argument has not been correctly specified");
        }


    }
}