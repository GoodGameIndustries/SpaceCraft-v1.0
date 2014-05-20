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
 * @date May 15, 2014
 */
public class BrickShip extends DefenseShip{

	public BrickShip(Space s,int x, int y,Color t) {
		super(s,x, y,150,150,t);
		shield = 1000;
		speed = 1;
		health = 250;
	}
	
	public String getInfo(){
		return "Name: Brick Shield: " + shield + " Health: " + health + " Speed: " + speed + " X: " + x + " Y: " + y;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.GRAY);
		g.fillRect(0,0,xLim,yLim);
		paintOutline(g);
	}

}
