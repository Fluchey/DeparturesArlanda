import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
	private NorthPanel northPanel;
	
	public MainFrame(ArrayList<Flight> flights){
		northPanel = new NorthPanel(this, flights);
		this.add(northPanel.getNorthPanel());
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
