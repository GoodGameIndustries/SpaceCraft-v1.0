/**
 * 
 */
package Frame;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import Ships.Ship;

/**
 * @author Emmett Deen
 *
 */
public class HealthBar extends JLabel{

	private Ship s;
	private int maxHealth;
	private int currentHealth;
	
	private int xLim;
	private int yLim;
	private int x;
	private int y;
	
	public HealthBar(Ship s){
		this.s = s;
		maxHealth = s.getHealth();
		currentHealth = s.getHealth();
		
		x = s.getX();
		y = s.getY()-15;
		xLim = s.getXLim();
		yLim = 10;
		
		this.setBounds(x,y,xLim,yLim);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		currentHealth = s.getHealth();
		if(currentHealth>maxHealth){maxHealth = currentHealth;}
		
		x=s.getX();
		y=s.getY()-15;
		
		
		g.setColor(Color.green);
		g.fillRect(0,0,(currentHealth/maxHealth)*xLim,yLim);
		this.setBounds(x,y,xLim,yLim);
		
	}
	
	
	
}
