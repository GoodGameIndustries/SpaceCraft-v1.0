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
public class Tank extends AttackShip{

	
	public Tank(Space s,int x, int y, Color t) {
		super(s,x, y,100,105, t);
		power = 10;
		speed = 1;
		health = 500;
		name = "Tank";
		attackType=3;
		rechargeNeeded = 50;
		maxDistance = 1500;

		ammoBank.clear();
		for(int i=0;i<50;i++){
			ammoBank.add(new Bullet(s,x+xLim+20,y+yLim+20));
		}

	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.DARK_GRAY);
		g.fillOval(0,5,xLim,yLim-5);
		paintOutline(g);
		drawHealth(g);
	}
}
