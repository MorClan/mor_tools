package net.morclan.beans;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.morclan.eao.DeathsEAO;
import net.morclan.eao.KillsEAO;
import net.morclan.eao.UsersEAO;
import net.morclan.enteties.Death;
import net.morclan.enteties.Kill;
import net.morclan.utils.TownNames;

public class KillsDeathsValidation {
	private String town;
  	private String gearLevel;
  	private String distance;
  	
  	DeathsEAO dEAO;
  	KillsEAO kEAO;
  	
  	
  	
  	public KillsDeathsValidation(HttpServletRequest request, DeathsEAO EAO) {
  		this.town=(String) request.getParameter("location");
  		this.gearLevel=(String) request.getParameter("gearLevel");
  		this.distance=(String) request.getParameter("distance");
  		
  		dEAO=EAO;
  	}
  	public KillsDeathsValidation(HttpServletRequest request, KillsEAO EAO) {
  		this.town=request.getParameter("location");
  		this.gearLevel=request.getParameter("gearLevel");
  		this.distance=request.getParameter("distance");
  		
  		kEAO=EAO;
  		
  	}
  	
public boolean isAltGyldig() {
		
		return true;//isTownLegal()&&isGearLevelLegal()&&isDistanceLegal();
	}

	public boolean isTownLegal() {
		List<String> locations=Arrays.asList(TownNames.getTownNames());
		return locations.stream().anyMatch(s->s.equals(town));
	}
	public boolean isGearLevelLegal() {
		List<String> GearLevels = Arrays.asList(new String[]{"Low", "Medium", "High"});
		return GearLevels.stream().anyMatch(g->g.equals(gearLevel));
	}
	public boolean isDistanceLegal() {
		List<String> Distances = Arrays.asList(new String[]{"0-100", "100-300", "300-500","500+"});
		return Distances.stream().anyMatch(g->g.equals(distance));
	}
	
public Kill createKill() {
	Kill ny= new Kill(town,gearLevel,distance);
	return ny;
}

public Death createDeath() {
	Death ny=new Death(town,gearLevel,distance);
	return ny;
	
}
  	
}
