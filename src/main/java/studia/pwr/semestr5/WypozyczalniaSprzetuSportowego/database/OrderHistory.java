package studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database;

import java.util.Date;
import java.util.List;

public class OrderHistory {
	private int orderNumber;
	private int clientID;
	private int workerID;
	private Date orderDate;
	private List<Integer> listEquipmentID;
	private int orderLength;
	
	public OrderHistory() {
		super();
	}

	public OrderHistory(int orderNumber, int clientID, int workerID, Date orderDate, List<Integer> listEquipmentID,
			int orderLength) {
		super();
		this.orderNumber = orderNumber;
		this.clientID = clientID;
		this.workerID = workerID;
		this.orderDate = orderDate;
		this.listEquipmentID = listEquipmentID;
		this.orderLength = orderLength;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public int getWorkerID() {
		return workerID;
	}

	public void setWorkerID(int workerID) {
		this.workerID = workerID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public List<Integer> getListEquipmentID() {
		return listEquipmentID;
	}

	public void setListEquipmentID(List<Integer> listEquipmentID) {
		this.listEquipmentID = listEquipmentID;
	}

	public int getOrderLength() {
		return orderLength;
	}

	public void setOrderLength(int orderLength) {
		this.orderLength = orderLength;
	}

	@Override
	public String toString() {
		return "OrderHistory [orderNumber=" + orderNumber + ", clientID=" + clientID + ", workerID=" + workerID
				+ ", orderDate=" + orderDate + ", listEquipmentID=" + listEquipmentID + ", orderLength=" + orderLength
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}


	
	
}
