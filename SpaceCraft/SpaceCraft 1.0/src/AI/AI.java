
package AI;

import java.awt.Color;
import java.util.ArrayList;

import Frame.*;
import Objects.SpaceOBJ;
import Ships.*;

public class AI {
	protected MotherShip mothership;
	protected ArrayList<Ship> fleet=new ArrayList<Ship>();
	protected ArrayList<Ship> toRemove=new ArrayList<Ship>();
	protected ArrayList<Ship> newShip=new ArrayList<Ship>();
	
	public AI(int x, int y, Space space){
		mothership=new MotherShip(x,y,space,Color.red);
	}
	
	public MotherShip getMotherShip(){return mothership;}
	
	public void update(Space space){
		//newShip.add(new Scout(space,mothership.getX(),mothership.getY()+200,Color.red));
	}
	
	public ArrayList<Ship> getFleet(){
		return fleet;
	}
	
	public ArrayList<Ship> getNew(){
		return newShip;
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
