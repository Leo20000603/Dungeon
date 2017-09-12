import javax.swing.ImageIcon;

public class Heart extends MovingImage {

	public Heart(int x, int y) {
		super((new ImageIcon("Heart.png")).getImage(), x, y, 30, 30);
	}
}

