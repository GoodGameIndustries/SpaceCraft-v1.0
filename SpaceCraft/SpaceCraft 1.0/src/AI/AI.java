
package AI;

import java.awt.Color;
import java.util.ArrayList;

import Frame.Space;
import Objects.SpaceOBJ;
import Ships.BasicGather;
import Ships.MotherShip;
import Ships.Ship;

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

		if(mothership.getTotalResources() > 100){
			newShip.add(new BasicGather(space,mothership.getX(),mothership.getY()+200, mothership, Color.red));
			
			mothership.setTotalResources(mothership.getTotalResources()-100);
			System.out.println(mothership.getTotalResources());

		}

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
