/**
 * 
 */
package Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;

import Objects.SpaceOBJ;

/**
 * @author Emmett Deen
 *
 */
public class MiniMap extends JLabel{
	
	private Space space;
	private int width = 100;
	private int height = 100;
	private int divX = 0;
	private int divY = 0;
	private Dimension dim;
	
	public MiniMap(Space s,Dimension dim){
		space = s;
		this.dim = dim;
		this.setSize(99,99);
		divX = (space.getxLim()/width);
		divY = (space.getyLim()/height);
				
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		
		//following method works but is very laggy
		/*
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
		*/
		
		for(SpaceOBJ obj :space.objects){
			g.setColor(obj.team());
			g.fillRect(obj.getX()/divX, obj.getY()/divY, obj.getXLim()/divX, obj.getYLim()/divY);
		}
		for(SpaceOBJ obj :space.resources){
			g.setColor(Color.cyan);
			g.fillRect(obj.getX()/divX, obj.getY()/divY, obj.getXLim()/divX, obj.getYLim()/divY);
		}
		
		g.setColor(Color.white);
		g.drawRect((-space.getX())/divX, (-space.getY())/divY, dim.width/divX, dim.height/divY);
		
	}

}
