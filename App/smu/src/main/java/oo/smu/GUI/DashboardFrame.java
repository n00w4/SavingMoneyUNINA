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
import javax.swing.JSpinner;
import javax.swing.JCheckBox;

public class DashboardFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private MainController mainController;
    private JPanel cardPanel;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

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
        gbl_addTransactionPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_addTransactionPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_addTransactionPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_addTransactionPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        addTransactionPanel.setLayout(gbl_addTransactionPanel);

        JLabel lblInserisciLaSomma = new JLabel("Inserisci la somma della transazione");
        lblInserisciLaSomma.setForeground(new Color(245, 245, 245));
        lblInserisciLaSomma.setFont(new Font("Noto Sans", Font.PLAIN, 14));
        GridBagConstraints gbc_lblInserisciLaSomma = new GridBagConstraints();
        gbc_lblInserisciLaSomma.gridwidth = 8;
        gbc_lblInserisciLaSomma.insets = new Insets(0, 0, 5, 5);
        gbc_lblInserisciLaSomma.gridx = 9;
        gbc_lblInserisciLaSomma.gridy = 1;
        addTransactionPanel.add(lblInserisciLaSomma, gbc_lblInserisciLaSomma);
        
        JLabel lblEuro = new JLabel("€");
        lblEuro.setForeground(new Color(245, 245, 245));
        GridBagConstraints gbc_lblEuro = new GridBagConstraints();
        gbc_lblEuro.insets = new Insets(0, 0, 5, 5);
        gbc_lblEuro.gridx = 9;
        gbc_lblEuro.gridy = 2;
        addTransactionPanel.add(lblEuro, gbc_lblEuro);

        textField = new JTextField();
        textField.setFont(new Font("Noto Sans", Font.PLAIN, 12));
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.gridwidth = 7;
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 10;
        gbc_textField.gridy = 2;
        addTransactionPanel.add(textField, gbc_textField);
        textField.setColumns(10);
                
        JLabel lblInserisciLaDescrizione = new JLabel("Inserisci la descrizione (max 255 caratteri)");
        lblInserisciLaDescrizione.setFont(new Font("Noto Sans", Font.PLAIN, 14));
        lblInserisciLaDescrizione.setForeground(new Color(245, 245, 245));
        GridBagConstraints gbc_lblInserisciLaDescrizione = new GridBagConstraints();
        gbc_lblInserisciLaDescrizione.gridwidth = 10;
        gbc_lblInserisciLaDescrizione.insets = new Insets(0, 0, 5, 5);
        gbc_lblInserisciLaDescrizione.gridx = 9;
        gbc_lblInserisciLaDescrizione.gridy = 3;
        addTransactionPanel.add(lblInserisciLaDescrizione, gbc_lblInserisciLaDescrizione);
                
        textField_1 = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.gridwidth = 10;
        gbc_textField_1.insets = new Insets(0, 0, 5, 5);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 9;
        gbc_textField_1.gridy = 4;
        addTransactionPanel.add(textField_1, gbc_textField_1);
        textField_1.setColumns(10);
                
        JLabel lblInserisciLaData = new JLabel("Inserisci la data e l'ora");
        lblInserisciLaData.setForeground(new Color(245, 245, 245));
        lblInserisciLaData.setFont(new Font("Noto Sans", Font.PLAIN, 14));
        GridBagConstraints gbc_lblInserisciLaData = new GridBagConstraints();
        gbc_lblInserisciLaData.gridwidth = 8;
        gbc_lblInserisciLaData.insets = new Insets(0, 0, 5, 5);
        gbc_lblInserisciLaData.gridx = 10;
        gbc_lblInserisciLaData.gridy = 5;
        addTransactionPanel.add(lblInserisciLaData, gbc_lblInserisciLaData);
                
        JLabel lblData = new JLabel("Data:");
        lblData.setForeground(new Color(245, 245, 245));
        lblData.setFont(new Font("Noto Sans", Font.BOLD, 12));
        GridBagConstraints gbc_lblData = new GridBagConstraints();
        gbc_lblData.insets = new Insets(0, 0, 5, 5);
        gbc_lblData.gridx = 11;
        gbc_lblData.gridy = 6;
        addTransactionPanel.add(lblData, gbc_lblData);
                
        JSpinner daySpinner = new JSpinner();
        daySpinner.setFont(new Font("Noto Sans", Font.BOLD, 12));
        daySpinner.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc_daySpinner = new GridBagConstraints();
        gbc_daySpinner.insets = new Insets(0, 0, 5, 5);
        gbc_daySpinner.gridx = 12;
        gbc_daySpinner.gridy = 6;
        addTransactionPanel.add(daySpinner, gbc_daySpinner);
        
        JSpinner monthSpinner = new JSpinner();
        monthSpinner.setFont(new Font("Noto Sans", Font.BOLD, 12));
        monthSpinner.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc_monthSpinner = new GridBagConstraints();
        gbc_monthSpinner.insets = new Insets(0, 0, 5, 5);
        gbc_monthSpinner.gridx = 13;
        gbc_monthSpinner.gridy = 6;
        addTransactionPanel.add(monthSpinner, gbc_monthSpinner);
        
        JSpinner yearSpinner = new JSpinner();
        yearSpinner.setFont(new Font("Noto Sans", Font.BOLD, 12));
        yearSpinner.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc_yearSpinner = new GridBagConstraints();
        gbc_yearSpinner.insets = new Insets(0, 0, 5, 5);
        gbc_yearSpinner.gridx = 14;
        gbc_yearSpinner.gridy = 6;
        addTransactionPanel.add(yearSpinner, gbc_yearSpinner);

        JLabel lblOra = new JLabel("Ora:");
        lblOra.setForeground(new Color(245, 245, 245));
        lblOra.setFont(new Font("Noto Sans", Font.BOLD, 12));
        GridBagConstraints gbc_lblOra = new GridBagConstraints();
        gbc_lblOra.insets = new Insets(0, 0, 5, 5);
        gbc_lblOra.gridx = 11;
        gbc_lblOra.gridy = 7;
        addTransactionPanel.add(lblOra, gbc_lblOra);

        JSpinner hourSpinner = new JSpinner();
        hourSpinner.setFont(new Font("Noto Sans", Font.BOLD, 12));
        hourSpinner.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc_hourSpinner = new GridBagConstraints();
        gbc_hourSpinner.insets = new Insets(0, 0, 5, 5);
        gbc_hourSpinner.gridx = 12;
        gbc_hourSpinner.gridy = 7;
        addTransactionPanel.add(hourSpinner, gbc_hourSpinner);
        
        JSpinner minuteSpinner = new JSpinner();
        minuteSpinner.setFont(new Font("Noto Sans", Font.BOLD, 12));
        minuteSpinner.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc_minuteSpinner = new GridBagConstraints();
        gbc_minuteSpinner.insets = new Insets(0, 0, 5, 5);
        gbc_minuteSpinner.gridx = 13;
        gbc_minuteSpinner.gridy = 7;
        addTransactionPanel.add(minuteSpinner, gbc_minuteSpinner);
        
        JSpinner secondSpinner = new JSpinner();
        secondSpinner.setFont(new Font("Noto Sans", Font.BOLD, 12));
        secondSpinner.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc_secondSpinner = new GridBagConstraints();
        gbc_secondSpinner.insets = new Insets(0, 0, 5, 5);
        gbc_secondSpinner.gridx = 14;
        gbc_secondSpinner.gridy = 7;
        addTransactionPanel.add(secondSpinner, gbc_secondSpinner);

        JLabel lblSpecificaIlTipo = new JLabel("Specifica il tipo di transazione");
        lblSpecificaIlTipo.setForeground(new Color(245, 245, 245));
        lblSpecificaIlTipo.setFont(new Font("Noto Sans", Font.PLAIN, 14));
        GridBagConstraints gbc_lblSpecificaIlTipo = new GridBagConstraints();
        gbc_lblSpecificaIlTipo.gridwidth = 8;
        gbc_lblSpecificaIlTipo.insets = new Insets(0, 0, 5, 5);
        gbc_lblSpecificaIlTipo.gridx = 9;
        gbc_lblSpecificaIlTipo.gridy = 8;
        addTransactionPanel.add(lblSpecificaIlTipo, gbc_lblSpecificaIlTipo);

        JCheckBox chckbxEntrata = new JCheckBox("Entrata");
        chckbxEntrata.setFont(new Font("Noto Sans", Font.PLAIN, 12));
        chckbxEntrata.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc_chckbxEntrata = new GridBagConstraints();
        gbc_chckbxEntrata.gridwidth = 2;
        gbc_chckbxEntrata.insets = new Insets(0, 0, 5, 5);
        gbc_chckbxEntrata.gridx = 10;
        gbc_chckbxEntrata.gridy = 9;
        addTransactionPanel.add(chckbxEntrata, gbc_chckbxEntrata);
        
        JCheckBox chckbxUscita = new JCheckBox("Uscita");
        chckbxUscita.setFont(new Font("Noto Sans", Font.PLAIN, 12));
        GridBagConstraints gbc_chckbxUscita = new GridBagConstraints();
        gbc_chckbxUscita.gridwidth = 2;
        gbc_chckbxUscita.insets = new Insets(0, 0, 5, 5);
        gbc_chckbxUscita.gridx = 14;
        gbc_chckbxUscita.gridy = 9;
        addTransactionPanel.add(chckbxUscita, gbc_chckbxUscita);

        JLabel lblInserisciNomeDel = new JLabel("Inserisci nome del Portfolio di destinazione");
        lblInserisciNomeDel.setForeground(new Color(245, 245, 245));
        lblInserisciNomeDel.setFont(new Font("Noto Sans", Font.PLAIN, 14));
        GridBagConstraints gbc_lblInserisciNomeDel = new GridBagConstraints();
        gbc_lblInserisciNomeDel.gridwidth = 10;
        gbc_lblInserisciNomeDel.insets = new Insets(0, 0, 5, 5);
        gbc_lblInserisciNomeDel.gridx = 9;
        gbc_lblInserisciNomeDel.gridy = 10;
        addTransactionPanel.add(lblInserisciNomeDel, gbc_lblInserisciNomeDel);

        textField_2 = new JTextField();
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.gridwidth = 10;
        gbc_textField_2.insets = new Insets(0, 0, 5, 5);
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridx = 9;
        gbc_textField_2.gridy = 11;
        addTransactionPanel.add(textField_2, gbc_textField_2);
        textField_2.setColumns(10);

        JButton btnSalva = new JButton("Salva");
        btnSalva.setBackground(new Color(245, 245, 245));
        btnSalva.setFont(new Font("Noto Sans", Font.PLAIN, 12));
        GridBagConstraints gbc_btnSalva = new GridBagConstraints();
        gbc_btnSalva.gridwidth = 3;
        gbc_btnSalva.insets = new Insets(0, 0, 5, 5);
        gbc_btnSalva.gridx = 12;
        gbc_btnSalva.gridy = 14;
        addTransactionPanel.add(btnSalva, gbc_btnSalva);

        JButton btnTornaAllaDashboard = new JButton("Torna alla dashboard");
        btnTornaAllaDashboard.setBackground(new Color(245, 245, 245));
        btnTornaAllaDashboard.setFont(new Font("Noto Sans", Font.PLAIN, 12));
        GridBagConstraints gbc_btnTornaAllaDashboard = new GridBagConstraints();
        gbc_btnTornaAllaDashboard.gridwidth = 5;
        gbc_btnTornaAllaDashboard.insets = new Insets(0, 0, 0, 5);
        gbc_btnTornaAllaDashboard.gridx = 11;
        gbc_btnTornaAllaDashboard.gridy = 15;
        addTransactionPanel.add(btnTornaAllaDashboard, gbc_btnTornaAllaDashboard);

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


