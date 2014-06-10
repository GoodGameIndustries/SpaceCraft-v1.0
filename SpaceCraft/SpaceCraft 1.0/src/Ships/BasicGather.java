/**
 * 
 */
package Ships;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Frame.Space;

/**
 * @author Emmett Deen
 *
 */
public class BasicGather extends GatherShip{

	public BasicGather(Space s,int x,int y,MotherShip ms,Color t){
		super(s,x,y,ms,t);
		xLim = 20;
		yLim = 20;
		speed = 1;
		name = "Basic Gather Ship";
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.white);
		g2.drawOval(0, 0, xLim, yLim);
		paintOutline(g);
	}
	
}
