
public class Player {

	private int baseImStandingOn;
	private Team teamImOn;

	public Player(Team team) {
		teamImOn = team;
	}
	
	public void advance(int bases) {
		baseImStandingOn += bases;
		
		//if(baseImStandingOn == 4) teamImOn.addRun();
	}
	
	public int base() {
		return baseImStandingOn;
	}
}