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

	public AssassinateMission(int nodeCount, int enemyCount, int missionValue) {
		super(nodeCount, missionValue);
		missionState = 0;
		enemies = new Agent[enemyCount];
		for (int i=0; i<enemyCount; i++) {
			enemies[i] = new Agent("Enemy #" + i, this, Faction.RUSSIA);
		}
	}
	public AssassinateMission(int nodeCount, int enemyCount, int missionValue, int reputationValue) {
		super(nodeCount, missionValue, reputationValue);
		missionState = 0;
		enemies = new Agent[enemyCount];
		for (int i=0; i<enemyCount; i++) {
			enemies[i] = new Agent("Enemy #" + i, this, Faction.RUSSIA);
		}
	}
	
	public void setAgent(Agent playerAgent) {
		super.setPlayerAgent(playerAgent);
		target = playerAgent.getTarget();
	}
	
}
