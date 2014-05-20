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
public class BubbleShip extends DefenseShip{

	public BubbleShip(Space s,int x, int y,Color b) {
		super(s,x, y,75,75,b);
		shield = 500;
		speed = 3;
		health = 100;
		name = "Bubble";
	}
	
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.blue);
		g.fillOval(0,0,xLim,yLim);
		paintOutline(g);
	}

}
