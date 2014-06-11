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
		super(s,x, y,20,25,b);
		this.homeShip = homeShip;
		health=50;
		resourceSelected = getClosestResource();
		target = resourceSelected;
	}

	public Resource getResourceSelected() {
		return resourceSelected;
	}

	public void setResourceSelected(SpaceOBJ temp) {
		this.resourceSelected = (Resource) temp;
	}
	
	public void move(){
		super.move();
		resourceSelected = getClosestResource();
		
		if(resourceSelected!=null&& Math.abs(x-resourceSelected.getX()) < 100 && Math.abs(y-resourceSelected.getY()) < 100 && resourcesCarrying == 0){
			resourcesCarrying = resourceSelected.gather();
			if(resourcesCarrying == 0){
				space.resources.remove(resourceSelected);
				resourceSelected = getClosestResource();
			}
		}
		else if(Math.abs(x-homeShip.getX()) < 100 && Math.abs(y-homeShip.getY()) < 100  && resourcesCarrying > 0){
			homeShip.setTotalResources(homeShip.getTotalResources()+resourcesCarrying);
			//space.player.setTotalResources(space.player.getTotalResources()+resourcesCarrying);
			resourcesCarrying = 0;
			System.out.println(space.player.getTotalResources());
			space.ui.build.resourceCount.setText(""+space.player.getTotalResources());
		}
		else if(resourcesCarrying == 0 && resourceSelected!=null){
			target = resourceSelected;
		}
		else if(resourcesCarrying == 25){
			target = homeShip;
		}
		
		
		
		
	}

	public String getInfo(){return "Name: " + name +" Resources: " + resourcesCarrying +" Health: "+health+" Speed: "+speed+" X: "+x+" Y: "+y;}
	
	
	public Resource getClosestResource(){
		Resource result = null;
		for(Resource r : space.resources){
			if(result == null){result = r;}
			else if(space.getDistance(this,r) < space.getDistance(this,result)){
				result = r;
			}
		}
		
		return result;
		
	}
}
