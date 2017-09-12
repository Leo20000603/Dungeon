import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class BlueButton extends Button{

	public BlueButton(int x, int y) {
		super((new ImageIcon("bluebutton.png")).getImage(), (new ImageIcon("bluebuttonlight.png")).getImage(), x, y);
	}

	public void mousePressed(MouseEvent arg0, MainCharacter m, Wall first, HintCharacter hint) {
		super.mousePressed(arg0);
		int mCenterX = m.getX()+50;
		int mCenterY = m.getY()+50;
		int x = this.getX();
		int y = this.getY();
		if (mCenterX > x-45 && mCenterX < x+95 && mCenterY > y-60 && mCenterY < y+100) {
			first.moveToLocation(1024, 144);
			if (hint != null) {
				hint.switchToGood();
			}
		}
	}
		
}

