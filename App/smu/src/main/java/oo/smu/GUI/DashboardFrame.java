package oo.smu.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oo.smu.Controller.MainController;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

public class DashboardFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private MainController mainController;
	private JPanel contentPane;
	
	public DashboardFrame(MainController mainController) {
		setResizable(true);
		this.mainController = mainController;
		initComponents();
	}
	
	public void initComponents() {
		setTitle("Dashboard - SavingMoneyUNINA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblBenvenuto = new JLabel("Bentornato!");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblBenvenuto, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblBenvenuto, -182, SpringLayout.EAST, contentPane);
		contentPane.add(lblBenvenuto);
		
		JButton btnVisualizzaReportMensile = new JButton("Visualizza report mensile");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnVisualizzaReportMensile, 10, SpringLayout.WEST, contentPane);
		contentPane.add(btnVisualizzaReportMensile);
		
		JButton btnAggiungiNuovaTransazione = new JButton("Aggiungi nuova transazione");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAggiungiNuovaTransazione, 63, SpringLayout.SOUTH, lblBenvenuto);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnVisualizzaReportMensile, 0, SpringLayout.NORTH, btnAggiungiNuovaTransazione);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAggiungiNuovaTransazione, 0, SpringLayout.EAST, contentPane);
		contentPane.add(btnAggiungiNuovaTransazione);
		
		JButton btnLogout = new JButton("Logout");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnLogout, 0, SpringLayout.WEST, lblBenvenuto);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnLogout, -38, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnLogout);
	}
}
