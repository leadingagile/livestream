import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class BaseballGameTests {

	private static final int TRIPPLE = 3;

	private static final int DOUBLE = 2;

	private static final int SINGLE = 1;

	private static final int HOMERUN = 4;

	private static final int OUT = 0;

	/**
	 * 
	 * Your school has hired you to keep track of the score at baseball games. Unfortunately you tend to be rather absent 
	 * minded because most nights you stay up late
	 * playing video games and coding. Let's create a program that will keep track of the score for us.
	 * 
	 * We'll need to create a constructor ScoreCard-->BaseballGame that has two public functions: addEntry->atBatOutcome and getScore->toString.
	 * 
	 * addEntry - Takes in the result of an at-bat. This result can be single, double, triple, homerun, or out. getScore - 
	 * Returns the score 
	 * in the format Home: [HOME_SCORE] Away: [AWAY_SCORE]
	 * 
	 * To keep things simple, base runners will advance the amount of bases equal to that of the batter's hit 
	 * (i.e. if the batter hits a double,
	 *  each base-runner will
	 * advance two bases). A few important baseball rules: The Away team bats first. There are three outs in an inning. 
	 * After three outs the opposing team hits.
	 * 
	 * The hits single, double, triple and homerun correspond to the batter reaching bases first, second, third and home respectively. 
	 * Base runners start at home and then
	 * cycle through the bases first, second, third and home. Runners score for their team after they reach home.
	 */

	private BaseballGame game;
	

	@BeforeEach
	public void setup() {
		game = new BaseballGame();
	}

	//@Disabled
	@Test
	public void newGame() {
		assertEquals("Home: 0 Away: 0", game.toString());
	}

	@Test
	public void firstHitHomerun() {
		game.atBatOutcome(HOMERUN);
		assertEquals("Home: 0 Away: 1", game.toString());
	}

	@Test
	public void twoHomeruns() {
		game.atBatOutcome(HOMERUN);
		game.atBatOutcome(HOMERUN);
		assertEquals("Home: 0 Away: 2", game.toString());
	}

	@Test
	public void threeHomeruns() {
		game.atBatOutcome(HOMERUN);
		game.atBatOutcome(HOMERUN);
		game.atBatOutcome(HOMERUN);
		assertEquals("Home: 0 Away: 3", game.toString());
	}

	@Test
	public void out() {
		game.atBatOutcome(OUT);
		assertEquals("Home: 0 Away: 0", game.toString());
	}

	// bad test
	@Test
	public void outThenHomerun() {
		game.atBatOutcome(OUT);
		game.atBatOutcome(HOMERUN);
		assertEquals("Home: 0 Away: 1", game.toString());
	}

	// bad test
	@Test
	public void homerunThenOut() {
		game.atBatOutcome(HOMERUN);
		game.atBatOutcome(OUT);
		assertEquals("Home: 0 Away: 1", game.toString());
	}

	@Test
	public void teamsSwitchSidesWhenThreeOuts() {
		// first out!		
		game.atBatOutcome(OUT);
		game.atBatOutcome(OUT);
		game.atBatOutcome(OUT);
		
		// second out!
		game.atBatOutcome(OUT);
		game.atBatOutcome(OUT);
		game.atBatOutcome(OUT);
		
		// third out!
		game.atBatOutcome(OUT);
		game.atBatOutcome(OUT);
		game.atBatOutcome(OUT);	
				
		game.atBatOutcome(HOMERUN);
		assertEquals("Home: 1 Away: 0", game.toString());
	}
	
	@Test
	public void threeOutsThenTwoHomeruns() {
		game.atBatOutcome(OUT);
		game.atBatOutcome(OUT);
		game.atBatOutcome(OUT);
		game.atBatOutcome(HOMERUN);
		game.atBatOutcome(HOMERUN);
		assertEquals("Home: 2 Away: 0", game.toString());
	}
	
	//Joel won $100 from Ron?
	@Test
	public void firstSingle() {
		game.atBatOutcome(SINGLE);
		assertEquals("Home: 0 Away: 0", game.toString());
	}
	
	@Test
	public void twoSingles() {
		game.atBatOutcome(SINGLE);
		game.atBatOutcome(SINGLE);
		assertEquals("Home: 0 Away: 0", game.toString());
	}
	
	@Test
	public void fourSingles() {
		game.atBatOutcome(SINGLE);
		game.atBatOutcome(SINGLE);
		game.atBatOutcome(SINGLE);
		game.atBatOutcome(SINGLE);
		assertEquals("Home: 0 Away: 1", game.toString());
	}
	
	@Test
	public void oneDouble() {
		game.atBatOutcome(DOUBLE);
		assertEquals("Home: 0 Away: 0", game.toString());
	}
	
	@Test
	public void twoDouble() {
		game.atBatOutcome(DOUBLE);
		game.atBatOutcome(DOUBLE);
		
		assertEquals("Home: 0 Away: 1", game.toString());
	}
	
	@Test
	public void oneTriple() {
		game.atBatOutcome(TRIPPLE);
		assertEquals("Home: 0 Away: 0", game.toString());
	}
	
	@Test
	public void twoTripples() {
		game.atBatOutcome(TRIPPLE);
		game.atBatOutcome(TRIPPLE);
		assertEquals("Home: 0 Away: 1", game.toString());
	}
		
	@Test
	public void onThirdThenSingle() {
		game.atBatOutcome(TRIPPLE);
		game.atBatOutcome(SINGLE);
		assertEquals("Home: 0 Away: 1", game.toString());
	}
	
	@Test
	public void singleThenTripple() {
		game.atBatOutcome(SINGLE);
		game.atBatOutcome(TRIPPLE);
		assertEquals("Home: 0 Away: 1", game.toString());
	}

}
