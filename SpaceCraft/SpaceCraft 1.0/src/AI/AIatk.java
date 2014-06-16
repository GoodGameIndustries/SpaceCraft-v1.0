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
		for(Ship ship:attackFleet){
		if(ship.fleet()==1){//fleet01:target motherhsip
			ship.setTarget(enemyMother);
			
		}	
		if(ship.fleet()==2){
			if(ship.getClosestEnemy()==null){
				ship.setTarget(enemyMother);
			}
			else{ship.setTarget(ship.getClosestEnemy());}
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
				if(space.ai.getMotherShip().getClosestEnemyShip()!=null){
					ship.setTarget(new Beacon(ship.getClosestEnemyDefense().getX(),ship.getClosestEnemyDefense().getY(),Color.red));
				}
				else if(needed==1){
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
			else{ship.setTarget(new Beacon(ship.getClosestEnemyDefense().getX(),ship.getClosestEnemyDefense().getY(),Color.red));}
		}
	}
			
}
			
	
	
	
	}
