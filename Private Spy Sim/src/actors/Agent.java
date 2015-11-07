/** Agent class 
 * Cole Twitchell
 * 
 * This class will represent a basic agent.
 * Agents can be owned by any faction.
 * 
 */

package actors;
import core.GameData;
import missions.*;

// a class to represent a default agent
public class Agent extends Actor {
	
	private int actionStat, charismaStat, techStat, stealthStat;
	private Actor target;
	private Weapon weapon;
	private int faction;
	
	// default constructor
	public Agent(String name) {
		super(name, null);
		actionStat = 50;
		charismaStat = 50;
		techStat = 50;
		stealthStat = 50;
	}
	
	// default + mission + faction
	public Agent(String name, Mission mission, int faction) {
		super(name, mission);
		this.faction = faction;
		actionStat = 50;
		charismaStat = 50;
		techStat = 50;
		stealthStat = 50;
	}
	
	// detailed constructor
	public Agent (String name, Mission mission, int faction, int aS, int chS, int tS, int sS) {
		super(name, mission);
		this.actionStat = aS;
		this.charismaStat = chS;
		this.techStat = tS;
		this.stealthStat = sS;
		this.faction = faction;
	}

	// getter/setter methods
	public int getAction() {return actionStat;}
	public void setAction(int newStat) {actionStat = newStat;}
	public int getCharisma() {return charismaStat;}
	public void setCharisma(int newStat) {charismaStat = newStat;}
	public int getTech() {return techStat;}
	public void setTech(int newStat) {techStat = newStat;}
	public int getStealth() {return stealthStat;}
	public void setStealth(int newStat) {stealthStat = newStat;}
	public Actor getTarget() {return target;}
	public void setTarget(Actor newTarget) {target = newTarget;}
	public Weapon getWeapon() {return weapon;}
	public void setWeapon(Weapon newWeapon) {weapon = newWeapon;}

	public void interactWith(Actor other) {
		if (((Agent)this).getTarget().equals(other)) {
			fight(other);
		}
	}
	
	public void fight(Actor other) {
		if (other instanceof Agent) {
			Agent temp = (Agent)other;
			int fightScore = 0;
			if (this.actionStat + weapon.getAction() < temp.actionStat + temp.weapon.getAction()) {
				fightScore--;
			} else if (this.actionStat + weapon.getAction() > temp.actionStat + temp.weapon.getAction()) {
				fightScore++;
			}
			if (fightScore > 0) { // this agent wins
				if (faction == Faction.PLAYER) {
					super.getMission().removeActor(temp);
				}
			} else if (fightScore < 0) { // this agent loses
				if (faction == Faction.PLAYER) {
					super.getMission().setState(-1);
				}
			}
		} else if (other instanceof AssassinationTargetActor) {
			((AssassinationTargetActor)other).actorKilled();
			super.getMission().setState(1);
		}
	}
	
}
