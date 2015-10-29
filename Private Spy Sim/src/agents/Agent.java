/** Agent class 
 * Cole Twitchell
 * Private Spy Sim
 */

package agents;
import missions.*;

// a class to represent a default agent
public class Agent {
	
	private int actionStat, charismaStat, techStat, stealthStat;
	private String name;
	private int age;
	private Mission mission;
	
	// default constructor
	public Agent(String name) {
		this.name = name;
		age = 35;
		actionStat = 50;
		charismaStat = 50;
		techStat = 50;
		stealthStat = 50;
	}
	
	// detailed constructor
	public Agent (String name, int age, int aS, int chS, int tS, int sS) {
		this.name = name;
		this.actionStat = aS;
		this.charismaStat = chS;
		this.techStat = tS;
		this.stealthStat = sS;
		this.age = age;
	}

	// getter/setter methods
	public String getName() {return name;}
	public int getAge() {return age;}
	public Mission getMission() {return mission;}
	public void setMission(Mission newMission) {mission = newMission;}
	public int getCombat() {return actionStat;}
	public void setCombat(int newStat) {actionStat = newStat;}
	public int getCharisma() {return charismaStat;}
	public void setCharisma(int newStat) {charismaStat = newStat;}
	public int getTech() {return techStat;}
	public void setTech(int newStat) {techStat = newStat;}
	public int getStealth() {return stealthStat;}
	public void setStealth(int newStat) {stealthStat = newStat;}
	
}
