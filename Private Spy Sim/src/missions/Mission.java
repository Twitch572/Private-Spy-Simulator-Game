package missions;

import java.util.ArrayList;

import actors.*;

public abstract class Mission {
	
	private String location;
	private int missionState;
	private MissionNode[] nodes;
	private Agent playerAgent;
	
	public Mission(int nodeCount) {
		nodes = new MissionNode[nodeCount];
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

	public int getState() {return missionState;}
	public void setState(int state) {missionState = state;}
	
}
