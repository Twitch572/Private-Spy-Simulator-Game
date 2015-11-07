package core;

import missions.*;

import java.util.ArrayList;

import actors.*;

/* a class to represent all of the player's current resources.
 * - money, reputation
 * - missions, agents
 */
public class PlayerStatus {

	private int money;
	private int reputation;
	private ArrayList<Mission> missions;
	private ArrayList<Agent> agents;
	private int timeOfDay;
	
	public PlayerStatus() {
		missions = new ArrayList<Mission>();
		agents = new ArrayList<Agent>();
	}
	
	// getter/setter methods
	public int getMoney() {return money;}
	public void addMoney(int amount) {money += amount;}
	public int getReputation() {return reputation;}
	public void addReputation(int amount) {reputation += amount;}
	public Mission getMission(int missionNumber) {return missions.get(missionNumber);}
	public void addMission(Mission newMission) {missions.add(newMission);}
	public void removeMission(Mission removeMission) {missions.remove(removeMission);}
	public Agent getAgent(int agentNumber) {return agents.get(agentNumber);}
	public void addAgent(Agent newAgent) {agents.add(newAgent);}
	public void removeAgent(Agent removeAgent) {agents.remove(removeAgent);}
	
	public void update() {
		for (Mission mission : missions) {
			mission.update();
			if (mission.getState() == 1) { // checks if mission has been completed
				addMoney(mission.getMissionValue());
				addReputation(mission.getReputationValue());
				removeMission(mission);
			}
			else if (mission.getState() == -1) { // checks if mission has been failed
				addMoney(-mission.getMissionValue()/10);
				addReputation(-mission.getReputationValue());
				removeMission(mission);
			}
		}
	}
	
}
