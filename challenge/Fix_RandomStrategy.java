package challenge;

import java.util.Random;

public class Fix_RandomStrategy implements GenAlgo {

	private Random random;

	public Fix_RandomStrategy() {
		random = new Random();
	}

	@Override
	public boolean decision(boolean[][] history) {
		return random.nextBoolean();
	}

	@Override
	public String getGroupName() {
		return "Random strat";
	}

}
