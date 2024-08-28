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
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class DashboardFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private MainController mainController;
    private JPanel cardPanel;
    private JTextField amountTextField;
    private JTextField descriptionTextField;
    private JTextField dateTextField;
    private JTextField timeTextField;
    private JTextField portfolioTextField;

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
        
        cardPanel.add(createDashboardPanel(), "dashboard");
        cardPanel.add(createAddTransactionPanel(), "addTransaction");

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
    
    private JPanel createDashboardPanel() {
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

        JButton btnAggiungiTransazione = new JButton("Aggiungi transazione");
        btnAggiungiTransazione.setFont(new Font("Noto Sans", Font.PLAIN, 15));
        btnAggiungiTransazione.setBackground(new Color(245, 245, 245));

        GridBagConstraints gbc_btnAggiungiTransazione = new GridBagConstraints();
        gbc_btnAggiungiTransazione.gridx = 1;
        gbc_btnAggiungiTransazione.gridy = 3;
        gbc_btnAggiungiTransazione.insets = new Insets(5, 5, 5, 5);
        gbc_btnAggiungiTransazione.anchor = GridBagConstraints.CENTER;
        dashboardPanel.add(btnAggiungiTransazione, gbc_btnAggiungiTransazione);
        btnAggiungiTransazione.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.show(cardPanel, "addTransaction");
            }
        });

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
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFrame loginFrame = new LoginFrame(mainController);
                loginFrame.setVisible(true);
                
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(dashboardPanel);
                topFrame.dispose();
            }
        });

        
        return dashboardPanel;
    }
    
    private JPanel createAddTransactionPanel() {
        JPanel addTransactionPanel = new JPanel();
        addTransactionPanel.setBackground(new Color(23, 171, 96));

        GridBagLayout gbl_addTransactionPanel = new GridBagLayout();
        gbl_addTransactionPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        gbl_addTransactionPanel.columnWeights = new double[]{1.0, 0.1, 0.0, 0.1, 1.0};
        gbl_addTransactionPanel.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
        addTransactionPanel.setLayout(gbl_addTransactionPanel);

        // Inserisci la somma
        JLabel lblInserisciLaSomma = new JLabel("Inserisci la somma");
        lblInserisciLaSomma.setForeground(new Color(245, 245, 245));
        lblInserisciLaSomma.setFont(new Font("Noto Sans", Font.PLAIN, 14));
        GridBagConstraints gbc_lblInserisciLaSomma = new GridBagConstraints();
        gbc_lblInserisciLaSomma.insets = new Insets(10, 0, 5, 5);
        gbc_lblInserisciLaSomma.gridx = 2;
        gbc_lblInserisciLaSomma.gridy = 0;
        addTransactionPanel.add(lblInserisciLaSomma, gbc_lblInserisciLaSomma);

        // Simbolo Euro
        JLabel lblNewLabel = new JLabel("€");
        lblNewLabel.setForeground(new Color(245, 245, 245));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 1;
        addTransactionPanel.add(lblNewLabel, gbc_lblNewLabel);

        // TextField per la somma
        amountTextField = new JTextField();
        amountTextField.setFont(new Font("Noto Sans", Font.PLAIN, 12));
        GridBagConstraints gbc_amountTextField = new GridBagConstraints();
        gbc_amountTextField.insets = new Insets(0, 0, 5, 5);
        gbc_amountTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_amountTextField.gridx = 2;
        gbc_amountTextField.gridy = 1;
        gbc_amountTextField.weightx = 0.1;
        addTransactionPanel.add(amountTextField, gbc_amountTextField);
        amountTextField.setColumns(10);

        // Inserisci la descrizione
        JLabel lblInserisciLaDescrizione = new JLabel("Inserisci la descrizione");
        lblInserisciLaDescrizione.setFont(new Font("Noto Sans", Font.PLAIN, 14));
        lblInserisciLaDescrizione.setForeground(new Color(245, 245, 245));
        GridBagConstraints gbc_lblInserisciLaDescrizione = new GridBagConstraints();
        gbc_lblInserisciLaDescrizione.insets = new Insets(10, 0, 5, 5);
        gbc_lblInserisciLaDescrizione.gridx = 2;
        gbc_lblInserisciLaDescrizione.gridy = 2;
        addTransactionPanel.add(lblInserisciLaDescrizione, gbc_lblInserisciLaDescrizione);

        // TextField per la descrizione
        descriptionTextField = new JTextField();
        descriptionTextField.setFont(new Font("Noto Sans", Font.PLAIN, 12));
        GridBagConstraints gbc_descriptionTextField = new GridBagConstraints();
        gbc_descriptionTextField.insets = new Insets(0, 0, 5, 5);
        gbc_descriptionTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_descriptionTextField.gridx = 2;
        gbc_descriptionTextField.gridy = 3;
        gbc_descriptionTextField.weightx = 0.1; 
        addTransactionPanel.add(descriptionTextField, gbc_descriptionTextField);
        descriptionTextField.setColumns(10);

        // Inserisci la data e l'ora
        JLabel lblInserisciLaData = new JLabel("Inserisci la data e l'ora");
        lblInserisciLaData.setForeground(new Color(245, 245, 245));
        lblInserisciLaData.setFont(new Font("Noto Sans", Font.PLAIN, 14));
        GridBagConstraints gbc_lblInserisciLaData = new GridBagConstraints();
        gbc_lblInserisciLaData.insets = new Insets(10, 0, 5, 5);
        gbc_lblInserisciLaData.gridx = 2;
        gbc_lblInserisciLaData.gridy = 4;
        addTransactionPanel.add(lblInserisciLaData, gbc_lblInserisciLaData);

        // Label Data
        JLabel lblData = new JLabel("Data:");
        lblData.setFont(new Font("Noto Sans", Font.BOLD, 12));
        lblData.setForeground(new Color(245, 245, 245));
        GridBagConstraints gbc_lblData = new GridBagConstraints();
        gbc_lblData.insets = new Insets(0, 0, 5, 5);
        gbc_lblData.anchor = GridBagConstraints.EAST;
        gbc_lblData.gridx = 1;
        gbc_lblData.gridy = 5;
        addTransactionPanel.add(lblData, gbc_lblData);

        // TextField per la data
        dateTextField = new JTextField();
        dateTextField.setFont(new Font("Noto Sans", Font.PLAIN, 12));
        GridBagConstraints gbc_dateTextField = new GridBagConstraints();
        gbc_dateTextField.insets = new Insets(0, 0, 5, 5);
        gbc_dateTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_dateTextField.gridx = 2;
        gbc_dateTextField.gridy = 5;
        gbc_dateTextField.weightx = 0.1; 
        addTransactionPanel.add(dateTextField, gbc_dateTextField);
        dateTextField.setColumns(10);

        // Label Ora
        JLabel lblOra = new JLabel("Ora:");
        lblOra.setForeground(new Color(245, 245, 245));
        lblOra.setFont(new Font("Noto Sans", Font.BOLD, 12));
        GridBagConstraints gbc_lblOra = new GridBagConstraints();
        gbc_lblOra.insets = new Insets(0, 0, 5, 5);
        gbc_lblOra.anchor = GridBagConstraints.EAST;
        gbc_lblOra.gridx = 1;
        gbc_lblOra.gridy = 6;
        addTransactionPanel.add(lblOra, gbc_lblOra);

        // TextField per l'ora
        timeTextField = new JTextField();
        timeTextField.setFont(new Font("Noto Sans", Font.PLAIN, 12));
        GridBagConstraints gbc_timeTextField = new GridBagConstraints();
        gbc_timeTextField.insets = new Insets(0, 0, 5, 5);
        gbc_timeTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_timeTextField.gridx = 2;
        gbc_timeTextField.gridy = 6;
        gbc_timeTextField.weightx = 0.1; 
        addTransactionPanel.add(timeTextField, gbc_timeTextField);
        timeTextField.setColumns(10);

        // Specifica il tipo di transazione
        JLabel lblSpecificaIlTipo = new JLabel("Specifica il tipo di transazione");
        lblSpecificaIlTipo.setForeground(new Color(245, 245, 245));
        lblSpecificaIlTipo.setFont(new Font("Noto Sans", Font.PLAIN, 14));
        GridBagConstraints gbc_lblSpecificaIlTipo = new GridBagConstraints();
        gbc_lblSpecificaIlTipo.insets = new Insets(10, 0, 5, 5);
        gbc_lblSpecificaIlTipo.gridx = 2;
        gbc_lblSpecificaIlTipo.gridy = 7;
        addTransactionPanel.add(lblSpecificaIlTipo, gbc_lblSpecificaIlTipo);
        
        JPanel checkboxPanel = new JPanel();
        checkboxPanel.setBackground(new Color(23, 171, 96));
        GridBagConstraints gbc_checkboxPanel = new GridBagConstraints();
        gbc_checkboxPanel.insets = new Insets(0, 0, 5, 5);
        gbc_checkboxPanel.fill = GridBagConstraints.BOTH;
        gbc_checkboxPanel.gridx = 2;
        gbc_checkboxPanel.gridy = 8;
        addTransactionPanel.add(checkboxPanel, gbc_checkboxPanel);
        
        // CheckBox Entrata
        JCheckBox chckbxEntrata = new JCheckBox("Entrata");
        checkboxPanel.add(chckbxEntrata);
        chckbxEntrata.setFont(new Font("Noto Sans", Font.PLAIN, 14));
        chckbxEntrata.setBackground(new Color(23, 171, 96));
        chckbxEntrata.setForeground(new Color(245, 245, 245));

        // CheckBox Uscita
        JCheckBox chckbxUscita = new JCheckBox("Uscita");
        checkboxPanel.add(chckbxUscita);
        chckbxUscita.setFont(new Font("Noto Sans", Font.PLAIN, 14));
        chckbxUscita.setBackground(new Color(23, 171, 96));
        chckbxUscita.setForeground(new Color(245, 245, 245));
        
        JPanel distancePanel = new JPanel();
        distancePanel.setBackground(new Color(23, 171, 96));
        GridBagConstraints gbc_distancePanel = new GridBagConstraints();
        gbc_distancePanel.insets = new Insets(0, 0, 5, 0);
        gbc_distancePanel.gridx = 4;
        gbc_distancePanel.gridy = 8;
        addTransactionPanel.add(distancePanel, gbc_distancePanel);

        // Inserisci il nome del Portfolio
        JLabel lblInserisciNomeDel = new JLabel("Inserisci il nome del Portfolio di destinazione");
        lblInserisciNomeDel.setForeground(new Color(245, 245, 245));
        lblInserisciNomeDel.setFont(new Font("Noto Sans", Font.PLAIN, 14));
        GridBagConstraints gbc_lblInserisciNomeDel = new GridBagConstraints();
        gbc_lblInserisciNomeDel.insets = new Insets(10, 0, 5, 5);
        gbc_lblInserisciNomeDel.gridx = 2;
        gbc_lblInserisciNomeDel.gridy = 9;
        addTransactionPanel.add(lblInserisciNomeDel, gbc_lblInserisciNomeDel);

        // TextField per il Portfolio
        portfolioTextField = new JTextField();
        GridBagConstraints gbc_portfolioTextField = new GridBagConstraints();
        gbc_portfolioTextField.insets = new Insets(0, 0, 5, 0);
        gbc_portfolioTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_portfolioTextField.gridx = 2;
        gbc_portfolioTextField.gridy = 10;
        gbc_portfolioTextField.weightx = 0.1;
        addTransactionPanel.add(portfolioTextField, gbc_portfolioTextField);
        portfolioTextField.setColumns(10);

        // Bottone Salva
        JButton btnSalva = new JButton("Salva");
        btnSalva.setFont(new Font("Noto Sans", Font.PLAIN, 14));
        btnSalva.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc_btnSalva = new GridBagConstraints();
        gbc_btnSalva.insets = new Insets(20, 0, 5, 5);
        gbc_btnSalva.gridx = 2;
        gbc_btnSalva.gridy = 11;
        addTransactionPanel.add(btnSalva, gbc_btnSalva);

        // Bottone Torna alla dashboard
        JButton btnDashboard = new JButton("Torna alla dashboard");
        btnDashboard.setBackground(new Color(245, 245, 245));
        btnDashboard.setFont(new Font("Noto Sans", Font.PLAIN, 14));
        GridBagConstraints gbc_btnDashboard = new GridBagConstraints();
        gbc_btnDashboard.insets = new Insets(0, 0, 0, 5);
        gbc_btnDashboard.gridx = 2;
        gbc_btnDashboard.gridy = 12;
        addTransactionPanel.add(btnDashboard, gbc_btnDashboard);
        btnDashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.show(cardPanel, "dashboard");
            }
        });

        return addTransactionPanel;
    }

}


