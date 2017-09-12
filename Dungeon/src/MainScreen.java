import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import javax.swing.*;

public class MainScreen extends JPanel implements MouseListener,Screen {

	private UserInterface UI;
	
	public MainScreen() {
		super();
	}
	
	public void setUI(UserInterface ui){
		UI = ui;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method
									// to paint the background
		int width = getWidth();
		int height = getHeight();

		double ratioX=width/1240.0;
		double ratioY=height/720.0;

		Graphics2D g2 = (Graphics2D)g;
		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
	
		Image background = (new ImageIcon("Start.jpg")).getImage();
		g.drawImage(background, 0, 0, 1240, 720, this);
		
		Image taokakaRunning = (new ImageIcon("taokakaBreathing2.gif")).getImage();
		g.drawImage(taokakaRunning, 0, 0, 1190, 735, this);
		
		Image crossroadBase = (new ImageIcon("crossroadsBase.png")).getImage();
		g.drawImage(crossroadBase, 804, 130, 430, 605, this);
		Image bottomSign = (new ImageIcon("crossroadsBottom.png")).getImage();
		g.drawImage(bottomSign, 835, 433, 203, 166, this);
		Image leftSign = (new ImageIcon("crossroadsLeft.png")).getImage();
		g.drawImage(leftSign, 872, 238, 181, 157, this);
		Image rightSign = (new ImageIcon("crossroadsRight.png")).getImage();
		g.drawImage(rightSign, 1057, 231, 177, 132, this);
		Image rightBottomSign = (new ImageIcon("crossroadsR.png")).getImage();
		g.drawImage(rightBottomSign, 1050, 410, 178, 112, this);
		
		g2.setTransform(at);
	}

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
		int x = arg0.getX();
		int y = arg0.getY();
		int width = getWidth();
		int height = getHeight();

		double ratioX=1240.0/width;
		double ratioY=720.0/height;
		
		int unscaledX = (int)(x*ratioX);
		int unscaledY = (int)(y*ratioY);
		
		if(unscaledX>=835 && unscaledX<=1038 && unscaledY>=433 && unscaledY<=599) {
			UI.changePanel(9);
			Floor.taokaka.setFalseIsOnAFloor();
		} else if (unscaledX>=872 && unscaledX<=1053 && unscaledY>=238 && unscaledY<=395) {				
			MainCharacter.reset();
			UI.changePanel(1);
			UI.setFloor(1);
			Floor.taokaka.setTrueIsOnAFloor();
			Floor.taokaka.floor = 1;
		} else if (unscaledX>=1057 && unscaledX<=1234 && unscaledY>=231 && unscaledY<=363) {			
			UI.changePanel(8);
			Floor.taokaka.setFalseIsOnAFloor();
		} else if (unscaledX>=1050 && unscaledX<=1228 && unscaledY>=410 && unscaledY<=522) {
			UI.changePanel(UI.getFloor());
			UI.setFloor(UI.getFloor());
			Floor.taokaka.setTrueIsOnAFloor();
			Floor.taokaka.floor = UI.getFloor();
		}
	}

	public void mouseReleased(MouseEvent arg0) {
	}
}


