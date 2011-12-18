package challenge.gumypasquier.strategies;

import challenge.GenAlgo;

/**
 * {@code Betray} class always betray when asked.
 */
public final class Betray implements Strategy {

	@Override
	public boolean decide(boolean[][] history) {
		return GenAlgo.BETRAY;
	}

	@Override
	public void reset() {
	}

	@Override
	public StrategyFactor getStrategyFactor() {
		return StrategyFactor.HARD_STRATEGY;
	}
}
