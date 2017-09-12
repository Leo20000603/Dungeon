import javax.swing.ImageIcon;

public class PlusButton extends Button{

	public PlusButton(int x, int y) {
		super((new ImageIcon("plusbutton.png")).getImage(), (new ImageIcon("plusbuttonlight.png")).getImage(), x, y);
	}
}

