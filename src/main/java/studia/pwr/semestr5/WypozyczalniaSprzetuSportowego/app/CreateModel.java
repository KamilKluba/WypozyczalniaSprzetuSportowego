package studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.app;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import studia.pwr.semestr5.WypozyczalniaSprzetuSportowego.database.Model;


public class CreateModel
{
	private MainWindow mainWindow;
	JDialog dialogCreateModel;
	JLabel labelModelName;
	JTextField textFieldModelName;
	JLabel labelProducer;
	JTextField textFieldProducer;
	JLabel labelEquipmentType;
	JTextField textFieldEquipmentType;
	JLabel labelSeasonOfUse;
	JTextField textFieldSeasonOfUse;
	JLabel labelPrice;
	JTextField textFieldPrice;
	JLabel labelDeposit;
	JTextField textFieldDeposit;
	JButton buttonCancel;
	JButton buttonCreateModel;
	
	public CreateModel() {
	}

	public CreateModel(MainWindow mainWindow) {
		this.mainWindow = mainWindow;

		initComponents();
		initListeners();
		
		dialogCreateModel.setVisible(true);
	}
	
	private void initComponents() {
		dialogCreateModel = new JDialog();
		dialogCreateModel.setTitle("Dodanie modelu");
		dialogCreateModel.setSize(new Dimension(450, 400));
		dialogCreateModel.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialogCreateModel.setResizable(false);
		dialogCreateModel.setModal(true);
		dialogCreateModel.setLayout(null);
		
		labelModelName = new JLabel("Nazwa modelu:");
		labelModelName.setBounds(20, 30, 180, 30);
		dialogCreateModel.add(labelModelName);
		textFieldModelName = new JTextField();
		textFieldModelName.setBounds(200, 30, 150, 30);
		dialogCreateModel.add(textFieldModelName);
		
		labelProducer = new JLabel("Producent:");
		labelProducer.setBounds(20, 70, 180, 30);
		dialogCreateModel.add(labelProducer);
		textFieldProducer = new JTextField();
		textFieldProducer.setBounds(200, 70, 150, 30);
		dialogCreateModel.add(textFieldProducer);
		

		labelEquipmentType = new JLabel("Rodzaj sprzętu:");
		labelEquipmentType.setBounds(20, 110, 180, 30);
		dialogCreateModel.add(labelEquipmentType);
		textFieldEquipmentType = new JTextField();
		textFieldEquipmentType.setBounds(200, 110, 150, 30);
		dialogCreateModel.add(textFieldEquipmentType);
		
		labelSeasonOfUse = new JLabel("Sezon uzytkowy :");
		labelSeasonOfUse.setBounds(20, 150, 180, 30);
		dialogCreateModel.add(labelSeasonOfUse);
		textFieldSeasonOfUse = new JTextField();
		textFieldSeasonOfUse.setBounds(200, 150, 150, 30);
		dialogCreateModel.add(textFieldSeasonOfUse);
		
		labelPrice = new JLabel("Cena za dzien:");
		labelPrice.setBounds(20, 190, 180, 30);
		dialogCreateModel.add(labelPrice);
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(200, 190, 150, 30);
		dialogCreateModel.add(textFieldPrice);
		
		labelDeposit = new JLabel("Kaucja za zniszczenie:");
		labelDeposit.setBounds(20, 230, 180, 30);
		dialogCreateModel.add(labelDeposit);
		textFieldDeposit = new JTextField();
		textFieldDeposit.setBounds(200, 230, 150, 30);
		dialogCreateModel.add(textFieldDeposit);
		
		buttonCancel = new JButton("Anuluj");
		buttonCancel.setBounds(260, 300, 180, 30);
		dialogCreateModel.add(buttonCancel);

		buttonCreateModel = new JButton("Utworz");
		buttonCreateModel.setBounds(20, 300, 180, 30);
		dialogCreateModel.add(buttonCreateModel);
		
		
		
		
	}
	
	
private void initListeners(){
		
		
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogCreateModel.dispose();
			}
		});
		
		buttonCreateModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String modelName = textFieldModelName.getText();
				String producer = textFieldProducer.getText();		
				String equipmentType = textFieldEquipmentType.getText();
				String seasonOfUse  = textFieldSeasonOfUse.getText();
				String price = textFieldPrice.getText();
				String deposit = textFieldDeposit.getText();
				
				
				if (modelName.equals(""))
				JOptionPane.showMessageDialog(dialogCreateModel, "Pole nazwa modelu nie moze byc puste"); 
				else if (producer.equals(""))
					JOptionPane.showMessageDialog(dialogCreateModel, "Pole producent nie moze byc puste");
				else if (equipmentType.equals(""))
					JOptionPane.showMessageDialog(dialogCreateModel, "Pole rodzaj sprzętu nie moze byc puste");
				else if (seasonOfUse.equals(""))
					JOptionPane.showMessageDialog(dialogCreateModel, "Pole sezon uzytkowy nie moze byc puste");
				else if (price == null)
					JOptionPane.showMessageDialog(dialogCreateModel, "Pole cena za dzien nie moze byc puste");
				else if (deposit == null)
					JOptionPane.showMessageDialog(dialogCreateModel, "Pole kaucja za zniszczenie nie moze byc puste");
			 	
			 	
		
				int costPerDay =Integer.parseInt(textFieldPrice.getText());
				int damageDeposit =Integer.parseInt(textFieldDeposit.getText());
				
				mainWindow.getArrayListModels().add(new Model(mainWindow.getArrayListAssortment().size() + 1,
						modelName, producer, equipmentType, true, costPerDay, damageDeposit));
				JOptionPane.showMessageDialog(dialogCreateModel, "Dodano model");
				dialogCreateModel.dispose();
				
				
				
			
				
			}
		});
	}
		
		


}
