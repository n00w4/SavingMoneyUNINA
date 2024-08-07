package oo.smu.GUI.GUIFrames;

import oo.smu.GUI.MainController;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private MainController mainController;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginFrame(MainController mainController) {
    	setResizable(false);
        this.mainController = mainController;
        initComponents();
    }
    
    private void initComponents() {
        setTitle("SavingMoneyUNINA");
        setSize(370, 160);
        setLocationRelativeTo(null);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        SpringLayout sl_panel = new SpringLayout();
        panel.setLayout(sl_panel);
        JLabel label = new JLabel("Username");
        sl_panel.putConstraint(SpringLayout.NORTH, label, 11, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.WEST, label, 47, SpringLayout.WEST, panel);
        sl_panel.putConstraint(SpringLayout.SOUTH, label, -100, SpringLayout.SOUTH, panel);
        panel.add(label);
        usernameField = new JTextField();
        sl_panel.putConstraint(SpringLayout.EAST, label, -6, SpringLayout.WEST, usernameField);
        sl_panel.putConstraint(SpringLayout.NORTH, usernameField, -1, SpringLayout.NORTH, label);
        sl_panel.putConstraint(SpringLayout.WEST, usernameField, 139, SpringLayout.WEST, panel);
        panel.add(usernameField);
        JLabel label_1 = new JLabel("Password");
        sl_panel.putConstraint(SpringLayout.NORTH, label_1, 41, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.WEST, label_1, 47, SpringLayout.WEST, panel);
        panel.add(label_1);
        passwordField = new JPasswordField();
        sl_panel.putConstraint(SpringLayout.NORTH, passwordField, 41, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.WEST, passwordField, 139, SpringLayout.WEST, panel);
        sl_panel.putConstraint(SpringLayout.EAST, passwordField, -48, SpringLayout.EAST, panel);
        sl_panel.putConstraint(SpringLayout.EAST, usernameField, 0, SpringLayout.EAST, passwordField);
        sl_panel.putConstraint(SpringLayout.EAST, label_1, -6, SpringLayout.WEST, passwordField);
        sl_panel.putConstraint(SpringLayout.SOUTH, label_1, 0, SpringLayout.SOUTH, passwordField);
        panel.add(passwordField);

        loginButton = new JButton("Login");
        sl_panel.putConstraint(SpringLayout.NORTH, loginButton, 90, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.SOUTH, passwordField, -28, SpringLayout.NORTH, loginButton);
        sl_panel.putConstraint(SpringLayout.WEST, loginButton, 140, SpringLayout.WEST, panel);
        sl_panel.putConstraint(SpringLayout.SOUTH, loginButton, -10, SpringLayout.SOUTH, panel);
        sl_panel.putConstraint(SpringLayout.EAST, loginButton, -141, SpringLayout.EAST, panel);
        panel.add(loginButton);

        getContentPane().add(panel, BorderLayout.CENTER);
     }
}

