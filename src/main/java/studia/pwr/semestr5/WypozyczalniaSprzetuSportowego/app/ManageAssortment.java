package studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.app;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Address;
import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Assortment;
import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Client;
import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Model;
import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Person;

public class ManageAssortment {
	
	private ArrayList<Assortment> arrayListAssortment;
	private boolean create;
	private Assortment assortment;
	private String[] dividedModel;
	JPanel panelDBContent;

	JDialog dialogManageAssortment;
	
	JLabel labelAssortmentID;
	JTextField textFieldAssortmentID;
	JLabel labelModelID;
	JTextField textFieldModelID;
	JLabel labelBuyDate;
	JTextField textFieldBuyDate;
	JLabel labelRentNumber;
	JTextField textFieldRentNumber;
	JLabel labelLastRentDate;
	JTextField textFieldLastRentDate;
	JLabel LabelAvailability;
	JTextField textFieldAvailability;
	JLabel labelNumberOfMaintenance;
	JTextField textFieldNumberOfMaintenance;
	JLabel labelDateNextMaintenance;
	JTextField textFieldDateNextMaintenance;
	JLabel labelCondition;
	JTextField textFieldCondition;
	JLabel labelInCirculation;
	JTextField textFieldInCirculation;
	JLabel labelMaintenanceNumber;
	JTextField textFieldMaintenanceNumber;
	JLabel labelRepairNumber;
	JTextField textFieldRepairNumber;
	JButton buttonCancel;
	JButton buttonCreateAssortment;
	
	public ManageAssortment() {
	}

	public ManageAssortment(ArrayList<Assortment> arrayListAssortment, boolean create) {
		
		this.arrayListAssortment = arrayListAssortment;
		this.create = create;

		initComponents();
		initListeners();
		
		dialogManageAssortment.setVisible(true);
	}
	
	public ManageAssortment(ArrayList<Assortment> arrayListAssortment, boolean create, Assortment assortment, JPanel panelDBContent) {
		
		this.arrayListAssortment = arrayListAssortment;
		this.create = create;
		this.assortment = assortment;
		this.panelDBContent = panelDBContent;

		divideModel();
		initComponents();
		initListeners();

		
		
		dialogManageAssortment.setVisible(true);
	}
	
	
	private void divideModel()
	{
	
		dividedModel = assortment.toString().split(Pattern.quote(" !&#*&% "));
	}
	
	
	
	
	private void initComponents() {
		dialogManageAssortment = new JDialog();
		dialogManageAssortment.setTitle("Dodanie sprzętu");
		dialogManageAssortment.setSize(new Dimension(800, 400));
		dialogManageAssortment.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialogManageAssortment.setResizable(false);
		dialogManageAssortment.setModal(true);
		dialogManageAssortment.setLayout(null);
		
		labelAssortmentID = new JLabel("ID sprzetu:");
		labelAssortmentID.setBounds(20, 30, 180, 30);
		dialogManageAssortment.add(labelAssortmentID);
		textFieldAssortmentID = new JTextField();
		textFieldAssortmentID.setBounds(200, 30, 150, 30);
		if (!create) {
			textFieldAssortmentID.setText(dividedModel[0]);
			textFieldAssortmentID.setEnabled(false);
		}
		dialogManageAssortment.add(textFieldAssortmentID);
		
		labelModelID = new JLabel("ID modelu:");
		labelModelID.setBounds(20, 70, 180, 30);
		dialogManageAssortment.add(labelModelID);
		textFieldModelID = new JTextField();
		textFieldModelID.setBounds(200, 70, 150, 30);
		if (!create) {
			textFieldModelID.setText(dividedModel[1]);
			textFieldModelID.setEnabled(false);
		}
		dialogManageAssortment.add(textFieldModelID);
		
		labelBuyDate = new JLabel("Data zakupu:");
		labelBuyDate.setBounds(20, 110, 180, 30);
		dialogManageAssortment.add(labelBuyDate);
		textFieldBuyDate = new JTextField();
		textFieldBuyDate.setBounds(200, 110, 150, 30);
		if (!create)
			textFieldBuyDate.setText(dividedModel[2]);
		dialogManageAssortment.add(textFieldBuyDate);
		
		labelRentNumber = new JLabel("Liczba wypozyczen:");
		labelRentNumber.setBounds(20, 150, 180, 30);
		dialogManageAssortment.add(labelRentNumber);
		textFieldRentNumber = new JTextField();
		textFieldRentNumber.setBounds(200, 150, 150, 30);
		if (!create) {
			textFieldRentNumber.setText(dividedModel[3]);
			textFieldRentNumber.setEnabled(false);
		}
		dialogManageAssortment.add(textFieldRentNumber);
		
		labelLastRentDate = new JLabel("Data ostatniego wypozyczenia:");
		labelLastRentDate.setBounds(20, 190, 180, 30);
		dialogManageAssortment.add(labelLastRentDate);
		textFieldLastRentDate = new JTextField();
		textFieldLastRentDate.setBounds(200, 190, 150, 30);
		if (!create) {
			textFieldLastRentDate.setText(dividedModel[4]);
			textFieldLastRentDate.setEnabled(false);
		}
		dialogManageAssortment.add(textFieldLastRentDate);
		
		LabelAvailability = new JLabel("Dostepnosc:");
		LabelAvailability.setBounds(20, 230, 180, 30);
		dialogManageAssortment.add(LabelAvailability);
		textFieldAvailability = new JTextField();
		textFieldAvailability.setBounds(200, 230, 150, 30);
		if (!create)
			textFieldAvailability.setText(dividedModel[5]);
		dialogManageAssortment.add(textFieldAvailability);
		
		labelNumberOfMaintenance = new JLabel("Liczba konserwacji:");
		labelNumberOfMaintenance.setBounds(20, 270, 180, 30);
		dialogManageAssortment.add(labelNumberOfMaintenance);
		textFieldNumberOfMaintenance = new JTextField();
		textFieldNumberOfMaintenance.setBounds(200, 270, 150, 30);
		if (!create) {
			textFieldNumberOfMaintenance.setText(dividedModel[6]);
			textFieldNumberOfMaintenance.setEnabled(false);
		}
		dialogManageAssortment.add(textFieldNumberOfMaintenance);
		
		labelDateNextMaintenance = new JLabel("Data nastepnej konserwacji:");
		labelDateNextMaintenance.setBounds(20, 310, 180, 30);
		dialogManageAssortment.add(labelDateNextMaintenance);
		textFieldDateNextMaintenance = new JTextField();
		textFieldDateNextMaintenance.setBounds(200, 310, 150, 30);
		if (!create)
			textFieldDateNextMaintenance.setText(dividedModel[7]);
		dialogManageAssortment.add(textFieldDateNextMaintenance);
		
		labelCondition = new JLabel("Stan:");
		labelCondition.setBounds(370, 30, 150, 30);
		dialogManageAssortment.add(labelCondition);
		textFieldCondition = new JTextField();
		textFieldCondition.setBounds(500, 30, 150, 30);
		if (!create)
			textFieldCondition.setText(dividedModel[8]);
		dialogManageAssortment.add(textFieldCondition);
		
		labelInCirculation = new JLabel("W obiegu:");
		labelInCirculation.setBounds(370, 70, 150, 30);
		dialogManageAssortment.add(labelInCirculation);
		textFieldInCirculation = new JTextField();
		textFieldInCirculation.setBounds(500, 70, 150, 30);
		if (!create) {
			textFieldInCirculation.setText(dividedModel[9]);
			textFieldInCirculation.setEnabled(false);
		}
		dialogManageAssortment.add(textFieldInCirculation);
		
		labelMaintenanceNumber = new JLabel("Numer konserwacji:");
		labelMaintenanceNumber.setBounds(370, 110, 150, 30);
		dialogManageAssortment.add(labelMaintenanceNumber);
		textFieldMaintenanceNumber = new JTextField();
		textFieldMaintenanceNumber.setBounds(500, 110, 150, 30);
		if (!create) {
			textFieldMaintenanceNumber.setText(dividedModel[10]);
			textFieldMaintenanceNumber.setEnabled(false);
		}
		dialogManageAssortment.add(textFieldMaintenanceNumber);
		
		labelRepairNumber = new JLabel("Numer naprawy:");
		labelRepairNumber.setBounds(370, 150, 150, 30);
		dialogManageAssortment.add(labelRepairNumber);
		textFieldRepairNumber = new JTextField();
		textFieldRepairNumber.setBounds(500, 150, 150, 30);
		if (!create) {
			textFieldRepairNumber.setText(dividedModel[11]);
			textFieldRepairNumber.setEnabled(false);
		}
		dialogManageAssortment.add(textFieldRepairNumber);
		
		buttonCancel = new JButton("Anuluj");
		buttonCancel.setBounds(500, 310, 80, 30);
		dialogManageAssortment.add(buttonCancel);

		buttonCreateAssortment = new JButton("Utworz");
		buttonCreateAssortment.setBounds(410, 310, 80, 30);
		dialogManageAssortment.add(buttonCreateAssortment);
		
		
	}
	
private void initListeners(){
		
		
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogManageAssortment.dispose();
			}
		});
		
		buttonCreateAssortment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (create)
					createAssortment();
				else
					editAssortment();
			}

			
		});
}

private void createAssortment() {
	
		
		String assortmentID = textFieldAssortmentID.getText();			
		String modelID = textFieldModelID.getText();
		java.util.Date buyDate = null;
		try {
			buyDate = new SimpleDateFormat("dd/MM/yyyy").parse(textFieldBuyDate.getText());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		String rentNumber = textFieldRentNumber.getText();		
		java.util.Date lastRentDate = null;
		try {
			lastRentDate = new SimpleDateFormat("dd/MM/yyyy").parse(textFieldLastRentDate.getText());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		String availability  = textFieldAvailability.getText();
		String numberOfMaintenance = textFieldNumberOfMaintenance.getText();
		java.util.Date dateNextMaintenance = null;
		try {
			dateNextMaintenance = new SimpleDateFormat("dd/MM/yyyy").parse(textFieldDateNextMaintenance.getText());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		String condition = textFieldCondition.getText();
		String circulation = textFieldInCirculation.getText();
		String maintenanceNumber  = textFieldMaintenanceNumber.getText();
		String repairNumber  = textFieldRepairNumber.getText();
		
		
		if (assortmentID.equals(""))
		JOptionPane.showMessageDialog(dialogManageAssortment, "Pole ID sprzetu nie moze byc puste"); 
		else if (modelID.equals(""))
			JOptionPane.showMessageDialog(dialogManageAssortment, "Pole ID modelu nie moze byc puste");
		else if (availability.equals(""))
			JOptionPane.showMessageDialog(dialogManageAssortment, "Pole dostepnosc nie moze byc puste");
		else if (condition.equals(""))
			JOptionPane.showMessageDialog(dialogManageAssortment, "Pole stan nie moze byc puste");
		else if (buyDate == null)
			JOptionPane.showMessageDialog(dialogManageAssortment, "Wprowadz date zakupu");
	 	
		else {
			for(Assortment a : arrayListAssortment)
				if(Integer.toString(a.getItemID()).equals(assortmentID)){
					JOptionPane.showMessageDialog(dialogManageAssortment, "Sprzet o podanym ID znajduje sie juz w bazie");
					return;
				}
		}
		int modelID2 =Integer.parseInt(textFieldModelID.getText());
		int rentNumber2 =Integer.parseInt(textFieldRentNumber.getText());
		int assortmentID2 =Integer.parseInt(textFieldAssortmentID.getText());
		
		arrayListAssortment.add(new Assortment(assortmentID2,
				 buyDate, rentNumber2, lastRentDate,true, dateNextMaintenance, condition,modelID2 ));
		JOptionPane.showMessageDialog(dialogManageAssortment, "Dodano sprzet");
		dialogManageAssortment.dispose();
	}


private void editAssortment()
{
	String assortmentID = textFieldAssortmentID.getText();			
	String modelID = textFieldModelID.getText();
	String rentNumber = textFieldRentNumber.getText();
	String availability  = textFieldAvailability.getText();
	String numberOfMaintenance = textFieldNumberOfMaintenance.getText();
	String condition = textFieldCondition.getText();
	String circulation = textFieldInCirculation.getText();
	String maintenanceNumber  = textFieldMaintenanceNumber.getText();
	String repairNumber  = textFieldRepairNumber.getText();
	java.util.Date dateNextMaintenance = null;
	try {
		dateNextMaintenance = new SimpleDateFormat("dd/MM/yyyy").parse(textFieldDateNextMaintenance.getText());
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	java.util.Date lastRentDate = null;
	try {
		lastRentDate = new SimpleDateFormat("dd/MM/yyyy").parse(textFieldLastRentDate.getText());
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	java.util.Date buyDate = null;
	try {
		buyDate = new SimpleDateFormat("dd/MM/yyyy").parse(textFieldBuyDate.getText());
	} catch (Exception ex) {
		ex.printStackTrace();
	}

	if (assortmentID.equals(""))
		JOptionPane.showMessageDialog(dialogManageAssortment, "Pole ID sprzetu nie moze byc puste"); 
		else if (modelID.equals(""))
			JOptionPane.showMessageDialog(dialogManageAssortment, "Pole ID modelu nie moze byc puste");
		else if (availability.equals(""))
			JOptionPane.showMessageDialog(dialogManageAssortment, "Pole dostepnosc nie moze byc puste");
		else if (condition.equals(""))
			JOptionPane.showMessageDialog(dialogManageAssortment, "Pole stan nie moze byc puste");
		else if (buyDate == null)
			JOptionPane.showMessageDialog(dialogManageAssortment, "Wprowadz date zakupu");
	 	
	else
		try {
			
			assortment.setPucharseDate(buyDate);
			assortment.setNextMaintenanceDate(dateNextMaintenance);
			assortment.setCondition(condition);
			dialogManageAssortment.dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(dialogManageAssortment, "Pole z ceną lub kaucją zawiera błędne dane!");
		}
	
	
}


}
		
	

