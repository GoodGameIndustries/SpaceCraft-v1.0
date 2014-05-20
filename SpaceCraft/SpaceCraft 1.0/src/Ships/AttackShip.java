package Ships;
import java.awt.Color;
import java.util.ArrayList;

import Frame.Space;
import Objects.Bullet;

/**
 * 
 */

/**
 * @author Emmett Deen
 * @version 1.0
 * @date May 13, 2014
 */
public class AttackShip extends Ship{

	protected int power = 1;
	protected ArrayList<Bullet> ammoBank = new ArrayList<Bullet>();
	protected int ammoCount=500;
	protected boolean isAttack = false;
	
	
	public AttackShip(Space s,int x, int y,Color t) {
		super(s,x, y,t);
		name = "AttackShip";
		for(int i=0;i<500;i++){
			ammoBank.add(new Bullet(s,x,y));
		}
		if(ammoBank.size()>0){System.out.println("ammo left");}
		// TODO Auto-generated constructor stub
	}
	
	public AttackShip(Space s,int x, int y,int xLim,int yLim,Color t) {
		super(s,x, y,xLim,yLim,t);
		name = "AttackShip";
		for(int i=0;i<500;i++){
			ammoBank.add(new Bullet(s,x,y));
		}
		// TODO Auto-generated constructor stub
	}

	
	public Bullet fire(){
		Bullet bullet=new Bullet(space,x,y);
		bullet.setTarget(target);
		return bullet;
	}
	
	
	
	public void move(){
		if(!(target instanceof Ship)){
		super.move();
		}
		
	}
	
	public boolean getAttack(){return true;}
	
	public int ammoCount(){return ammoCount;}
	
	public void ammoUsed(){ammoBank.remove(0);ammoCount--;}
	
	public ArrayList<Bullet> getAmmoBank(){
		isAttack = true;
		return ammoBank;
		
	}
	
	public boolean fireAgain(){return recharge%10==0;}
	
	public String getInfo(){return "Name: " + name +" Health: "+health+" Speed: "+speed+" Power: " + power + " Ammo: " + ammoCount +" X: "+x+" Y: "+y;}
	
	
}
