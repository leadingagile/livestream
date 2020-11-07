import java.util.ArrayList;
import java.util.List;

class Team {
	private String name;
	private int strikes;
	private BaseballGame game;
	private List<Player> players = new ArrayList<Player>();

	Team(String name, BaseballGame baseballGame) {
		this.name = name;
		this.game = baseballGame;
		players.add(new Player(this)); 
	}

	public void advance(int numberOfBasesAcquired) {
		cycleTheBases(numberOfBasesAcquired);		
		switchTeamsIfRequired(numberOfBasesAcquired);
		batterUpIfRequired(numberOfBasesAcquired);		
	}

	private void cycleTheBases(int numberOfBasesAcquired) {
		for (Player player : players) {
	 		player.advance(numberOfBasesAcquired);
		}
	}

	private void batterUpIfRequired(int numberOfBasesAcquired) {
		if ( numberOfBasesAcquired > 0) {
			players.add(new Player(this));
		}
	}

	private void switchTeamsIfRequired(int numberOfBasesAcquired) {
		if (numberOfBasesAcquired == 0) {
			strikes++;
			if (strikes % 3 == 0) game.switchTeam();
		}
	}

	@Override
	public String toString() {
		return name + ": " + players.stream().filter(player->player.base()>3).count();
	}

	public int activePlayers() {
		return this.players.size();
	}

}