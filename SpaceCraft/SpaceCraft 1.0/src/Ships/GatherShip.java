package Ships;
import java.awt.Color;

import Frame.Space;
import Objects.Resource;
import Objects.SpaceOBJ;

/**
 * 
 */

/**
 * @author Emmett Deen
 * @version 1.0
 * @date May 15, 2014
 */
public class GatherShip extends Ship{

	private Resource resourceSelected;
	private MotherShip homeShip;
	private int resourcesCarrying = 0;
	private int lastX = 0;
	private int lastY = 0;
	
	public GatherShip(Space s,int x, int y, MotherShip homeShip,Color b) {
		super(s,x, y,20,20,b);
		this.homeShip = homeShip;
	}

	public Resource getResourceSelected() {
		return resourceSelected;
	}

	public void setResourceSelected(SpaceOBJ temp) {
		this.resourceSelected = (Resource) temp;
	}
	
	public void move(){
		super.move();
		
		if(resourceSelected!=null&&lastX == x && lastY == y && resourcesCarrying == 0){
			resourcesCarrying = resourceSelected.gather();
		}
		else if(lastX == x && lastY == y && resourcesCarrying > 0){
			homeShip.setTotalRescources(homeShip.getTotalRescources()+resourcesCarrying);
			resourcesCarrying = 0;
		}
		else if(resourcesCarrying == 0 && resourceSelected!=null){
			target = resourceSelected;
		}
		else if(resourcesCarrying == 25){
			target = homeShip;
		}
		
		
		
		
	}

}
