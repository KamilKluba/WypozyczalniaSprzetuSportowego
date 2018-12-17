package studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.users;

import java.util.Date;

public class Person {
	private int personID;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private int addressID;
	private String password;
	
	
	public Person() {
		super();
	}
	
	public Person(int personID, String firstName, String lastName, Date birthDate, int addressID, String password) {
		super();
		this.personID = personID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.addressID = addressID;
		this.password = password;
	}

	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Person [personID=" + personID + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate="
				+ birthDate + ", addressID=" + addressID + ", password=" + password + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


	
	
}
