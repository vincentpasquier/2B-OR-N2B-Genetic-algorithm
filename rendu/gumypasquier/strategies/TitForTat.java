package challenge.gumypasquier.strategies;

import challenge.Challenge;

public final class TitForTat implements Strategy {

	private int cnt = 0;

	@Override
	public boolean decide(boolean[][] history) {
		if (cnt++ == 0)
			return false;
		return history[Challenge.HISTORY - 1][0];
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
