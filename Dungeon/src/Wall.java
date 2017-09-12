import javax.swing.ImageIcon;

public class Wall extends MovingImage{
	
	public Wall(int x, int y) {
		super((new ImageIcon("wall.png")).getImage(),x,y,128,36);
	}
}

