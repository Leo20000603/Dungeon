import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Floor5 extends Floor {
	
	private Wall wall;
	private Wall wall2;
	private BlueButton blue;
	private RedButton red;
	private GreenButton green;
	private HintCharacter hint;
	
	public Floor5(MainCharacter m) {
		super(5, m);
		addMonster(new Monster(40,680,0,100,100));
		addMonster(new Monster(40,14,238,100,100));
		addMonster(new Monster(40,398,598,100,100));
		addTrap(new Trap(128,432));
		addTrap(new Trap(128,504));
		addTrap(new Trap(128,576));
		addTrap(new Trap(128,648));
		addTrap(new Trap(785,130));
		addTrap(new Trap(780,58));
		wall = new Wall(896,144);
		wall2 = new Wall(1024,180);
		blue = new BlueButton(295,659);
		red = new RedButton(39,371);
		green = new GreenButton(295,371);
		hint = new HintCharacter(225,271);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		wall.draw(g, this);
		wall2.draw(g, this);
		blue.draw(g, this);
		red.draw(g, this);
		green.draw(g, this);
		hint.draw(g, this);
		taokaka.draw(g, this);
	}
	
	public void keyPressed(KeyEvent arg0) {
		if (Floor.taokaka.floor == 5) {
			if (!taokaka.collideWithWall(wall) && !taokaka.collideWithWall(wall2)) { 
				super.keyPressed(arg0);
			} else {
				taokaka.moveByAmount(0, 16);
			}
		}
	}
	
	public void mousePressed(MouseEvent arg0) {
		if (Floor.taokaka.floor == 5) {
			int clickX = (int)(arg0.getX()*1024.0/getWidth());
			int clickY = (int)(arg0.getY()*720.0/getHeight());
			if (blue.isPointInImage(clickX, clickY)) {
				blue.mousePressed(arg0, taokaka, wall, null);
			} else if (red.isPointInImage(clickX, clickY)) {
				red.mousePressed(arg0, taokaka, wall2, null);
			} else if (green.isPointInImage(clickX, clickY)) {
				green.mousePressed(arg0, taokaka, this, hint);
				hint.switchToBad();
				this.updateHearts();
				repaint();
				if (taokaka.getHP()<=0) {
					taokaka.die();
					UI.changePanel(8);
					Floor.taokaka.setFalseIsOnAFloor();
					this.reset();
				}
			}	
		}
	}
	
	public void mouseReleased(MouseEvent arg0) {
		if (Floor.taokaka.floor == 5) {
			int clickX = (int)(arg0.getX()*1024.0/getWidth());
			int clickY = (int)(arg0.getY()*720.0/getHeight());
			if (blue.isPointInImage(clickX, clickY)) {
				blue.mouseReleased(arg0);
			} else if (red.isPointInImage(clickX, clickY)) {
				red.mouseReleased(arg0);
			} else if (green.isPointInImage(clickX, clickY)){
				green.mouseReleased(arg0);
			}
		}
	}

	public void reset() {
		super.reset();
		addMonster(new Monster(40,680,0,100,100));
		addMonster(new Monster(40,14,238,100,100));
		addMonster(new Monster(40,398,598,100,100));
		wall.moveToLocation(896,144);
		wall2.moveToLocation(1024,180);
		hint.switchBack();
	}
}

