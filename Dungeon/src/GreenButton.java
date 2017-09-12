import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class GreenButton extends Button{

	public GreenButton(int x, int y) {
		super((new ImageIcon("greenbutton.png")).getImage(), (new ImageIcon("greenbuttonlight.png")).getImage(), x, y);
	}
	
	public void mousePressed(MouseEvent e, MainCharacter m, Floor f, HintCharacter hint) {
		super.mousePressed(e);
		int mCenterX = m.getX()+50;
		int mCenterY = m.getY()+50;
		int x = this.getX();
		int y = this.getY();
		if (mCenterX > x-45 && mCenterX < x+95 && mCenterY > y-60 && mCenterY < y+100) {
			f.taokaka.setHP(Floor.taokaka.getHP()-3);
			if (hint != null) {
				hint.switchToBad();
			}
		}
	}
}
