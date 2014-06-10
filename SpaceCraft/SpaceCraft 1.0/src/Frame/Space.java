package Frame;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import AI.AI;
import Objects.Asteroid;
import Objects.Beacon;
import Objects.Bullet;
import Objects.Resource;
import Objects.SpaceOBJ;
import Objects.Sun;
import Ships.AdvancedGather;
import Ships.BasicGather;
import Ships.BrickShip;
import Ships.BubbleShip;
import Ships.Destroyer;
import Ships.MotherShip;
import Ships.Scout;
import Ships.Ship;
import Ships.Sniper;
import Ships.Tank;

/**
 * 
 */

/**
 * @author Emmett Deen
 * @version 1.0
 * @date May 12, 2014
 */
public class Space extends JPanel implements Runnable{

	private ArrayList<SpaceOBJ> allObjects=new ArrayList<SpaceOBJ>();
	
	public ArrayList<SpaceOBJ> objects = new ArrayList<SpaceOBJ>();
	public ArrayList<Ship> selected = new ArrayList<Ship>();
	public ArrayList<Ship> AIObjects=new ArrayList<Ship>();
	private ArrayList<SpaceOBJ> toRemove=new ArrayList<SpaceOBJ>();
	public ArrayList<Resource> resources=new ArrayList<Resource>();
	private ArrayList<Bullet> stoppedBullets=new ArrayList<Bullet>();
	public ArrayList<Bullet> bullets=new ArrayList<Bullet>();
	private static int[][] vec; 
	private int x,y,xLim=5000,yLim=5000;
	public Game g;
	
	public ShipsPanel ui;
	private Dimension dim;
	public MotherShip player;
	private Color team = Color.blue;
	private AI ai;
	
	public Space(Game g, Dimension dim){
		this.dim=dim;
		this.g=g;
		
		
		x=0;
		y=0;
		
		
		genResources();
		genAI();
		genBases();
		genPlanet();
		genAsteroid();
		genShips();
		
		this.setBackground(Color.black);
		this.setLayout(null);
		this.setSize(getxLim(),getyLim());
		//objects.add(new Ship(500,500));
		this.add(ui);
		
		
		
		addObjs();
		
		this.setBounds(x,y,getxLim(),getyLim());
		
		
	}
	
	private void genResources() {
		for(int i = 0; i < 100; i++){
			resources.add(new Resource((int)(Math.random()*5000),(int)(Math.random()*5000),(int)(Math.random()*50),(int)(Math.random()*50)));
			allObjects.addAll(objects);
		}
		
	}

	private void genShips() {
		
		
	}

	private void addObjs() {
		for(int i = 0; i <objects.size(); i++){
			this.add(objects.get(i));
			objects.get(i).setID(i);
			allObjects.add(objects.get(i));
		}
		for(int i=0;i<resources.size();i++){
			this.add(resources.get(i));
		}
		/*
		for(int i = 0; i < healthBars.size();i++){
			this.add(healthBars.get(i));
		}
		*/
	}

	private SpaceOBJ collide(SpaceOBJ obj){
		for(int i=0;i<objects.size();i++){
			if(obj!=objects.get(i)){
				if(obj.collision(objects.get(i))){System.out.println("collide");return objects.get(i);}
			}
		}
		return null;
	}

	public double getDistance(SpaceOBJ self, SpaceOBJ target){
		return Math.pow(Math.pow(Math.abs(self.getX()-target.getX()),2)+Math.pow(Math.abs(self.getY()-target.getY()), 2),1.5);
	}
	
	private void shot(SpaceOBJ obj, Bullet bullet){
		if(obj.collision(bullet)){
			System.out.println("shot");
			bullet.setStopped();
			obj.subtractHealth();
		}
	}
	
	
	private void genBases() {
		//objects.add(new MotherShip(4500,2500,this,Color.red));
		//objects.add(ai.getMotherShip());
		player=new MotherShip(500,2500,this,Color.blue);
		objects.add(player);
		ui=new ShipsPanel(this,g,player);
		
	}
	
	private void genPlanet(){
		objects.add(new Sun(300,300));
	}

	private void genAsteroid(){
		objects.add(new Asteroid(500,500,10,10,this));
	}
	
	private void genAI(){
		ai=new AI(4500,2500,this);
		objects.add(ai.getMotherShip());
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
		this.setBounds(x,y,getxLim(),getyLim());
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
		this.setBounds(x,y,getxLim(),getyLim());
		repaint();
	}

	@Override
	public void run() {
		//player.setTotalRescources(resources);
		
		ui.build.repaint();
		
		setY(-2500+dim.height/2);
		ui.setBounds(-x,-y+dim.height-100,ui.getWidth(),ui.getHeight());
		
		while(true){
			ai.update(this);
			for(Ship ship:ai.getNew()){
				this.add(ship);
				objects.add(ship);
				allObjects.add(ship);
				ship.setID(objects.size()-1);
			}
			for(SpaceOBJ obj :objects){
				obj.move();obj.control();
				if(collide(obj)!=null && (obj.team()!=collide(obj).team())){
					toRemove.add(obj);toRemove.add(collide(obj));
					
				}
				for(int i=0;i<bullets.size();i++){
					shot(obj,bullets.get(i));
				}
				if(obj.getHealth()<=0){toRemove.add(obj);}
				if(obj.getAttack()){
					if(obj.getTarget()!=null && !(obj.getTarget().team().equals(obj.team()))){
						if(obj.ammoCount()!=0 && obj.fireAgain()){
							Bullet bullet=obj.getAmmoBank().get(0);
							bullet.setTarget(new Beacon(obj.getTarget().getX(),obj.getTarget().getY(),team));
							double r=getDistance(obj,obj.getTarget());
							double di=Math.pow(Math.pow(obj.getXLim(),2)+Math.pow(obj.getYLim(), 2), 0.5);
							bullet.setX((int) (obj.getX()+obj.getXLim()/2+di*(obj.getTarget().getX()+obj.getTarget().getXLim()-obj.getX()-obj.getXLim())/r));
							bullet.setY((int) (obj.getY()+obj.getYLim()/2+di*(obj.getTarget().getY()+obj.getTarget().getYLim()-obj.getY()-obj.getYLim())/r));
							this.add(bullet);bullets.add(bullet);allObjects.add(bullet);
							obj.ammoUsed();
						}
					
					}
				}
				obj.recharge();
			}
			
			ai.remove(toRemove);
			
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
					if(player.getTotalResources()>=100){
					Scout scout=new Scout(this,player.getX()+player.getXLim()+200,player.getY()+player.getYLim()+200,Color.blue);

					this.add(scout);objects.add(scout);scout.setID(objects.size()-1);allObjects.add(scout);ui.reset();

					this.add(scout);objects.add(scout);scout.setID(objects.size()-1);ui.reset();
					player.setTotalResources(player.getTotalResources()-100);
					}

				}
				else if(ID==1){
					if(player.getTotalResources()>=300){
					Destroyer destroyer=new Destroyer(this,player.getX()+player.getXLim()+200,player.getY()+player.getYLim()+200,Color.blue);

					objects.add(destroyer);this.add(destroyer);destroyer.setID(objects.size()-1);allObjects.add(destroyer);ui.reset();
				}
					player.setTotalResources(player.getTotalResources()-300);
					
				}

				else if(ID==2){
					if(player.getTotalResources()>=500){
					Sniper sniper=new Sniper(this,player.getX()+player.getXLim()+200,player.getY()+player.getYLim()+200,Color.blue);

					objects.add(sniper);this.add(sniper);sniper.setID(objects.size()-1);allObjects.add(sniper);ui.reset();
				}

					
					player.setTotalResources(player.getTotalResources()-500);
					
				}

				else if(ID==3){
					if(player.getTotalResources()>=750){
					Tank tank=new Tank(this,player.getX()+player.getXLim()+200,player.getY()+player.getYLim()+200,Color.blue);

					objects.add(tank);this.add(tank);tank.setID(objects.size()-1);allObjects.add(tank);ui.reset();
				}

					
					player.setTotalResources(player.getTotalResources()-750);
					
				}

				else if(ID==4){
					if(player.getTotalResources()>=100){
					BubbleShip bubble=new BubbleShip(this,player.getX()+player.getXLim()+200,player.getY()+player.getYLim()+200,Color.blue);

					objects.add(bubble);this.add(bubble);bubble.setID(objects.size()-1);allObjects.add(bubble);ui.reset();
				}

					
					player.setTotalResources(player.getTotalResources()-100);
					}
					

				else if(ID==5){
					if(player.getTotalResources()>=300){
					BrickShip brick=new BrickShip(this,player.getX()+player.getXLim()+200,player.getY()+player.getYLim()+200,Color.blue);

					objects.add(brick);this.add(brick);brick.setID(objects.size()-1);allObjects.add(brick);ui.reset();
				}

					
					player.setTotalResources(player.getTotalResources()-300);
					}
					

				else if(ID==6){
					if(player.getTotalResources()>=100){
					BasicGather bg=new BasicGather(this,player.getX()+player.getXLim()+200,player.getY()+player.getYLim()+200,player,Color.blue);

					objects.add(bg);this.add(bg);bg.setID(objects.size()-1);allObjects.add(bg);ui.reset();
				}

					
					player.setTotalResources(player.getTotalResources()-100);
					}
					

				else if(ID==7){
					if(player.getTotalResources()>=300){
					AdvancedGather bg=new AdvancedGather(this,player.getX()+player.getXLim()+200,player.getY()+player.getYLim()+200,player,Color.blue);
					objects.add(bg);this.add(bg);bg.setID(objects.size()-1);allObjects.add(bg);ui.reset();

					
					player.setTotalResources(player.getTotalResources()-300);
					}

				}
			
			ui.build.resourceCount.setText(""+player.getTotalResources());
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
		if(temp==null){
			for(SpaceOBJ obj2 : resources){
				if(x>obj2.getX() && x<obj2.getX()+obj2.getXLim() && y>obj2.getY() && y<obj2.getY()+obj2.getYLim()){
					temp = obj2;
				}
			}
		}
		}
		
		return temp;
	}
	
	public ArrayList<SpaceOBJ> allObjects(){
		return allObjects;
	}
	
	

	public Color getTeam() {
		// TODO Auto-generated method stub
		return team;
	}

	public int getxLim() {
		return xLim;
	}

	public void setxLim(int xLim) {
		this.xLim = xLim;
	}

	public int getyLim() {
		return yLim;
	}

	public void setyLim(int yLim) {
		this.yLim = yLim;
	}
	
}
