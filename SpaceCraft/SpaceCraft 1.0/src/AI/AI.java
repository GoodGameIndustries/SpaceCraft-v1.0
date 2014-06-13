
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
	protected AIatk attackAi;
	protected AIdef defenseAi;
	protected int enemyScout=0;protected int enemyDestroyer=0;protected int enemySniper=0;protected int enemyTank=0;
	protected int enemyBrick=0;protected int enemyBubble=0;
	protected int aiScout=0;protected int aiDestroyer=0;protected int aiSniper=0;protected int aiTank=0;
	protected int aiBrick=0;protected int aiBubble=0;
	protected boolean needGather=false;
	protected ArrayList<Ship> attackFleet=new ArrayList<Ship>();
	
	private int select = -1; //0=gather,1=attack,2=defense
	
	public AI(int x, int y, Space space){
		mothership=new MotherShip(x,y,space,Color.red);
		attackAi=new AIatk(space);
		defenseAi=new AIdef(space);
		newShip.add(new BasicGather(space, mothership.getX()-200, mothership.getY(), mothership, Color.red));
		mothership.setTotalResources(mothership.getTotalResources()-100);
	}
	
	public MotherShip getMotherShip(){return mothership;}
	
	public void update(Space space){
		enemyAttack=0;enemyDefense=0;enemyGather=0;
		aiAttack=0;aiDefense=0;aiGather=0;
		
		for(SpaceOBJ enemy:enemyFleet){
			if(enemy instanceof AttackShip){
				enemyAttack++;
				if(enemy instanceof Scout){enemyScout++;}
				else if(enemy instanceof Destroyer){enemyDestroyer++;}
				else if(enemy instanceof Sniper){enemySniper++;}
				else if(enemy instanceof Tank){enemyTank++;}
			}
			else if(enemy instanceof DefenseShip){
				enemyDefense++;
				if(enemy instanceof BrickShip){enemyBrick++;}
				else if(enemy instanceof BubbleShip){enemyBubble++;}
				}
			else if(enemy instanceof GatherShip){enemyGather++;}
		}
		for(Ship ship:fleet){
			if(ship instanceof AttackShip){
				aiAttack++;
				if(ship instanceof Scout){aiScout++;}
				else if(ship instanceof Destroyer){aiDestroyer++;}
				else if(ship instanceof Sniper){aiSniper++;}
				else if(ship instanceof Tank){aiTank++;}
				}
			else if(ship instanceof DefenseShip){
				aiDefense++;
				if(ship instanceof BrickShip){aiBrick++;}
				else if(ship instanceof BubbleShip){aiBubble++;}
				}
			else if(ship instanceof GatherShip){aiGather++;}
		}
		int[] order=new int[7];
		int difScout=(enemyScout+1-aiScout>0)?enemyScout+1-aiScout:0;order[0]=difScout;
		int difDestroyer=(enemyDestroyer+1-aiDestroyer>0)?enemyDestroyer+1-aiDestroyer:0;order[1]=difDestroyer;
		int difSniper=(enemySniper+1-aiSniper>0)?enemySniper+1-aiSniper:0;order[2]=difSniper;
		int difTank=(enemyTank+1-aiTank>0)?enemyTank+1-aiTank:0;order[3]=difTank;
		int difBrick=(enemyBrick+1-aiBrick>0)?enemyBrick+1-aiBrick:0;order[4]=difBrick;
		int difBubble=(enemyBubble+1-aiBubble>0)?enemyBubble+1-aiBubble:0;order[5]=difBubble;
		int difGather=(enemyGather+1-aiGather>0)?enemyGather+1-aiGather:0;order[6]=difGather;
		int pri=0;
		for(int i=0;i<order.length-1;i++){
			if(order[i]<order[i+1]){
				pri=i+1;
			}
		}
		if(order[pri]==0 || pri==6 || needGather){
			select=0;
			if(aiGather*75>mothership.getTotalResources()){
				System.out.println("enough gather");
				select=-1;
				needGather=false;}
			}
		else if(pri==0 && !needGather){select=1;}
		else if(pri==1 && !needGather){select=2;}
		else if(pri==2 && !needGather){select=3;}
		else if(pri==3 && !needGather){select=4;}
		else if(pri==4 && !needGather){select=5;}
		else if(pri==5 && !needGather){select=6;}
		
		if(order[pri]==0){
			if(aiBrick<9){select=5;}
		}
		makeShip(select,space);
		attackAi.updateFleet(attackFleet);
		attackAi.update(space);
		System.out.println("mother: "+mothership.getTotalResources());
		
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
			if(destroyed instanceof AttackShip){
				attackFleet.remove(destroyed);
			}
		}
	}
	
	private int[] sort(int[] array){
		int key=0;
		for(int i=1;i<array.length;i++){
			key=array[i];
			for(int j=i-1;(j>=0)&&(array[j]<key);j--){
				array[j+1]=array[j];
				array[j+1]=key;
			}
		}
		return array;
	}
	
	private void makeShip(int select,Space space){
		switch(select){
		case 0:
			/*if(mothership.getTotalResources()>300){
				newShip.add(new AdvancedGather(space, mothership.getX()-200, mothership.getY(), mothership, Color.red));
				mothership.setTotalResources(mothership.getTotalResources()-300);
				needGather=false;
			}*/
			if(mothership.getTotalResources()>100){
				newShip.add(new BasicGather(space, mothership.getX()-200, mothership.getY(), mothership, Color.red));
				mothership.setTotalResources(mothership.getTotalResources()-100);
				needGather=false;
			}
			break;
		case 4:
			if(mothership.getTotalResources()>750){
				Tank tank=new Tank(space, mothership.getX()-200, mothership.getY(), Color.red);
				newShip.add(tank);attackFleet.add(tank);
				mothership.setTotalResources(mothership.getTotalResources()-750);
			}
			else
				needGather=true;
			break;
		case 3:
			if(mothership.getTotalResources()>500){
				Sniper sniper=new Sniper(space, mothership.getX()-200, mothership.getY(), Color.red);
				newShip.add(sniper);attackFleet.add(sniper);
				mothership.setTotalResources(mothership.getTotalResources()-500);
			}
			else
				needGather=true;
			break;
		case 2:
			if(mothership.getTotalResources()>300){
				Destroyer destroyer=new Destroyer(space, mothership.getX()-200, mothership.getY(), Color.red);
				newShip.add(destroyer);attackFleet.add(destroyer);
				mothership.setTotalResources(mothership.getTotalResources()-300);
			}
			else
				needGather=true;
			break;
		case 1:
			if(mothership.getTotalResources()>100){
				Scout scout=new Scout(space, mothership.getX()-200, mothership.getY(), Color.red);
				newShip.add(scout);attackFleet.add(scout);
				mothership.setTotalResources(mothership.getTotalResources()-100);
			}
			else
				needGather=true;
			break;
		case 5:
			if(mothership.getTotalResources()>300){
				newShip.add(new BrickShip(space, mothership.getX()-200, mothership.getY(), Color.red));
				mothership.setTotalResources(mothership.getTotalResources()-300);
			}
			else
				needGather=true;
			break;
		case 6:
			if(mothership.getTotalResources()>100){
				newShip.add(new BubbleShip(space, mothership.getX()-200, mothership.getY(), Color.red));
				mothership.setTotalResources(mothership.getTotalResources()-100);
			}
			else
				needGather=true;
			break;
			
		}
	}
	

}





