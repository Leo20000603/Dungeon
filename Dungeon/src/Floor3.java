import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Floor3 extends Floor {
	
	private Wall wall;
	private BlueButton blue;
	private HintCharacter hint;
	
	public Floor3(MainCharacter m) {
		super(3, m);
		addMonster(new Monster(40,128,620,100,100));
		addMonster(new Monster(40,718,72,100,100));
		addTrap(new Trap(0,432));
		addTrap(new Trap(562,504));
		addTrap(new Trap(690,504));
		addTrap(new Trap(818,504));
		addTrap(new Trap(562,576));
		addTrap(new Trap(562,648));
		addTrap(new Trap(780,110));
		addTrap(new Trap(770,38));
		wall = new Wall(896,144);
		blue = new BlueButton(807,659);
		hint = new HintCharacter(730,570);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		wall.draw(g, this);
		blue.draw(g, this);
		hint.draw(g, this);
		taokaka.draw(g, this);
	}
	
	public void keyPressed(KeyEvent arg0) {
		if (Floor.taokaka.floor == 3) {
			if (!taokaka.collideWithWall(wall)) { 
				super.keyPressed(arg0);
			} else {
				taokaka.moveByAmount(0, 16);
			}
		}	
	}
	
	public void mousePressed(MouseEvent arg0) {
		if (Floor.taokaka.floor == 3) {
			int clickX = (int)(arg0.getX()*1024.0/getWidth());
			int clickY = (int)(arg0.getY()*720.0/getHeight());
			if (blue.isPointInImage(clickX, clickY)) {
				blue.mousePressed(arg0, taokaka, wall, hint);
			}
		}
	}
	
	public void mouseReleased(MouseEvent arg0) {
		if (Floor.taokaka.floor == 3) {
			int clickX = (int)(arg0.getX()*1024.0/getWidth());
			int clickY = (int)(arg0.getY()*720.0/getHeight());
			if (blue.isPointInImage(clickX, clickY)) {
				blue.mouseReleased(arg0);
			}
		}
	}
	
	public void reset() {
		super.reset();
		addMonster(new Monster(40,128,620,100,100));
		addMonster(new Monster(40,718,72,100,100));
		wall.moveToLocation(896,144);
		hint.switchBack();
	}
}
