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
		yLim = 20;
		speed = 4;
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.yellow);
		g2.drawOval(0, 0, xLim, yLim);
		paintOutline(g);
	}
	
	

}