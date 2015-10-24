package actors;

import missions.Mission;

public abstract class Actor {

	private String name;
	private Mission mission;
	
	public Actor(String name, Mission mission) {
		this.name = name;
		this.mission = mission;
	}

	public String getName() {return name;}
	public Mission getMission() {return mission;}
	public void setMission(Mission newMission) {mission = newMission;}
	
}
