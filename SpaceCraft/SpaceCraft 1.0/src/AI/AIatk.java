/**
 * 
 */
package AI;

import java.awt.Color;
import java.util.ArrayList;

import Frame.Space;
import Objects.SpaceOBJ;
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
	
	public void updateFleet(ArrayList<Ship> attackShips){
		fleet=attackShips;
	}
	
	public void update(Space space){
		for(SpaceOBJ obj:space.objects){
			if(obj instanceof MotherShip && obj.team()==Color.blue){
				for(Ship ship:fleet){
					ship.setTarget(obj);
				}
			}
		}
	}
	
	
}
