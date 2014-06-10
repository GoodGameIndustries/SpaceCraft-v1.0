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
public class Sniper extends AttackShip{

	
	public Sniper(Space s,int x, int y, Color t) {
		super(s,x, y,35,40, t);
		power = 10;
		speed = 4;
		health = 175;
		name = "Sniper";
		attackType=2;
		maxDistance = 2500;
	}
	
	public void paintComponent(Graphics g){
		g.setColor(new Color(0,50,0));
		g.fillOval(0,5,xLim,yLim-5);
		paintOutline(g);
		drawHealth(g);
	}
}
