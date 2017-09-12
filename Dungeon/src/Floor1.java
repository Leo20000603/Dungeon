import java.awt.Graphics;

public class Floor1 extends Floor{
	
	public Floor1(MainCharacter m) {
		super(1, m);
		addMonster(new Monster(40,796,44,100,100));
		addTrap(new Trap(896,145));
		addTrap(new Trap(384,72));
		addTrap(new Trap(384,216));
		addTrap(new Trap(384,360));
		addTrap(new Trap(384,504));
		addTrap(new Trap(384,638));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		taokaka.draw(g, this);
	}

	public void reset() {
		super.reset();
		addMonster(new Monster(40,796,44,100,100));
	}
}

