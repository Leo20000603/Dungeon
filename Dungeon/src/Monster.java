import java.awt.Image;
import javax.swing.ImageIcon;

public class Monster extends Character{
	
	private Image grimReaper;

	public Monster(int hp, int x, int y, int width, int height) {
		super(hp, x, y, (new ImageIcon("grim-reaperRight.png")).getImage(), width, height);
		grimReaper = (new ImageIcon("grim-reaperRight.png")).getImage();
	}

	public void die(){
		this.toggleVisibility();
	}	
}

