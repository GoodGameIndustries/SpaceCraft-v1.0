package Objects;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JLabel;

import Frame.Space;

/**
 * 
 */

/**
 * @author Emmett Deen
 * @version 1.0
 * @date May 12, 2014
 */
public class SpaceOBJ extends JLabel implements KeyListener{

	protected int x, y;
	protected int xLim=50,yLim=50;
	protected int id;
	private int MASS=200;
	private ArrayList<SpaceOBJ> objects;
	private double[] vec=new double[2];
	private final double G=1;
	private SpaceOBJ target=null;
	protected Color team = Color.white;
	protected Space space;
	protected int recharge=1;
	protected boolean alive=true;
	protected int health=0;
	
	
	public SpaceOBJ(Space space){
		objects=space.allObjects();
		this.space=space;
		vec[0]=0;vec[1]=0;
		this.setBounds(x,y, xLim, yLim);
		
		
	}
	
	public SpaceOBJ(){}
	
	public void clearVec(){vec[0]=0;vec[1]=0;}
	
	public void gravityVec(){
		int count=0;
		for(SpaceOBJ obj:objects){
			if(count!=id){
			vec[0]=vec[0]+(G*MASS*obj.getMass()/getDistance(obj))*(obj.getX()-x)/300000;
			vec[1]=vec[1]+(G*MASS*obj.getMass()/getDistance(obj))*(obj.getY()-y)/300000;
			vec[0]=(vec[0]>100)?100:vec[0];
			vec[1]=(vec[1]>100)?100:vec[1];
			}
			if(vec[0]==100 || vec[1]==100){System.out.println("<"+vec[0]+","+vec[1]+">");}
			count++;
		}
	}
	
	public void move(){
		//gravityVec();
		//x=x+10*(int)vec[0];y=y+10*(int)vec[1];
		//x=x+10;y=y+10;
		checkBoundary();
	}
	
	public void move(int deltaX, int deltaY){
		
	}
	
	public void control(){}
	
	public double getDistance(SpaceOBJ obj){
		//System.out.println( Math.pow(Math.pow(obj.getX()-x,2)+Math.pow(obj.getY()-y, 2),1.5)/100000);
		return Math.pow(Math.pow(obj.getX()-x,2)+Math.pow(obj.getY()-y, 2),1.5)/100000;
	}
	
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	public void drift(){
		x+=10;y+=10;
	}
	
	public int getMass(){
		return 0;
	}
	
	public void setID(int id){
		this.id=id;
	}
	
	public int getID(){return id;}
	
	public boolean collision(SpaceOBJ obj){
		int txLim = obj.getXLim();
		int tyLim = obj.getYLim();
		int tX = obj.getX();
		int tY = obj.getY();
		
		if(((x>tX && x<(txLim+tX)) && (y<tY && y <(tyLim+tY))) || (((x+xLim)>tX && (x+xLim)<(txLim+tX)) && ((y+yLim)>tY &&(y+yLim)<(tY+tyLim)) )){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void checkBoundary(){
		x=(x<0)?0:x;
		x=(x>5000)?5000:x;
		y=(y<0)?0:y;
		y=(y>5000)?5000:y;
	}
	
	public int getXLim(){return xLim;}
	public int getYLim(){return yLim;}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

	public Color team() {
		// TODO Auto-generated method stub
		return team;
	}
	
	
	
	public boolean getAttack(){return false;}
	
	public SpaceOBJ getTarget(){return null;}
	
	public int ammoCount(){return 0;}
	
	public ArrayList<Bullet> getAmmoBank(){return null;}
	
	public void ammoUsed(){}
	
	public boolean fireAgain(){return false;}
	
	public void recharge(){recharge++;}

	public void destoryed(){alive=false;}
	
	public boolean alive(){return alive;}
	
	public void subtractHealth(){health--;}
	
	public int getHealth(){return health;}
	
	protected void paintOutline(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(1));
		g2.setColor(team);
		g2.drawRect(0, 0, xLim-1, yLim-1);
	}
}
