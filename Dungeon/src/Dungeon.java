import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class Dungeon implements MouseListener, KeyListener, ActionListener{
	
	private ArrayList<Floor> floors;
	private MainScreen ms;
	private InstructionsScreen is;
	private DeathScreen ds;
	private StatsScreen ss;
	private UserInterface w;
	private EndScreen es;
	private MainCharacter taokaka;
	private Timer timer;
	EasySound2 music;
	
	public Dungeon(){
		taokaka = new MainCharacter(0, 620);
		floors = new ArrayList<Floor>();
		Floor1 f1= new Floor1(taokaka);
		Floor2 f2= new Floor2(taokaka);
		Floor3 f3= new Floor3(taokaka);
		Floor4 f4= new Floor4(taokaka);
		Floor5 f5= new Floor5(taokaka);
		Floor6 f6= new Floor6(taokaka);
		floors.add(f1);
		floors.add(f2);
		floors.add(f3);
		floors.add(f4);
		floors.add(f5);
		floors.add(f6);
		ms = new MainScreen();
		is = new InstructionsScreen();
		ds = new DeathScreen();
		ss = new StatsScreen();
		es = new EndScreen();
		w = new UserInterface(floors,es,ms,ds,ss,is);
		ms.setUI(w);
		is.setUI(w);
		ds.setUI(w);
		ss.setUI(w);
		es.setUI(w);
		ms.addMouseListener(ms);
		ds.addMouseListener(ds);
		ss.addMouseListener(ss);
		is.addMouseListener(is);
		es.addMouseListener(es);
		w.addKeyListener(f1);
		w.addKeyListener(f2);
		w.addKeyListener(f3);
		w.addKeyListener(f4);
		w.addKeyListener(f5);
		w.addKeyListener(f6);
		f3.addMouseListener(f3);
		f4.addMouseListener(f4);
		f5.addMouseListener(f5);
		f1.setUI(w);
		f2.setUI(w);
		f3.setUI(w);
		f4.setUI(w);
		f5.setUI(w);
		f6.setUI(w);
		music = new EasySound2("Background Music.wav");
		music.play();
		timer = new Timer(161000, this);
		timer.start();
	}
	
	public static void main(String[] args) {
		
		
		Dungeon dungeon = new Dungeon();
	}

	public void keyPressed(KeyEvent e) {
		for(int i = 0; i < floors.size(); i++) {
			Floor aFloor = floors.get(i);
			if (Floor.taokaka.floor == aFloor.floorNum) {
			    aFloor.keyPressed(e);
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		for(int i = 0; i < floors.size(); i++) {
			Floor aFloor = floors.get(i);
			if (Floor.taokaka.floor == aFloor.floorNum) {
			    aFloor.keyReleased(e);
			}
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
		for(int i = 0; i < floors.size(); i++) {
			Floor aFloor = floors.get(i);
			if (Floor.taokaka.floor == aFloor.floorNum) {
			    aFloor.mousePressed(arg0);
			}
		}
	}

	public void mouseReleased(MouseEvent arg0) {
		for(int i = 0; i < floors.size(); i++) {
			Floor aFloor = floors.get(i);
			if (Floor.taokaka.floor == aFloor.floorNum) {
			    aFloor.mouseReleased(arg0);
			}
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		music.play();
	}
}



