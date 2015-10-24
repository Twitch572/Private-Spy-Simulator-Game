package core;

import missions.*;

import java.util.ArrayList;

import agents.*;

/* a class to represent all of the player's current resources.
 * - money, reputation
 * - missions, agents
 */
public class PlayerStatus {

	private int money;
	private int reputation;
	private ArrayList<Mission> missions;
	private ArrayList<Agent> agents;
	
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
	public void removeMission(Mission removeMission) {
		for (Mission mission : missions) {
			int count = 0;
			if (mission.equals(removeMission)) {
				missions.remove(count);
				break;
			}
			count++;
		}
	}
	public Agent getAgent(int agentNumber) {return agents.get(agentNumber);}
	public void addAgent(Agent newAgent) {agents.add(newAgent);}
	public void removeAgent(Agent removeAgent) {
		for (Agent agent : agents) {
			int count = 0;
			if (agent.equals(removeAgent)) {
				agents.remove(count);
				break;
			}
			count++;
		}
	}
	
}
