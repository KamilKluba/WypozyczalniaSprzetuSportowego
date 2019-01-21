package studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database;

import java.util.Date;

public class Client{
	private int clientID;
	private Date registrationDate;
	private int orderQuantity;
	private Date lastOrderDate;
	private boolean activeAccount;
	private int personID;
	
	public Client() {
	}
	
	public Client(int clientID, Date registrationDate, int orderQuantity, Date lastOrderDate, boolean suspendedAccount,
			int personID) {
		this.clientID = clientID;
		this.registrationDate = registrationDate;
		this.orderQuantity = orderQuantity;
		this.lastOrderDate = lastOrderDate;
		this.activeAccount = suspendedAccount;
		this.personID = personID;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Date getLastOrderDate() {
		return lastOrderDate;
	}

	public void setLastOrderDate(Date lastOrderDate) {
		this.lastOrderDate = lastOrderDate;
	}

	public boolean isSuspendedAccount() {
		return activeAccount;
	}

	public void setSuspendedAccount(boolean suspendedAccount) {
		this.activeAccount = suspendedAccount;
	}

	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	@Override
	public String toString() {
		return "Client [clientID=" + clientID + ", registrationDate=" + registrationDate + ", orderQuantity="
				+ orderQuantity + ", lastOrderDate=" + lastOrderDate + ", suspendedAccount=" + activeAccount
				+ ", personID=" + personID;
	}
	
	
}
