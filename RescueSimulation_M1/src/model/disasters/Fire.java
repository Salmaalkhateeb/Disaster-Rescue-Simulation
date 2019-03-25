package model.disasters;

import model.infrastructure.ResidentialBuilding;

public class Fire extends Disaster {

	public Fire(int startCycle, ResidentialBuilding target) {

		super(startCycle, target);

	}
	public void strike(){ 
		this.setActive(true);
		int x = ((ResidentialBuilding)getTarget()).getGasLevel();
		((ResidentialBuilding)getTarget()).setGasLevel(x+10);
		((ResidentialBuilding)getTarget()).struckBy(this);
		
		
		}

	public void cycleStep(){
			
			
			int z = ((ResidentialBuilding)getTarget()).getFireDamage();
			
			((ResidentialBuilding)getTarget()).setFireDamage(z+10);
		
		

		
			
	}

}
