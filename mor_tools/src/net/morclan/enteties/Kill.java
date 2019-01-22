package net.morclan.enteties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="kdratio",name="kills")
public class Kill {
  	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int killID;
  	
  	private String town;
  	private String gearLevel;
  	private String distance; 
  	
  	public Kill() {
  		this.town="";
  		this.gearLevel="";
  		this.distance="";
  	}
  	
  	public Kill(String town,String gearLevel, String distance) {
  		this.town=town;
  		this.gearLevel=gearLevel;
  		this.distance=distance;
  	}

	public int getKillID() {
		return killID;
	}

	public void setKillID(int killID) {
		this.killID = killID;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getGearLevel() {
		return gearLevel;
	}

	public void setGearLevel(String gearLevel) {
		this.gearLevel = gearLevel;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}
  	
  	
}