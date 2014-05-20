/**
 * 
 */
package Ships;

import java.awt.Color;
import java.awt.Graphics;

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
		speed = 2;
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.drawOval(0, 0, xLim, yLim);
		paintOutline(g);
	}
	
}
