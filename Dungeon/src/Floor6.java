import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Floor6 extends Floor {
	
	private HintCharacter hint;
	private Stairs fake;
	
	public Floor6(MainCharacter m) {
		super(6, m);
		for (int i = 2; i <= 6; i++) {
			addMonster(new Monster(40,128*i,166,100,100));
			addMonster(new Monster(40,128*i,404,100,100));
		}
		for (int i = 2; i <= 5; i++) {
			addTrap(new Trap(128*i,266));
		}
		addTrap(new Trap(128,194));
		addTrap(new Trap(768,194));
		addTrap(new Trap(896,194));
		addTrap(new Trap(0,432));
		addTrap(new Trap(128,432));
		addTrap(new Trap(896,432));
		addTrap(new Trap(768,648));
		addTrap(new Trap(768,576));
		addTrap(new Trap(768,504));
		hint = new HintCharacter(830,570);
		fake = new Stairs(896,576);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		fake.draw(g, this);
		hint.draw(g, this);
		taokaka.draw(g, this);
	}
	
	public void keyPressed(KeyEvent arg0) {
		if (Floor.taokaka.floor == 6) {
			super.keyPressed(arg0);
		}
	}

	public void reset() {
		super.reset();
		for (int i = 2; i <= 6; i++) {
			addMonster(new Monster(40,128*i,216,100,100));
			addMonster(new Monster(40,128*i,404,100,100));
		}
		hint.switchBack();
	}
}