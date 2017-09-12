import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;

public class MainCharacter extends Character implements KeyListener{
	
	private Image taokakaForward, taokakaR, taokakaL, taokakaFight, taokakaDefend, taokakaDying;
	public static int numDeaths;
	public static int floor;
	public static int startingHP = 10;
	private boolean isOnAFloor;
	
	public MainCharacter(int x, int y) {
		super(startingHP, x, y, (new ImageIcon("taokakaBouncing2.gif")).getImage(), 100, 100);
		reset();
		taokakaForward = (new ImageIcon("taokakaBouncing2.gif")).getImage();
		taokakaR = (new ImageIcon("taokaka-mini.gif")).getImage();
		taokakaL = (new ImageIcon("taokaka-miniL.gif")).getImage();
		taokakaFight = (new ImageIcon("taokakaPunching.gif")).getImage();
		taokakaDefend = (new ImageIcon("taokakaBlocking.gif")).getImage();
		taokakaDying = (new ImageIcon("taokakaCollapsing.gif")).getImage();
		isOnAFloor = false;
	}
	
	public void setTrueIsOnAFloor(){
		isOnAFloor = true;
	}
	public void setFalseIsOnAFloor(){
		isOnAFloor = false;
	}

	public boolean returnOnAFloor(){
		return isOnAFloor;
	}
	
	public void updateStats() {
		setHP(startingHP);
	}
	
	public void die() {
		changeImage(taokakaDying);
		super.die();
		setHP(0);
		numDeaths++;
	}
	
	public static void reset() {
		startingHP = 10;
		numDeaths = 0;
	}
	
	public static void increaseStartingHP() {
		startingHP++;
	}
	
	public void revive() {
		super.revive();
		setHP(startingHP);
	}

	public boolean collideWithWall(Wall w) {
		if (w.isPointInImage(getX()+100, getY()) || w.isPointInImage(getX()+100, getY()+50) || w.isPointInImage(getX()+100, getY()+100)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if(isOnAFloor==true){
			int code = e.getKeyCode();
			if (code == KeyEvent.VK_D && getX() <= 1024-108) { //change this number and the rest later to fit screen
				moveRight();
			}
			if (code == KeyEvent.VK_W && getY() >= 8) {
				moveUp();
			}
			if (code == KeyEvent.VK_A && getX() >= 8) {
				moveLeft();
			}
			if (code == KeyEvent.VK_S && getY() <= 720-108) {
				moveDown();
			}
		}	
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}
	
	private void moveLeft() {
		changeImage(taokakaL);
		moveByAmount(-8, 0);
	}
	
	private void moveRight() {
		changeImage(taokakaR);
		moveByAmount(8, 0);
	}
	
	private void moveDown() {
		changeImage(taokakaForward);
		moveByAmount(0, 8);
	}

    private void moveUp() {
		changeImage(taokakaForward);
		moveByAmount(0, -8);
	}
}





