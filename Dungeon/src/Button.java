import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.ImageObserver;

public class Button extends MovingImage implements MouseListener{
	
	private Image button, buttonSwitch;

	public Button(Image img, Image img2, int x, int y) {
		super(img,x,y,50,50);
		button = img;
		buttonSwitch = img2;
	}

	public void draw(Graphics g, ImageObserver io) {
		g.drawImage(button, getX(), getY(), getWidth(), getHeight(), io);
	}
	
	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}
       
	public void mouseExited(MouseEvent arg0) {	
	}
        
	public void mousePressed(MouseEvent arg0) {
		switchButton(); //button turns light
	    //and action happens specific to button color
   	}    
	
	public void mouseReleased(MouseEvent arg0) {
		switchButton(); //button turns back
	}
	
	private void switchButton() {
		Image img1 = button;
		Image img2 = buttonSwitch;
		button = img2;
		buttonSwitch = img1;
	}
}


