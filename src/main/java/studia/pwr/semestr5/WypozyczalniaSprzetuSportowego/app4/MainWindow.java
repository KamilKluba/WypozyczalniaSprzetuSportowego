package studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.app4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MainWindow{
	private JFrame mainFrame;
	
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
	private List<Component> createAccountScreenComponents;
	JTextField textFieldLogin;
	JPasswordField passwordFieldPassword;
	JCheckBox checkBoxShowPassword;
	JButton buttonLogin1;
	JButton buttonRemindPassword;
	JButton buttonCreateAccount1;
	JButton buttonReturnScreen;
	
	//elementy przegląania sprzętu
	private List<Component> itemInfoScreenComponents;
	JLabel labelLogo1;
	JButton buttonLogin2;
	JButton buttonCreateAccount2;
	JButton buttonToCart;
	JButton buttonSearch;
	JButton buttonFilter;
	JTextField textFieldItemName;
	JPanel panelItems; //tutaj zaczynają się elementy scrollowalnego panelu
	JScrollPane scrollPaneItemPanel;
	List<JLabel> listOfAllItems;
	
	
	
	public MainWindow(){
		initComponents(); //tylko tworzenie i dodawanie elementów do okna
		initListeners(); //tworzenie i obsługa listenerów, 
		
		for(Component c : mainScreenComponents) c.setVisible(false);
		for(Component c : createAccountScreenComponents) c.setVisible(false);
		for(Component c : itemInfoScreenComponents) c.setVisible(true);
		
		mainFrame.setVisible(true);
	}
	
	private void initComponents(){
		mainScreenComponents = new ArrayList<Component>();
		createAccountScreenComponents = new ArrayList<Component>();
		itemInfoScreenComponents = new ArrayList<Component>();
		
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
		
		//ELEMENTY EKRANU TWORZENIA KONTA  ------------------------------------------------------------------------------------
		textFieldLogin = new JTextField("Login");
		textFieldLogin.setBounds(500, 250, 300, 40);
		textFieldLogin.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		textFieldLogin.setForeground(Color.GRAY);
		mainFrame.add(textFieldLogin);
		createAccountScreenComponents.add(textFieldLogin);
		
		passwordFieldPassword = new JPasswordField("Haslo");
		passwordFieldPassword.setBounds(500, 300, 300, 40);
		passwordFieldPassword.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		passwordFieldPassword.setEchoChar((char)0);
		passwordFieldPassword.setForeground(Color.GRAY);
		mainFrame.add(passwordFieldPassword);
		createAccountScreenComponents.add(passwordFieldPassword);
		
		checkBoxShowPassword = new JCheckBox("Pokaż hasło");
		checkBoxShowPassword.setBounds(810, 305, 150, 30);
		mainFrame.add(checkBoxShowPassword);
		createAccountScreenComponents.add(checkBoxShowPassword);
		
		buttonLogin1 = new JButton("Zaloguj się");
		buttonLogin1.setBounds(600, 350, 100, 40);
		buttonLogin1.requestFocus(); //tylko po ro zeby na textfieldach byl szary tekst
		mainFrame.add(buttonLogin1);
		createAccountScreenComponents.add(buttonLogin1);
		
		buttonCreateAccount1 = new JButton("Utwórz konto");
		buttonCreateAccount1.setBounds(590, 550, 120, 40);
		mainFrame.add(buttonCreateAccount1);
		createAccountScreenComponents.add(buttonCreateAccount1);
		
		buttonRemindPassword = new JButton("Zapomniałem hasła");
		buttonRemindPassword.setBounds(350, 550, 200, 40);
		mainFrame.add(buttonRemindPassword);
		createAccountScreenComponents.add(buttonRemindPassword);
		
		buttonReturnScreen = new JButton("Powrót do ekranu głównego");
		buttonReturnScreen.setBounds(750, 550, 200, 40);
		mainFrame.add(buttonReturnScreen);
		createAccountScreenComponents.add(buttonReturnScreen);
		
		//ELEMENTY EKRANU PRZEGLADANIA SPRZETU------------------------------------------------------------------------------------
		labelLogo1 = new JLabel();
		labelLogo1.setBounds(500, 20, 400, 150);
		labelLogo1.setIcon(new ImageIcon(getClass().getResource("/Resources/Logo.png")));
		mainFrame.add(labelLogo1);
		itemInfoScreenComponents.add(labelLogo1);
		
		buttonLogin2 = new JButton("Logowanie");
		buttonLogin2.setBounds(1050, 50, 150, 30);
		mainFrame.add(buttonLogin2);
		itemInfoScreenComponents.add(buttonLogin2);
		
		buttonCreateAccount2 = new JButton("Logowanie");
		buttonCreateAccount2.setBounds(1050, 100, 150, 30);
		mainFrame.add(buttonCreateAccount2);
		itemInfoScreenComponents.add(buttonCreateAccount2);
		
		buttonToCart = new JButton("Koszyk");
		buttonToCart.setBounds(1050, 150, 150, 30);
		mainFrame.add(buttonToCart);
		itemInfoScreenComponents.add(buttonToCart);
		
		buttonSearch = new JButton("Szukaj");
		buttonSearch.setBounds(50, 100, 100, 30);
		mainFrame.add(buttonSearch);
		itemInfoScreenComponents.add(buttonSearch);
		
		buttonFilter = new JButton("Filtrowanie");
		buttonFilter.setBounds(200, 100, 100, 30);
		mainFrame.add(buttonFilter);
		itemInfoScreenComponents.add(buttonFilter);
		
		textFieldItemName = new JTextField();
		textFieldItemName.setBounds(50, 50, 350, 30);
		mainFrame.add(textFieldItemName);
		itemInfoScreenComponents.add(textFieldItemName);
		
		panelItems = new JPanel();
		panelItems.setBackground(Color.PINK);
		
		scrollPaneItemPanel = new JScrollPane();
		scrollPaneItemPanel.setViewportView(panelItems);
		scrollPaneItemPanel.setBounds(50, 200, 1170, 450);
		mainFrame.add(scrollPaneItemPanel);
		itemInfoScreenComponents.add(scrollPaneItemPanel);
		
	}
	
	private void initListeners(){
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
			@SuppressWarnings("deprecation")
			public void focusGained(FocusEvent e) {
				passwordFieldPassword.setEchoChar('*');
				passwordFieldPassword.setForeground(Color.BLACK);
				passwordFieldPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				if(passwordFieldPassword.getText().equals("Haslo")) passwordFieldPassword.setText("");
			}
			@SuppressWarnings("deprecation")
			public void focusLost(FocusEvent e) {
				if(passwordFieldPassword.getText().equals("")){
					passwordFieldPassword.setEchoChar((char)0);
					passwordFieldPassword.setForeground(Color.GRAY);
					passwordFieldPassword.setText("Haslo");
					passwordFieldPassword.setFont(new Font("Times New Roman", Font.ITALIC, 14));
				}
			}
		});
	}
	
	private void setStartScreenVisible(){
		
	}
	
}
