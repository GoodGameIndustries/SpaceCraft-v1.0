package Ships;
import java.awt.Color;
import java.awt.Graphics;

import Frame.Space;
import Objects.Bullet;

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
		super(s,x, y,25,30, t);
		power = 1;
		speed = 5;
		health = 100;
		name = "Scout";
		attackType=0;

		maxDistance = 500;

		ammoBank.clear();
		for(int i=0;i<500;i++){
			ammoBank.add(new Bullet(s,x+xLim+20,y+yLim+20));
		}

	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.fillOval(0,5,xLim,yLim-5);
		paintOutline(g);
		drawHealth(g);
	}
	

	
	
}
