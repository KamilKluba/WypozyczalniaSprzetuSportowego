package studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.app4;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Address;
import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Client;
import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Person;

public class CreateAccount {
	private MainWindow mainWindow;

	JDialog dialogCreateAccount;
	JLabel labelLogin;
	JTextField textFieldLogin;
	JLabel labelPassword;
	JPasswordField passwordFieldPassword;
	JLabel labelRepeatPassword;
	JPasswordField passwordFieldRepeatPassword;
	JLabel labelShowPassword;
	JCheckBox checkBoxShowPassword;
	JLabel labelSecurityQuestion;
	JTextField textFieldSecurityQuestion;
	JLabel labelSecurityAnswer;
	JTextField textFieldSecurityAnswer;
	JLabel labelName;
	JTextField textFieldName;
	JLabel labelLastName;
	JTextField textFieldLastName;
	JLabel labelBirthDate;
	JTextField textFieldBirthDate;
	JLabel labelCity;
	JTextField textFieldCity;
	JLabel labelPostalCode;
	JTextField textFieldPostalCode;
	JLabel labelStreet;
	JTextField textFieldStreet;
	JLabel labelHouseNumber;
	JTextField textFieldHouseNumber;
	JLabel labelFlatNumber;
	JTextField textFieldFlatNumber;
	JLabel labelRequiredFields;
	JButton buttonCancel;
	JButton buttonCreateAccount;

	public CreateAccount() {
	}

	public CreateAccount(MainWindow mainWindow) {
		this.mainWindow = mainWindow;

		initComponents();
		initListeners();
		
		dialogCreateAccount.setVisible(true);
	}

	private void initComponents() {
		dialogCreateAccount = new JDialog();
		dialogCreateAccount.setTitle("Tworzenie konta");
		dialogCreateAccount.setSize(new Dimension(700, 400));
		dialogCreateAccount.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialogCreateAccount.setResizable(false);
		dialogCreateAccount.setModal(true);
		dialogCreateAccount.setLayout(null);

		labelLogin = new JLabel("Login:*");
		labelLogin.setBounds(30, 30, 150, 30);
		dialogCreateAccount.add(labelLogin);
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(180, 30, 150, 30);
		dialogCreateAccount.add(textFieldLogin);

		labelPassword = new JLabel("Hasło:*");
		labelPassword.setBounds(30, 70, 150, 30);
		dialogCreateAccount.add(labelPassword);
		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setBounds(180, 70, 150, 30);
		passwordFieldPassword.setEchoChar('*');
		dialogCreateAccount.add(passwordFieldPassword);

		labelRepeatPassword = new JLabel("Powtórz hasło:*");
		labelRepeatPassword.setBounds(30, 110, 150, 30);
		dialogCreateAccount.add(labelRepeatPassword);
		passwordFieldRepeatPassword = new JPasswordField();
		passwordFieldRepeatPassword.setBounds(180, 110, 150, 30);
		passwordFieldRepeatPassword.setEchoChar('*');
		dialogCreateAccount.add(passwordFieldRepeatPassword);

		labelShowPassword = new JLabel("Pokaz haslo:");
		labelShowPassword.setBounds(200, 140, 100, 30);
		dialogCreateAccount.add(labelShowPassword);
		checkBoxShowPassword = new JCheckBox();
		checkBoxShowPassword.setBounds(280, 145, 20, 20);
		dialogCreateAccount.add(checkBoxShowPassword);

		labelSecurityQuestion = new JLabel("Pytanie bezpieczeństwa:*");
		labelSecurityQuestion.setBounds(30, 170, 150, 30);
		dialogCreateAccount.add(labelSecurityQuestion);
		textFieldSecurityQuestion = new JTextField();
		textFieldSecurityQuestion.setBounds(180, 170, 150, 30);
		dialogCreateAccount.add(textFieldSecurityQuestion);

		labelSecurityAnswer = new JLabel("Odpowiedz:*");
		labelSecurityAnswer.setBounds(30, 210, 150, 30);
		dialogCreateAccount.add(labelSecurityAnswer);
		textFieldSecurityAnswer = new JTextField();
		textFieldSecurityAnswer.setBounds(180, 210, 150, 30);
		dialogCreateAccount.add(textFieldSecurityAnswer);

		labelName = new JLabel("Imie:*");
		labelName.setBounds(30, 250, 150, 30);
		dialogCreateAccount.add(labelName);
		textFieldName = new JTextField();
		textFieldName.setBounds(180, 250, 150, 30);
		dialogCreateAccount.add(textFieldName);

		labelLastName = new JLabel("Nazwisko:*");
		labelLastName.setBounds(30, 290, 150, 30);
		dialogCreateAccount.add(labelLastName);
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(180, 290, 150, 30);
		dialogCreateAccount.add(textFieldLastName);

		labelBirthDate = new JLabel("Data urodzenia:* **");
		labelBirthDate.setBounds(350, 30, 150, 30);
		dialogCreateAccount.add(labelBirthDate);
		textFieldBirthDate = new JTextField();
		textFieldBirthDate.setBounds(500, 30, 150, 30);
		dialogCreateAccount.add(textFieldBirthDate);

		labelCity = new JLabel("Miasto:");
		labelCity.setBounds(350, 70, 150, 30);
		dialogCreateAccount.add(labelCity);
		textFieldCity = new JTextField();
		textFieldCity.setBounds(500, 70, 150, 30);
		dialogCreateAccount.add(textFieldCity);

		labelPostalCode = new JLabel("Kod pocztowy:");
		labelPostalCode.setBounds(350, 110, 150, 30);
		dialogCreateAccount.add(labelPostalCode);
		textFieldPostalCode = new JTextField();
		textFieldPostalCode.setBounds(500, 110, 150, 30);
		dialogCreateAccount.add(textFieldPostalCode);

		labelStreet = new JLabel("Ulica:");
		labelStreet.setBounds(350, 150, 150, 30);
		dialogCreateAccount.add(labelStreet);
		textFieldStreet = new JTextField();
		textFieldStreet.setBounds(500, 150, 150, 30);
		dialogCreateAccount.add(textFieldStreet);

		labelHouseNumber = new JLabel("Numer domu:");
		labelHouseNumber.setBounds(350, 190, 150, 30);
		dialogCreateAccount.add(labelHouseNumber);
		textFieldHouseNumber = new JTextField();
		textFieldHouseNumber.setBounds(500, 190, 150, 30);
		dialogCreateAccount.add(textFieldHouseNumber);

		labelFlatNumber = new JLabel("Numer mieszkania:");
		labelFlatNumber.setBounds(350, 230, 150, 30);
		dialogCreateAccount.add(labelFlatNumber);
		textFieldFlatNumber = new JTextField();
		textFieldFlatNumber.setBounds(500, 230, 150, 30);
		dialogCreateAccount.add(textFieldFlatNumber);

		labelRequiredFields = new JLabel("* - wymagane pola       ** - format dd/mm/yyyy");
		labelRequiredFields.setBounds(40, 340, 350, 30);
		dialogCreateAccount.add(labelRequiredFields);

		buttonCancel = new JButton("Anuluj");
		buttonCancel.setBounds(500, 310, 80, 30);
		dialogCreateAccount.add(buttonCancel);

		buttonCreateAccount = new JButton("Utworz");
		buttonCreateAccount.setBounds(410, 310, 80, 30);
		dialogCreateAccount.add(buttonCreateAccount);
	}
	
	private void initListeners(){
		checkBoxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBoxShowPassword.isSelected()) {
					passwordFieldPassword.setEchoChar((char) 0);
					passwordFieldRepeatPassword.setEchoChar((char) 0);
				} else {
					passwordFieldPassword.setEchoChar('*');
					passwordFieldRepeatPassword.setEchoChar('*');
				}
			}
		});
		
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogCreateAccount.dispose();
			}
		});
		
		buttonCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = textFieldLogin.getText();
				String password = String.valueOf(passwordFieldPassword.getPassword());
				String repeated_password = String.valueOf(passwordFieldRepeatPassword.getPassword());
				String security_question = textFieldSecurityQuestion.getText();
				String security_answer = textFieldSecurityAnswer.getText();
				String name = textFieldName.getText();
				String last_name = textFieldLastName.getText();
				java.util.Date birth_date = null;
				try {
					birth_date = new SimpleDateFormat("dd/MM/yyyy").parse(textFieldBirthDate.getText());
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				String city = textFieldCity.getText();
				String postal_code = textFieldPostalCode.getText();
				String street = textFieldStreet.getText();
				String house_number = textFieldHouseNumber.getText();
				String flat_number = textFieldFlatNumber.getText();

				if (login.equals(""))
					JOptionPane.showMessageDialog(dialogCreateAccount, "Login nie moze byc pusty");
				else if (password.equals(""))
					JOptionPane.showMessageDialog(dialogCreateAccount, "Haslo nie moze byc puste");
				else if (!repeated_password.equals(password))
					JOptionPane.showMessageDialog(dialogCreateAccount, "Hasla nie są takie same");
				else if (security_question.equals(""))
					JOptionPane.showMessageDialog(dialogCreateAccount, "Pytanie pomocnicze nie moze byc puste");
				else if (security_answer.equals(""))
					JOptionPane.showMessageDialog(dialogCreateAccount,
							"Odpowiedz na pytanie pomocnicze nie moze byc pusta");
				else if (name.equals(""))
					JOptionPane.showMessageDialog(dialogCreateAccount, "Imie nie moze byc puste");
				else if (last_name.equals(""))
					JOptionPane.showMessageDialog(dialogCreateAccount, "Nazwisko nie moze byc puste");
				else if (birth_date == null)
					JOptionPane.showMessageDialog(dialogCreateAccount, "Data urodzenia nie moze byc pusta");
				else {
					mainWindow.getArrayListAddresses().add(new Address(mainWindow.getArrayListAddresses().size() + 1,
							city, postal_code, street, house_number, flat_number));
					mainWindow.getArrayListPeople()
							.add(new Person(mainWindow.getArrayListPeople().size() + 1, name, last_name, birth_date,
									mainWindow.getArrayListAddresses().size(), login, password, security_question,
									security_answer));
					mainWindow.getArrayListClients().add(new Client(mainWindow.getArrayListClients().size() + 1,
							new Date(), 0, null, false, mainWindow.getArrayListPeople().size()));
					dialogCreateAccount.dispose();
				}
				// Poza tym co tu jest trzeba dodać w bazie danych
				// pytanie pomocnicze oraz odpowiedz na nie
				// haslo i login maja byc w tabelu Dane_kont
			}
		});
	}
}
