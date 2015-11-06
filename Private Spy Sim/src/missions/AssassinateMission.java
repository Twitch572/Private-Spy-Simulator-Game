package missions;

import java.util.ArrayList;

import actors.*;

public class AssassinateMission extends Mission {
	
	private Actor target;
	private Agent[] enemies;
	
	private int missionState;
	
	private class MissionNode {
		public ArrayList<Actor> actors;
		private MissionNode() {
			
		}
		public void calculateActorInteractions() {
			int count = 1;
			for (Actor actor : actors) {
				while (count < actors.size()) {
					actor.interactWith(actors.get(count));
				}
				count++;
			}
		}
		public void addActor(Actor actor) {actors.add(actor);}
		public void removeActor(Actor actor) {actors.remove(actors.indexOf(actor));}
	}

	public AssassinateMission(int nodeCount, int enemyCount) {
		super(nodeCount);
		enemies = new Agent[enemyCount];
	}
	
}
