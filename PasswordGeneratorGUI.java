import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PasswordGeneratorGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Password Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel lengthLabel = new JLabel("Password Length:");
        JTextField lengthField = new JTextField();
        JLabel complexityLabel = new JLabel("Password Complexity:");
        JCheckBox useUppercase = new JCheckBox("Uppercase");
        JCheckBox useLowercase = new JCheckBox("Lowercase");
        JCheckBox useNumbers = new JCheckBox("Numbers");
        JCheckBox useSpecialChars = new JCheckBox("Special Characters");

        panel.add(lengthLabel);
        panel.add(lengthField);
        panel.add(complexityLabel);
        panel.add(useUppercase);
        panel.add(useLowercase);
        panel.add(useNumbers);
        panel.add(useSpecialChars);

        JButton generateButton = new JButton("Generate Password");
        JButton clearButton = new JButton("Clear");
        JLabel passwordLabel = new JLabel();

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int length = Integer.parseInt(lengthField.getText());
                boolean uppercase = useUppercase.isSelected();
                boolean lowercase = useLowercase.isSelected();
                boolean numbers = useNumbers.isSelected();
                boolean specialChars = useSpecialChars.isSelected();

                String password = generatePassword(length, uppercase, lowercase, numbers, specialChars);
                passwordLabel.setText("Generated Password: " + password);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lengthField.setText("");
                useUppercase.setSelected(false);
                useLowercase.setSelected(false);
                useNumbers.setSelected(false);
                useSpecialChars.setSelected(false);
                passwordLabel.setText("Generated Password: ");
            }
        });

        frame.add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(generateButton);
        buttonPanel.add(clearButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(passwordLabel, BorderLayout.NORTH);
      //  frame.add(passwordLabel,BorderLayout.PAGE_END);

        frame.pack();
        frame.setVisible(true);
    }

    private static String generatePassword(int length, boolean useUppercase, boolean useLowercase, boolean useNumbers, boolean useSpecialChars) {
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String numberChars = "0123456789";
        String specialChars = "!@#$%^&*()-_+=<>?";

        StringBuilder validChars = new StringBuilder();
        if (useUppercase) {
            validChars.append(uppercaseChars);
        }
        if (useLowercase) {
            validChars.append(lowercaseChars);
        }
        if (useNumbers) {
            validChars.append(numberChars);
        }
        if (useSpecialChars) {
            validChars.append(specialChars);
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            password.append(validChars.charAt(randomIndex));
        }
        return password.toString();
    }
}