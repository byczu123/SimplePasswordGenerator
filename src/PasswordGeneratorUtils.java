import java.util.Random;


public class PasswordGeneratorUtils {
    //method that gets as argument passwordOptions, checks all of its fields and returns
    //string that contains characters which will be used to create a password
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

        //System.out.println(signs);
        return signs;
    }
    //method that gets as argument signs from chooseSigns method and password length
    //generate password and return it as a string
    public String generatePassword(String signs,int length){
        int index;
        char randomChar;

        Random rand;
        StringBuilder password = new StringBuilder();
        for (int i = 0;i<length ;i++) {
            rand = new Random();
            index = rand.nextInt(signs.length());
            randomChar = signs.charAt(index);
            password.append(randomChar);

        }
        return String.valueOf(password);
    }
}
