package studia.pwr.semestr5.WypozyczalniaSprzetuSportowego;

import java.util.Date;
import java.util.List;

public class Asortment {
	private int itemID;
	private Date pucharseDate;
	private int loansNumber;
	private Date lastLoanDate;
	private boolean availability;
	private Date nextMaintenanceDate;
	private String condition;
	private int modelID;
	private List<Integer> listOrdersNumber;
	private List<Integer> listRepairsNumber;
	private List<Integer> listMaintenancesNumber;

	public Asortment() {
		super();
	}


	public Asortment(int itemID, Date pucharseDate, int loansNumber, Date lastLoanDate, boolean availability,
			Date nextMaintenanceDate, String condition, int modelID, List<Integer> listOrdersNumber,
			List<Integer> listRepairsNumber, List<Integer> listMaintenancesNumber) {
		super();
		this.itemID = itemID;
		this.pucharseDate = pucharseDate;
		this.loansNumber = loansNumber;
		this.lastLoanDate = lastLoanDate;
		this.availability = availability;
		this.nextMaintenanceDate = nextMaintenanceDate;
		this.condition = condition;
		this.modelID = modelID;
		this.listOrdersNumber = listOrdersNumber;
		this.listRepairsNumber = listRepairsNumber;
		this.listMaintenancesNumber = listMaintenancesNumber;
	}


	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public Date getPucharseDate() {
		return pucharseDate;
	}

	public void setPucharseDate(Date pucharseDate) {
		this.pucharseDate = pucharseDate;
	}

	public int getLoansNumber() {
		return loansNumber;
	}

	public void setLoansNumber(int loansNumber) {
		this.loansNumber = loansNumber;
	}

	public Date getLastLoanDate() {
		return lastLoanDate;
	}

	public void setLastLoanDate(Date lastLoanDate) {
		this.lastLoanDate = lastLoanDate;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public Date getNextMaintenanceDate() {
		return nextMaintenanceDate;
	}

	public void setNextMaintenanceDate(Date nextMaintenanceDate) {
		this.nextMaintenanceDate = nextMaintenanceDate;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getModelID() {
		return modelID;
	}

	public void setModelID(int modelID) {
		this.modelID = modelID;
	}

	public List<Integer> getListOrdersNumber() {
		return listOrdersNumber;
	}

	public void setListOrdersNumber(List<Integer> listOrdersNumber) {
		this.listOrdersNumber = listOrdersNumber;
	}

	public List<Integer> getListRepairsNumber() {
		return listRepairsNumber;
	}


	public void setListRepairsNumber(List<Integer> listRepairsNumber) {
		this.listRepairsNumber = listRepairsNumber;
	}


	public List<Integer> getListMaintenancesNumber() {
		return listMaintenancesNumber;
	}


	public void setListMaintenancesNumber(List<Integer> listMaintenancesNumber) {
		this.listMaintenancesNumber = listMaintenancesNumber;
	}


	@Override
	public String toString() {
		return "Asortment [itemID=" + itemID + ", pucharseDate=" + pucharseDate + ", loansNumber=" + loansNumber
				+ ", lastLoanDate=" + lastLoanDate + ", availability=" + availability + ", nextMaintenanceDate="
				+ nextMaintenanceDate + ", condition=" + condition + ", modelID=" + modelID + ", listOrdersNumber="
				+ listOrdersNumber + ", listRepairsNumber=" + listRepairsNumber + ", listMaintenancesNumber="
				+ listMaintenancesNumber + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
