import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

public class HintCharacter extends MovingImage{
	
	private Image hintPic;
	private Image badPic;
	private Image goodPic;
	private Image drawPic;
	
	public HintCharacter(int x, int y) {
		super((new ImageIcon("taokaka-face.png")).getImage(), x, y, 150, 150);
		hintPic = (new ImageIcon("taokaka-face.png")).getImage();
		drawPic = hintPic;
		badPic = (new ImageIcon("taokaka-laugh.png")).getImage();
		goodPic = (new ImageIcon("taokaka-gratz.png")).getImage();
	}

	public void draw(Graphics g, ImageObserver io) {
		g.drawImage(drawPic, getX(), getY(), getWidth(), getHeight(), io);
	}
	
	public void switchToBad() {
		drawPic = badPic;
	}
	
	public void switchToGood() {
		drawPic = goodPic;
	}
	
	public void switchBack() {
		drawPic = hintPic; 
	}
}
