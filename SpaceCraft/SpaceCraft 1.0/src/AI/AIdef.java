/**
 * 
 */
package AI;

import java.awt.Color;
import java.util.ArrayList;

import Frame.Space;
import Objects.Beacon;
import Ships.DefenseShip;
import Ships.Ship;

/**
 * @author Emmett Deen
 *
 */
public class AIdef {
	private Space space;
	private ArrayList<Ship> fleet;
	private ArrayList<Ship> def = new ArrayList<Ship>();
	
	
	public AIdef(Space space){
		this.space = space;
		this.fleet = space.ai.getFleet();
	}
	
	public void update(Space space){
		this.fleet = space.ai.getFleet();
		makeDef();
		if(def.size()>0){
			def.get(0).setTarget(space.ai.getMotherShip());
			if(def.size()>1){
				def.get(1).setTarget(new Beacon(def.get(0).getX()-def.get(1).getXLim(),def.get(0).getY(),Color.red));
				
				if(def.size()>2){
					def.get(2).setTarget(new Beacon(def.get(0).getX(),def.get(0).getY()-def.get(2).getY(),Color.red));
					
					if(def.size()>3){
						def.get(3).setTarget(new Beacon(def.get(0).getX(),def.get(0).getY()+def.get(3).getY(),Color.red));
						
						if(def.size()>4){
							def.get(4).setTarget(new Beacon(def.get(0).getX()+def.get(4).getXLim(),def.get(0).getY(),Color.red));
							
							if(def.size()>5){
								def.get(5).setTarget(new Beacon(def.get(0).getX()-def.get(5).getXLim(),def.get(0).getY()-def.get(5).getY(),Color.red));
								
								if(def.size()>6){
									def.get(6).setTarget(new Beacon(def.get(0).getX()+def.get(6).getXLim(),def.get(0).getY()-def.get(6).getY(),Color.red));
									
									if(def.size()>7){
										def.get(7).setTarget(new Beacon(def.get(0).getX()-def.get(7).getXLim(),def.get(0).getY()+def.get(7).getY(),Color.red));
										
										if(def.size()>8){
											def.get(8).setTarget(new Beacon(def.get(0).getX()+def.get(8).getXLim(),def.get(0).getY()+def.get(8).getY(),Color.red));

										}
									}
								}
							}
						}
					}
				}
			
			}
			else{
			
			}
			def.clear();
		}
	}

	private void makeDef() {
		//def.clear();
		for(int i = 0; i < fleet.size(); i++){
			if(fleet.get(i) instanceof DefenseShip){
				def.add(fleet.get(i));
			}
		}
	}
	
	
	
}
