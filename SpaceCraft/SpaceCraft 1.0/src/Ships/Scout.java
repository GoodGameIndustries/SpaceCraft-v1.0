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
		rechargeNeeded = 10;
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
	
	public void move(){
		super.move();
		if(fleet==5 && target!=null){
			System.out.println("keep moving");
			double r=calculateDistance(target);
			if(r>10){
				x=(int) (x+(int)(target.getX()-x)*speed*10/r);
				y=(int) (y+(int)(target.getY()-y)*speed*10/r);
			}
			else{
				x=target.getX();
				y=target.getY();
			}
		}
	}

	
	
}
