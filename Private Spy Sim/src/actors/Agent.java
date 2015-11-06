/** Agent class 
 * Cole Twitchell
 * 
 * This class will represent a basic agent.
 * Agents can be owned by any faction.
 * 
 */

package actors;
import missions.*;

// a class to represent a default agent
public class Agent extends Actor {
	
	private int actionStat, charismaStat, techStat, stealthStat;
	private Actor target;
	
	// default constructor
	public Agent(String name) {
		super(name, null);
		actionStat = 50;
		charismaStat = 50;
		techStat = 50;
		stealthStat = 50;
	}
	
	// default + mission
	public Agent(String name, Mission mission) {
		super(name, mission);
		actionStat = 50;
		charismaStat = 50;
		techStat = 50;
		stealthStat = 50;
	}
	
	// detailed constructor
	public Agent (String name, Mission mission, int aS, int chS, int tS, int sS) {
		super(name, mission);
		this.actionStat = aS;
		this.charismaStat = chS;
		this.techStat = tS;
		this.stealthStat = sS;
	}

	// getter/setter methods
	public int getCombat() {return actionStat;}
	public void setCombat(int newStat) {actionStat = newStat;}
	public int getCharisma() {return charismaStat;}
	public void setCharisma(int newStat) {charismaStat = newStat;}
	public int getTech() {return techStat;}
	public void setTech(int newStat) {techStat = newStat;}
	public int getStealth() {return stealthStat;}
	public void setStealth(int newStat) {stealthStat = newStat;}
	public Actor getTarget() {return target;}
	public void setTarget(Actor newTarget) {target = newTarget;}
	
}
