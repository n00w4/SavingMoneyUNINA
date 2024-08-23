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
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame(MainController mainController) {
        getContentPane().setBackground(new Color(23, 171, 96));
        this.mainController = mainController;
        initComponents();
    }

    private void performLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try {
            if (mainController.tryLogin(username, password)) {
                dispose();
                mainController.showDashboardFrame();
            } else {
                JOptionPane.showMessageDialog(LoginFrame.this, "Login fallito!");
            }
        } catch (SQLException e1) { e1.printStackTrace(); }
    }

    private void initComponents() {
        setTitle("Accedi - SavingMoneyUNINA");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("smuIcon.png")).getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());

        GridBagConstraints gbcPanel = new GridBagConstraints();
        gbcPanel.insets = new Insets(5, 5, 5, 5);
        gbcPanel.fill = GridBagConstraints.BOTH;

        gbcPanel.gridwidth = 1;
        gbcPanel.weightx = 0.3;
        gbcPanel.weighty = 1;

        JPanel panel = new JPanel();
        panel.setBackground(new Color(23, 171, 96));
        panel.setLayout(new GridBagLayout());
        getContentPane().add(panel, gbcPanel);

        GridBagConstraints gbcTitle = new GridBagConstraints();
        gbcTitle.anchor = GridBagConstraints.NORTH;
        gbcTitle.insets = new Insets(0, 5, 30, 5);
        gbcTitle.gridx = 0;
        gbcTitle.gridy = 0;
        gbcTitle.fill = GridBagConstraints.HORIZONTAL;
        JLabel lblSavingmoneyunina = new JLabel("SavingMoneyUNINA");
        lblSavingmoneyunina.setVerticalAlignment(SwingConstants.TOP);
        lblSavingmoneyunina.setForeground(new Color(245, 245, 245));
        lblSavingmoneyunina.setFont(new Font("Noto Sans", Font.BOLD, 23));
        panel.add(lblSavingmoneyunina, gbcTitle);

        GridBagConstraints gbcLabel = new GridBagConstraints();
        gbcLabel.insets = new Insets(0, 5, 5, 0);
        gbcLabel.gridx = 0;
        gbcLabel.gridy = 1;
        JLabel lblAccedi = new JLabel("Accedi");
        lblAccedi.setForeground(new Color(245, 245, 245));
        lblAccedi.setFont(new Font("Noto Sans", Font.BOLD, 20));
        panel.add(lblAccedi, gbcLabel);

        GridBagConstraints gbcUsernameLabel = new GridBagConstraints();
        gbcUsernameLabel.insets = new Insets(0, 5, 5, 0);
        gbcUsernameLabel.gridx = 0;
        gbcUsernameLabel.gridy = 3;
        gbcUsernameLabel.fill = GridBagConstraints.BOTH;
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Noto Sans", Font.PLAIN, 14));
        lblUsername.setForeground(new Color(245, 245, 245));
        panel.add(lblUsername, gbcUsernameLabel);

        GridBagConstraints gbcUsernameField = new GridBagConstraints();
        gbcUsernameField.insets = new Insets(0, 5, 5, 0);
        gbcUsernameField.gridx = 0;
        gbcUsernameField.gridy = 4;
        gbcUsernameField.fill = GridBagConstraints.BOTH;
        usernameField = new JTextField(10);
        panel.add(usernameField, gbcUsernameField);

        GridBagConstraints gbcPasswordLabel = new GridBagConstraints();
        gbcPasswordLabel.insets = new Insets(0, 5, 5, 0);
        gbcPasswordLabel.gridx = 0;
        gbcPasswordLabel.gridy = 5;
        gbcPasswordLabel.fill = GridBagConstraints.BOTH;
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Noto Sans", Font.PLAIN, 14));
        lblPassword.setForeground(new Color(245, 245, 245));
        panel.add(lblPassword, gbcPasswordLabel);

        GridBagConstraints gbcPasswordField = new GridBagConstraints();
        gbcPasswordField.insets = new Insets(0, 5, 5, 0);
        gbcPasswordField.gridx = 0;
        gbcPasswordField.gridy = 6;
        gbcPasswordField.fill = GridBagConstraints.BOTH;
        passwordField = new JPasswordField(10);
        panel.add(passwordField, gbcPasswordField);

        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });

        GridBagConstraints gbcLoginButton = new GridBagConstraints();
        gbcLoginButton.insets = new Insets(0, 5, 5, 0);
        gbcLoginButton.gridx = 0;
        gbcLoginButton.gridy = 8;
        gbcLoginButton.fill = GridBagConstraints.BOTH;
        JButton loginButton = new JButton("Log In");
        loginButton.setFont(new Font("Noto Sans", Font.PLAIN, 14));
        loginButton.setBackground(new Color(245, 245, 245));
        panel.add(loginButton, gbcLoginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });

        GridBagConstraints gbcImagePanel = new GridBagConstraints();
        gbcImagePanel.gridwidth = 1;
        gbcImagePanel.weightx = 0.7;
        gbcImagePanel.fill = GridBagConstraints.BOTH;

        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(new Color(8, 60, 51));
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("smuIcon.png"));
        JLabel imageLabel = new JLabel(icon, JLabel.CENTER);
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        getContentPane().add(imagePanel, gbcImagePanel);
    }
}


