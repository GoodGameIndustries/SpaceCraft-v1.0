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
public class Scout extends AttackShip{

	
	public Scout(Space s,int x, int y, Color t) {
		super(s,x, y,25,25, t);
		power = 1;
		speed = 5;
		health = 100;
		name = "Scout";
		attackType=0;
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.fillOval(0,0,25,25);
		paintOutline(g);
	}
	

	
	
}
