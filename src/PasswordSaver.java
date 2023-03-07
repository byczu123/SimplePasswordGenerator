import java.io.*;

public class PasswordSaver {

    public void savePassword(String password, String filename) {
        try {
            File file = new File(filename+".txt");
            PrintWriter zapis = new PrintWriter(filename+".txt");
            zapis.println(password);
            zapis.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
