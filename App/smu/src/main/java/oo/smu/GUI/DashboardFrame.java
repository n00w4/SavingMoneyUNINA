package oo.smu.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oo.smu.Controller.MainController;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

public class DashboardFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private MainController mainController;
	private JPanel contentPane;
	
	public DashboardFrame(MainController mainController) {
		setResizable(false);
		this.mainController = mainController;
		initComponents();
	}
	
	public void initComponents() {
		setTitle("Dashboard - SavingMoneyUNINA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(7, 60, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(23, 171, 96));
		panel.setBounds(12, 0, 423, 270);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblBenvenuto = new JLabel("Bentornato!");
		sl_panel.putConstraint(SpringLayout.NORTH, lblBenvenuto, 20, SpringLayout.NORTH, panel);
		lblBenvenuto.setForeground(new Color(245, 245, 245));
		lblBenvenuto.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		sl_panel.putConstraint(SpringLayout.WEST, lblBenvenuto, 169, SpringLayout.WEST, panel);
		panel.add(lblBenvenuto);
		
		JButton btnGestisciTransazioni = new JButton("Gestisci transazioni");
		sl_panel.putConstraint(SpringLayout.NORTH, btnGestisciTransazioni, 85, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnGestisciTransazioni, 110, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnGestisciTransazioni, -110, SpringLayout.EAST, panel);
		btnGestisciTransazioni.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		btnGestisciTransazioni.setBackground(new Color(245, 245, 245));
		panel.add(btnGestisciTransazioni);
		
		JButton btnVisualizzaReportMensile = new JButton("Visualizza report mensile");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblBenvenuto, -17, SpringLayout.NORTH, btnVisualizzaReportMensile);
		sl_panel.putConstraint(SpringLayout.WEST, btnVisualizzaReportMensile, 0, SpringLayout.WEST, btnGestisciTransazioni);
		sl_panel.putConstraint(SpringLayout.NORTH, btnVisualizzaReportMensile, 52, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnVisualizzaReportMensile, -6, SpringLayout.NORTH, btnGestisciTransazioni);
		sl_panel.putConstraint(SpringLayout.EAST, btnVisualizzaReportMensile, 0, SpringLayout.EAST, btnGestisciTransazioni);
		btnVisualizzaReportMensile.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		btnVisualizzaReportMensile.setBackground(new Color(245, 245, 245));
		panel.add(btnVisualizzaReportMensile);
		
		JButton btnLogout = new JButton("Logout");
		sl_panel.putConstraint(SpringLayout.NORTH, btnLogout, 146, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnGestisciTransazioni, -34, SpringLayout.NORTH, btnLogout);
		sl_panel.putConstraint(SpringLayout.EAST, lblBenvenuto, 0, SpringLayout.EAST, btnLogout);
		sl_panel.putConstraint(SpringLayout.WEST, btnLogout, 155, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnLogout, -162, SpringLayout.EAST, panel);
		btnLogout.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		btnLogout.setBackground(new Color(245, 245, 245));
		panel.add(btnLogout);
		
		btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                LoginFrame loginFrame = new LoginFrame(mainController);
                loginFrame.setVisible(true);
            }
        });
	}
}
