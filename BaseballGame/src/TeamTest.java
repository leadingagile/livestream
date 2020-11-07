import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TeamTest {

	private Team team;
	
	@BeforeEach
	void setupTeam() {
		team = new Team("Anheim Arbitrary", new BaseballGame());
	}
	
	@Test
	void teamCreatedWithOneActivePlayer() { 
		assertEquals(1, team.activePlayers());
	}

	
	@Test
	void whenPlayerGetsAHitThenNextPlayerAtBat() {
		team.advance(1);
		assertEquals(2, team.activePlayers());
	}
}
