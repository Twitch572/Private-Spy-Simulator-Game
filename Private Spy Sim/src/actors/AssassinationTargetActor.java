package actors;

import missions.*;

public class AssassinationTargetActor extends Actor {

	public AssassinationTargetActor(String name, AssassinateMission mission) {
		super(name, mission);
	}

	public void interactWith(Actor actor) {
		if (actor instanceof Agent) {
			if (((Agent)actor).getTarget().equals(this)) {
				actorKilled();
			}
		}
	}
	
	public void actorKilled() {
		super.getMission().removeActor(this);
		((AssassinateMission)super.getMission()).setState(1);
	}
	
}