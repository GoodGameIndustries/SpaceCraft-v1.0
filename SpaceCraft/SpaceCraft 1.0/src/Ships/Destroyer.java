package Ships;
import java.awt.Color;
import java.awt.Graphics;

import Frame.Space;

/**
 * 
 */

/**
 * @author Emmett Deen
 * @version 1.0
 * @date May 17, 2014
 */
public class Destroyer extends AttackShip{

	
	public Destroyer(Space s,int x, int y, Color t) {
		super(s,x, y,50,55, t);
		power = 5;
		speed = 3;
		health = 250;
		name = "Destroyer";
		attackType=1;
		maxDistance = 1000;
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.orange);
		g.fillOval(0,5,xLim,yLim-5);
		paintOutline(g);
		drawHealth(g);
	}
}
