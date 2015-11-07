package actors;

public class Weapon {

	private int actionStat, stealthStat;
	private Agent agent;
	
	/* constructors
	 * @param agent the agent the weapon belongs to
	 * @param aS the action stat of the weapon
	 * @param sS the stealth stat of the weapon
	 */
	public Weapon(Agent agent, int aS, int sS) {
		this.agent = agent;
		actionStat = aS;
		stealthStat = sS;
	}
	
	// getter setter methods
	public int getAction() {return actionStat;}
	public void setAction(int newAS) {actionStat = newAS;}
	public int getStealth() {return stealthStat;}
	public void setStealth(int newSS) {stealthStat = newSS;}
	
}
