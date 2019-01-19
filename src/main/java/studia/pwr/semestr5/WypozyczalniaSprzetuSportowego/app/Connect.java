package studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Model;

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

	public boolean db_createAddress(int adressID, String cityName, String postalCode, String street, int houseNumber,
			int flatNumber) {

		try {
			PreparedStatement prepStmt = connection
					.prepareStatement("INSERT INTO DANE_ADRESOWE VALUES (?, ?, ?, ?, ?, ?)");
			prepStmt.setInt(1, adressID);
			prepStmt.setString(2, cityName);
			prepStmt.setString(3, postalCode);
			prepStmt.setString(4, street);
			prepStmt.setInt(5, houseNumber);
			prepStmt.setInt(6, flatNumber);
			prepStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;
	}

	public boolean db_createPerson(int personID, String name, String last_name, java.util.Date birth_date,
			int addressID) {
		java.sql.Date sDate = convertUtilToSql(birth_date);

		try {

			PreparedStatement prepStmt = connection.prepareStatement("INSERT INTO Dane_Osobowe VALUES (?, ?, ?, ?, ?)");
			prepStmt.setInt(1, personID);
			prepStmt.setString(2, name);
			prepStmt.setString(3, last_name);
			prepStmt.setDate(4, sDate);
			prepStmt.setInt(5, addressID);
			prepStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean db_createClient(int clientID, int personID, int accountID, java.util.Date date, int orderQuantity,
			java.util.Date lastOrderDate, int suspendedAccount) {

		java.sql.Date sDate = convertUtilToSql(date);

		try {
			PreparedStatement prepStmt = connection.prepareStatement("INSERT INTO KLIENT VALUES (?, ?, ?, ?, ?, ?, ?)");
			prepStmt.setInt(1, clientID);
			prepStmt.setInt(2, personID);
			prepStmt.setInt(3, accountID);
			prepStmt.setDate(4, sDate);
			prepStmt.setInt(5, orderQuantity);
			prepStmt.setDate(6, null);
			prepStmt.setInt(7, suspendedAccount);
			prepStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean db_createAssortment(int assortmentID, java.util.Date buyDate, int rentNumber,
			java.util.Date lastRentDate, int availability, java.util.Date dateNextMaintenance, String condition,
			int modelID) {
		java.sql.Date sDate = convertUtilToSql(buyDate);
		java.sql.Date sDate2 = convertUtilToSql(dateNextMaintenance);
		try {
			PreparedStatement prepStmt = connection
					.prepareStatement("INSERT INTO SPRZET VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			prepStmt.setInt(1, assortmentID);
			prepStmt.setDate(2, sDate);
			prepStmt.setInt(3, rentNumber);
			prepStmt.setDate(4, null);
			prepStmt.setInt(5, availability);
			prepStmt.setDate(6, sDate2);
			prepStmt.setString(7, condition);
			prepStmt.setInt(8, modelID);
			prepStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean db_createModel(int modelID, String modelName, String producer, String equipmentType, int season,
			int costPerDay, int damageDeposit) {
		try {
			PreparedStatement prepStmt = connection.prepareStatement("INSERT INTO MODEL VALUES (?, ?, ?, ?, ?, ?, ?)");
			prepStmt.setInt(1, modelID);
			prepStmt.setString(2, modelName);
			prepStmt.setString(3, producer);
			prepStmt.setString(4, equipmentType);
			prepStmt.setInt(5, season);
			prepStmt.setInt(6, costPerDay);
			prepStmt.setInt(7, damageDeposit);
			prepStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ArrayList<Model> dbQueryModels() {
		ArrayList<Model> arrayListModels = new ArrayList<Model>();

		try {
			System.out.println("lecimy");

			String query = "SELECT ID_MODELU, NAZWA_MODELU, PRODUCENT, RODZAJ_SPRZĘTU, SEZON_UZYTKOWY, CENA_DZIEN, KAUCJA_ZA_ZNISZCZENIE FROM administrator.Model";

			Statement stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				System.out.println(
						rs.getInt("ID_MODELU") + " " + rs.getString("NAZWA_MODELU") + " " + rs.getString("PRODUCENT")
								+ " " + rs.getString("RODZAJ_SPRZĘTU") + " " + rs.getString("SEZON_UZYTKOWY") + " "
								+ rs.getInt("CENA_DZIEN") + " " + rs.getInt("KAUCJA_ZA_ZNISZCZENIE"));

				boolean season = false;
				if (rs.getString("SEZON_UZYTKOWY").equals("L"))
					season = true;
				arrayListModels.add(new Model(rs.getInt("ID_MODELU"), rs.getString("NAZWA_MODELU"),
						rs.getString("PRODUCENT"), rs.getString("RODZAJ_SPRZĘTU"), season, rs.getInt("CENA_DZIEN"),
						rs.getInt("KAUCJA_ZA_ZNISZCZENIE")));
			}

			System.out.println("polecielimy");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arrayListModels;
	}
}