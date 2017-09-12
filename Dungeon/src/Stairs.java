import javax.swing.ImageIcon;

public class Stairs extends MovingImage{

	public Stairs() {
		super((new ImageIcon("flatstairs.png")).getImage(),896,0,128,144);
	}
	
	public Stairs(int x, int y) {
		super((new ImageIcon("flatstairs.png")).getImage(),x,y,128,144);
	}
}

