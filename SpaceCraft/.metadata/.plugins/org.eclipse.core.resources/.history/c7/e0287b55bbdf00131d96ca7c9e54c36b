package Ships;
import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 */

/**
 * @author Emmett Deen
 * @version 1.0
 * @date May 15, 2014
 */
public class BrickShip extends DefenseShip{

	public BrickShip(int x, int y,boolean b) {
		super(x, y,150,150,b);
		shield = 1000;
		speed = 1;
		health = 250;
	}
	
	public String getInfo(){
		return "Name: Brick Shield: " + shield + " Health: " + health + " Speed: " + speed + " X: " + x + " Y: " + y;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.GRAY);
		g.fillRect(0,0,xLim,yLim);
	}

}
