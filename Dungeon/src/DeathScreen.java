import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import javax.swing.*;

public class DeathScreen extends JPanel implements MouseListener, Screen {
	
	private UserInterface UI;
	
	public DeathScreen() {
		super();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method
									// to paint the background
		int width = getWidth();
		int height = getHeight();

		double ratioX=width/640.0;
		double ratioY=height/480.0;

		Graphics2D g2 = (Graphics2D)g;
		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
		
		Image tombStone, taokaka, background, returnL, returnM;
		
		tombStone = (new ImageIcon("tombstone.png")).getImage();
		taokaka = (new ImageIcon("taoSad.png")).getImage();
		background = (new ImageIcon("NightSkyForest.jpg")).getImage();
		returnL = (new ImageIcon("returnL.png")).getImage();
		returnM = (new ImageIcon("returnM.png")).getImage();
		
		g.drawImage(background, 0, 0, 640, 480, this);		
		g.drawImage(tombStone, 5, 225, 390, 255, this);
		g.drawImage(taokaka, 85, 65, 200, 190, this);
		g.drawImage(returnL, 400, 355, 110, 125, this);
		g.drawImage(returnM, 520, 355, 110, 125, this);
		
		Font f1 = new Font("Georgia", Font.ITALIC, 20);
		g.setFont(f1);
		g.drawString("\"Curiosity killed the cat...\"", 115, 290);
		
		Font f2 = new Font("Georgia", Font.BOLD, 35);
		g.setFont(f2);
		g.drawString("Death Count:", 103, 350);
		
		String deathCount = MainCharacter.numDeaths + "";
		int numZero = 5-deathCount.length();
		for (; numZero !=0; numZero--) {
			deathCount= "0" + deathCount;
		}
		
		Font f3 = new Font("Times New Roman", Font.PLAIN, 50);
		g.setFont(f3);
		g.drawString(deathCount, 150, 440);
		
		g2.setTransform(at);
	}
	
	public void mouseClicked(MouseEvent arg0) {
	}
	
	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		int width = getWidth();
		int height = getHeight();

		double ratioX=640.0/width;
		double ratioY=480.0/height;
		
		int unscaledX = (int)(x*ratioX);
		int unscaledY = (int)(y*ratioY);
		
		if(unscaledY>=355 && unscaledY<=480) {
			if(unscaledX>=400 && unscaledX<=510) {
				UI.changePanel(UI.getFloor());
				UI.setFloor(UI.getFloor());
				Floor.taokaka.setTrueIsOnAFloor();
				repaint();
			} else if (unscaledX>=520 && unscaledX<=630) {			
				UI.changePanel(0);
				Floor.taokaka.setFalseIsOnAFloor();
			}
		}
		Floor.taokaka.revive();
		Floor.taokaka.setHP(Floor.taokaka.startingHP);
	}
	
	public void mouseReleased(MouseEvent e) {
	}

	public void setUI(UserInterface ui) {
		UI = ui;
	}
}


