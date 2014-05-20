package Objects;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import Frame.Space;

/**
 * 
 */

/**
 * @author Emmett Deen
 * @version 1.0
 * @date May 12, 2014
 */
public class Asteroid extends SpaceOBJ{

	private int rescources = 5000;
	private int xLim;
	private int yLim;
	private ArrayList<SpaceOBJ> objects;
	private final int MASS=10;
	
	
	public Asteroid(int x,int y, int xLim, int yLim,Space space){
		super(space);
		objects=space.allObjects();
		this.x = x;
		this.y = y;
		this.xLim = xLim;
		this.yLim = yLim;
		this.setBounds(x+xLim/2,y+yLim/2,xLim,yLim);
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.red);
		g2.fillOval(0,0,xLim,yLim);
	}
	
	public int getMass(){return MASS;}
	
}
