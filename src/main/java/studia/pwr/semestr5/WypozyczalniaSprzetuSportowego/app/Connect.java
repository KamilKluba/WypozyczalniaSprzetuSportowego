package studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.*;

// aby utowrzyc polaczenie z baza danych nalezy:
// 1. pobrac oracle jdbc ze strony https://www.oracle.com/technetwork/database/application-development/jdbc/downloads/index.html
// 2. dodac jdbc do projektu: W tym celu klikamy PPM na nazw� naszego projektu ->Build Path->Configure Build Path,
// przechodzimy do zakladki Libraries->Add External JARs i wybieramy biblioteke ojbc8.jar z katalogu do ktorego ja zapisalismy.
// 3. sprawdzamy dane dotyczace naszej bazy danych: musimy znalezc plik o nazwie tnsnames.ora jest on w katalogu bazy oracle w folderze \NETWORK\ADMIN\tnsnames.ora
// 4. tworzymy baze w oracle sql developer
// connection_name: dowolone,
// username: system,
// password: haslo przy instalacji bazy
// connection type: basic
// role default
// hostname: localhost
// Port: odczytac z tnsnames.ora
// SID: odczytac z tnsnames.ora = SERVICE_NAME
// po utworzeniu takiej bazy mozna sie z nia polaczyc 
public class Connect {
	static Connection connection = null;

	public boolean dbConnectAsSpectator() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Sterowniki zaladowane");

			// jdbc:oracle:thin:username/password@localhost:port:SID
			connection = DriverManager.getConnection("jdbc:oracle:thin:spectator/spectator123@localhost:1521:orcl");

			System.out.println("Polaczenie nawiazane");
			// odczytanie danych z bazy dla sprawdzenia poprawnosci polaczenia,
			// sql developer musi byc wylaczony
			return true;
		} catch (Exception e) {
			System.out.println("Blad polaczenia z baza danych");
			return false;
		}
	}

	public boolean dbConnectAsClient() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Sterowniki zaladowane");

			connection = DriverManager.getConnection("jdbc:oracle:thin:client/client123@localhost:1521:orcl");

			System.out.println("Polaczenie nawiazane");

			return true;
		} catch (Exception e) {
			System.out.println("Blad polaczenia z baza danych");
			return false;
		}
	}

	public boolean dbConnectAsWorker() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Sterowniki zaladowane");

			connection = DriverManager.getConnection("jdbc:oracle:thin:worker/worker123@localhost:1521:orcl");

			System.out.println("Polaczenie nawiazane");

			return true;
		} catch (Exception e) {
			System.out.println("Blad polaczenia z baza danych");
			return false;
		}
	}

	public boolean dbConnectAsAdministrator() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Sterowniki zaladowane");

			connection = DriverManager
					.getConnection("jdbc:oracle:thin:administrator/administrator123@localhost:1521:orcl");

			System.out.println("Polaczenie nawiazane");

			return true;
		} catch (Exception e) {
			System.out.println("Blad polaczenia z baza danych");
			return false;
		}
	}

	public void db_disconnect() {
		try {
			connection.close();
			System.out.println("Polaczenie z baza danych zakonczone");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean db_createAccount(int accountID, String login, String password, String security_question,
			String security_answer) {

		try {
			PreparedStatement prepStmt = connection.prepareStatement("INSERT INTO KONTO VALUES (?, ?, ?, ?, ?)");
			prepStmt.setInt(1, accountID);
			prepStmt.setString(2, login);
			prepStmt.setString(3, password);
			prepStmt.setString(4, security_question);
			prepStmt.setString(5, security_answer);
			prepStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean dbCreateAddress(Address address) {
		try {
			PreparedStatement prepStmt = connection.prepareStatement("INSERT INTO administrator.Dane_Adresowe"
					+ " (ID_ADRESU, MIASTO, KOD_POCZTOWY, ULICA, NUMER_DOMU, NUMER_MIESZKANIA) VALUES (?, ?, ?, ?, ?, ?)");
			prepStmt.setInt(1, address.getAdressID());
			prepStmt.setString(2, address.getCityName());
			prepStmt.setString(3, address.getPostalCode());
			prepStmt.setString(4, address.getStreet());
			prepStmt.setString(5, address.getHouseNumber());
			prepStmt.setString(6, address.getFlatNumber());
			prepStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean dbCreatePerson(Person person) {
		try {
			PreparedStatement prepStmt = connection
					.prepareStatement("INSERT INTO administrator.Dane_Osobowe (ID_OSOBY, IMIE, "
							+ "NAZWISKO, DATA_URODZENIA, ID_ADRESU, NUMER_TELEFONU, PYTANIE_BEZPIECZENSTWA, ODPOWIEDZ_BEZPIECZENSTWA) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			prepStmt.setInt(1, person.getPersonID());
			prepStmt.setString(2, person.getFirstName());
			prepStmt.setString(3, person.getLastName());
			prepStmt.setDate(4, convertUtilToSql(person.getBirthDate()));
			prepStmt.setInt(5, person.getAddressID());
			prepStmt.setInt(6, person.getPhoneNumber());
			prepStmt.setString(7, person.getSecurityQuestion());
			prepStmt.setString(8, person.getSecurityAnswer());
			prepStmt.execute();

			PreparedStatement prepStmt2 = connection
					.prepareStatement("INSERT INTO administrator.Dane_Kont (ID_KONTA, LOGIN, HASLO) VALUES (?, ?, ?)");
			prepStmt2.setInt(1, person.getPersonID());
			prepStmt2.setString(2, person.getLogin());
			prepStmt2.setString(3, person.getPassword());
			prepStmt2.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean dbCreateClient(Client client) {
		String suspended = "0";
		if (client.isSuspendedAccount())
			suspended = "1";

		try {
			PreparedStatement prepStmt = connection
					.prepareStatement("INSERT INTO administrator.Klienci (ID_KLIENTA, ID_OSOBY, "
							+ "DATA_REJESTRACJI, LICZBA_ZAMOWIEN, DATA_OSTATNIEJ_REZERWACJI, AKTYWNOSC) VALUES (?, ?, ?, ?, ?, ?)");
			prepStmt.setInt(1, client.getClientID());
			prepStmt.setInt(2, client.getPersonID());
			prepStmt.setDate(3, convertUtilToSql(client.getRegistrationDate()));
			prepStmt.setInt(4, client.getOrderQuantity());
			prepStmt.setDate(5, null);
			prepStmt.setString(6, suspended);
			prepStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean dbCreateWorker(Worker worker) {
		String isAdmin = "0";
		if (worker.isAdmin())
			isAdmin = "1";
		try {
			PreparedStatement prepStmt = connection
					.prepareStatement("INSERT INTO administrator.Pracownicy (ID_PRACOWNIKA, DATA_ZATRUDNIENIA,"
							+ " PENSJA, LICZBA_OBSLUZONYCH_KLIENTOW, ID_OSOBY, JEST_ADMINISTRATOREM) VALUES (?, ?, ?, ?, ?, ?)");
			prepStmt.setInt(1, worker.getPersonID());
			prepStmt.setDate(2, convertUtilToSql(worker.getHireDate()));
			prepStmt.setInt(3, worker.getSalary());
			prepStmt.setInt(4, worker.getServedClientsAmount());
			prepStmt.setInt(5, worker.getPersonID());
			prepStmt.setString(6, isAdmin);
			prepStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean dbCreateAssortment(Assortment assortment) {
		String availability = "0";
		if (assortment.isAvailability())
			availability = "1";
		try {
			PreparedStatement prepStmt = connection.prepareStatement(
					"INSERT INTO administrator.Asortyment (ID_SPRZETU, DATA_ZAKUPU, LICZBA_WYPOZYCZEN, DATA_OSTATNIEGO_WYPOZYCZENIA, "
							+ "DOSTEPNOSC, DATA_NASTEPNEJ_KONSERWACJI, STAN, ID_MODELU) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			prepStmt.setInt(1, assortment.getItemID());
			prepStmt.setDate(2, convertUtilToSql(assortment.getPucharseDate()));
			prepStmt.setInt(3, assortment.getLoansNumber());
			prepStmt.setDate(4, convertUtilToSql(assortment.getLastLoanDate()));
			prepStmt.setString(5, availability);
			prepStmt.setDate(6, convertUtilToSql(assortment.getNextMaintenanceDate()));
			prepStmt.setString(7, assortment.getCondition());
			prepStmt.setInt(8, assortment.getModelID());
			prepStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean dbCreateModel(Model model) {
		String season = "Z";
		if (model.getSeason())
			season = "L";
		try {
			PreparedStatement prepStmt = connection.prepareStatement("INSERT INTO administrator.Model (ID_MODELU, "
					+ "NAZWA_MODELU, PRODUCENT, RODZAJ_SPRZĘTU, SEZON_UZYTKOWY, CENA_DZIEN, KAUCJA_ZA_ZNISZCZENIE) VALUES (?, ?, ?, ?, ?, ?, ?)");
			prepStmt.setInt(1, model.getModelID());
			prepStmt.setString(2, model.getModelName());
			prepStmt.setString(3, model.getProducer());
			prepStmt.setString(4, model.getEquipmentType());
			prepStmt.setString(5, season);
			prepStmt.setInt(6, model.getCostPerDay() * 100);
			prepStmt.setInt(7, model.getDamageDeposit() * 100);
			prepStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean dbCreateRepair(RepairHistory repair) {
		try {
			PreparedStatement prepStmt = connection.prepareStatement(
					"INSERT INTO administrator.Historia_Napraw (NUMER_NAPRAWY, DATA_NAPRAWY, ID_PRACOWNIKA, CENA) VALUES (?, ?, ?, ?)");
			prepStmt.setInt(1, repair.getRepairNumber());
			prepStmt.setDate(2, convertUtilToSql(repair.getRepairDate()));
			prepStmt.setInt(3, repair.getWorkerID());
			prepStmt.setInt(4, repair.getPrice());
			prepStmt.execute();
			for (Integer i : repair.getListEqupimentID()) {
				PreparedStatement prepStmt2 = connection.prepareStatement(
						"INSERT INTO administrator.Naprawy_Asortyment (ID_SPRZETU, NUMER_NAPRAWY) VALUES (?, ?)");
				prepStmt2.setInt(1, i);
				prepStmt2.setInt(2, repair.getRepairNumber());
				prepStmt2.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean dbCreateMaintenance(MaintenanceHistory maintenance) {
		try {
			PreparedStatement prepStmt = connection.prepareStatement("INSERT INTO administrator.Historia_Konserwacji"
					+ " (NUMER_KONSERWACJI, DATA_KONSERWACJI, ID_PRACOWNIKA, CENA) VALUES (?, ?, ?, ?)");
			prepStmt.setInt(1, maintenance.getMaintenanceNumber());
			prepStmt.setDate(2, convertUtilToSql(maintenance.getMaintenanceDate()));
			prepStmt.setInt(3, maintenance.getWorkerID());
			prepStmt.setInt(4, maintenance.getPrice());
			prepStmt.execute();
			for (Integer i : maintenance.getListEquipmentID()) {
				PreparedStatement prepStmt2 = connection.prepareStatement(
						"INSERT INTO administrator.Konserwacje_Asortyment (ID_SPRZETU, NUMER_KONSERWACJI) VALUES (?, ?)");
				prepStmt2.setInt(1, i);
				prepStmt2.setInt(2, maintenance.getMaintenanceNumber());
				prepStmt2.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean dbCreateOrder(OrderHistory order) {
		try {
			PreparedStatement prepStmt = connection
					.prepareStatement("INSERT INTO administrator.Historia_Zamowien (NUMER_ZAMOWIENIA, ID_KLIENTA,"
							+ " ID_PRACOWNIKA, KOSZT, DATA_ZAMOWIENIA) VALUES (?, ?, ?, ?, ?)");
			prepStmt.setInt(1, order.getOrderNumber());
			if (order.getClientID() == -1)
				prepStmt.setNull(2, Types.NUMERIC);
			else
				prepStmt.setInt(2, order.getClientID());
			prepStmt.setNull(3, Types.NUMERIC);
			prepStmt.setInt(4, order.getCost());
			prepStmt.setDate(5, convertUtilToSql(order.getOrderDate()));
			prepStmt.execute();
			for (int i = 0; i < order.getListEquipmentID().size(); i++) {
				PreparedStatement prepStmt2 = connection.prepareStatement(
						"INSERT INTO administrator.Zamowienia_Asortyment (NUMER_ZAMOWIENIA, ID_SPRZETU,"
								+ " DATA_ROZPOCZECIA, DLUGOSC_ZAMOWIENIA) VALUES (?, ?, ?, ?)");
				prepStmt2.setInt(1, order.getOrderNumber());
				prepStmt2.setInt(2, order.getListEquipmentID().get(i));
				prepStmt2.setDate(3, convertUtilToSql(order.getListEqupimentLoanDate().get(i)));
				prepStmt2.setInt(4, order.getListEquipmentLoanLength().get(i));
				prepStmt2.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public ArrayList<Model> dbQueryModels() {
		ArrayList<Model> arrayListModels = new ArrayList<Model>();

		try {
			String queryModel = "SELECT ID_MODELU, NAZWA_MODELU, PRODUCENT, RODZAJ_SPRZĘTU, SEZON_UZYTKOWY, CENA_DZIEN,"
					+ " KAUCJA_ZA_ZNISZCZENIE FROM administrator.Model";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(queryModel);

			while (rs.next()) {
				int model_ID = rs.getInt("ID_MODELU");
				String model_name = rs.getString("NAZWA_MODELU");
				String producer = rs.getString("PRODUCENT");
				String equipment_type = rs.getString("RODZAJ_SPRZĘTU");
				boolean season = false;
				if (rs.getString("SEZON_UZYTKOWY").equals("L"))
					season = true;
				int cost_per_day = rs.getInt("CENA_DZIEN");
				int damage_deposit = rs.getInt("KAUCJA_ZA_ZNISZCZENIE");

				arrayListModels.add(new Model(model_ID, model_name, producer, equipment_type, season, cost_per_day,
						damage_deposit));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("model");
		}

		return arrayListModels;
	}

	public ArrayList<Assortment> dbQueryAssortment() {
		ArrayList<Assortment> arrayListAssortment = new ArrayList<Assortment>();

		try {
			String queryAssortment = "SELECT ID_SPRZETU, DATA_ZAKUPU, LICZBA_WYPOZYCZEN, DATA_OSTATNIEGO_WYPOZYCZENIA,"
					+ " DOSTEPNOSC, DATA_NASTEPNEJ_KONSERWACJI, STAN, ID_MODELU FROM administrator.Asortyment";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(queryAssortment);

			while (rs.next()) {
				int item_ID = rs.getInt("ID_SPRZETU");
				Date pucharse_date = convertSqlToUtil(rs.getDate("DATA_ZAKUPU"));
				int loans_number = rs.getInt("LICZBA_WYPOZYCZEN");
				Date last_loan_date = convertSqlToUtil(rs.getDate("DATA_OSTATNIEGO_WYPOZYCZENIA"));
				boolean availability = false;
				if (rs.getBoolean("DOSTEPNOSC"))
					availability = true;
				Date next_maintenance_date = rs.getDate("DATA_NASTEPNEJ_KONSERWACJI");
				String condition = rs.getString("STAN");
				int model_ID = rs.getInt("ID_MODELU");

				ArrayList<Integer> arrayList_order_ID = new ArrayList<Integer>();
				ArrayList<Date> arrayList_equipment_loan_date = new ArrayList<Date>();
				ArrayList<Integer> arrayList_equipment_loan_length = new ArrayList<Integer>();

				String query_equipment_ID_and_length = "SELECT NUMER_ZAMOWIENIA, DATA_ROZPOCZECIA, DLUGOSC_ZAMOWIENIA"
						+ " FROM administrator.Zamowienia_Asortyment WHERE ID_SPRZETU = " + item_ID;
				Statement stmt2 = connection.createStatement();
				ResultSet rs2 = stmt2.executeQuery(query_equipment_ID_and_length);

				while (rs2.next()) {
					arrayList_order_ID.add(rs2.getInt("NUMER_ZAMOWIENIA"));
					arrayList_equipment_loan_date.add(convertSqlToUtil(rs2.getDate("DATA_ROZPOCZECIA")));
					arrayList_equipment_loan_length.add(rs2.getInt("DLUGOSC_ZAMOWIENIA"));
				}

				arrayListAssortment.add(new Assortment(item_ID, pucharse_date, loans_number, last_loan_date,
						availability, next_maintenance_date, condition, model_ID, arrayList_order_ID,
						arrayList_equipment_loan_date, arrayList_equipment_loan_length));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("assortment");
		}

		return arrayListAssortment;
	}

	public ArrayList<Person> dbQueryPeople() {
		ArrayList<Person> arrayListPeople = new ArrayList<Person>();

		try {
			String queryPerson = "SELECT ID_OSOBY, IMIE, NAZWISKO, DATA_URODZENIA, ID_ADRESU, NUMER_TELEFONU,"
					+ " PYTANIE_BEZPIECZENSTWA, ODPOWIEDZ_BEZPIECZENSTWA FROM administrator.Dane_Osobowe";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(queryPerson);

			String queryAccountDate = "SELECT ID_KONTA, LOGIN, HASLO FROM administrator.Dane_Kont";
			Statement stmt2 = connection.createStatement();
			ResultSet rs2 = stmt2.executeQuery(queryAccountDate);

			while (rs.next() && rs2.next()) {
				int person_ID = rs.getInt("ID_OSOBY");
				String first_name = rs.getString("IMIE");
				String last_name = rs.getString("NAZWISKO");
				Date birth_date = convertSqlToUtil(rs.getDate("DATA_URODZENIA"));
				int address_ID = rs.getInt("ID_ADRESU");
				int phone_number = rs.getInt("NUMER_TELEFONU");
				String security_question = rs.getString("PYTANIE_BEZPIECZENSTWA");
				String security_answer = rs.getString("ODPOWIEDZ_BEZPIECZENSTWA");
				String login = rs2.getString("LOGIN");
				String password = rs2.getString("HASLO");

				arrayListPeople.add(new Person(person_ID, first_name, last_name, birth_date, phone_number, address_ID,
						login, password, security_question, security_answer));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("person");
		}

		return arrayListPeople;
	}

	public ArrayList<Address> dbQueryAddresses() {
		ArrayList<Address> arrayListAddresses = new ArrayList<Address>();

		try {
			String queryAdress = "SELECT ID_ADRESU, MIASTO, KOD_POCZTOWY, ULICA, NUMER_DOMU, NUMER_MIESZKANIA"
					+ " FROM administrator.Dane_Adresowe";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(queryAdress);

			while (rs.next()) {
				int address_id = rs.getInt("ID_ADRESU");
				String city_name = rs.getString("MIASTO");
				String postal_code = rs.getString("KOD_POCZTOWY");
				String street = rs.getString("ULICA");
				String house_number = rs.getString("NUMER_DOMU");
				String flat_number = rs.getString("NUMER_MIESZKANIA");

				arrayListAddresses
						.add(new Address(address_id, city_name, postal_code, street, house_number, flat_number));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("adres");
		}

		return arrayListAddresses;
	}

	public ArrayList<Client> dbQueryClients() {
		ArrayList<Client> arrayListClients = new ArrayList<Client>();

		try {
			String queryClient = "SELECT ID_KLIENTA, DATA_REJESTRACJI, LICZBA_ZAMOWIEN, DATA_OSTATNIEJ_REZERWACJI"
					+ ", AKTYWNOSC, ID_OSOBY FROM administrator.Klienci";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(queryClient);

			while (rs.next()) {
				int client_ID = rs.getInt("ID_KLIENTA");
				Date registration_date = convertSqlToUtil(rs.getDate("DATA_REJESTRACJI"));
				int order_quantity = rs.getInt("LICZBA_ZAMOWIEN");
				Date last_order_date = convertSqlToUtil(rs.getDate("DATA_OSTATNIEJ_REZERWACJI"));
				boolean suspended_account = false;
				if (rs.getString("AKTYWNOSC").equals("1"))
					suspended_account = true;
				int person_ID = rs.getInt("ID_OSOBY");

				arrayListClients.add(new Client(client_ID, registration_date, order_quantity, last_order_date,
						suspended_account, person_ID));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("client");
		}

		return arrayListClients;
	}

	public ArrayList<Worker> dbQueryWorkers() {
		ArrayList<Worker> arrayListWorkers = new ArrayList<Worker>();

		try {
			String queryClient = "SELECT ID_PRACOWNIKA, DATA_ZATRUDNIENIA, PENSJA, LICZBA_OBSLUZONYCH_KLIENTOW"
					+ ", ID_OSOBY, JEST_ADMINISTRATOREM FROM administrator.Pracownicy";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(queryClient);

			while (rs.next()) {
				int worker_ID = rs.getInt("ID_PRACOWNIKA");
				Date hire_date = rs.getDate("DATA_ZATRUDNIENIA");
				int salary = rs.getInt("PENSJA");
				int served_clients_amount = rs.getInt("LICZBA_OBSLUZONYCH_KLIENTOW");
				boolean is_admin = false;
				if (rs.getString("JEST_ADMINISTRATOREM").equals("1"))
					is_admin = true;
				int person_ID = rs.getInt("ID_OSOBY");

				arrayListWorkers
						.add(new Worker(worker_ID, hire_date, salary, served_clients_amount, person_ID, is_admin));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("worker");
		}

		return arrayListWorkers;
	}

	public ArrayList<OrderHistory> dbQueryOrders() {
		ArrayList<OrderHistory> arrayListOrders = new ArrayList<OrderHistory>();

		try {
			String queryOrder = "SELECT NUMER_ZAMOWIENIA, ID_KLIENTA, ID_PRACOWNIKA, KOSZT, DATA_ZAMOWIENIA"
					+ " FROM administrator.Historia_Zamowien";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(queryOrder);

			while (rs.next()) {
				int order_number = rs.getInt("NUMER_ZAMOWIENIA");
				int client_ID = rs.getInt("ID_KLIENTA");
				int cost = rs.getInt("KOSZT");
				Date order_date = convertSqlToUtil(rs.getDate("DATA_ZAMOWIENIA"));
				ArrayList<Integer> arrayList_equipment_ID = new ArrayList<Integer>();
				ArrayList<Date> arrayList_equipment_loan_date = new ArrayList<Date>();
				ArrayList<Integer> arrayList_equipment_loan_length = new ArrayList<Integer>();

				String query_equipment_ID_and_length = "SELECT ID_SPRZETU, DATA_ROZPOCZECIA, DLUGOSC_ZAMOWIENIA"
						+ " FROM administrator.Zamowienia_Asortyment WHERE NUMER_ZAMOWIENIA = " + order_number;
				Statement stmt2 = connection.createStatement();
				ResultSet rs2 = stmt2.executeQuery(query_equipment_ID_and_length);

				while (rs2.next()) {
					arrayList_equipment_ID.add(rs2.getInt("ID_SPRZETU"));
					arrayList_equipment_loan_date.add(convertSqlToUtil(rs2.getDate("DATA_ROZPOCZECIA")));
					arrayList_equipment_loan_length.add(rs2.getInt("DLUGOSC_ZAMOWIENIA"));
				}

				arrayListOrders.add(new OrderHistory(order_number, client_ID, order_date, cost, arrayList_equipment_ID,
						arrayList_equipment_loan_date, arrayList_equipment_loan_length));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("order");
		}

		return arrayListOrders;
	}

	public ArrayList<MaintenanceHistory> dbQueryMaintenances() {
		ArrayList<MaintenanceHistory> arrayListMaintenances = new ArrayList<MaintenanceHistory>();

		try {
			String queryMaintenance = "SELECT NUMER_KONSERWACJI, DATA_KONSERWACJI, ID_PRACOWNIKA, CENA"
					+ " FROM administrator.Historia_Konserwacji";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(queryMaintenance);

			while (rs.next()) {
				int maintenance_number = rs.getInt("NUMER_KONSERWACJI");
				Date maintenance_date = convertSqlToUtil(rs.getDate("DATA_KONSERWACJI"));
				int worker_ID = rs.getInt("ID_PRACOWNIKA");
				int price = rs.getInt("CENA");
				ArrayList<Integer> arrayList_equipment_ID = new ArrayList<Integer>();

				String query_maintenance_items = "SELECT ID_SPRZETU FROM administrator.Konserwacje_Asortyment"
						+ " WHERE NUMER_KONSERWACJI = " + maintenance_number;
				Statement stmt2 = connection.createStatement();
				ResultSet rs2 = stmt2.executeQuery(query_maintenance_items);

				while (rs2.next()) {
					arrayList_equipment_ID.add(rs2.getInt("ID_SPRZETU"));
				}

				arrayListMaintenances.add(new MaintenanceHistory(maintenance_number, maintenance_date,
						arrayList_equipment_ID, worker_ID, price));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("maintenance");
		}

		return arrayListMaintenances;
	}

	public ArrayList<RepairHistory> dbQueryRepairs() {
		ArrayList<RepairHistory> arrayListRepairs = new ArrayList<RepairHistory>();

		try {
			String queryRepair = "SELECT NUMER_NAPRAWY, DATA_NAPRAWY, ID_PRACOWNIKA, CENA"
					+ " FROM administrator.Historia_Napraw";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(queryRepair);

			while (rs.next()) {
				int repair_number = rs.getInt("NUMER_NAPRAWY");
				Date repair_date = convertSqlToUtil(rs.getDate("DATA_NAPRAWY"));
				int worker_ID = rs.getInt("ID_PRACOWNIKA");
				int price = rs.getInt("CENA");
				ArrayList<Integer> arrayList_equipment_ID = new ArrayList<Integer>();

				String query_maintenance_items = "SELECT ID_SPRZETU FROM administrator.Naprawy_Asortyment"
						+ " WHERE NUMER_NAPRAWY = " + repair_number;
				Statement stmt2 = connection.createStatement();
				ResultSet rs2 = stmt2.executeQuery(query_maintenance_items);

				while (rs2.next()) {
					arrayList_equipment_ID.add(rs2.getInt("ID_SPRZETU"));
				}

				arrayListRepairs
						.add(new RepairHistory(repair_number, repair_date, arrayList_equipment_ID, worker_ID, price));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("repair");
		}
		return arrayListRepairs;
	}

	public ArrayList<Integer> dbQueryPopularItems() {
		ArrayList<Integer> arrayListPopularItems = new ArrayList<Integer>();

		try {
			String queryRepair = "SELECT ID_MODELU FROM administrator.Najpopularniejsze_przedmioty";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(queryRepair);
			
			int items_number = 0;
			while(rs.next() || items_number == 5) {
				arrayListPopularItems.add(rs.getInt("ID_MODELU"));
				items_number++;
			}
		} catch (Exception e) {
			System.out.println("popular items");
		}

		return arrayListPopularItems;
	}

	private Date convertSqlToUtil(java.sql.Date date) {
		try {
			String[] parts = date.toString().split("-");
			Calendar c = Calendar.getInstance();
			c.set(Calendar.YEAR, Integer.parseInt(parts[0]));
			c.set(Calendar.MONTH, Integer.parseInt(parts[1]));
			c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(parts[2]));
			c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			c.set(Calendar.MILLISECOND, 0);
			return (c.getTime());
		} catch (Exception ex) {
			return null;
		}
	}

	public static java.sql.Date convertUtilToSql(java.util.Date uDate) {
		try {
			java.sql.Date sDate = new java.sql.Date(uDate.getTime());
			return sDate;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}