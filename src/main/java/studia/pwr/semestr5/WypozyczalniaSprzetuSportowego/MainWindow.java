package studia.pwr.semestr5.WypozyczalniaSprzetuSportowego;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MainWindow{
	private JFrame mainFrame;
	
	public MainWindow(){
		initComponents();
	}
	
	private void initComponents(){
		mainFrame = new JFrame("Wypozyczalnia sprzetu sportowego");
		mainFrame.setSize(new Dimension(1280,720));
		mainFrame.setResizable(false);		
		mainFrame.setVisible(true);
	}
	
}
