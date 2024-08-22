package oo.smu.GUI;

import javax.swing.*;

import oo.smu.Controller.MainController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private MainController mainController;
	private JTextField usernameTextField;
	private JPasswordField passwordField;

    public LoginFrame(MainController mainController) {
    	getContentPane().setBackground(new Color(8, 60, 51));
    	setResizable(false);
        this.mainController = mainController;
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Accedi - SavingMoneyUNINA");
        setSize(800, 600);
        setLocationRelativeTo(null);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(23, 171, 96));
        panel.setBounds(0, 0, 250, 570);
        SpringLayout sl_panel = new SpringLayout();
        panel.setLayout(sl_panel);

        getContentPane().add(panel);
        
        JLabel lblAccedi = new JLabel("Accedi");
        lblAccedi.setForeground(new Color(245, 245, 245));
        panel.add(lblAccedi);
        lblAccedi.setFont(new Font("Noto Sans", Font.PLAIN, 20));
        
        JLabel lblUsername = new JLabel("Username");
        sl_panel.putConstraint(SpringLayout.WEST, lblAccedi, 0, SpringLayout.WEST, lblUsername);
        sl_panel.putConstraint(SpringLayout.SOUTH, lblAccedi, -58, SpringLayout.NORTH, lblUsername);
        lblUsername.setFont(new Font("Noto Sans", Font.PLAIN, 14));
        lblUsername.setForeground(new Color(245, 245, 245));
        panel.add(lblUsername);
        
        usernameTextField = new JTextField();
        sl_panel.putConstraint(SpringLayout.SOUTH, lblUsername, -6, SpringLayout.NORTH, usernameTextField);
        sl_panel.putConstraint(SpringLayout.EAST, usernameTextField, -35, SpringLayout.EAST, panel);
        panel.add(usernameTextField);
        usernameTextField.setColumns(10);
        
        JLabel lblPassword = new JLabel("Password");
        sl_panel.putConstraint(SpringLayout.WEST, lblPassword, 88, SpringLayout.WEST, panel);
        sl_panel.putConstraint(SpringLayout.WEST, lblUsername, 0, SpringLayout.WEST, lblPassword);
        sl_panel.putConstraint(SpringLayout.SOUTH, usernameTextField, -6, SpringLayout.NORTH, lblPassword);
        lblPassword.setFont(new Font("Noto Sans", Font.PLAIN, 14));
        lblPassword.setForeground(new Color(245, 245, 245));
        panel.add(lblPassword);
        
        passwordField = new JPasswordField();
        sl_panel.putConstraint(SpringLayout.WEST, passwordField, 30, SpringLayout.WEST, panel);
        sl_panel.putConstraint(SpringLayout.EAST, passwordField, -35, SpringLayout.EAST, panel);
        sl_panel.putConstraint(SpringLayout.WEST, usernameTextField, 0, SpringLayout.WEST, passwordField);
        sl_panel.putConstraint(SpringLayout.NORTH, passwordField, 265, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.SOUTH, lblPassword, -6, SpringLayout.NORTH, passwordField);
        panel.add(passwordField);
        
        JButton btnLogin = new JButton("Log In");
        sl_panel.putConstraint(SpringLayout.NORTH, btnLogin, 29, SpringLayout.SOUTH, passwordField);
        sl_panel.putConstraint(SpringLayout.WEST, btnLogin, 30, SpringLayout.WEST, panel);
        sl_panel.putConstraint(SpringLayout.EAST, btnLogin, -35, SpringLayout.EAST, panel);
        btnLogin.setFont(new Font("Noto Sans", Font.PLAIN, 14));
        btnLogin.setBackground(new Color(245, 245, 245));
        panel.add(btnLogin);
        
        JLabel lblSavingmoneyunina = new JLabel("SavingMoneyUNINA");
        sl_panel.putConstraint(SpringLayout.NORTH, lblSavingmoneyunina, 10, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.WEST, lblSavingmoneyunina, 10, SpringLayout.WEST, panel);
        lblSavingmoneyunina.setForeground(new Color(245, 245, 245));
        lblSavingmoneyunina.setFont(new Font("Noto Sans", Font.BOLD, 22));
        panel.add(lblSavingmoneyunina);
     }
}

