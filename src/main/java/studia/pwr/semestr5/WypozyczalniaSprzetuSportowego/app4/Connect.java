import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

// aby utowrzyc polaczenie z baza danych nalezy:
// 1. pobrac oracle jdbc ze strony https://www.oracle.com/technetwork/database/application-development/jdbc/downloads/index.html
// 2. dodac jdbc do projektu: W tym celu klikamy PPM na nazwê naszego projektu ->Build Path->Configure Build Path,
// przechodzimy do zak³adki Libraries->Add External JARs i wybieramy bibliotekê ojbc8.jar z katalogu do którego j¹ zapisaliœmy.
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
 
 static public void db_connection() 
  {
  try
  {
  Class.forName("oracle.jdbc.driver.OracleDriver");
  System.out.println("Sterowniki za³adowane");
  
  // jdbc:oracle:thin:username/password@localhost:port:SID
  Connection polaczenie=DriverManager.getConnection("jdbc:oracle:thin:system/Bazydanych2@localhost:1522:ORCLE");

  System.out.println("Po³¹czenie nawi¹zane");
  // odczytanie danych z bazy dla sprawdzenia poprawnosci polaczenia, sql developer musi byc wylaczony
  Statement a =polaczenie.createStatement();
  ResultSet res = a.executeQuery("select * from PRACOWNIK");

  System.out.println("Wyniki zapytania: ");

  while(res.next()){
  System.out.print(res.getString(1) + " ");  
  System.out.print(res.getString(2));
  System.out.println(res.getString(3));
  }
  }
  catch(Exception wyjatek)
  {  
  System.out.println("B³¹d"); 
  }
   

  }
public static void main(String[] args){
  Connect oracle = new Connect();
  oracle.db_connection();  
}
}