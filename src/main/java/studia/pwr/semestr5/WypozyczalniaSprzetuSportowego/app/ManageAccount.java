package studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.app;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

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
import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Worker;

public class ManageAccount {
	private MainWindow mainWindow;
	private boolean create;
	private Person person;
	private String[] dividedPerson;
	private String[] dividedAddress;
	private Address address;
	private boolean isWorker;
	private Connect dbConnection;

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
	JLabel labelPhoneNumber;
	JTextField textFieldPhoneNumber;
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
	JLabel labelSalary;
	JTextField textFieldSalary;
	JLabel labelRequiredFields;
	JButton buttonCancel;
	JButton buttonCreateAccount;

	public ManageAccount() {
	}

	// jeśli create jest true, tworzy nowe konto, jeśli false to edytuje
	// istniejące
	public ManageAccount(MainWindow mainWindow, boolean create, Connect dbConnection) {
		this.mainWindow = mainWindow;
		this.create = create;
		isWorker = false;
		this.dbConnection = dbConnection;

		initComponents();
		initListeners();

		dialogCreateAccount.setVisible(true);
	}

	public ManageAccount(MainWindow mainWindow, boolean create, boolean isWorker, Connect dbConnection) {
		this.mainWindow = mainWindow;
		this.create = create;
		this.isWorker = isWorker;
		this.dbConnection = dbConnection;

		initComponents();
		initListeners();

		dialogCreateAccount.setVisible(true);
	}

	public ManageAccount(MainWindow mainWindow, boolean create, Person person, Connect dbConnection) {
		this.mainWindow = mainWindow;
		this.create = create;
		this.person = person;
		this.isWorker = false;
		this.dbConnection = dbConnection;

		dividePerson();
		initComponents();
		initListeners();

		dialogCreateAccount.setVisible(true);
	}

	private void dividePerson() {
		// dla klasy Person
		// id[0], imie[1], nazwisko[2], data ur.[3], adresid[4], login[5],
		// haslo[6]
		// pyt. pom.[7], odp.[8]

		// dla klasy Address
		// adresid[0], city[1], postal[2], street[3], housenum[4], flatnum[5]

		// !&#*&% takie cos jest w metodzie toString klasy Person i Address
		// zeby bylo prawie pewne ze sie podzieli (200IQ)
		dividedPerson = person.toString().split(Pattern.quote(" !&#*&% "));

		for (Address a : mainWindow.getArrayListAddresses()) {
			if (a.getAdressID() == Integer.parseInt(dividedPerson[5])) {
				address = a;
				break;
			}
		}

		try {
			dividedAddress = address.toString().split(Pattern.quote(" !&#*&% "));

			if (dividedAddress[0].equals("."))
				dividedAddress[0] = dividedAddress[0].substring(1);
			else if (dividedAddress[0].equals("null."))
				dividedAddress[0] = dividedAddress[0].substring(4);
			else
				dividedAddress[0] = dividedAddress[0].substring(0, dividedAddress[0].length() - 1);
			if (dividedAddress[1].equals("."))
				dividedAddress[1] = dividedAddress[1].substring(1);
			else if (dividedAddress[1].equals("null."))
				dividedAddress[1] = dividedAddress[1].substring(4);
			else
				dividedAddress[1] = dividedAddress[1].substring(0, dividedAddress[1].length() - 1);
			if (dividedAddress[2].equals("."))
				dividedAddress[2] = dividedAddress[2].substring(1);
			else if (dividedAddress[2].equals("null."))
				dividedAddress[2] = dividedAddress[2].substring(4);
			else
				dividedAddress[2] = dividedAddress[2].substring(0, dividedAddress[2].length() - 1);
			if (dividedAddress[3].equals("."))
				dividedAddress[3] = dividedAddress[3].substring(1);
			else if (dividedAddress[3].equals("null."))
				dividedAddress[3] = dividedAddress[3].substring(4);
			else
				dividedAddress[3] = dividedAddress[3].substring(0, dividedAddress[3].length() - 1);
			if (dividedAddress[4].equals("."))
				dividedAddress[4] = dividedAddress[4].substring(1);
			else if (dividedAddress[4].equals("null."))
				dividedAddress[4] = dividedAddress[4].substring(4);
			else
				dividedAddress[4] = dividedAddress[4].substring(0, dividedAddress[4].length() - 1);
			if (dividedAddress[5].equals("."))
				dividedAddress[5] = dividedAddress[5].substring(1);
			else if (dividedAddress[5].equals("null."))
				dividedAddress[5] = dividedAddress[5].substring(4);
			else
				dividedAddress[5] = dividedAddress[5].substring(0, dividedAddress[5].length() - 1);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(address.toString());
	}

	private void initComponents() {
		dialogCreateAccount = new JDialog();
		dialogCreateAccount.setTitle("Tworzenie konta");
		if (!create)
			dialogCreateAccount.setTitle("Edycja konta");
		dialogCreateAccount.setSize(new Dimension(700, 420));
		dialogCreateAccount.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialogCreateAccount.setResizable(false);
		dialogCreateAccount.setModal(true);
		dialogCreateAccount.setLayout(null);

		labelLogin = new JLabel("Login:*");
		labelLogin.setBounds(30, 30, 150, 30);
		dialogCreateAccount.add(labelLogin);
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(180, 30, 150, 30);
		if (!create) {
			textFieldLogin.setText(dividedPerson[6]);
			textFieldLogin.setEnabled(false);
		}
		dialogCreateAccount.add(textFieldLogin);

		labelPassword = new JLabel("Hasło:*");
		labelPassword.setBounds(30, 70, 150, 30);
		dialogCreateAccount.add(labelPassword);
		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setBounds(180, 70, 150, 30);
		passwordFieldPassword.setEchoChar('*');
		if (!create)
			passwordFieldPassword.setText(dividedPerson[7]);
		dialogCreateAccount.add(passwordFieldPassword);

		labelRepeatPassword = new JLabel("Powtórz hasło:*");
		labelRepeatPassword.setBounds(30, 110, 150, 30);
		dialogCreateAccount.add(labelRepeatPassword);
		passwordFieldRepeatPassword = new JPasswordField();
		passwordFieldRepeatPassword.setBounds(180, 110, 150, 30);
		passwordFieldRepeatPassword.setEchoChar('*');
		if (!create)
			passwordFieldRepeatPassword.setText(dividedPerson[7]);
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
		if (!create)
			textFieldSecurityQuestion.setText(dividedPerson[8]);
		dialogCreateAccount.add(textFieldSecurityQuestion);

		labelSecurityAnswer = new JLabel("Odpowiedz:*");
		labelSecurityAnswer.setBounds(30, 210, 150, 30);
		dialogCreateAccount.add(labelSecurityAnswer);
		textFieldSecurityAnswer = new JTextField();
		textFieldSecurityAnswer.setBounds(180, 210, 150, 30);
		if (!create)
			textFieldSecurityAnswer.setText(dividedPerson[9]);
		dialogCreateAccount.add(textFieldSecurityAnswer);

		labelName = new JLabel("Imie:*");
		labelName.setBounds(30, 250, 150, 30);
		dialogCreateAccount.add(labelName);
		textFieldName = new JTextField();
		textFieldName.setBounds(180, 250, 150, 30);
		if (!create)
			textFieldName.setText(dividedPerson[1]);
		dialogCreateAccount.add(textFieldName);

		labelLastName = new JLabel("Nazwisko:*");
		labelLastName.setBounds(30, 290, 150, 30);
		dialogCreateAccount.add(labelLastName);
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(180, 290, 150, 30);
		if (!create)
			textFieldLastName.setText(dividedPerson[2]);
		dialogCreateAccount.add(textFieldLastName);

		if (isWorker) {
			labelSalary = new JLabel("Pensja:");
			labelSalary.setBounds(30, 330, 150, 30);
			dialogCreateAccount.add(labelSalary);
			textFieldSalary = new JTextField();
			textFieldSalary.setBounds(180, 330, 150, 30);
			dialogCreateAccount.add(textFieldSalary);
		}

		labelBirthDate = new JLabel("Data urodzenia: * **");
		labelBirthDate.setBounds(350, 30, 150, 30);
		dialogCreateAccount.add(labelBirthDate);
		textFieldBirthDate = new JTextField();
		textFieldBirthDate.setBounds(500, 30, 150, 30);
		if (!create) {
			String[] parts = dividedPerson[3].split(" ");

			if (parts[1].equals("Jan"))
				parts[1] = "01";
			else if (parts[1].equals("Feb"))
				parts[1] = "02";
			else if (parts[1].equals("Mar"))
				parts[1] = "03";
			else if (parts[1].equals("Apr"))
				parts[1] = "04";
			else if (parts[1].equals("May"))
				parts[1] = "05";
			else if (parts[1].equals("Jun"))
				parts[1] = "06";
			else if (parts[1].equals("Jul"))
				parts[1] = "07";
			else if (parts[1].equals("Aug"))
				parts[1] = "08";
			else if (parts[1].equals("Oct"))
				parts[1] = "09";
			else if (parts[1].equals("Sep"))
				parts[1] = "10";
			else if (parts[1].equals("Nov"))
				parts[1] = "11";
			else if (parts[1].equals("Dec"))
				parts[1] = "12";

			textFieldBirthDate.setText(parts[2] + "/" + parts[1] + "/" + parts[5]);
		}
		dialogCreateAccount.add(textFieldBirthDate);

		labelPhoneNumber = new JLabel("Numer telefonu: * ***");
		labelPhoneNumber.setBounds(350, 70, 150, 30);
		dialogCreateAccount.add(labelPhoneNumber);
		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setBounds(500, 70, 150, 30);
		if (!create)
			textFieldPhoneNumber.setText(dividedPerson[4]);
		dialogCreateAccount.add(textFieldPhoneNumber);

		labelCity = new JLabel("Miasto:");
		labelCity.setBounds(350, 110, 150, 30);
		dialogCreateAccount.add(labelCity);
		textFieldCity = new JTextField();
		textFieldCity.setBounds(500, 110, 150, 30);
		if (!create)
			textFieldCity.setText(dividedAddress[1]);
		dialogCreateAccount.add(textFieldCity);

		labelPostalCode = new JLabel("Kod pocztowy:");
		labelPostalCode.setBounds(350, 150, 150, 30);
		dialogCreateAccount.add(labelPostalCode);
		textFieldPostalCode = new JTextField();
		textFieldPostalCode.setBounds(500, 150, 150, 30);
		if (!create)
			textFieldPostalCode.setText(dividedAddress[2]);
		dialogCreateAccount.add(textFieldPostalCode);

		labelStreet = new JLabel("Ulica:");
		labelStreet.setBounds(350, 190, 150, 30);
		dialogCreateAccount.add(labelStreet);
		textFieldStreet = new JTextField();
		textFieldStreet.setBounds(500, 190, 150, 30);
		if (!create)
			textFieldStreet.setText(dividedAddress[3]);
		dialogCreateAccount.add(textFieldStreet);

		labelHouseNumber = new JLabel("Numer domu:");
		labelHouseNumber.setBounds(350, 230, 150, 30);
		dialogCreateAccount.add(labelHouseNumber);
		textFieldHouseNumber = new JTextField();
		textFieldHouseNumber.setBounds(500, 230, 150, 30);
		if (!create)
			textFieldHouseNumber.setText(dividedAddress[4]);
		dialogCreateAccount.add(textFieldHouseNumber);

		labelFlatNumber = new JLabel("Numer mieszkania:");
		labelFlatNumber.setBounds(350, 270, 150, 30);
		dialogCreateAccount.add(labelFlatNumber);
		textFieldFlatNumber = new JTextField();
		textFieldFlatNumber.setBounds(500, 270, 150, 30);
		if (!create)
			textFieldFlatNumber.setText(dividedAddress[5]);
		dialogCreateAccount.add(textFieldFlatNumber);

		labelRequiredFields = new JLabel("* - wymagane pola       ** - format dd/mm/yyyy       *** - dziewiec cyfr");
		labelRequiredFields.setBounds(40, 360, 450, 30);
		dialogCreateAccount.add(labelRequiredFields);

		buttonCancel = new JButton("Anuluj");
		buttonCancel.setBounds(550, 330, 80, 30);
		dialogCreateAccount.add(buttonCancel);

		buttonCreateAccount = new JButton("Utworz");
		if (!create)
			buttonCreateAccount.setText("Zapisz");
		buttonCreateAccount.setBounds(460, 330, 80, 30);
		dialogCreateAccount.add(buttonCreateAccount);
	}

	private void initListeners() {
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
				if (create)
					createAccount();
				else
					editAccount();
			}
		});
	}

	private void createAccount() {
		String login = textFieldLogin.getText();
		String password = String.valueOf(passwordFieldPassword.getPassword());
		String repeated_password = String.valueOf(passwordFieldRepeatPassword.getPassword());
		String security_question = textFieldSecurityQuestion.getText();
		String security_answer = textFieldSecurityAnswer.getText();
		String name = textFieldName.getText();
		String last_name = textFieldLastName.getText();
		java.util.Date birth_date = null;
		try {
			birth_date = new SimpleDateFormat("dd/mm/yyyy").parse(textFieldBirthDate.getText());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		int phone_number = 0;
		try {
			phone_number = Integer.parseInt(textFieldPhoneNumber.getText());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		String city = textFieldCity.getText();
		String postal_code = textFieldPostalCode.getText();
		String street = textFieldStreet.getText();
		String house_number = textFieldHouseNumber.getText();
		String flat_number = textFieldFlatNumber.getText();
		String salary = null;
		if (isWorker)
			salary = textFieldSalary.getText();

		if (login.equals(""))
			JOptionPane.showMessageDialog(dialogCreateAccount, "Login nie moze byc pusty");
		else if (password.equals(""))
			JOptionPane.showMessageDialog(dialogCreateAccount, "Haslo nie moze byc puste");
		else if (!repeated_password.equals(password))
			JOptionPane.showMessageDialog(dialogCreateAccount, "Hasla nie są takie same");
		else if (security_question.equals(""))
			JOptionPane.showMessageDialog(dialogCreateAccount, "Pytanie pomocnicze nie moze byc puste");
		else if (security_answer.equals(""))
			JOptionPane.showMessageDialog(dialogCreateAccount, "Odpowiedz na pytanie pomocnicze nie moze byc pusta");
		else if (name.equals(""))
			JOptionPane.showMessageDialog(dialogCreateAccount, "Imie nie moze byc puste");
		else if (last_name.equals(""))
			JOptionPane.showMessageDialog(dialogCreateAccount, "Nazwisko nie moze byc puste");
		else if (birth_date == null)
			JOptionPane.showMessageDialog(dialogCreateAccount, "Data urodzenia nie moze byc pusta");
		else if (phone_number < 100000000 || phone_number > 999999999)
			JOptionPane.showMessageDialog(dialogCreateAccount, "Bledny numer telefonu");
		else {
			for (Person p : mainWindow.getArrayListPeople())
				if (p.getLogin().equals(login)) {
					JOptionPane.showMessageDialog(dialogCreateAccount, "Użytkownik o podanym nicku już istnieje!");
					return;
				}

			Integer house_number2 = null;
			Integer flat_number2 = null;
			int salary2 = 0;

			try {
				house_number2 = Integer.parseInt(textFieldHouseNumber.getText());
				flat_number2 = Integer.parseInt(textFieldFlatNumber.getText());
			} catch (Exception ex) {
			}

			if (isWorker)
				try {
					salary2 = Integer.parseInt(salary) * 100;
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(dialogCreateAccount, "Pensja musi byc liczba!");
					return;
				}

			int nextAddressID = 0;
			for(int i = 0; i < mainWindow.getArrayListAddresses().size(); i++)
					if(mainWindow.getArrayListAddresses().get(i).getAdressID() > nextAddressID)
						nextAddressID = mainWindow.getArrayListAddresses().get(i).getAdressID();
			nextAddressID += 1;
			
			int nextPersonID = 0;
			for(int i = 0; i < mainWindow.getArrayListPeople().size(); i++)
					if(mainWindow.getArrayListPeople().get(i).getPersonID() > nextPersonID)
						nextPersonID = mainWindow.getArrayListPeople().get(i).getPersonID();
			nextPersonID += 1;
			
			int nextClientID = 0;
			for(int i = 0; i < mainWindow.getArrayListClients().size(); i++)
					if(mainWindow.getArrayListClients().get(i).getClientID() > nextClientID)
						nextClientID = mainWindow.getArrayListClients().get(i).getClientID();
			nextClientID += 1;
			
			int nextWorkerID = 0;
			for(int i = 0; i < mainWindow.getArrayListWorkers().size(); i++)
					if(mainWindow.getArrayListWorkers().get(i).getWorkerID() > nextWorkerID)
						nextWorkerID = mainWindow.getArrayListWorkers().get(i).getWorkerID();
			nextWorkerID += 1;

			Address address = new Address(nextAddressID, city, postal_code, street, house_number, flat_number);
			mainWindow.getArrayListAddresses().add(address);
			dbConnection.dbCreateAddress(address);

			Person person = new Person(nextPersonID, name, last_name, birth_date, phone_number, nextAddressID, login,
					password, security_question, security_answer);
			mainWindow.getArrayListPeople().add(person);
			dbConnection.dbCreatePerson(person);

			if (!isWorker) {
				Client client = new Client(nextClientID, new Date(), 0, null, true, nextPersonID);
				mainWindow.getArrayListClients().add(client);
				dbConnection.dbCreateClient(client);
			} else {
				Worker worker = new Worker(nextWorkerID, new Date(), salary2, 0, nextPersonID, false);
				mainWindow.getArrayListWorkers().add(worker);
				dbConnection.dbCreateWorker(worker);
			}
			dialogCreateAccount.dispose();
		}

		// Poza tym co tu jest trzeba dodać w bazie danych
		// pytanie pomocnicze oraz odpowiedz na nie
		// haslo i login maja byc w tabelu Dane_kont
	}

	private void editAccount() {
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
		int phone_number = 0;
		try {
			phone_number = Integer.parseInt(textFieldPhoneNumber.getText());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		String city = textFieldCity.getText();
		String postal_code = textFieldPostalCode.getText();
		String street = textFieldStreet.getText();
		String house_number = textFieldHouseNumber.getText();
		String flat_number = textFieldFlatNumber.getText();

		if (password.equals(""))
			JOptionPane.showMessageDialog(dialogCreateAccount, "Haslo nie moze byc puste");
		else if (!repeated_password.equals(password))
			JOptionPane.showMessageDialog(dialogCreateAccount, "Hasla nie są takie same");
		else if (security_question.equals(""))
			JOptionPane.showMessageDialog(dialogCreateAccount, "Pytanie pomocnicze nie moze byc puste");
		else if (security_answer.equals(""))
			JOptionPane.showMessageDialog(dialogCreateAccount, "Odpowiedz na pytanie pomocnicze nie moze byc pusta");
		else if (name.equals(""))
			JOptionPane.showMessageDialog(dialogCreateAccount, "Imie nie moze byc puste");
		else if (last_name.equals(""))
			JOptionPane.showMessageDialog(dialogCreateAccount, "Nazwisko nie moze byc puste");
		else if (birth_date == null)
			JOptionPane.showMessageDialog(dialogCreateAccount, "Data urodzenia nie moze byc pusta");
		else if (phone_number < 100000000 || phone_number > 999999999)
			JOptionPane.showMessageDialog(dialogCreateAccount, "Bledny numer telefonu");
		else {
			person.setFirstName(name);
			person.setLastName(last_name);
			person.setBirthDate(birth_date);
			person.setPhoneNumber(phone_number);
			person.setLogin(login);
			person.setPassword(password);
			person.setSecurityQuestion(security_question);
			person.setSecurityAnswer(security_answer);

			address.setCityName(city);
			address.setPostalCode(postal_code);
			address.setStreet(street);
			address.setHouseNumber(house_number);
			address.setFlatNumber(flat_number);

			dialogCreateAccount.dispose();
		}
		// Poza tym co tu jest trzeba dodać w bazie danych
		// pytanie pomocnicze oraz odpowiedz na nie
		// haslo i login maja byc w tabelu Dane_kont
	}
}