import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author Emmett Deen
 * @version 1.0
 * @date May 12, 2014
 */
public class Space extends JPanel implements Runnable{

	public ArrayList<SpaceOBJ> objects = new ArrayList<SpaceOBJ>();
	public ArrayList<Ship> selected = new ArrayList<Ship>();
	private ArrayList<SpaceOBJ> toRemove=new ArrayList<SpaceOBJ>();
	private ArrayList<Bullet> stoppedBullets=new ArrayList<Bullet>();
	public ArrayList<Bullet> bullets=new ArrayList<Bullet>();
	private static int[][] vec; 
	private int x,y,xLim=5000,yLim=5000;
	private Game g;
	private int Resources=100;
	public ShipsPanel ui;
	private Dimension dim;
	private MotherShip player;
	
	public Space(Game g, Dimension dim){
		this.dim=dim;
		this.g=g;
		
		
		x=0;
		y=0;
		
		
		genBases();
		genPlanet();
		genAsteroid();
		genShips();
		
		this.setBackground(Color.black);
		this.setLayout(null);
		this.setSize(xLim,yLim);
		//objects.add(new Ship(500,500));
		this.add(ui);
		
		
		
		addObjs();
		
		this.setBounds(x,y,xLim,yLim);
		
		
	}
	
	private void genShips() {
		objects.add(new AttackShip(600,600,15,15,true));
		
	}

	private void addObjs() {
		for(int i = 0; i <objects.size(); i++){
			this.add(objects.get(i));
			objects.get(i).setID(i);
		}
	}

	private double getDistance(SpaceOBJ self, SpaceOBJ target){
		return Math.pow(Math.pow(Math.abs(self.getX()-target.getX()),2)+Math.pow(Math.abs(self.getY()-target.getY()), 2),1.5);
	}
	
	private int collide(SpaceOBJ obj){
		for(int i=0;i<objects.size();i++){
			if(obj.getID()!=i){
				if(obj.collision(objects.get(i))){System.out.println("collide");return i;}
			}
		}
		return -1;
	}
	
	
	
	
	private void genBases() {
		objects.add(new MotherShip(4500,2500,Color.red,this,false));
		
		player=new MotherShip(500,2500,Color.blue,this,true);
		objects.add(player);
		ui=new ShipsPanel(this,g,player);
		
	}
	
	private void genPlanet(){
		objects.add(new Sun(300,300));
	}

	private void genAsteroid(){
		objects.add(new Asteroid(500,500,10,10,this));
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
		this.setBounds(x,y,xLim,yLim);
		repaint();
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
		this.setBounds(x,y,xLim,yLim);
		repaint();
	}

	@Override
	public void run() {
		setY(-2500+dim.height/2);
		ui.setBounds(-x,-y+dim.height-100,ui.getWidth(),ui.getHeight());
		
		while(true){
			for(SpaceOBJ obj :objects){
				obj.move();obj.control();
				if(collide(obj)!=-1){
					toRemove.add(obj);toRemove.add(objects.get(collide(obj)));
				}
				if(obj.getAttack()){
					if(obj.getTarget()!=null && obj.getTarget().enemy()){
						if(obj.ammoCount()!=0 && obj.fireAgain()){
							Bullet bullet=obj.getAmmoBank().get(0);
							bullet.setTarget(new Beacon(obj.getTarget().x,obj.getTarget().y));bullet.setX(obj.getX()+20);bullet.setY(obj.getY()+20);
							this.add(bullet);bullets.add(bullet);
							obj.ammoUsed();
						}
					
					}
				}
				obj.recharge();
			}
			
			for(Bullet bullet:bullets){
				bullet.move();
				if(bullet.stopped()){
					stoppedBullets.add(bullet);
				}
			}
			
			
			for(int i=0;i<toRemove.size();i++){
				objects.remove(toRemove.get(i));
				this.remove(toRemove.get(i));
			}
			for(int i=0;i<stoppedBullets.size();i++){
				bullets.remove(stoppedBullets.get(i));
				this.remove(stoppedBullets.get(i));
			}
			
			int ID=ui.getSelectedShip();
				if(ID==0){
					Scout scout=new Scout(player.getX()+player.getXLim()+200,player.getY()+player.getYLim()+200,true);
					this.add(scout);objects.add(scout);scout.setID(objects.size()-1);ui.reset();
				}
				else if(ID==1){
					Destroyer destroyer=new Destroyer(player.getX()+player.getXLim()+200,player.getY()+player.getYLim()+200,true);
					objects.add(destroyer);this.add(destroyer);destroyer.setID(objects.size()-1);ui.reset();
				}
				else if(ID==2){
					Sniper sniper=new Sniper(player.getX()+player.getXLim()+200,player.getY()+player.getYLim()+200,true);
					objects.add(sniper);this.add(sniper);sniper.setID(objects.size()-1);ui.reset();
				}
				else if(ID==3){
					Tank tank=new Tank(player.getX()+player.getXLim()+200,player.getY()+player.getYLim()+200,true);
					objects.add(tank);this.add(tank);tank.setID(objects.size()-1);ui.reset();
				}
				else if(ID==4){
					BubbleShip bubble=new BubbleShip(player.getX()+player.getXLim()+200,player.getY()+player.getYLim()+200,true);
					objects.add(bubble);this.add(bubble);bubble.setID(objects.size()-1);ui.reset();
				}
				else if(ID==5){
					BrickShip brick=new BrickShip(player.getX()+player.getXLim()+200,player.getY()+player.getYLim()+200,true);
					objects.add(brick);this.add(brick);brick.setID(objects.size()-1);ui.reset();
				}
			
			
			repaint();
			ui.update();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public SpaceOBJ atSpot(int x,int y){
		//System.out.println("x: " + x + "y: " + y + " at spot");
		SpaceOBJ temp = null;
		for(SpaceOBJ obj : objects){
			if(x>obj.getX() && x<obj.getX()+obj.getXLim() && y>obj.getY() && y<obj.getY()+obj.getYLim()){
				temp = obj;
			}
		}
		
		return temp;
	}
	
	public ArrayList<SpaceOBJ> allObjects(){
		return objects;
	}
	
	public int getResources(){return Resources;}
	
	public void setResources(int resources){Resources=resources;}
	
}
