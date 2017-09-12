import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class InstructionsScreen extends JPanel implements MouseListener, Screen {
	
	private UserInterface UI;
	
	public InstructionsScreen() {
		super();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method
									// to paint the background
		int width = getWidth();
		int height = getHeight();

		double ratioX=width/1024.0;
		double ratioY=height/720.0;

		Graphics2D g2 = (Graphics2D)g;
		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
		
		Image instructions = (new ImageIcon("instructions.png")).getImage();
		g.drawImage(instructions, 0, 0, 1024, 720, this);
		Image taokaka = (new ImageIcon("taokakaSwinging.gif")).getImage();
		g.drawImage(taokaka, 620, 95, 100, 100, this);
		Image stair = (new ImageIcon("flatstairs.png")).getImage();
		g.drawImage(stair, 800, 170, 100, 100, this);
		BlueButton blue = new BlueButton(610, 325);
		blue.draw(g, this);
		Image trap = (new ImageIcon("trap.png")).getImage();
		g.drawImage(trap, 730, 380, 138, 72, this);
		Image monster = (new ImageIcon("grim-reaperRight.png")).getImage();
		g.drawImage(monster, 640, 535, 100, 100, this);
		Image heart = (new ImageIcon("heart.png")).getImage();
		g.drawImage(heart, 760, 535, 25, 25, this);
		Image returnM = (new ImageIcon("returnM.png")).getImage();
		g.drawImage(returnM, 880, 595, 130, 145, this);
		
		g2.setTransform(at);
	}
	
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		int width = getWidth();
		int height = getHeight();

		double ratioX=1024.0/width;
		double ratioY=720.0/height;
		
		int unscaledX = (int)(x*ratioX);
		int unscaledY = (int)(y*ratioY);
		
		if(unscaledX>=900 && unscaledX<=1010 && unscaledY>=615 && unscaledY<=740) {
			UI.changePanel(0);
			Floor.taokaka.setFalseIsOnAFloor();
		}	
	}
	
	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void setUI(UserInterface ui) {
		UI = ui;
	}
}



