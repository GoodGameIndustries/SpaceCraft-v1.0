/**
 * 
 */
package AI;

import java.awt.Color;
import java.util.ArrayList;

import Frame.Space;
import Objects.Beacon;
import Objects.SpaceOBJ;
import Ships.AttackShip;
import Ships.MotherShip;
import Ships.Ship;

/**
 * @author Emmett Deen
 *
 */
public class AIatk {
	ArrayList<Ship> fleet=new ArrayList<Ship>();
	Space space;
	
	public AIatk(Space space){
		this.space=space;
	}
	
	
	
	public void update(Space space,ArrayList<Ship> attackFleet,int needed){
		SpaceOBJ enemyMother=null;
		for(SpaceOBJ obj:space.objects){
			if(obj instanceof MotherShip && obj.team()==Color.blue){
				enemyMother=obj;
			}
		}
		int fleet1Count=0;
		for(Ship ship:attackFleet){
		if(ship.fleet()==1){//fleet01:target motherhsip
			fleet1Count++;
			if(fleet1Count%3==1 && enemyMother!=null){
				ship.aiSudoMove(enemyMother.getX(),enemyMother.getY()+150);
			}
			else if(fleet1Count%3==2 && enemyMother!=null){
				ship.aiSudoMove(enemyMother.getX(),enemyMother.getY()-150);
			}
			else if(fleet1Count%3==0 && enemyMother!=null){
				ship.aiSudoMove(enemyMother.getX()+150,enemyMother.getY());
			}
			ship.setTarget(enemyMother);
			//if(enemyMother==null){ship.setTarget(new Beacon(space.ai.getMotherShip().getX()-200,space.ai.getMotherShip().getY(),Color.red));}
		}
		
		
		
		if(ship.fleet()==2){
			if(ship.getClosestEnemy()==null){
				ship.setTarget(enemyMother,Color.red);
				if(enemyMother==null){ship.setTarget(new Beacon(space.ai.getMotherShip().getX()-200,space.ai.getMotherShip().getY(),Color.red));}
			}
			else{
				ship.setTarget(ship.getClosestEnemy(),Color.red);
			}
		}
		if(ship.fleet()==4){
			if(needed==1){
					ship.setTarget(enemyMother);
				}
			else if(needed==2){
				if(ship.getClosestEnemy()!=null){
					ship.setTarget(enemyMother);
				}
				else{
						ship.setTarget(ship.getClosestEnemy());
					}
			}
			else if(needed==0){
				ship.setTarget(new Beacon(space.ai.getMotherShip().getX()-200,space.ai.getMotherShip().getY(),Color.red));
			}
		}
		if(ship.fleet()==5){
			if(ship.getClosestEnemyDefense()==null){
				ship.setTarget(new Beacon(space.ai.getMotherShip().getX()-200,space.ai.getMotherShip().getY(),Color.red));
		}
			else{ship.setTarget(new Beacon(ship.getClosestEnemyDefense().getX(),ship.getClosestEnemyDefense().getY(),Color.red));}
		}
	}
			
}
	
	public void killPattern(ArrayList<Ship> fleet1){
		SpaceOBJ enemyMother=null;
		for(SpaceOBJ obj:space.objects){
			if(obj instanceof MotherShip && obj.team()==Color.blue){
				enemyMother=obj;
			}
		}
		for(int i=fleet1.size()-1;i>=0;i--){
			if(i%4==0 && fleet.size()>0){
				fleet1.get(i).aiSudoMove(enemyMother.getX()-50,enemyMother.getY());
				/*if((fleet.get(i).getX()<=enemyMother.getX()-40 && fleet.get(i).getX()>=enemyMother.getX()-60) && (fleet.get(i).getY()<=enemyMother.getY()+10 && fleet.get(i).getY()>=enemyMother.getY()-10)){
					fleet.get(i).setTarget(enemyMother,Color.red);
				}*/
			}
			else if(i%4==1 && fleet.size()>0){
				fleet1.get(i).aiSudoMove(enemyMother.getX(),enemyMother.getY()-50);
				if((fleet.get(i).getX()<=enemyMother.getX()+10 && fleet.get(i).getX()>=enemyMother.getX()-10) && (fleet.get(i).getY()<=enemyMother.getY()-40 && fleet.get(i).getY()>=enemyMother.getY()-60)){
					fleet.get(i).setTarget(enemyMother,Color.red);
				}
			}
			else if(i%4==2 && fleet.size()>0){
				fleet1.get(i).aiSudoMove(enemyMother.getX()+50,enemyMother.getY());
				if((fleet.get(i).getX()<=enemyMother.getX()+60 && fleet.get(i).getX()>=enemyMother.getX()+40) && (fleet.get(i).getY()<=enemyMother.getY()+10 && fleet.get(i).getY()>=enemyMother.getY()-10)){
					fleet.get(i).setTarget(enemyMother,Color.red);
				}
			}
			else if(i%4==3  && fleet.size()>0){
				fleet1.get(i).aiSudoMove(enemyMother.getX(),enemyMother.getY()+50);
				if((fleet.get(i).getX()<=enemyMother.getX()+10 && fleet.get(i).getX()>=enemyMother.getX()-10) && (fleet.get(i).getY()<=enemyMother.getY()+60 && fleet.get(i).getY()>=enemyMother.getY()+40)){
					fleet.get(i).setTarget(enemyMother,Color.red);
				}
			}
		}
	}
			
	
	
	
	}
