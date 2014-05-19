import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 */

/**
 * @author Emmett Deen
 * @version 1.0
 * @date May 17, 2014
 */
public class Destroyer extends AttackShip{

	
	public Destroyer(int x, int y, boolean player) {
		super(x, y,50,50, player);
		power = 5;
		speed = 3;
		health = 250;
		name = "Destroyer";
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.orange);
		g.fillOval(0,0,50,50);
	}
}
