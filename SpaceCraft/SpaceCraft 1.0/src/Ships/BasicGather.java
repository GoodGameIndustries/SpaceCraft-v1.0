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
		yLim = 25;
		speed = 1;
		name = "Basic Gather Ship";
	}
	
	public BasicGather(Space s,int x,int y,MotherShip ms,Color t,int fleet){
		super(s,x,y,ms,t);
		xLim = 20;
		yLim = 25;
		speed = 1;
		name = "Basic Gather Ship";
		this.fleet=fleet;
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.white);
		g2.drawOval(0, 5, xLim, yLim-5);
		paintOutline(g);
		drawHealth(g);
	}
	
}
