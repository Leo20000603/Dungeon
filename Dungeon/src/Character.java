import java.awt.Image;

public abstract class Character extends MovingImage{
	
	private int hp;
	private boolean isDead;
	
	public Character (int hp, int x, int y, Image image, int width, int height){
		super(image, x, y, width, height);
		this.hp = hp;
        isDead = false;	
	}
		
	public int getHP () {
		return hp;
	}
	
	public void setHP(int x){
		hp = x;
	}
	
	public void die() {
		isDead = true;
	}

	public boolean isDead() {
		return isDead;
	}
	
	public void revive() {
		isDead = false;
	}
}


	

