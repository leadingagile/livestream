import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PlayerTest {
	
	@Test
	public void advance() {
		Player player = new Player(new Team("Anaheim Arbitraries", new BaseballGame()));
		player.advance(1);
		assertEquals(1, player.base());
	}
	
	@Test
	public void singleSingle() {
		Player player = new Player(new Team("Anaheim Arbitraries", new BaseballGame()));
		player.advance(1);
		player.advance(1);
		assertEquals(2, player.base());
	}
	
}
