import java.io.*;

public class PasswordSaver {
    //method that saves password to the filename.txt
    public void savePassword(String password, String filename) {
        try {
            PrintWriter save = new PrintWriter(filename+".txt");
            save.println(password);
            save.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
