package Objects;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * 
 */

/**
 * @author Emmett Deen
 * @version 1.0
 * @date May 12, 2014
 */
public class Resource extends SpaceOBJ{

	
	private int xLim;
	private int yLim;
	private int mass=0;
	
	public Resource(int x,int y, int xLim, int yLim){
		this.x = x;
		this.y = y;
		this.xLim = xLim;
		this.yLim = yLim;
		
		
		
		this.setBounds(x-xLim/2,y-yLim/2,xLim,yLim);
	}
	
	public int gather(){
		if(xLim > 0 && yLim>0){
			xLim--;
			yLim--;
			return 25;
		}
		else{
			return 0;
		}
		
		
		
	}
	
	public int getMass(){return mass;}
	
	public void move(){}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.cyan);
		g2.fillRect(0,0,xLim,yLim);
	}
	
	
	public boolean collision(SpaceOBJ obj){return false;}
	
	
	
}
