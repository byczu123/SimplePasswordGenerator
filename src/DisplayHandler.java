import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class DisplayHandler extends JFrame{
    public DisplayHandler(){
        PasswordOptions passwordOptions = new PasswordOptions();
        PasswordGeneratorUtils passwordGeneratorUtils = new PasswordGeneratorUtils();
        PasswordSaver passwordSaver = new PasswordSaver();

        //Creating components for layout
        JFrame frame = new JFrame();
        GridLayout grid = new GridLayout(10, 1, 3, 3);

        JLabel lengthLabel = new JLabel("How long do you want your password to be?");
        JLabel uppercaseLabel = new JLabel("Do you want to use uppercase characters?");
        JLabel lowercaseLabel = new JLabel("Do you want to use lowercase characters?");
        JLabel numberLabel = new JLabel("Do you want to use numeric characters?");
        JLabel signLabel = new JLabel("Do you want to use sign characters?");
        JLabel filenameLabel = new JLabel("Name of your file");
        JTextField lengthField = new JTextField(2);
        JCheckBox uppercaseCheckBox = new JCheckBox("",false);
        JCheckBox lowercaseCheckBox = new JCheckBox("", false);
        JCheckBox numberCheckBox = new JCheckBox("", false);
        JCheckBox signCheckBox = new JCheckBox("", false);
        JTextField filenameField = new JTextField(5);
        JButton submitButton = new JButton("Submit");

        //Adding components to layout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(grid);
        frame.add(lengthLabel);
        frame.add(lengthField);
        frame.add(uppercaseLabel);
        frame.add(uppercaseCheckBox);
        frame.add(lowercaseLabel);
        frame.add(lowercaseCheckBox);
        frame.add(numberLabel);
        frame.add(numberCheckBox);
        frame.add(signLabel);
        frame.add(signCheckBox);
        frame.add(filenameLabel);
        frame.add(filenameField);
        frame.add(submitButton);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //check if given length of password is a number
                    passwordOptions.setLength(Integer.parseInt(lengthField.getText()));
                }catch (Exception exception){
                    System.out.println("nan");
                }
                //check if given password length is longer than 0
                if(passwordOptions.getLength()>0) {
                    //if it is, creating passwordOptions to get user options for the password
                    passwordOptions.setLowercase(lowercaseCheckBox.isSelected());
                    passwordOptions.setUppercase(uppercaseCheckBox.isSelected());
                    passwordOptions.setNumbers(numberCheckBox.isSelected());
                    passwordOptions.setSymbols(signCheckBox.isSelected());

                    //passing user password options to passwordGeneratorUtils
                    String signs = passwordGeneratorUtils.chooseSigns(passwordOptions);
                    //generating password
                    String password = passwordGeneratorUtils.generatePassword(signs,passwordOptions.getLength());
                    //get filename from filenameField
                    String filename = filenameField.getText();
                    frame.setVisible(false);
                    //save password, passing password and filename to create txt file
                    passwordSaver.savePassword(password,filename);
                    JOptionPane.showMessageDialog(null,"Your password: "+password);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

                }else {
                    System.out.println("length must be positive value larger than 0!");
                }

            }
        });
    }
}
