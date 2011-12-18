package challenge.gumypasquier.strategies;

import challenge.Challenge;
import challenge.GenAlgo;

/**
 * Doesn't betray the first turn then only betray when the last turn history
 * differs.
 */
public class Pavlov implements Strategy {

	private int cnt = 0;

	@Override
	public boolean decide(boolean[][] history) {
		if (cnt++ == 0)
			return GenAlgo.NOT_BETRAY;
		return (history[Challenge.HISTORY - 1][0] != history[Challenge.HISTORY - 1][1]);
	}

	@Override
	public void reset() {
		cnt = 0;
	}

	@Override
	public StrategyFactor getStrategyFactor() {
		return StrategyFactor.SOFT_STRATEGY;
	}
}
