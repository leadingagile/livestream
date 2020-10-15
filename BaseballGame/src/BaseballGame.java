
public class BaseballGame {
	private Team awayTeam = new Team("Away", this);
	private Team homeTeam = new Team("Home", this);
	private Team offensiveTeam = awayTeam;

	public String toString() {
		return homeTeam + " " + awayTeam;
	}

	public void atBatOutcome(int numberOfBasesAcquired) {
		
		offensiveTeam.advance(numberOfBasesAcquired);
	}
	
	public void switchTeam() {
		offensiveTeam = (offensiveTeam == awayTeam ? homeTeam : awayTeam); 
	}
}
