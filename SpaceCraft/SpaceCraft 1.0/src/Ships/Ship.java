package Ships;
 import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Frame.Space;
import Objects.SpaceOBJ;

/**
 * 
 */

/**
 * @author Emmett Deen
 * @version 1.0
 * @date May 13, 2014
 */
public class Ship extends SpaceOBJ{

	protected SpaceOBJ target;
	protected int speed = 1;
	//protected int health = 1;
	protected String name = "Ship";
	
	public Ship(Space s,int x, int y, Color team){
		this.x =x;
		this.y =y;
		xLim =10;
		yLim = 10;
		this.team=team;
		this.setBounds(x,y,xLim,yLim);
		health=1;
	}
	public Ship(Space s,int x, int y,int length, int width,Color team){
		this.x =x;
		this.y =y;
		space = s;
		xLim = length;
		yLim = width;
		this.team=team;
		this.setBounds(x,y,length,width);
		health=1;
	}
	
	public void setTarget(SpaceOBJ t){
		target = t;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.white);
		g2.fillOval(0,0,xLim,yLim);
	}
	
	public void move(){
		if(target != null && (team.equals(space.getTeam())||team.equals(Color.white))){
			calculateMove(target);
		}
	}
	
	protected double calculateDistance(SpaceOBJ target){
		return Math.pow(Math.pow(target.getX()-x,2)+Math.pow(target.getY()-y,2),0.5);
	}
	
	protected void calculateMove(SpaceOBJ t) {
		double r=calculateDistance(t);
		if(r>100){
			x=(int) (x+(int)(t.getX()-x)*speed*10/r);
			y=(int) (y+(int)(t.getY()-y)*speed*10/r);
		}
		//System.out.println("<"+x+","+y+">");
	}
	
	public SpaceOBJ getTarget(){return target;}
	
	public String getInfo(){return "Name: " + name +" Health: "+health+" Speed: "+speed+" X: "+x+" Y: "+y;}
	
}
