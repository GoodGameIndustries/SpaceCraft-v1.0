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
public class AdvancedGather extends GatherShip{

	public AdvancedGather(Space s, int x, int y, MotherShip homeShip, Color b) {
		super(s, x, y, homeShip, b);
		xLim = 20;
		yLim = 25;
		speed = 2;
		name = "Advanced Gather Ship";
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.yellow);
		g2.drawOval(0, 5, xLim, yLim-5);
		paintOutline(g);
		drawHealth(g);
	}
	
	

}
