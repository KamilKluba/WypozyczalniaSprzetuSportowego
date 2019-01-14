package studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.app;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	 public void db_connect()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Sterowniki zaladowane");
			
			// jdbc:oracle:thin:username/password@localhost:port:SID
			connection = DriverManager.getConnection("jdbc:oracle:thin:system/Bazydanych2@localhost:1521:ORACLE");

			System.out.println("Polaczenie nawiazane");
			// odczytanie danych z bazy dla sprawdzenia poprawnosci polaczenia,
			// sql developer musi byc wylaczony
			
		} catch (Exception e) {
			System.out.println("Blad polaczenia z baza danych");
		}
		
		
	}
	
	public void db_disconnect()
	{
		try {
			connection.close();
			System.out.println("Polaczenie z baza danych zakonczone");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean db_createAccount(int accountID, String login, String password, String security_question, String security_answer)
	{

		try {
			PreparedStatement prepStmt = connection.prepareStatement(
					"INSERT INTO KONTO VALUES (?, ?, ?, ?, ?)");
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
			int flatNumber)
	{

		try {
			PreparedStatement prepStmt = connection.prepareStatement(
					"INSERT INTO DANE_ADRESOWE VALUES (?, ?, ?, ?, ?, ?)");
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
	

	
	public boolean db_createPerson(int personID, String name, String last_name, java.sql.Date birth_date,
			int addressID) 
	{
			
		try {
			
			PreparedStatement prepStmt = connection.prepareStatement(
					"INSERT INTO Dane_Osobowe VALUES (?, ?, ?, ?, ?)");
			prepStmt.setInt(1, personID);
			prepStmt.setString(2, name);
			prepStmt.setString(3, last_name);
			prepStmt.setDate(4, (Date) birth_date);
			prepStmt.setInt(5, addressID);
			prepStmt.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean db_createClient(int clientID, int personID, int adressID, java.util.Date date, int orderQuantity, java.util.Date lastOrderDate, int suspendedAccount)
	{
		
		try {
			PreparedStatement prepStmt = connection.prepareStatement(
					"INSERT INTO KLIENT VALUES (?, ?, ?, ?, ?, ?, ?)");
			prepStmt.setInt(1, clientID);
			prepStmt.setInt(2, personID);
			prepStmt.setInt(3, adressID);
			prepStmt.setDate(4, (Date) date);
			prepStmt.setInt(5, orderQuantity);
			prepStmt.setDate(6, (Date) lastOrderDate);
			prepStmt.setInt(7, suspendedAccount);
			prepStmt.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean db_createAssortment(int assortmentID, java.util.Date buyDate, int rentNumber, java.util.Date lastRentDate, int availability, java.util.Date dateNextMaintenance, String condition, int modelID)
	{
		try {
			PreparedStatement prepStmt = connection.prepareStatement(
					"INSERT INTO SPRZET VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			prepStmt.setInt(1, assortmentID);
			prepStmt.setDate(2, (Date)buyDate);
			prepStmt.setInt(3, rentNumber);
			prepStmt.setDate(4, (Date) lastRentDate);
			prepStmt.setInt(5, availability);
			prepStmt.setDate(6, (Date) dateNextMaintenance);
			prepStmt.setString(7, condition);
			prepStmt.setInt(8, modelID);
			prepStmt.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean db_createModel(int modelID, String modelName, String producer, String equipmentType, int season, int costPerDay,	int damageDeposit)
	{
		try {
			PreparedStatement prepStmt = connection.prepareStatement(
					"INSERT INTO MODEL VALUES (?, ?, ?, ?, ?, ?, ?)");
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
	


}