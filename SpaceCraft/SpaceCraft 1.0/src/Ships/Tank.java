package Ships;
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
public class Tank extends AttackShip{

	
	public Tank(int x, int y, boolean player) {
		super(x, y,100,100, player);
		power = 10;
		speed = 1;
		health = 500;
		name = "Tank";
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.DARK_GRAY);
		g.fillOval(0,0,100,100);
	}
}
