package studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.app;

import java.text.SimpleDateFormat;
import java.util.Date;

import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Address;
import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Assortment;
import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Client;
import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Model;
import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Person;
import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Worker;

public class TestData {
	MainWindow mainWindow;

	public TestData(MainWindow mainWindow) {
		this.mainWindow = mainWindow;

		try {
			// pracownicy-------------------------------------------------------------------------------------------
			mainWindow.getArrayListAddresses().add(new Address(1, "Wroclaw", "12-345", "Krotka", "1", "1"));
			mainWindow.getArrayListPeople()
					.add(new Person(1, "Kamil", "Kluba", new SimpleDateFormat("dd/MM/yyyy").parse("12/06/1996"), 123456789, 1,
							"a", "a", "Imie kota", "Jurgen"));
			mainWindow.getArrayListWorkers()
					.add(new Worker(1, new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2010"), 3000, 0, 1, true));

			mainWindow.getArrayListAddresses().add(new Address(2, "Wroclaw", "21-434", "Dluga", "15", null));
			mainWindow.getArrayListPeople()
					.add(new Person(2, "Jerzy", "Jerzowski", new SimpleDateFormat("dd/MM/yyyy").parse("22/02/1986"), 987654321, 2,
							"Frankensztajn", "password2", "Ulubiony kolor", "Niebieski"));
			mainWindow.getArrayListWorkers()
					.add(new Worker(2, new SimpleDateFormat("dd/MM/yyyy").parse("11/12/2014"), 3000, 0, 2, false));

			// klienci----------------------------------------------------------------------------------------------
			mainWindow.getArrayListAddresses().add(new Address(3, "Krakow", "98-754", "Krakowska", "143", "12"));
			mainWindow.getArrayListPeople()
					.add(new Person(3, "Tomasz", "Nowak", new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1980"), 123654789, 3,
							"b", "b", "Wzrost", "185"));
			mainWindow.getArrayListClients()
					.add(new Client(1, new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2015"), 0, null, false, 3));

			mainWindow.getArrayListAddresses().add(new Address(4, "Czestochowa", "88-888", "Krzywa", "132", null));
			mainWindow.getArrayListPeople()
					.add(new Person(4, "Jan", "Nowak", new SimpleDateFormat("dd/MM/yyyy").parse("20/12/1995"), 987456321, 4,
							"Jano12", "password4", "Pierwsze auto", "Golf 3"));
			mainWindow.getArrayListClients()
					.add(new Client(2, new SimpleDateFormat("dd/MM/yyyy").parse("04/11/2016"), 0, null, false, 4));

			mainWindow.getArrayListAddresses().add(new Address(5, "Wroclaw", "98-987", "Kwadratowa", "99", "12"));
			mainWindow.getArrayListPeople().add(new Person(5, "Bartosz", "Kurek",
					new SimpleDateFormat("dd/MM/yyyy").parse("05/07/1990"), 132457689, 5, "Siatkarz", "password5", "MVP?", "Tak"));
			mainWindow.getArrayListClients()
					.add(new Client(3, new SimpleDateFormat("dd/MM/yyyy").parse("15/08/2016"), 0, null, false, 5));
			
			//modele------------------------------------------------------------------------------------------------
			mainWindow.getArrayListModels().add(new Model(1, "Helmix2000", "WinterWear", "Kask", false, 1000, 250000));
			mainWindow.getArrayListModels().add(new Model(2, "Helmix3000", "WinterWear", "Kask", false, 1200, 300000));
			mainWindow.getArrayListModels().add(new Model(3, "Kurtex150", "WinterWear", "Kurtka", false, 2000, 500000));
			mainWindow.getArrayListModels().add(new Model(4, "NartyWziuuu", "Winter Sports", "narty", false, 6000, 90000));
			mainWindow.getArrayListModels().add(new Model(5, "RękawiczkiCieploWŁapex", "Winter Sports", "Rękawiczki", false, 500, 10000));
			mainWindow.getArrayListModels().add(new Model(6, "Łyżwy ostre jak maczeta", "KrakowSport", "Buty", false, 10000, 200000));
		
			//przedmioty--------------------------------------------------------------------------------------------
			mainWindow.getArrayListAssortment()
					.add(new Assortment(1, new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2008"), 0, null, true,
							new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"), "Dobry", 1));
			mainWindow.getArrayListAssortment()
			.add(new Assortment(2, new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2008"), 0, null, true,
					new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"), "Bardzo Dobry", 1));
			mainWindow.getArrayListAssortment()
			.add(new Assortment(3, new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2008"), 0, null, true,
					new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"), "Średni", 2));
			mainWindow.getArrayListAssortment()
			.add(new Assortment(4, new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2010"), 0, null, true,	
					new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"), "Uszkodzony", 2));
			mainWindow.getArrayListAssortment()
			.add(new Assortment(5, new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2010"), 0, null, true,
					new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"), "Dobry", 3));
			mainWindow.getArrayListAssortment()
			.add(new Assortment(6, new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2010"), 0, null, true,
					new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"), "Bardzo Dobry", 3));
			mainWindow.getArrayListAssortment()
			.add(new Assortment(7, new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2012"), 0, null, true,
					new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"), "Dobry", 4));
			mainWindow.getArrayListAssortment()
			.add(new Assortment(8, new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2012"), 0, null, true,
					new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"), "Dobry", 4));
			mainWindow.getArrayListAssortment()
			.add(new Assortment(9, new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2012"), 0, null, true,
					new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"), "Średni", 5));
			mainWindow.getArrayListAssortment()
			.add(new Assortment(10, new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2014"), 0, null, true,
					new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"), "Dobry", 5));
			mainWindow.getArrayListAssortment()
			.add(new Assortment(11, new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2014"), 0, null, true,
					new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"), "Bardzo Dobry", 6));
			
			//zamownienia------------------------------------------------------------------------------------
			mainWindow.getArrayListAssortment().get(0).getListDateOfOrder().add(new SimpleDateFormat("dd/MM/yyyy").parse("12/01/2019"));
			mainWindow.getArrayListAssortment().get(0).getListLengthOfOrder().add(7);
			
			mainWindow.getArrayListAssortment().get(0).getListDateOfOrder().add(new SimpleDateFormat("dd/MM/yyyy").parse("27/01/2019"));
			mainWindow.getArrayListAssortment().get(0).getListLengthOfOrder().add(10);
			
			mainWindow.getArrayListAssortment().get(1).getListDateOfOrder().add(new SimpleDateFormat("dd/MM/yyyy").parse("17/01/2019"));
			mainWindow.getArrayListAssortment().get(1).getListLengthOfOrder().add(5);
			
			mainWindow.getArrayListAssortment().get(1).getListDateOfOrder().add(new SimpleDateFormat("dd/MM/yyyy").parse("15/02/2019"));
			mainWindow.getArrayListAssortment().get(1).getListLengthOfOrder().add(4);

			mainWindow.getArrayListAssortment().get(1).getListDateOfOrder().add(new SimpleDateFormat("dd/MM/yyyy").parse("17/01/2019"));
			mainWindow.getArrayListAssortment().get(1).getListLengthOfOrder().add(5);
			
			mainWindow.getArrayListAssortment().get(1).getListDateOfOrder().add(new SimpleDateFormat("dd/MM/yyyy").parse("15/02/2019"));
			mainWindow.getArrayListAssortment().get(1).getListLengthOfOrder().add(4);
			
			mainWindow.getArrayListAssortment().get(2).getListDateOfOrder().add(new SimpleDateFormat("dd/MM/yyyy").parse("20/01/2019"));
			mainWindow.getArrayListAssortment().get(2).getListLengthOfOrder().add(15);
			
			mainWindow.getArrayListAssortment().get(4).getListDateOfOrder().add(new SimpleDateFormat("dd/MM/yyyy").parse("26/03/2019"));
			mainWindow.getArrayListAssortment().get(4).getListLengthOfOrder().add(9);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
