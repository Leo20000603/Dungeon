import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Floor4 extends Floor {
	
	private Wall wall;
	private Wall wall2;
	private BlueButton blue;
	private RedButton red;
	private HintCharacter hint;
	
	public Floor4(MainCharacter m) {
		super(4, m);
		addMonster(new Monster(40,398,110,100,100));
		addMonster(new Monster(40,498,620,100,100));
		addTrap(new Trap(0,576));
		addTrap(new Trap(128,576));
		addTrap(new Trap(256,576));
		addTrap(new Trap(384,540));
		addTrap(new Trap(785,130));
		addTrap(new Trap(270,110));
		addTrap(new Trap(498,110));
		addTrap(new Trap(780,58));
		wall = new Wall(896,144);
		wall2 = new Wall(1024,180);
		blue = new BlueButton(423,7);
		red = new RedButton(423,659);
		hint = new HintCharacter(350,570);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		wall.draw(g, this);
		blue.draw(g, this);
		red.draw(g, this);
		hint.draw(g, this);
		taokaka.draw(g, this);
		wall2.draw(g, this);
	}
	
	public void keyPressed(KeyEvent arg0) {
		if (Floor.taokaka.floor == 4) {
			if (!taokaka.collideWithWall(wall) && !taokaka.collideWithWall(wall2)) { 
				super.keyPressed(arg0);
			} else {
				taokaka.moveByAmount(0, 16);
			}
		}	
	}
	
	public void mousePressed(MouseEvent arg0) {
		if (Floor.taokaka.floor == 4) {
			int clickX = (int)(arg0.getX()*1024.0/getWidth());
			int clickY = (int)(arg0.getY()*720.0/getHeight());
			if (blue.isPointInImage(clickX, clickY)) {
				blue.mousePressed(arg0, taokaka, wall, null);
			} else if (red.isPointInImage(clickX, clickY)) {
				red.mousePressed(arg0, taokaka, wall2, hint);
			}
		}
	}
	
	public void mouseReleased(MouseEvent arg0) {
		if (Floor.taokaka.floor == 4) {
			int clickX = (int)(arg0.getX()*1024.0/getWidth());
			int clickY = (int)(arg0.getY()*720.0/getHeight());
			if (blue.isPointInImage(clickX, clickY)) {
				blue.mouseReleased(arg0);
			} else if (red.isPointInImage(clickX, clickY)) {
				red.mouseReleased(arg0);
			}
		}
	}

	public void reset() {
		super.reset();
		addMonster(new Monster(40,398,110,100,100));
		addMonster(new Monster(40,498,620,100,100));
		wall.moveToLocation(896,144);
		wall2.moveToLocation(1024,180);
		hint.switchBack();
	}
}
