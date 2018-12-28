package studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.app4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Account;
import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Address;
import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Client;
import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Person;
import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Worker;

public class MainWindow{
	private JFrame mainFrame;
	
	ArrayList<Client> arrayListClients;
	ArrayList<Worker> arrayListWorkers;
	ArrayList<Person> arrayListPeople;
	ArrayList<Account> arrayListAccounts;
	ArrayList<Address> arrayListAddresses;
	
	//elementy ekranu startowego aplikacji
	private List<Component> mainScreenComponents;
	JLabel labelLogo;
	JButton buttonLogin;
	JButton buttonBrowseEquipment;
	JButton buttonCreateAccount;
	JButton buttonFirmInfo;
	JButton buttonPopularItemPhoto1;
	JLabel labelPopularItemDesc1;
	JButton buttonPopularItemPhoto2;
	JLabel labelPopularItemDesc2;
	JButton buttonPopularItemPhoto3;
	JLabel labelPopularItemDesc3;
	JButton buttonPopularItemPhoto4;
	JLabel labelPopularItemDesc4;
	JButton buttonPopularItemPhoto5;
	JLabel labelPopularItemDesc5;
	
	//elementy ekranu logowania
	private List<Component> loginScreenComponents;
	JTextField textFieldLogin;
	JPasswordField passwordFieldPassword;
	JCheckBox checkBoxShowPassword;
	JButton buttonLogin1;
	JButton buttonRemindPassword;
	JButton buttonCreateAccount1;
	JButton buttonReturnToMainScreen;
	
	//elementy przegląania sprzętu
	private List<Component> itemBrowseScreenComponents;
	JLabel labelLogo1;
	JButton buttonLogin2;
	JButton buttonCreateAccount2;
	JButton buttonToCart;
	JButton buttonSearch;
	JButton buttonFilter;
	JButton buttonReturnToMainScreen2;
	JTextField textFieldItemName;
	JPanel panelItems; //tutaj zaczynają się elementy scrollowalnego panelu
	JScrollPane scrollPaneItemPanel;
	List<JLabel> listOfAllItems;
	
	//elementy ekranu dla każdego ze sprzętów
	private List<Component> itemInfoScreenComponents;
	JLabel labelLogo2;
	JButton buttonReturnToBrowse;
	JButton buttonLogin3;
	JButton buttonCreateAccount3;
	JButton buttonToCart2;
	JLabel labelItemPhoto;
	JButton buttonAddToCart;
	JTextArea textAreaItemDescription;
	JCalendar calendar;
	
	public MainWindow(){
		initArrays();
		initComponents(); //tylko tworzenie i dodawanie elementów do okna
		initListeners(); //tworzenie i obsługa listenerów, 
		
		for(Component c : mainScreenComponents) c.setVisible(true);
		for(Component c : loginScreenComponents) c.setVisible(false);
		for(Component c : itemBrowseScreenComponents) c.setVisible(false);
		for(Component c : itemInfoScreenComponents) c.setVisible(false);
		
		mainFrame.setVisible(true);
	}
	
	private void initArrays(){
		arrayListClients = new ArrayList<Client>();
		arrayListWorkers = new ArrayList<Worker>();
		arrayListPeople = new ArrayList<Person>();
		arrayListAccounts = new ArrayList<Account>();
		arrayListAddresses = new ArrayList<Address>();
		
		mainScreenComponents = new ArrayList<Component>();
		loginScreenComponents = new ArrayList<Component>();
		itemBrowseScreenComponents = new ArrayList<Component>();
		itemInfoScreenComponents = new ArrayList<Component>();
	}
	
	private void initComponents(){		
		//ELEMENTY EKRANU STARTOWEGO ------------------------------------------------------------------------------------
		mainFrame = new JFrame("Wypozyczalnia sprzetu sportowego");
		mainFrame.setSize(new Dimension(1280,720));
		mainFrame.setResizable(false);		
		mainFrame.setLayout(null);
		
		labelLogo = new JLabel();
		labelLogo.setIcon(new ImageIcon(getClass().getResource("/Resources/Logo.png")));
		labelLogo.setBounds(800, 50, 320, 320);
		mainFrame.add(labelLogo);
		mainScreenComponents.add(labelLogo);
		
		buttonLogin = new JButton("Zaloguj się");
		buttonLogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		buttonLogin.setBounds(800, 420, 320, 40);
		mainFrame.add(buttonLogin);
		mainScreenComponents.add(buttonLogin);
		
		buttonBrowseEquipment = new JButton("Przeglądaj sprzęt");
		buttonBrowseEquipment.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		buttonBrowseEquipment.setBounds(800, 480, 320, 40);
		mainFrame.add(buttonBrowseEquipment);
		mainScreenComponents.add(buttonBrowseEquipment);
		
		buttonCreateAccount = new JButton("Załóż konto");
		buttonCreateAccount.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		buttonCreateAccount.setBounds(800, 540, 320, 40);
		mainFrame.add(buttonCreateAccount);
		mainScreenComponents.add(buttonCreateAccount);
		
		buttonFirmInfo = new JButton("O wypożyczalni");
		buttonFirmInfo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		buttonFirmInfo.setBounds(800, 600, 320, 40);
		mainFrame.add(buttonFirmInfo);
		mainScreenComponents.add(buttonFirmInfo);

		buttonPopularItemPhoto1 = new JButton();
		buttonPopularItemPhoto1.setIcon(new ImageIcon(getClass().getResource("/Resources/popularnyprzedmiot.png")));
		buttonPopularItemPhoto1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		buttonPopularItemPhoto1.setBounds(100, 60, 150, 100);
		mainFrame.add(buttonPopularItemPhoto1);
		mainScreenComponents.add(buttonPopularItemPhoto1);
		
		labelPopularItemDesc1 = new JLabel("Popularny przedmiot #1");
		labelPopularItemDesc1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelPopularItemDesc1.setBounds(300, 60, 400, 100);
		mainFrame.add(labelPopularItemDesc1);
		mainScreenComponents.add(labelPopularItemDesc1);
		
		buttonPopularItemPhoto2 = new JButton();
		buttonPopularItemPhoto2.setIcon(new ImageIcon(getClass().getResource("/Resources/popularnyprzedmiot.png")));
		buttonPopularItemPhoto2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		buttonPopularItemPhoto2.setBounds(100, 180, 150, 100);
		mainFrame.add(buttonPopularItemPhoto2);
		mainScreenComponents.add(buttonPopularItemPhoto2);
		
		labelPopularItemDesc2 = new JLabel("Popularny przedmiot #2");
		labelPopularItemDesc2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelPopularItemDesc2.setBounds(300, 180, 400, 100);
		mainFrame.add(labelPopularItemDesc2);
		mainScreenComponents.add(labelPopularItemDesc2);
		
		buttonPopularItemPhoto3 = new JButton();
		buttonPopularItemPhoto3.setIcon(new ImageIcon(getClass().getResource("/Resources/popularnyprzedmiot.png")));
		buttonPopularItemPhoto3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		buttonPopularItemPhoto3.setBounds(100, 300, 150, 100);
		mainFrame.add(buttonPopularItemPhoto3);
		mainScreenComponents.add(buttonPopularItemPhoto3);
		
		labelPopularItemDesc3 = new JLabel("Popularny przedmiot #3");
		labelPopularItemDesc3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelPopularItemDesc3.setBounds(300, 300, 400, 100);
		mainFrame.add(labelPopularItemDesc3);
		mainScreenComponents.add(labelPopularItemDesc3);
		
		buttonPopularItemPhoto4 = new JButton();
		buttonPopularItemPhoto4.setIcon(new ImageIcon(getClass().getResource("/Resources/popularnyprzedmiot.png")));
		buttonPopularItemPhoto4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		buttonPopularItemPhoto4.setBounds(100, 420, 150, 100);
		mainFrame.add(buttonPopularItemPhoto4);
		mainScreenComponents.add(buttonPopularItemPhoto4);
		
		labelPopularItemDesc4 = new JLabel("Popularny przedmiot #4");
		labelPopularItemDesc4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelPopularItemDesc4.setBounds(300, 420, 400, 100);
		mainFrame.add(labelPopularItemDesc4);
		mainScreenComponents.add(labelPopularItemDesc4);
		
		buttonPopularItemPhoto5 = new JButton();
		buttonPopularItemPhoto5.setIcon(new ImageIcon(getClass().getResource("/Resources/popularnyprzedmiot.png")));
		buttonPopularItemPhoto5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		buttonPopularItemPhoto5.setBounds(100, 540, 150, 100);
		mainFrame.add(buttonPopularItemPhoto5);
		mainScreenComponents.add(buttonPopularItemPhoto5);
		
		labelPopularItemDesc5 = new JLabel("Popularny przedmiot #5");
		labelPopularItemDesc5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelPopularItemDesc5.setBounds(300, 540, 400, 100);
		mainFrame.add(labelPopularItemDesc5);
		mainScreenComponents.add(labelPopularItemDesc5);
		
		//ELEMENTY EKRANU LOGOWANIA ------------------------------------------------------------------------------------
		textFieldLogin = new JTextField("Login");
		textFieldLogin.setBounds(500, 250, 300, 40);
		textFieldLogin.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		textFieldLogin.setForeground(Color.GRAY);
		mainFrame.add(textFieldLogin);
		loginScreenComponents.add(textFieldLogin);
		
		passwordFieldPassword = new JPasswordField("Haslo");
		passwordFieldPassword.setBounds(500, 300, 300, 40);
		passwordFieldPassword.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		passwordFieldPassword.setEchoChar((char)0);
		passwordFieldPassword.setForeground(Color.GRAY);
		mainFrame.add(passwordFieldPassword);
		loginScreenComponents.add(passwordFieldPassword);
		
		checkBoxShowPassword = new JCheckBox("Pokaż hasło");
		checkBoxShowPassword.setBounds(810, 305, 150, 30);
		mainFrame.add(checkBoxShowPassword);
		loginScreenComponents.add(checkBoxShowPassword);
		
		buttonLogin1 = new JButton("Zaloguj się");
		buttonLogin1.setBounds(600, 350, 100, 40);
		mainFrame.add(buttonLogin1);
		loginScreenComponents.add(buttonLogin1);
		
		buttonCreateAccount1 = new JButton("Utwórz konto");
		buttonCreateAccount1.setBounds(590, 550, 120, 40);
		mainFrame.add(buttonCreateAccount1);
		loginScreenComponents.add(buttonCreateAccount1);
		
		buttonRemindPassword = new JButton("Zapomniałem hasła");
		buttonRemindPassword.setBounds(350, 550, 200, 40);
		mainFrame.add(buttonRemindPassword);
		loginScreenComponents.add(buttonRemindPassword);
		
		buttonReturnToMainScreen = new JButton("Powrót do ekranu głównego");
		buttonReturnToMainScreen.setBounds(750, 550, 200, 40);
		mainFrame.add(buttonReturnToMainScreen);
		loginScreenComponents.add(buttonReturnToMainScreen);
		
		//ELEMENTY EKRANU PRZEGLADANIA SPRZETU------------------------------------------------------------------------------------
		labelLogo1 = new JLabel();
		labelLogo1.setBounds(500, 20, 400, 150);
		labelLogo1.setIcon(new ImageIcon(getClass().getResource("/Resources/Logo.png")));
		mainFrame.add(labelLogo1);
		itemBrowseScreenComponents.add(labelLogo1);
		
		buttonLogin2 = new JButton("Logowanie");
		buttonLogin2.setBounds(1050, 50, 150, 30);
		mainFrame.add(buttonLogin2);
		itemBrowseScreenComponents.add(buttonLogin2);
		
		buttonCreateAccount2 = new JButton("Utwórz konto");
		buttonCreateAccount2.setBounds(1050, 100, 150, 30);
		mainFrame.add(buttonCreateAccount2);
		itemBrowseScreenComponents.add(buttonCreateAccount2);
		
		buttonToCart = new JButton("Koszyk");
		buttonToCart.setBounds(1050, 150, 150, 30);
		mainFrame.add(buttonToCart);
		itemBrowseScreenComponents.add(buttonToCart);
		
		buttonSearch = new JButton("Szukaj");
		buttonSearch.setBounds(50, 150, 100, 30);
		mainFrame.add(buttonSearch);
		itemBrowseScreenComponents.add(buttonSearch);
		
		buttonFilter = new JButton("Filtrowanie");
		buttonFilter.setBounds(200, 150, 100, 30);
		mainFrame.add(buttonFilter);
		itemBrowseScreenComponents.add(buttonFilter);
		
		buttonReturnToMainScreen2 = new JButton("Powrót do ekranu głównego");
		buttonReturnToMainScreen2.setBounds(250, 20, 200, 30);
		mainFrame.add(buttonReturnToMainScreen2);
		itemBrowseScreenComponents.add(buttonReturnToMainScreen2);
		
		textFieldItemName = new JTextField();
		textFieldItemName.setBounds(50, 100, 350, 30);
		mainFrame.add(textFieldItemName);
		itemBrowseScreenComponents.add(textFieldItemName);
		
		panelItems = new JPanel();
		panelItems.setBackground(Color.PINK);
		
		scrollPaneItemPanel = new JScrollPane();
		scrollPaneItemPanel.setViewportView(panelItems);
		scrollPaneItemPanel.setBounds(50, 200, 1170, 450);
		mainFrame.add(scrollPaneItemPanel);
		itemBrowseScreenComponents.add(scrollPaneItemPanel);
		
		//ELEMENTY SZEGÓŁÓW KAŻDEGO ZE SPRZĘTÓW
		labelLogo2 = new JLabel();
		labelLogo2.setBounds(500, 20, 400, 150);
		labelLogo2.setIcon(new ImageIcon(getClass().getResource("/Resources/Logo.png")));
		mainFrame.add(labelLogo2);
		itemInfoScreenComponents.add(labelLogo2);
		
		buttonReturnToBrowse = new JButton("Powrót do przeglądania sprzętu");
		buttonReturnToBrowse.setBounds(50, 50, 250, 30);
		mainFrame.add(buttonReturnToBrowse);
		itemInfoScreenComponents.add(buttonReturnToBrowse);
		
		buttonLogin3 = new JButton("Logowanie");
		buttonLogin3.setBounds(1050, 50, 150, 30);
		mainFrame.add(buttonLogin3);
		itemInfoScreenComponents.add(buttonLogin3);
		
		buttonCreateAccount3 = new JButton("Utwórz konto");
		buttonCreateAccount3.setBounds(1050, 100, 150, 30);
		mainFrame.add(buttonCreateAccount3);
		itemInfoScreenComponents.add(buttonCreateAccount3);
		
		buttonToCart2 = new JButton("Koszyk");
		buttonToCart2.setBounds(1050, 150, 150, 30);
		mainFrame.add(buttonToCart2);
		itemInfoScreenComponents.add(buttonToCart2);
		
		labelItemPhoto = new JLabel();
		labelItemPhoto.setBounds(50, 200, 150, 150);
		labelItemPhoto.setIcon(new ImageIcon(getClass().getResource("/Resources/Logo.png")));
		mainFrame.add(labelItemPhoto);
		itemInfoScreenComponents.add(labelItemPhoto);
		
		buttonAddToCart = new JButton("Dodaj do koszyka");
		buttonAddToCart.setBounds(220, 320, 150, 30);
		mainFrame.add(buttonAddToCart);
		itemInfoScreenComponents.add(buttonAddToCart);
		
		textAreaItemDescription = new JTextArea();
		textAreaItemDescription.setBounds(50, 370, 1170, 450);
		textAreaItemDescription.setEnabled(false);
		mainFrame.add(textAreaItemDescription);
		itemInfoScreenComponents.add(textAreaItemDescription);
		
		calendar = new JCalendar();
		calendar.setBounds(900, 200, 300, 150);
		calendar.setMinSelectableDate(Calendar.getInstance().getTime());
		mainFrame.add(calendar);
		itemInfoScreenComponents.add(calendar);
		
	}
	
	private void initListeners(){
		//listenery ekranu głównego-------------------------------------------------------------------------------------------
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Component c : mainScreenComponents) c.setVisible(false);
				for(Component c : loginScreenComponents) c.setVisible(true);
				buttonLogin1.requestFocus(); //tylko po ro zeby na textfieldach byl szary tekst
			}
		});
		buttonBrowseEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Component c : mainScreenComponents) c.setVisible(false);
				for(Component c : itemBrowseScreenComponents) c.setVisible(true);
			}
		});
		buttonCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createAccount();
			}
		});
		buttonFirmInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainFrame, "Jeszcze sie napisze");
			}
		});
		//listenery ekranu logowania------------------------------------------------------------------------------------------
		buttonReturnToMainScreen.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				for(Component c : loginScreenComponents) c.setVisible(false);
				for(Component c : mainScreenComponents) c.setVisible(true);
				textFieldLogin.setForeground(Color.GRAY);
				textFieldLogin.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				textFieldLogin.setText("Login");
				passwordFieldPassword.setForeground(Color.GRAY);
				passwordFieldPassword.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				passwordFieldPassword.setEchoChar((char)0);
				passwordFieldPassword.setText("Haslo");
			}
		});
		
		textFieldLogin.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				textFieldLogin.setForeground(Color.BLACK);
				textFieldLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				if(textFieldLogin.getText().equals("Login")) textFieldLogin.setText("");
			}
			public void focusLost(FocusEvent e) {
				if(textFieldLogin.getText().equals("")){
					textFieldLogin.setForeground(Color.GRAY);
					textFieldLogin.setText("Login");
					textFieldLogin.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				}
			}
		});
		
		passwordFieldPassword.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				passwordFieldPassword.setEchoChar('*');
				passwordFieldPassword.setForeground(Color.BLACK);
				passwordFieldPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				if(String.valueOf(passwordFieldPassword.getPassword()).equals("Haslo")) passwordFieldPassword.setText("");
			}
			public void focusLost(FocusEvent e) {
				if(String.valueOf(passwordFieldPassword.getPassword()).equals("")){
					passwordFieldPassword.setEchoChar((char)0);
					passwordFieldPassword.setForeground(Color.GRAY);
					passwordFieldPassword.setText("Haslo");
					passwordFieldPassword.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				}
			}
		});
		
		buttonCreateAccount1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				createAccount();
			}
		});
		
		buttonRemindPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remindPassword();
			}
		});

		buttonLogin1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logIn();
			}
		});
		
		checkBoxShowPassword.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(!passwordFieldPassword.getText().equals("Haslo"))
					if(checkBoxShowPassword.isSelected()) passwordFieldPassword.setEchoChar((char)0);
					else passwordFieldPassword.setEchoChar('*');
			}
		});
		
		passwordFieldPassword.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				checkBoxShowPassword.setSelected(false);
			}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});
		passwordFieldPassword.addKeyListener(new KeyListener() {		
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				checkBoxShowPassword.setSelected(false);
			}
		});
		
		//listenery ekranu przegląania sprzętu--------------------------------------------------------------------------------
		buttonReturnToMainScreen2.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				for(Component c : itemBrowseScreenComponents) c.setVisible(false);
				for(Component c : mainScreenComponents) c.setVisible(true);
			}
		});
		
		buttonLogin2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Component c : itemBrowseScreenComponents) c.setVisible(false);
				for(Component c : loginScreenComponents) c.setVisible(true);
			}
		});
		
		buttonCreateAccount2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createAccount();
			}
		});
		
		buttonToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toCart();
			}
		});
		
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchInAssortment();
			}
		});
		
		buttonFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filterAssortment();
			}
		});

		//listenery ekranu informacji o sprzęcie--------------------------------------------------------------------------------
	}
	
	private void createAccount(){
		final JDialog dialogCreateAccount = new JDialog();
		dialogCreateAccount.setTitle("Tworzenie konta");
		dialogCreateAccount.setSize(new Dimension(700,400));
		dialogCreateAccount.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialogCreateAccount.setResizable(false);
		dialogCreateAccount.setModal(true);
		dialogCreateAccount.setLayout(null);

		JLabel label_login = new JLabel("Login:*");
		label_login.setBounds(30, 30, 150, 30);
		dialogCreateAccount.add(label_login);
		final JTextField textField_login = new JTextField();
		textField_login.setBounds(180, 30, 150, 30);
		dialogCreateAccount.add(textField_login);
		
		JLabel label_password = new JLabel("Hasło:*");
		label_password.setBounds(30, 70, 150, 30);
		dialogCreateAccount.add(label_password);
		final JPasswordField passwordField_password = new JPasswordField();
		passwordField_password.setBounds(180, 70, 150, 30);
		passwordField_password.setEchoChar('*');
		dialogCreateAccount.add(passwordField_password);
		
		JLabel label_repeat_password = new JLabel("Powtórz hasło:*");
		label_repeat_password.setBounds(30, 110, 150, 30);
		dialogCreateAccount.add(label_repeat_password);		
		final JPasswordField passwordField_repeat_password = new JPasswordField();
		passwordField_repeat_password.setBounds(180, 110, 150, 30);
		passwordField_repeat_password.setEchoChar('*');
		dialogCreateAccount.add(passwordField_repeat_password);
		
		JLabel label_show_password = new JLabel("Pokaz haslo:");
		label_show_password.setBounds(200, 140, 100, 30);
		dialogCreateAccount.add(label_show_password);	
		final JCheckBox checkBox_show_password = new JCheckBox();
		checkBox_show_password.setBounds(280, 145, 20, 20);
		checkBox_show_password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox_show_password.isSelected()){
					passwordField_password.setEchoChar((char)0);
					passwordField_repeat_password.setEchoChar((char)0);
				}
				else{
					passwordField_password.setEchoChar('*');
					passwordField_repeat_password.setEchoChar('*');
				}
			}
		});
		dialogCreateAccount.add(checkBox_show_password);
		
		JLabel label_security_question = new JLabel("Pytanie bezpieczeństwa:*");
		label_security_question.setBounds(30, 170, 150, 30);
		dialogCreateAccount.add(label_security_question);
		final JTextField textField_security_question = new JTextField();
		textField_security_question.setBounds(180, 170, 150, 30);
		dialogCreateAccount.add(textField_security_question);

		JLabel label_security_answer = new JLabel("Odpowiedz:*");
		label_security_answer.setBounds(30, 210, 150, 30);
		dialogCreateAccount.add(label_security_answer);
		final JTextField textField_security_answer = new JTextField();
		textField_security_answer.setBounds(180, 210, 150, 30);
		dialogCreateAccount.add(textField_security_answer);
		
		JLabel label_name = new JLabel("Imie:*");
		label_name.setBounds(30, 250, 150, 30);
		dialogCreateAccount.add(label_name);
		final JTextField textField_name = new JTextField();
		textField_name.setBounds(180, 250, 150, 30);
		dialogCreateAccount.add(textField_name);
		
		JLabel label_last_name = new JLabel("Nazwisko:*");
		label_last_name.setBounds(30, 290, 150, 30);
		dialogCreateAccount.add(label_last_name);
		final JTextField textField_last_name = new JTextField();
		textField_last_name.setBounds(180, 290, 150, 30);
		dialogCreateAccount.add(textField_last_name);
		
		JLabel label_birth_date = new JLabel("Data urodzenia:* **");
		label_birth_date.setBounds(350, 30, 150, 30);
		dialogCreateAccount.add(label_birth_date);
		final JTextField textField_birth_date = new JTextField();
		textField_birth_date.setBounds(500, 30, 150, 30);
		dialogCreateAccount.add(textField_birth_date);
		
		JLabel label_city = new JLabel("Miasto:");
		label_city.setBounds(350, 70, 150, 30);
		dialogCreateAccount.add(label_city);
		final JTextField textField_city = new JTextField();
		textField_city.setBounds(500, 70, 150, 30);
		dialogCreateAccount.add(textField_city);
		
		JLabel label_postal_code = new JLabel("Kod pocztowy:");
		label_postal_code.setBounds(350, 110, 150, 30);
		dialogCreateAccount.add(label_postal_code);
		final JTextField textField_postal_code = new JTextField();
		textField_postal_code.setBounds(500, 110, 150, 30);
		dialogCreateAccount.add(textField_postal_code);
		
		JLabel label_street = new JLabel("Ulica:");
		label_street.setBounds(350, 150, 150, 30);
		dialogCreateAccount.add(label_street);	
		final JTextField textField_street = new JTextField();
		textField_street.setBounds(500, 150, 150, 30);
		dialogCreateAccount.add(textField_street);
		
		JLabel label_house_number = new JLabel("Numer domu:");
		label_house_number.setBounds(350, 190, 150, 30);
		dialogCreateAccount.add(label_house_number);		
		final JTextField textField_house_number = new JTextField();
		textField_house_number.setBounds(500, 190, 150, 30);
		dialogCreateAccount.add(textField_house_number);
		
		JLabel label_flat_number = new JLabel("Numer mieszkania:");
		label_flat_number.setBounds(350, 230, 150, 30);
		dialogCreateAccount.add(label_flat_number);	
		final JTextField textField_flat_number = new JTextField();
		textField_flat_number.setBounds(500, 230, 150, 30);
		dialogCreateAccount.add(textField_flat_number);
		
		JLabel label_required_fields = new JLabel("* - wymagane pola       ** - format dd/mm/yyyy");
		label_required_fields.setBounds(40, 340, 350, 30);
		dialogCreateAccount.add(label_required_fields);
		
		JButton button_cancel = new JButton("Anuluj");
		button_cancel.setBounds(500, 310, 80, 30);
		button_cancel.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				dialogCreateAccount.dispose();
			}
		});
		dialogCreateAccount.add(button_cancel);
		
		JButton button_create_account = new JButton("Utworz");
		button_create_account.setBounds(410, 310, 80, 30);
		button_create_account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = textField_login.getText();
				String password = String.valueOf(passwordField_password.getPassword());
				String repeated_password = String.valueOf(passwordField_repeat_password.getPassword());
				String security_question = textField_security_question.getText();
				String security_answer = textField_security_answer.getText();
				String name = textField_name.getText();
				String last_name = textField_last_name.getText();
				java.util.Date birth_date = null;
						try{birth_date = new SimpleDateFormat("dd/MM/yyyy").parse(textField_birth_date.getText());} catch(Exception ex){ex.printStackTrace();}
				String city = textField_city.getText();
				String postal_code = textField_postal_code.getText();
				String street = textField_street.getText();
				String house_number = textField_house_number.getText();
				String flat_number = textField_flat_number.getText();
				
				if(login.equals("")) JOptionPane.showMessageDialog(dialogCreateAccount, "Login nie moze byc pusty");
				else if(password.equals("")) JOptionPane.showMessageDialog(dialogCreateAccount, "Haslo nie moze byc puste");
				else if(!repeated_password.equals(password)) JOptionPane.showMessageDialog(dialogCreateAccount, "Hasla nie są takie same");
				else if(security_question.equals("")) JOptionPane.showMessageDialog(dialogCreateAccount, "Pytanie pomocnicze nie moze byc puste");
				else if(security_answer.equals("")) JOptionPane.showMessageDialog(dialogCreateAccount, "Odpowiedz na pytanie pomocnicze nie moze byc pusta");
				else if(name.equals("")) JOptionPane.showMessageDialog(dialogCreateAccount, "Imie nie moze byc puste");
				else if(last_name.equals("")) JOptionPane.showMessageDialog(dialogCreateAccount, "Nazwisko nie moze byc puste");
				else if(birth_date == null) JOptionPane.showMessageDialog(dialogCreateAccount, "Data urodzenia nie moze byc pusta");
				else {
					arrayListAddresses.add(new Address(arrayListAddresses.size() + 1, city, postal_code, street, house_number, flat_number));
					arrayListPeople.add(new Person(arrayListPeople.size() + 1, name, last_name, birth_date, arrayListAddresses.size(), login, password));
				}
				//Poza tym co tu jest trzeba dodać w klasie Person oraz bazie danych
				//pytanie pomocnicze oraz odpowiedz na nie
			}
		});
		dialogCreateAccount.add(button_create_account);

		dialogCreateAccount.setVisible(true);
	}
	
	private void remindPassword(){
		JOptionPane.showMessageDialog(mainFrame, "Bedzie dodane");
	}
	
	private void logIn(){
		JOptionPane.showMessageDialog(mainFrame, "Bedzie dodane");
	}
	
	private void toCart(){
		JOptionPane.showMessageDialog(mainFrame, "Bedzie dodane");
	}
	
	private void searchInAssortment(){
		JOptionPane.showMessageDialog(mainFrame, "Bedzie dodane");
	}
	
	private void filterAssortment(){
		JOptionPane.showMessageDialog(mainFrame, "Bedzie dodane");
	}
	
}
