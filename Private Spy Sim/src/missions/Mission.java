package missions;

import java.util.ArrayList;

import actors.*;

public abstract class Mission {
	
	private String location;
	private int missionState;
	private MissionNode[] nodes;
	private final int playerStart = 0;
	private Agent playerAgent;
	public int missionValue;
	public int reputationValue;
	
	public Mission(int nodeCount, int missionValue) {
		nodes = new MissionNode[nodeCount];
		reputationValue = 50;
	}
	public Mission(int nodeCount, int missionValue, int reputationValue) {
		nodes = new MissionNode[nodeCount];
		this.reputationValue = reputationValue;
	}
	
	private class MissionNode {
		public ArrayList<Actor> actors;
		private MissionNode() {
			
		}
		public void calculateActorInteractions() {
			int count = 0;
			for (Actor actor : actors) {
				actor.interactWith(actors.get(count));
			}
		}
		public void addActor(Actor actor) {actors.add(actor);}
		public void removeActor(Actor actor) {actors.remove(actors.indexOf(actor));}
	}
	
	public void update() {
		for (MissionNode node : nodes) {
			node.calculateActorInteractions();
		}
	}

	public Agent getPlayerAgent() {return playerAgent;}
	public void setPlayerAgent(Agent agent) {
		playerAgent = agent;
		nodes[playerStart].addActor(agent);
	}
	public int getState() {return missionState;}
	public void setState(int state) {missionState = state;}
	public int getMissionValue() {return missionValue;}
	public int getReputationValue() {return reputationValue;}
	public void removeActor(Actor actor) {
		for (MissionNode node : nodes) {
			node.removeActor(actor);
		}
	}
	
}
