
class Team {
	private String name;
	private int score;
	private boolean firstBaseOccupied = false;
	private boolean secondBaseOccupied = false;
	private boolean thirdBaseOccupied = false;
	private int strikes;
	private BaseballGame game;

	Team(String name, BaseballGame baseballGame) {
		this.name = name;
		this.game = baseballGame;
	}

	public void addRun() {
		score++;
	}

	public void advance(int numberOfBasesAcquired) {
		/* Start use Players in the code below.
		 * foreach (activePlayer: player ) {
		 * 		activePlayer.advance(numberOfBasesAcquired);
		 * }
		 */
		
		
		
		if (numberOfBasesAcquired == 0) {
			strikes++;
			if (strikes % 3 == 0) game.switchTeam();
		}

		if (numberOfBasesAcquired == 4) {
			addRun();
		}

		if (numberOfBasesAcquired == 1) {
			if (thirdBaseOccupied) {
				addRun();
				return;
			}		
			
			if (!firstBaseOccupied) {
				firstBaseOccupied = true;
			} else if (!secondBaseOccupied) {
				secondBaseOccupied = true;
			} else if (!thirdBaseOccupied) {
				thirdBaseOccupied = true;
			}
		}

		if (numberOfBasesAcquired == 2) {
			if (!secondBaseOccupied) {
				secondBaseOccupied = true;
			} else if (secondBaseOccupied) {
				addRun();
			}
		}

		if (numberOfBasesAcquired == 3) {
			if (!thirdBaseOccupied) {
				thirdBaseOccupied = true;
			} else {
				addRun();
			}
		}
	}

	private boolean toggleIfUnoccupied(boolean base) {
		if (!base) return true;
		return base;
	}

	@Override
	public String toString() {
		return name + ": " + score;
	}

}
