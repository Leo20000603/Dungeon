import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class EndScreen extends JPanel implements MouseListener, Screen{
	
	private ArrowButton buttonMain;
	private UserInterface UI;
	
	public EndScreen() {
		super();
		buttonMain = new ArrowButton(485, 580);
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
		
		Image background = (new ImageIcon("woodFloor.jpg")).getImage();
		Image taokaka = (new ImageIcon("taokakaHappy.png")).getImage();
		Image kakaElder = (new ImageIcon("KakaElder.png")).getImage();
		g.drawImage(background, 0, 0, 1024, 720, this);
		g.drawImage(taokaka, 20, 200, 380, 520, this);
		g.drawImage(kakaElder, 650, 190, 380, 525, this);
		
		Font f1 = new Font("Georgia", Font.ITALIC, 50);
		g.setFont(f1);
		g.drawString("Congrats!", 410, 60);
		g.drawString("You've passed every floor! ", 225, 115);
		g.drawString("Death Count:", 370, 240);
		String deathCount = MainCharacter.numDeaths + "";
		int numZero = 5-deathCount.length();
		for (; numZero !=0; numZero--) {
			deathCount= "0" + deathCount;
		}
		g.drawString(deathCount, 420, 300);
		g.drawString("Return ", 435,500);
		g.drawString("to main", 425, 550);
		buttonMain.draw(g2,  this);
		
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

		double ratioX = 1024.0 / width;
		double ratioY = 720.0 / height;

		int unscaledX = (int) (x * ratioX);
		int unscaledY = (int) (y * ratioY);

		if (unscaledX >= 485 && unscaledX <= 535 && unscaledY>= 580 && unscaledY <= 630) {
			buttonMain.mousePressed(arg0);
			UI.changePanel(0);
			MainCharacter.reset();
			UI.setFloor(1);
			Floor.taokaka.updateStats();
		}
		repaint();
	}

	public void mouseReleased(MouseEvent arg0) {
		int x = arg0.getX();
		int y = arg0.getY();

		int width = getWidth();
		int height = getHeight();

		double ratioX = 1024.0 / width;
		double ratioY = 720.0 / height;

		int unscaledX = (int) (x * ratioX);
		int unscaledY = (int) (y * ratioY);

		if (unscaledX >= 485 && unscaledX <= 535 && unscaledY>= 580 && unscaledY <= 630) {
			buttonMain.mouseReleased(arg0);
		}
		repaint();
	}

	public void setUI(UserInterface ui) {
		UI = ui;
	}
}


