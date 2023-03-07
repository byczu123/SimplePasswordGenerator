import java.util.Random;
import java.util.UUID;

public class PasswordGeneratorUtils {
    public String chooseSigns(PasswordOptions passwordOptions) {
        String signs = "";
        if (passwordOptions.isUppercase())
            signs += "QWERTYUIOPASDFGHJKLZXCVBNM";
        if(passwordOptions.isLowercase())
            signs += "qwertyuiopasdfghjklzxcvbnm";
        if (passwordOptions.isNumbers())
            signs += "1234567890";
        if (passwordOptions.isSymbols())
            signs += "!@#$%^&*()";

        System.out.println(signs);
        return signs;
    }
    public String generatePassword(String signs,int length){
        int index;
        char randomChar;
        String password="";
        Random rand;
        for (int i = 0;i<length ;i++) {
            rand = new Random();
            index = rand.nextInt(signs.length());
            randomChar = signs.charAt(index);
            password += String.valueOf(randomChar);

        }
        return password;
    }
}
