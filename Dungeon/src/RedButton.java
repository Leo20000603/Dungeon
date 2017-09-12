import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class RedButton extends Button{
	
	private int count;

	public RedButton(int x, int y) {
		super((new ImageIcon("redbutton.png")).getImage(), (new ImageIcon("redbuttonlight.png")).getImage(), x, y);
		count = 0;
	}
	
	public void mousePressed(MouseEvent arg0, MainCharacter m, Wall w, HintCharacter hint) {
		super.mousePressed(arg0);
		int mCenterX = m.getX()+50;
		int mCenterY = m.getY()+50;
		int x = this.getX();
		int y = this.getY();
		if (mCenterX > x-45 && mCenterX < x+95 && mCenterY > y-60 && mCenterY < y+100) {
			if (count%2 == 1) {
				w.moveToLocation(1024, 180);
			} else {
				w.moveToLocation(896, 180);
				if (hint != null) {
					hint.switchToBad();
				}
			}
			count++;
		} 
	}
}

