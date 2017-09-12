import java.awt.Graphics;

public class Floor2 extends Floor {
	
	public Floor2(MainCharacter m) {
		super(2, m);
		addMonster(new Monster(40,796,116,100,100));
		addMonster(new Monster(40,668,404,100,100));
		addMonster(new Monster(40,156,116,100,100));
		addTrap(new Trap(0,576));
		addTrap(new Trap(128,576));
		addTrap(new Trap(256,576));
		addTrap(new Trap(384,576));
		addTrap(new Trap(562,400));
		addTrap(new Trap(768,432));
		addTrap(new Trap(896,432));
		addTrap(new Trap(700,120));
		addTrap(new Trap(700,48));
		addTrap(new Trap(896,144));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		taokaka.draw(g, this);
	}
	
	public void reset() {
		super.reset();
		addMonster(new Monster(40,796,116,100,100));
		addMonster(new Monster(40,668,404,100,100));
		addMonster(new Monster(40,156,116,100,100));
	}
}
