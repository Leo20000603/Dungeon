import javax.swing.ImageIcon;

public class ArrowButton extends Button{

	public ArrowButton(int x, int y) {
		super((new ImageIcon("arrow button.png")).getImage(), (new ImageIcon("arrow button light.png")).getImage(), x, y);
	}
}

