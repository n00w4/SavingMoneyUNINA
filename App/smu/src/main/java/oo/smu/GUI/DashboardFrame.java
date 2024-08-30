package oo.smu.GUI;

import oo.smu.Entity.User;
import oo.smu.Entity.Income;
import oo.smu.Entity.Portfolio;
import oo.smu.Entity.Card;
import oo.smu.Entity.Expense;
import oo.smu.Controller.MainController;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class DashboardFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private MainController mainController;
	private User user;
	private JPanel cardPanel;
	private JTextField amountTextField;
	private JTextField descriptionTextField;
	private JTextField dateTextField;
	private JTextField timeTextField;
	private JTextField portfolioTextField;
	private JTextField cardNumberTextField;
	private JTextField chckbxTextField;

	public DashboardFrame(MainController mainController, User user) {
		this.mainController = mainController;
		this.user = user;
		initComponents();
	}

	public void initComponents() {
		setTitle("SavingMoneyUNINA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
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
		gbl_dashboardPanel.columnWidths = new int[] { 1, 1, 1 };
		gbl_dashboardPanel.rowHeights = new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1 };
		gbl_dashboardPanel.columnWeights = new double[] { 1.0, 1.0, 1.0 };
		gbl_dashboardPanel.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 1.0 };
		dashboardPanel.setLayout(gbl_dashboardPanel);

		JPanel distancePanel = new JPanel();
		distancePanel.setBackground(new Color(23, 171, 96));
		distancePanel.setLayout(null);
		GridBagConstraints gbc_distancePanel = new GridBagConstraints();
		gbc_distancePanel.insets = new Insets(0, 0, 5, 5);
		gbc_distancePanel.fill = GridBagConstraints.BOTH;
		gbc_distancePanel.gridx = 1;
		gbc_distancePanel.gridy = 0;
		dashboardPanel.add(distancePanel, gbc_distancePanel);

		JLabel lblBentornato = new JLabel(
				String.format("Bentornato %s %s!", user.getFirstName(), user.getSecondName()));
		lblBentornato.setHorizontalAlignment(SwingConstants.CENTER);
		lblBentornato.setFont(new Font("Noto Sans", Font.BOLD, 14));
		lblBentornato.setForeground(new Color(245, 245, 245));

		GridBagConstraints gbc_lblBentornato = new GridBagConstraints();
		gbc_lblBentornato.gridx = 1;
		gbc_lblBentornato.gridy = 1;
		gbc_lblBentornato.insets = new Insets(5, 5, 5, 5);
		gbc_lblBentornato.anchor = GridBagConstraints.NORTH;
		dashboardPanel.add(lblBentornato, gbc_lblBentornato);

		JPanel distancePanel2 = new JPanel();
		distancePanel2.setBackground(new Color(23, 171, 96));
		distancePanel2.setLayout(null);
		GridBagConstraints gbc_distancePanel2 = new GridBagConstraints();
		gbc_distancePanel2.insets = new Insets(0, 0, 5, 5);
		gbc_distancePanel2.fill = GridBagConstraints.BOTH;
		gbc_distancePanel2.gridx = 1;
		gbc_distancePanel2.gridy = 9;
		dashboardPanel.add(distancePanel2, gbc_distancePanel2);

		JButton btnAggiungiTransazione = new JButton("Aggiungi transazione");
		btnAggiungiTransazione.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		btnAggiungiTransazione.setBackground(new Color(245, 245, 245));

		GridBagConstraints gbc_btnAggiungiTransazione = new GridBagConstraints();
		gbc_btnAggiungiTransazione.gridx = 1;
		gbc_btnAggiungiTransazione.gridy = 10;
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
		gbc_btnVisualizzaTransazioni.gridy = 11;
		dashboardPanel.add(btnVisualizzaTransazioni, gbc_btnVisualizzaTransazioni);

		JButton btnVisualizzaReportMensile = new JButton("Visualizza report mensile");
		btnVisualizzaReportMensile.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		btnVisualizzaReportMensile.setBackground(new Color(245, 245, 245));
		GridBagConstraints gbc_btnVisualizzaReportMensile = new GridBagConstraints();
		gbc_btnVisualizzaReportMensile.insets = new Insets(0, 0, 5, 5);
		gbc_btnVisualizzaReportMensile.gridx = 1;
		gbc_btnVisualizzaReportMensile.gridy = 12;
		dashboardPanel.add(btnVisualizzaReportMensile, gbc_btnVisualizzaReportMensile);

		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(new Color(245, 245, 245));
		btnLogout.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		GridBagConstraints gbc_btnLogout = new GridBagConstraints();
		gbc_btnLogout.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogout.gridx = 1;
		gbc_btnLogout.gridy = 14;
		dashboardPanel.add(btnLogout, gbc_btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginFrame loginFrame = new LoginFrame(mainController);
				loginFrame.setVisible(true);
				user = null;
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
		gbl_addTransactionPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_addTransactionPanel.columnWeights = new double[] { 1.0, 0.1, 1.0, 0.1, 1.0 };
		gbl_addTransactionPanel.rowHeights = new int[] { 30, 30, 30, 30, 30, 30, 30, 0, 30, 0, 0, 30, 0, 0, 30, 30, 30,
				0, 30 };
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

		chckbxEntrata.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// Deseleziona l'altra checkbox
					chckbxUscita.setSelected(false);
				}
			}
		});
		chckbxUscita.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// Deseleziona l'altra checkbox
					chckbxEntrata.setSelected(false);
				}
			}
		});

		JLabel lblInserisciIlRicevente = new JLabel(
				"Inserisci il ricevente (Uscita) o il mittente (Entrata) della somma");
		lblInserisciIlRicevente.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		lblInserisciIlRicevente.setForeground(new Color(245, 245, 245));
		GridBagConstraints gbc_lblInserisciIlRicevente = new GridBagConstraints();
		gbc_lblInserisciIlRicevente.insets = new Insets(0, 0, 5, 5);
		gbc_lblInserisciIlRicevente.gridx = 2;
		gbc_lblInserisciIlRicevente.gridy = 9;
		addTransactionPanel.add(lblInserisciIlRicevente, gbc_lblInserisciIlRicevente);

		chckbxTextField = new JTextField();
		GridBagConstraints gbc_chckbxTextField = new GridBagConstraints();
		gbc_chckbxTextField.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxTextField.gridx = 2;
		gbc_chckbxTextField.gridy = 10;
		addTransactionPanel.add(chckbxTextField, gbc_chckbxTextField);
		chckbxTextField.setColumns(10);

		JPanel distancePanel = new JPanel();
		distancePanel.setBackground(new Color(23, 171, 96));
		GridBagConstraints gbc_distancePanel = new GridBagConstraints();
		gbc_distancePanel.insets = new Insets(0, 0, 5, 0);
		gbc_distancePanel.gridx = 4;
		gbc_distancePanel.gridy = 11;
		addTransactionPanel.add(distancePanel, gbc_distancePanel);

		JLabel lblInserisciIlNumero = new JLabel("Inserisci il numero della carta associata");
		lblInserisciIlNumero.setForeground(new Color(245, 245, 245));
		lblInserisciIlNumero.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblInserisciIlNumero = new GridBagConstraints();
		gbc_lblInserisciIlNumero.insets = new Insets(0, 0, 5, 5);
		gbc_lblInserisciIlNumero.gridx = 2;
		gbc_lblInserisciIlNumero.gridy = 12;
		addTransactionPanel.add(lblInserisciIlNumero, gbc_lblInserisciIlNumero);

		cardNumberTextField = new JTextField();
		cardNumberTextField.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		GridBagConstraints gbc_cardNumberTextField = new GridBagConstraints();
		gbc_cardNumberTextField.insets = new Insets(0, 0, 5, 5);
		gbc_cardNumberTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_cardNumberTextField.gridx = 2;
		gbc_cardNumberTextField.gridy = 13;
		addTransactionPanel.add(cardNumberTextField, gbc_cardNumberTextField);
		cardNumberTextField.setColumns(10);

		// Inserisci il nome del Portfolio
		JLabel lblInserisciNomeDel = new JLabel("Inserisci il nome del Portfolio di destinazione");
		lblInserisciNomeDel.setForeground(new Color(245, 245, 245));
		lblInserisciNomeDel.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_lblInserisciNomeDel = new GridBagConstraints();
		gbc_lblInserisciNomeDel.insets = new Insets(10, 0, 5, 5);
		gbc_lblInserisciNomeDel.gridx = 2;
		gbc_lblInserisciNomeDel.gridy = 14;
		addTransactionPanel.add(lblInserisciNomeDel, gbc_lblInserisciNomeDel);

		// TextField per il Portfolio
		portfolioTextField = new JTextField();
		portfolioTextField.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		GridBagConstraints gbc_portfolioTextField = new GridBagConstraints();
		gbc_portfolioTextField.insets = new Insets(0, 0, 5, 5);
		gbc_portfolioTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_portfolioTextField.gridx = 2;
		gbc_portfolioTextField.gridy = 15;
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
		gbc_btnSalva.gridy = 17;
		addTransactionPanel.add(btnSalva, gbc_btnSalva);
		btnSalva.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String amountString = amountTextField.getText().trim().replace(',', '.');
					String description = descriptionTextField.getText();
					String dateText = dateTextField.getText().trim().replace('/', '-');
					String timeText = timeTextField.getText().trim();
					String portfolioName = portfolioTextField.getText();
					String chckbxText = chckbxTextField.getText();
					String cardNumber = cardNumberTextField.getText().trim();

					if (amountString.isEmpty() || description.isEmpty() || dateText.isEmpty() || timeText.isEmpty()
							|| portfolioName.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Compila tutti i campi prima di salvare.", "Errore",
								JOptionPane.ERROR_MESSAGE);
					}

					DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
					// Parsing della data
					LocalDate date = LocalDate.parse(dateText, dateFormatter);
					// Parsing dell'ora
					LocalTime time = LocalTime.parse(timeText, timeFormatter);

					Card card = mainController.findCardByCardNumber(cardNumber);
					Portfolio portfolio = mainController.findUserPortfolioByName(portfolioName, user);

					if (chckbxEntrata.isSelected()) {
						Income income = new Income(Float.parseFloat(amountString), LocalDateTime.of(date, time),
								description, chckbxText);
						mainController.saveIncome(income, card, portfolio);
					}
					if (chckbxUscita.isSelected()) {
						Expense expense = new Expense(Float.parseFloat(amountString), LocalDateTime.of(date, time),
								description, chckbxText);
						mainController.saveExpense(expense, card, portfolio);
					}
					JOptionPane.showMessageDialog(null, "Transazione salvata con successo!", "Successo",
							JOptionPane.INFORMATION_MESSAGE);

					// Reset dei campi dopo il salvataggio
					amountTextField.setText("");
					descriptionTextField.setText("");
					dateTextField.setText("");
					timeTextField.setText("");
					chckbxTextField.setText("");
					cardNumberTextField.setText("");
					portfolioTextField.setText("");
					chckbxEntrata.setSelected(false);
					chckbxUscita.setSelected(false);

				} catch (Exception exception) {
					exception.printStackTrace();
					JOptionPane.showMessageDialog(null, "Transazione non salvata, riprova più tardi", "Errore",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// Bottone Torna alla dashboard
		JButton btnDashboard = new JButton("Torna alla dashboard");
		btnDashboard.setBackground(new Color(245, 245, 245));
		btnDashboard.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		GridBagConstraints gbc_btnDashboard = new GridBagConstraints();
		gbc_btnDashboard.insets = new Insets(0, 0, 0, 5);
		gbc_btnDashboard.gridx = 2;
		gbc_btnDashboard.gridy = 18;
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
