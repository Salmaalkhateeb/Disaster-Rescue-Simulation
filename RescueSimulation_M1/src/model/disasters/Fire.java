package model.disasters;

import model.infrastructure.ResidentialBuilding;

public class Fire extends Disaster {

	public Fire(int startCycle, ResidentialBuilding target) {

		super(startCycle, target);

	}
	public void strike(){ 
		super.strike();
		int x = ((ResidentialBuilding)getTarget()).getFireDamage();
		((ResidentialBuilding)getTarget()).setFireDamage(x+10);
		//((ResidentialBuilding)getTarget()).struckBy(this);
		
		
		
		}

	public void cycleStep(){
			
			
			int z = ((ResidentialBuilding)getTarget()).getFireDamage();
			
			((ResidentialBuilding)getTarget()).setFireDamage(z+10);
		
		

		
			
	}
}
