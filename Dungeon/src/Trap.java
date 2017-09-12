import javax.swing.*;

public class Trap extends MovingImage{

	public Trap(int x, int y) {
		super((new ImageIcon("trap.png")).getImage(),x,y,128,72);
		toggleVisibility();
	}
	
	public boolean playerCollides(MainCharacter m) {
		if (isPointInImage(m.getX()+50,m.getY()+100)) {
			toggleVisibility();
			return true;
		} else {
			return false;
		}
	}
}

