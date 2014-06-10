/**
 * 
 */
package Frame;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Objects.Resource;

/**
 * @author Emmett Deen
 *
 */
public class MiniMap extends JLabel{
	
	private Space space;
	private int width = 100;
	private int height = 100;
	
	public MiniMap(Space s){
		space = s;
		this.setSize(99,99);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		
		for(int i = 0; i < space.getxLim(); i+=(space.getxLim()/width)){
			
			for(int j = 0; j < space.getyLim(); j+=(space.getyLim()/height)){
				
				if(space.atSpot(i, j) != null){
					if(space.atSpot(i,j) instanceof Resource){
						g.setColor(Color.cyan);
					}
					else{
					g.setColor(space.atSpot(i, j).team());
					}
					g.drawLine(i/(space.getxLim()/width), j/(space.getyLim()/height),i/(space.getxLim()/width), j/(space.getyLim()/height));
				}
				
			}
			
		}
	}

}
