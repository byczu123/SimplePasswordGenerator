import javax.swing.*;

public class PasswordGenerator {
    public static void main(String[] args) {
        PasswordOptions passwordOptions = new PasswordOptions();

        String response;
        response = JOptionPane.showInputDialog("How many characters do you want?");
        int length = Integer.parseInt(response);
        passwordOptions.setLength(length);
        JOptionPane.showMessageDialog(null,"Your password will be "+passwordOptions.getLength()+ " length.");
        int reply = JOptionPane.showConfirmDialog(null,"Do you want to use uppercase characters?", "Uppercase choice",JOptionPane.YES_NO_OPTION);

        passwordOptions.setUppercase(reply == JOptionPane.YES_OPTION);

        reply = JOptionPane.showConfirmDialog(null,"Do you want to use lowercase characters?", "Lowercase choice",JOptionPane.YES_NO_OPTION);

        passwordOptions.setLowercase(reply == JOptionPane.YES_OPTION);

        reply = JOptionPane.showConfirmDialog(null,"Do you want to use symbol characters?", "Symbol choice",JOptionPane.YES_NO_OPTION);

        passwordOptions.setSymbols(reply == JOptionPane.YES_OPTION);

        reply = JOptionPane.showConfirmDialog(null,"Do you want to use number characters?", "Number choice",JOptionPane.YES_NO_OPTION);

        passwordOptions.setNumbers(reply == JOptionPane.YES_OPTION);

        PasswordGeneratorUtils passwordGeneratorUtils = new PasswordGeneratorUtils();
        String signs = passwordGeneratorUtils.chooseSigns(passwordOptions);
        String password = passwordGeneratorUtils.generatePassword(signs,passwordOptions.getLength());


        String message = "Here is your password: \n"+ password;
        JOptionPane.showMessageDialog(null,message);
        String filename = JOptionPane.showInputDialog("What will be name of your password file?");
        PasswordSaver passwordSaver = new PasswordSaver();
        passwordSaver.savePassword(password,filename);
    }
}
