package model.units;
import java.util.*;

import model.events.WorldListener;
import simulation.Address;
import simulation.Rescuable;
import simulation.Simulatable;
import model.events.*;
import model.people.Citizen;
public abstract class Unit implements Simulatable, SOSResponder {

	private String unitID;
	private UnitState state;
	private Address location;
	private Rescuable target;
	private int distanceToTarget;
	private int stepsPerCycle;
	private WorldListener worldListener;

	public Unit(String unitID, Address location, int stepsPerCycle,WorldListener w) {

		this.unitID = unitID;
		this.location = location;
		this.stepsPerCycle = stepsPerCycle;
		this.state = UnitState.IDLE;
		this.worldListener=w;

	}

	public UnitState getState() {
		return state;
	}

	public void setState(UnitState state) {
		this.state = state;
	}

	public Address getLocation() {
		return location;
	}

	public void setLocation(Address location) {
		this.location = location;
	}

	public String getUnitID() {
		return unitID;
	}

	public Rescuable getTarget() {
		return target;
	}

	public int getStepsPerCycle() {
		return stepsPerCycle;
	}
	public void setDistanceToTarget(int distanceToTarget) {
		if( distanceToTarget <= 0){
			this.distanceToTarget = 0 ;
			worldListener.assignAddress(this, this.target.getLocation().getX(), this.target.getLocation().getY());
		   
		}
		
		else
		this.distanceToTarget = distanceToTarget;
	}

	public void setWorldListener(WorldListener worldListener) {
		this.worldListener = worldListener;
	}

	public WorldListener getWorldListener() {
		return worldListener;
	}
	public  void cycleStep(){
		if(this.distanceToTarget==0){
			this.state = UnitState.TREATING ;
			this.treat();
		}	
		
		if(this.state == UnitState.RESPONDING){
				int x = this.distanceToTarget - this.stepsPerCycle ;
				this.setDistanceToTarget(x);
				if(this instanceof PoliceUnit)
					((PoliceUnit)this).setDistanceToBase(((PoliceUnit)this).getDistanceToBase()-this.stepsPerCycle);
				
				}
			

		
	}
	public void treat(){
		if(this.target!=null)
		this.target.getDisaster().setActive(false);
	}
	public void jobsDone(){
		this.target=null;
		this.setState(UnitState.IDLE);
	}
	public void respond(Rescuable r){
	   if(this instanceof MedicalUnit){
		   if(this.getState()==UnitState.RESPONDING)
				 this.getTarget().getDisaster().setActive(true);
			 else if(this.getState()==UnitState.TREATING){
				 if(((Citizen)this.getTarget()).getBloodLoss()!=0 ||((Citizen)this.getTarget()).getToxicity()!=0 )
					 this.getTarget().getDisaster().setActive(true);
			 } 
	   }
	   else {if(this.state==UnitState.RESPONDING || this.state==UnitState.TREATING){
	    	this.target.getDisaster().setActive(true);
	    }}
		this.target=r;
		this.state=UnitState.RESPONDING;
		this.setDistanceToTarget(getManhattanDistance(this.getLocation(),this.target.getLocation()));
	    
	}
	public int getManhattanDistance(Address x,Address y){
		return Math.abs(x.getX()-y.getX())+Math.abs(x.getY()-y.getY());
	}
}
