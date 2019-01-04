package studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.app;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Address;
import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Assortment;
import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Client;
import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Person;

public class CreateAssortment {
	private MainWindow mainWindow;
	JDialog dialogCreateAssortment;
	
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
	
	public CreateAssortment() {
	}

	public CreateAssortment(MainWindow mainWindow) {
		this.mainWindow = mainWindow;

		initComponents();
		initListeners();
		
		dialogCreateAssortment.setVisible(true);
	}
	
	
	
	
	
	private void initComponents() {
		dialogCreateAssortment = new JDialog();
		dialogCreateAssortment.setTitle("Dodanie sprzętu");
		dialogCreateAssortment.setSize(new Dimension(800, 400));
		dialogCreateAssortment.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialogCreateAssortment.setResizable(false);
		dialogCreateAssortment.setModal(true);
		dialogCreateAssortment.setLayout(null);
		
		labelAssortmentID = new JLabel("ID sprzetu:");
		labelAssortmentID.setBounds(20, 30, 180, 30);
		dialogCreateAssortment.add(labelAssortmentID);
		textFieldAssortmentID = new JTextField();
		textFieldAssortmentID.setBounds(200, 30, 150, 30);
		dialogCreateAssortment.add(textFieldAssortmentID);
		
		labelModelID = new JLabel("ID modelu:");
		labelModelID.setBounds(20, 70, 180, 30);
		dialogCreateAssortment.add(labelModelID);
		textFieldModelID = new JTextField();
		textFieldModelID.setBounds(200, 70, 150, 30);
		dialogCreateAssortment.add(textFieldModelID);
		
		labelBuyDate = new JLabel("Data zakupu:");
		labelBuyDate.setBounds(20, 110, 180, 30);
		dialogCreateAssortment.add(labelBuyDate);
		textFieldBuyDate = new JTextField();
		textFieldBuyDate.setBounds(200, 110, 150, 30);
		dialogCreateAssortment.add(textFieldBuyDate);
		
		labelRentNumber = new JLabel("Liczba wypozyczen:");
		labelRentNumber.setBounds(20, 150, 180, 30);
		dialogCreateAssortment.add(labelRentNumber);
		textFieldRentNumber = new JTextField();
		textFieldRentNumber.setBounds(200, 150, 150, 30);
		dialogCreateAssortment.add(textFieldRentNumber);
		
		labelLastRentDate = new JLabel("Data ostatniego wypozyczenia:");
		labelLastRentDate.setBounds(20, 190, 180, 30);
		dialogCreateAssortment.add(labelLastRentDate);
		textFieldLastRentDate = new JTextField();
		textFieldLastRentDate.setBounds(200, 190, 150, 30);
		dialogCreateAssortment.add(textFieldLastRentDate);
		
		LabelAvailability = new JLabel("Dostepnosc:");
		LabelAvailability.setBounds(20, 230, 180, 30);
		dialogCreateAssortment.add(LabelAvailability);
		textFieldAvailability = new JTextField();
		textFieldAvailability.setBounds(200, 230, 150, 30);
		dialogCreateAssortment.add(textFieldAvailability);
		
		labelNumberOfMaintenance = new JLabel("Liczba konserwacji:");
		labelNumberOfMaintenance.setBounds(20, 270, 180, 30);
		dialogCreateAssortment.add(labelNumberOfMaintenance);
		textFieldNumberOfMaintenance = new JTextField();
		textFieldNumberOfMaintenance.setBounds(200, 270, 150, 30);
		dialogCreateAssortment.add(textFieldNumberOfMaintenance);
		
		labelDateNextMaintenance = new JLabel("Data nastepnej konserwacji:");
		labelDateNextMaintenance.setBounds(20, 310, 180, 30);
		dialogCreateAssortment.add(labelDateNextMaintenance);
		textFieldDateNextMaintenance = new JTextField();
		textFieldDateNextMaintenance.setBounds(200, 310, 150, 30);
		dialogCreateAssortment.add(textFieldDateNextMaintenance);
		
		labelCondition = new JLabel("Stan:");
		labelCondition.setBounds(370, 30, 150, 30);
		dialogCreateAssortment.add(labelCondition);
		textFieldCondition = new JTextField();
		textFieldCondition.setBounds(500, 30, 150, 30);
		dialogCreateAssortment.add(textFieldCondition);
		
		labelInCirculation = new JLabel("W obiegu:");
		labelInCirculation.setBounds(370, 70, 150, 30);
		dialogCreateAssortment.add(labelInCirculation);
		textFieldInCirculation = new JTextField();
		textFieldInCirculation.setBounds(500, 70, 150, 30);
		dialogCreateAssortment.add(textFieldInCirculation);
		
		labelMaintenanceNumber = new JLabel("Numer konserwacji:");
		labelMaintenanceNumber.setBounds(370, 110, 150, 30);
		dialogCreateAssortment.add(labelMaintenanceNumber);
		textFieldMaintenanceNumber = new JTextField();
		textFieldMaintenanceNumber.setBounds(500, 110, 150, 30);
		dialogCreateAssortment.add(textFieldMaintenanceNumber);
		
		labelRepairNumber = new JLabel("Numer naprawy:");
		labelRepairNumber.setBounds(370, 150, 150, 30);
		dialogCreateAssortment.add(labelRepairNumber);
		textFieldRepairNumber = new JTextField();
		textFieldRepairNumber.setBounds(500, 150, 150, 30);
		dialogCreateAssortment.add(textFieldRepairNumber);
		
		buttonCancel = new JButton("Anuluj");
		buttonCancel.setBounds(500, 310, 80, 30);
		dialogCreateAssortment.add(buttonCancel);

		buttonCreateAssortment = new JButton("Utworz");
		buttonCreateAssortment.setBounds(410, 310, 80, 30);
		dialogCreateAssortment.add(buttonCreateAssortment);
		
		
	}
	
private void initListeners(){
		
		
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogCreateAssortment.dispose();
			}
		});
		
		buttonCreateAssortment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
				JOptionPane.showMessageDialog(dialogCreateAssortment, "Pole ID sprzetu nie moze byc puste"); 
				else if (modelID.equals(""))
					JOptionPane.showMessageDialog(dialogCreateAssortment, "Pole ID modelu nie moze byc puste");
				else if (availability.equals(""))
					JOptionPane.showMessageDialog(dialogCreateAssortment, "Pole dostepnosc nie moze byc puste");
				else if (condition.equals(""))
					JOptionPane.showMessageDialog(dialogCreateAssortment, "Pole stan nie moze byc puste");
				else if (buyDate == null)
					JOptionPane.showMessageDialog(dialogCreateAssortment, "Wprowadz date zakupu");
			 	
				else {
					for(Assortment a : mainWindow.getArrayListAssortment())
						if(Integer.toString(a.getItemID()).equals(assortmentID)){
							JOptionPane.showMessageDialog(dialogCreateAssortment, "Sprzet o podanym ID znajduje sie juz w bazie");
							return;
						}
				}
				int modelID2 =Integer.parseInt(textFieldModelID.getText());
				int rentNumber2 =Integer.parseInt(textFieldRentNumber.getText());
				int assortmentID2 =Integer.parseInt(textFieldAssortmentID.getText());
				
				mainWindow.getArrayListAssortment().add(new Assortment(assortmentID2,
						 buyDate, rentNumber2, lastRentDate,true, dateNextMaintenance, condition,modelID2 ));
				JOptionPane.showMessageDialog(dialogCreateAssortment, "Dodano sprzet");
				dialogCreateAssortment.dispose();
							
			}
		});
	}
	
}
