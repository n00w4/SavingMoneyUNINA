package oo.smu.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oo.smu.Controller.MainController;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextField;

public class DashboardFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private MainController mainController;
    private JPanel cardPanel;
    private JTextField textField;

    public DashboardFrame(MainController mainController) {
        this.mainController = mainController;
        initComponents();
    }

    public void initComponents() {
        setTitle("SavingMoneyUNINA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("smuIcon.png")).getImage());

        JPanel outerPanel = new JPanel(new BorderLayout());
        outerPanel.setBackground(new Color(7, 60, 51));
        outerPanel.setBorder(new EmptyBorder(10, 0, 0, 0));

        cardPanel = new JPanel();
        cardPanel.setLayout(new CardLayout());
        cardPanel.setBackground(new Color(7, 60, 51));

        outerPanel.add(cardPanel, BorderLayout.CENTER);
        setContentPane(outerPanel);

        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setBackground(new Color(23, 171, 96));
        cardPanel.add(dashboardPanel, "dashboard");

        GridBagLayout gbl_dashboardPanel = new GridBagLayout();
        gbl_dashboardPanel.columnWidths = new int[]{1, 1, 1};
        gbl_dashboardPanel.rowHeights = new int[]{1, 0, 0, 2, 0, 0, 0, 0, 1};
        gbl_dashboardPanel.columnWeights = new double[]{1.0, 0.0, 1.0};
        gbl_dashboardPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
        dashboardPanel.setLayout(gbl_dashboardPanel);

        JLabel lblBentornato = new JLabel("Bentornato!");
        lblBentornato.setHorizontalAlignment(SwingConstants.CENTER);
        lblBentornato.setFont(new Font("Noto Sans", Font.BOLD, 14));
        lblBentornato.setForeground(new Color(245, 245, 245));

        GridBagConstraints gbc_lblBentornato = new GridBagConstraints();
        gbc_lblBentornato.gridx = 1;
        gbc_lblBentornato.gridy = 1;
        gbc_lblBentornato.insets = new Insets(5, 5, 5, 5);
        gbc_lblBentornato.anchor = GridBagConstraints.NORTH;
        dashboardPanel.add(lblBentornato, gbc_lblBentornato);

        JButton btnGestisciTransazioni = new JButton("Aggiungi transazione");
        btnGestisciTransazioni.setFont(new Font("Noto Sans", Font.PLAIN, 15));
        btnGestisciTransazioni.setBackground(new Color(245, 245, 245));

        GridBagConstraints gbc_btnGestisciTransazioni = new GridBagConstraints();
        gbc_btnGestisciTransazioni.gridx = 1;
        gbc_btnGestisciTransazioni.gridy = 3;
        gbc_btnGestisciTransazioni.insets = new Insets(5, 5, 5, 5);
        gbc_btnGestisciTransazioni.anchor = GridBagConstraints.CENTER;
        dashboardPanel.add(btnGestisciTransazioni, gbc_btnGestisciTransazioni);

        JButton btnVisualizzaTransazioni = new JButton("Visualizza transazioni");
        btnVisualizzaTransazioni.setBackground(new Color(245, 245, 245));
        btnVisualizzaTransazioni.setFont(new Font("Noto Sans", Font.PLAIN, 15));
        GridBagConstraints gbc_btnVisualizzaTransazioni = new GridBagConstraints();
        gbc_btnVisualizzaTransazioni.insets = new Insets(0, 0, 5, 5);
        gbc_btnVisualizzaTransazioni.gridx = 1;
        gbc_btnVisualizzaTransazioni.gridy = 4;
        dashboardPanel.add(btnVisualizzaTransazioni, gbc_btnVisualizzaTransazioni);

        JButton btnVisualizzaReportMensile = new JButton("Visualizza report mensile");
        btnVisualizzaReportMensile.setFont(new Font("Noto Sans", Font.PLAIN, 15));
        btnVisualizzaReportMensile.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc_btnVisualizzaReportMensile = new GridBagConstraints();
        gbc_btnVisualizzaReportMensile.insets = new Insets(0, 0, 5, 5);
        gbc_btnVisualizzaReportMensile.gridx = 1;
        gbc_btnVisualizzaReportMensile.gridy = 5;
        dashboardPanel.add(btnVisualizzaReportMensile, gbc_btnVisualizzaReportMensile);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setBackground(new Color(245, 245, 245));
        btnLogout.setFont(new Font("Noto Sans", Font.PLAIN, 15));
        GridBagConstraints gbc_btnLogout = new GridBagConstraints();
        gbc_btnLogout.insets = new Insets(0, 0, 5, 5);
        gbc_btnLogout.gridx = 1;
        gbc_btnLogout.gridy = 7;
        dashboardPanel.add(btnLogout, gbc_btnLogout);

        JPanel addTransactionPanel = new JPanel();
        addTransactionPanel.setBackground(new Color(23, 171, 96));
        cardPanel.add(addTransactionPanel, "name_4295965428862");

        GridBagLayout gbl_addTransactionPanel = new GridBagLayout();
        gbl_addTransactionPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_addTransactionPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
        gbl_addTransactionPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_addTransactionPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        addTransactionPanel.setLayout(gbl_addTransactionPanel);

        JLabel lblInserisciLaSomma = new JLabel("Inserisci la somma della transazione");
        lblInserisciLaSomma.setForeground(new Color(245, 245, 245));
        lblInserisciLaSomma.setFont(new Font("Noto Sans", Font.PLAIN, 14));
        GridBagConstraints gbc_lblInserisciLaSomma = new GridBagConstraints();
        gbc_lblInserisciLaSomma.gridwidth = 4;
        gbc_lblInserisciLaSomma.insets = new Insets(0, 0, 5, 5);
        gbc_lblInserisciLaSomma.gridx = 9;
        gbc_lblInserisciLaSomma.gridy = 1;
        addTransactionPanel.add(lblInserisciLaSomma, gbc_lblInserisciLaSomma);

        textField = new JTextField();
        textField.setFont(new Font("Noto Sans", Font.PLAIN, 12));
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.gridwidth = 4;
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 9;
        gbc_textField.gridy = 2;
        addTransactionPanel.add(textField, gbc_textField);
        textField.setColumns(10);

        JLabel lblInserisciLaData = new JLabel("Inserisci la data e l'ora");
        lblInserisciLaData.setForeground(new Color(245, 245, 245));
        lblInserisciLaData.setFont(new Font("Noto Sans", Font.PLAIN, 14));
        GridBagConstraints gbc_lblInserisciLaData = new GridBagConstraints();
        gbc_lblInserisciLaData.gridwidth = 4;
        gbc_lblInserisciLaData.insets = new Insets(0, 0, 5, 5);
        gbc_lblInserisciLaData.gridx = 9;
        gbc_lblInserisciLaData.gridy = 3;
        addTransactionPanel.add(lblInserisciLaData, gbc_lblInserisciLaData);

        JLabel lblSavingmoneyunina = new JLabel("SavingMoneyUNINA");
        lblSavingmoneyunina.setForeground(new Color(245, 245, 245));
        lblSavingmoneyunina.setFont(new Font("Noto Sans", Font.BOLD, 20));
        lblSavingmoneyunina.setHorizontalAlignment(SwingConstants.CENTER);
        outerPanel.add(lblSavingmoneyunina, BorderLayout.NORTH);

        ImageIcon originalIcon = new ImageIcon(getClass().getClassLoader().getResource("smuIcon.png"));
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(scaledIcon);
        outerPanel.add(imageLabel, BorderLayout.SOUTH);
    }
}


