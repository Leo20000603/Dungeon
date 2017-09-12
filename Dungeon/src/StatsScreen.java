import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class StatsScreen extends JPanel implements MouseListener, Screen{

	private static int points;
	private PlusButton button3; 
	private ArrowButton buttonNext;
	private UserInterface UI;
	
	public StatsScreen() {
		super();
		button3 = new PlusButton(460, 279);
		buttonNext = new ArrowButton(460, 360);
		points =  1;
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
		
		Image background = (new ImageIcon("basement-stairs.jpg")).getImage();
		g.drawImage(background, 0, 0, 1024, 720, this);		
		Image taokaka = (new ImageIcon("taokakaSwinging.gif")).getImage();
		g.drawImage(taokaka, 620, 350, 360, 360, this);	
		
		g.setColor(Color.WHITE);
		Font f1 = new Font("Monospaced", Font.BOLD, 35);
		g.setFont(f1);
		g.drawString("Character Stats ", 100, 100);
		g.drawString("Points: " + points, 100, 140);
		g.drawString("Think you're good enough?", 100, 210);
		g.drawString("Don't change your stats!", 100, 250);
		g.drawString("Health(HP):    " + MainCharacter.startingHP, 100, 320);
		button3.draw(g, this);
		g.drawString("Continue to" , 100, 380);
		g.drawString("the next level..." , 100, 410);
		buttonNext.draw(g, this);

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

		double ratioX=1024.0/width;
		double ratioY=720.0/height;
		
		int unscaledX = (int)(x*ratioX);
		int unscaledY = (int)(y*ratioY);
		
		if (unscaledX>=460 && unscaledX<=510 && unscaledY>=279 && unscaledY<=329) {
			button3.mousePressed(arg0);
			if (points>0) {
				MainCharacter.increaseStartingHP();
				Floor.taokaka.updateStats();
				points--;
			}
		}
	
		if (unscaledY>=360 && unscaledY<=410) {
			buttonNext.mousePressed(arg0);
			if(UI.getFloor()+1<=6){
				UI.setFloor(UI.getFloor()+1);
				UI.changePanel(UI.getFloor());
				Floor.taokaka.floor = UI.getFloor();
				Floor.taokaka.setTrueIsOnAFloor();
			}else{
				UI.setFloor(1);
				UI.changePanel(10);
				Floor.taokaka.floor=0;
				Floor.taokaka.setFalseIsOnAFloor();
			}	
		} 
		repaint();
	}

	public void mouseReleased(MouseEvent arg0) {
		int x = arg0.getX();
		int y = arg0.getY();

		int width = getWidth();
		int height = getHeight();

		double ratioX=1024.0/width;
		double ratioY=720.0/height;
		
		int unscaledX = (int)(x*ratioX);
		int unscaledY = (int)(y*ratioY);
		
		if (unscaledX>=460 && unscaledX<=510 && unscaledY>=279 && unscaledY<=329) {
			button3.mouseReleased(arg0);
		}
			
		if (unscaledY>=360 && unscaledY<=410) {
			buttonNext.mouseReleased(arg0);
		}
		repaint();
	}

	public void setUI(UserInterface ui) {
		UI = ui;
	}

	public static void resetPoints() {
		points = 1;
	}
}



