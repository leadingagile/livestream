import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AcceptanceTest {

	@Test
	void game() {
		BaseballGame game = new BaseballGame();
		
		game.atBatOutcome(1);
		game.atBatOutcome(3);
		game.atBatOutcome(2);
		game.atBatOutcome(4);
		assertEquals("Home: 0 Away: 4", game.toString());
		
		game.atBatOutcome(0);
		game.atBatOutcome(0);
		game.atBatOutcome(0);
		game.atBatOutcome(4);
		assertEquals("Home: 1 Away: 4", game.toString());
	}

}
