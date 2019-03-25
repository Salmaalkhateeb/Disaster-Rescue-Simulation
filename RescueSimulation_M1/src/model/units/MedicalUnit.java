package model.units;

import model.people.Citizen;
import simulation.Address;
import simulation.Rescuable;
import model.events.*;

public abstract class MedicalUnit extends Unit {

	private int healingAmount;
	private int treatmentAmount;

	public MedicalUnit(String unitID, Address location, int stepsPerCycle,WorldListener w) {

		super(unitID, location, stepsPerCycle,w);
		healingAmount = 10;
		treatmentAmount = 10;

	}
	public int getTreatmentAmount() {
		return treatmentAmount;
	}
   public void heal(){
	   if(((Citizen)this.getTarget()).getHp()==100)
		   this.jobsDone();
	   else
	       ((Citizen)this.getTarget()).setHp(((Citizen)this.getTarget()).getHp()+this.healingAmount);
}
 }
