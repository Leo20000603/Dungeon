import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.*;

public class UserInterface extends JFrame{
	
	private UserLocation location;
	private JPanel cardPanel;
		
	public UserInterface(ArrayList<Floor> floors, EndScreen es, MainScreen ms, DeathScreen ds, StatsScreen ss, InstructionsScreen is){
		super("Dungeon");
		
		location = new UserLocation();
		location.changeLocation(0);
		
		cardPanel = new JPanel();
		CardLayout cl = new CardLayout();
		cardPanel.setLayout(cl);
		
		cardPanel.add(ms,"0");
		cardPanel.add(floors.get(0),"1");
		cardPanel.add(floors.get(1),"2");
		cardPanel.add(floors.get(2),"3");
		cardPanel.add(floors.get(3),"4");
		cardPanel.add(floors.get(4),"5");
		cardPanel.add(floors.get(5),"6");
		cardPanel.add(es,"10");
		cardPanel.add(ss,"7");
		cardPanel.add(ds,"8");
		cardPanel.add(is,"9");
		add(cardPanel);
		changePanel(0);
		
		Container c = getContentPane();
	    c.setBackground(Color.WHITE);
	    setBounds(100, 100, 1024, 720);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setVisible(true);
	}
	
	public void changePanel(int x) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel, x+"");;
		requestFocus();
	}
	
	public int getFloor(){
		return location.getFloor();
	}
	
	public void setFloor(int i){
		location.changeLocation(i);
	}
}


