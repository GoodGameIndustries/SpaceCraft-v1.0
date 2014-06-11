
package AI;

import java.awt.Color;
import java.util.ArrayList;

import Frame.Space;
import Objects.SpaceOBJ;
import Ships.AdvancedGather;
import Ships.AttackShip;
import Ships.BasicGather;
import Ships.BrickShip;
import Ships.BubbleShip;
import Ships.DefenseShip;
import Ships.Destroyer;
import Ships.GatherShip;
import Ships.MotherShip;
import Ships.Scout;
import Ships.Ship;
import Ships.Sniper;
import Ships.Tank;

public class AI {
	protected MotherShip mothership;
	protected ArrayList<Ship> fleet=new ArrayList<Ship>();
	protected ArrayList<Ship> toRemove=new ArrayList<Ship>();
	protected ArrayList<Ship> newShip=new ArrayList<Ship>();
	protected ArrayList<SpaceOBJ> enemyFleet=new ArrayList<SpaceOBJ>();
	protected int enemyAttack=0;protected int enemyDefense=0;protected int enemyGather=0;
	protected int aiAttack=0;protected int aiDefense=0;protected int aiGather=0;
	
	private int select = -1; //0=gather,1=attack,2=defense
	
	public AI(int x, int y, Space space){
		mothership=new MotherShip(x,y,space,Color.red);
	}
	
	public MotherShip getMotherShip(){return mothership;}
	
	public void update(Space space){
		enemyAttack=0;enemyDefense=0;enemyGather=0;
		aiAttack=0;aiDefense=0;aiGather=0;
		for(SpaceOBJ enemy:enemyFleet){
			if(enemy instanceof AttackShip){enemyAttack++;}
			else if(enemy instanceof DefenseShip){enemyDefense++;}
			else if(enemy instanceof GatherShip){enemyGather++;}
		}
		for(Ship ship:fleet){
			if(ship instanceof AttackShip){aiAttack++;}
			else if(ship instanceof DefenseShip){aiDefense++;}
			else if(ship instanceof GatherShip){aiGather++;}
		}
		int difAttack=enemyAttack-aiAttack;int difDefense=enemyDefense-aiDefense;int difGather=enemyGather-aiGather;
		System.out.println("enemy attack: "+enemyAttack+" enemy defense: "+enemyDefense+" enemy gather: "+enemyGather);
		difAttack=(difAttack>0)?difAttack:0;difGather=(difGather>0)?difGather:0;difDefense=(difDefense>0)?difDefense:0;
		if(Math.max(Math.max(difAttack, difGather),Math.max(difDefense,difGather))==difGather){
			select=0;
		}
		else if(Math.max(Math.max(difAttack, difGather),Math.max(difDefense,difGather))==difAttack){
			select=1;
		}
		else if(Math.max(Math.max(difAttack, difGather),Math.max(difDefense,difGather))==difDefense){
			select=2;
		}
		
		switch(select){
		case 0:
			if(mothership.getTotalResources()>300){
				newShip.add(new AdvancedGather(space, mothership.getX()-200, mothership.getY(), mothership, Color.red));
				mothership.setTotalResources(mothership.getTotalResources()-300);
			}
			else if(mothership.getTotalResources()>100){
				newShip.add(new BasicGather(space, mothership.getX()-200, mothership.getY(), mothership, Color.red));
				mothership.setTotalResources(mothership.getTotalResources()-100);
			}
			break;
		case 1:
			if(mothership.getTotalResources()>750){
				newShip.add(new Tank(space, mothership.getX()-200, mothership.getY(), Color.red));
				mothership.setTotalResources(mothership.getTotalResources()-750);
			}
			else if(mothership.getTotalResources()>500){
				newShip.add(new Sniper(space, mothership.getX()-200, mothership.getY(), Color.red));
				mothership.setTotalResources(mothership.getTotalResources()-500);
			}
			else if(mothership.getTotalResources()>300){
				newShip.add(new Destroyer(space, mothership.getX()-200, mothership.getY(), Color.red));
				mothership.setTotalResources(mothership.getTotalResources()-300);
			}
			else if(mothership.getTotalResources()>100){
				newShip.add(new Scout(space, mothership.getX()-200, mothership.getY(), Color.red));
				mothership.setTotalResources(mothership.getTotalResources()-100);
			}
			break;
		case 2:
			if(mothership.getTotalResources()>300){
				newShip.add(new BrickShip(space, mothership.getX()-200, mothership.getY(), Color.red));
				mothership.setTotalResources(mothership.getTotalResources()-300);
			}
			else if(mothership.getTotalResources()>100){
				newShip.add(new BubbleShip(space, mothership.getX()-200, mothership.getY(), Color.red));
				mothership.setTotalResources(mothership.getTotalResources()-100);
			}
			break;
		}
		
	}
	
	public ArrayList<Ship> getFleet(){
		return fleet;
	}
	
	public ArrayList<Ship> getNew(){
		return newShip;
	}
	
	public void updatePlayerFleet(ArrayList<SpaceOBJ> playerFleet){
		enemyFleet=playerFleet;
	}
	
	public void remove(ArrayList<SpaceOBJ> remove){
		fleet.addAll(newShip);
		newShip.clear();
		for(SpaceOBJ obj:remove){
			if(obj instanceof Ship && obj.team().equals(Color.red)){
				toRemove.add((Ship)obj);
			}
		}
		for(Ship destroyed:toRemove){
			fleet.remove(destroyed);
		}
	}
	
}
