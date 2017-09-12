import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Floor extends JPanel implements MouseListener, KeyListener, Screen, ActionListener{
	
	private Image background;
	private boolean goToNextLevel, goToDeathScreen;
	private Stairs endStair;
	private ArrayList<Trap> traps;
	private ArrayList<Monster> monsters;
	private ArrayList<Heart>hearts;
	public static MainCharacter taokaka;
	public UserInterface UI;  
	public int floorNum; 
	private Timer timer;
	
	public Floor(int x, MainCharacter taokaka) {
		super();
		background = (new ImageIcon("LevelBackground.jpg")).getImage();
		this.taokaka = taokaka;
		endStair = new Stairs();
		traps = new ArrayList<Trap>();
		monsters = new ArrayList<Monster>();
		hearts = new ArrayList<Heart>();
		updateHearts();
		goToNextLevel = false;
		goToDeathScreen = false;
		floorNum = x;
		timer = new Timer(1000, this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method
									// to paint the background
		int width = getWidth();
		int height = getHeight();

		double ratioX=width/1024.0;
		double ratioY=height/720.0;

		Graphics2D g2 = (Graphics2D)g;
		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
	
		g.drawImage(background, 0, 0, 1024, 720, this);
		endStair.draw(g,  this);
		updateHearts();
		for(int i = 0; i < traps.size(); i++) {
			Trap aTrap = traps.get(i);
			aTrap.draw(g, this);
		}
		for(int i = 0; i < monsters.size(); i++) {
			Monster aMonster = monsters.get(i);
			aMonster.draw(g, this);
		}
		for(int i = 0; i < hearts.size(); i++) {
			Heart aHeart = hearts.get(i);
			aHeart.draw(g, this);
		}
	}
	
	public void addTrap(Trap t) {
		traps.add(t);
	}
	
	public void addMonster(Monster m) {
		monsters.add(m);
	}
	
	public void removeMonster(Monster m) {
		monsters.remove(m);
	}
	
	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}
	
	public void keyPressed(KeyEvent e) {
		if (taokaka.isDead()==false){
			updateHearts();
			repaint();
			taokaka.keyPressed(e);
			if (Floor.taokaka.floor == floorNum) {
				if (this.checkTrapCollision()) {
					taokaka.die();
					timer.start();
					repaint();
					Floor.taokaka.setFalseIsOnAFloor();
				}else if (this.returnGoToNextLevel()){
					if (Floor.taokaka.floor == 6) {
						UI.changePanel(10);
					} else {
						UI.changePanel(7);
						StatsScreen.resetPoints();
					}
					Floor.taokaka.setFalseIsOnAFloor();
					this.reset();
				}else if (this.checkMonsterHit()) {
					taokaka.setHP(taokaka.getHP()-5);
					if (taokaka.getHP()<=0) {
						taokaka.die();
						timer.start();
						repaint();
						Floor.taokaka.setFalseIsOnAFloor();
					}
					updateHearts();
				}
			}
		}
		repaint();
	}
		
	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

	public void setUI(UserInterface ui) {
		UI = ui;
	}

	public void updateHearts() {
		hearts.clear();
		for (int i = 0; i < taokaka.getHP(); i++) {
			Heart aHeart = new Heart(30*i, 0);
			hearts.add(aHeart);
		}
	}
	
	public void reset() {
		goToNextLevel = false;
		goToDeathScreen = false;
		Image original = new ImageIcon("taokakaBouncing2.gif").getImage();
		taokaka.changeImage(original);
		taokaka.moveToLocation(0, 620);
		taokaka.revive();
		for(int i = 0; i < traps.size(); i++) {
			Trap aTrap = traps.get(i);
			if (aTrap.isVisible()) {
				aTrap.toggleVisibility();
			}
		}
		monsters.removeAll(monsters);
	}

	public void actionPerformed(ActionEvent e) {
		UI.changePanel(8);
		timer.stop();
		this.reset();
	}	
	

	private boolean returnGoToNextLevel() {
		if (endStair.isPointInImage(taokaka.getX()+50, taokaka.getY()+100)) {
			goToNextLevel=true;
		}
		return goToNextLevel;
	}
	
	private boolean returnGoToDeathScreen() {
		if (taokaka.isDead()) {
			goToDeathScreen = true; 
		}
		return goToDeathScreen;
	}
	
	private boolean checkTrapCollision() {
		if (Floor.taokaka.floor == floorNum) {
			for(int i = 0; i < traps.size(); i++) {
				Trap aTrap = traps.get(i);
				if (aTrap.playerCollides(taokaka)) {
					for (int x = 1; i <=10000; i++) {
						repaint();
					}
					return true;
				}
			}	
		}
		return false;
	}
	
	private boolean checkMonsterHit(){
		if (Floor.taokaka.floor == floorNum) {
			for(int i = 0; i < monsters.size(); i++) {
				Monster aMonster = monsters.get(i);
				if (aMonster.isPointInImage(taokaka.getX()+50, taokaka.getY()+50)) {
				    monsters.remove(aMonster);
				    return true;
				}
			}
		}
		return false;
	}	
}



