package challenge.gumypasquier.strategies;

import challenge.Challenge;

public class SoftMajority implements Strategy {
	private int cnt = 0;
	private int cBetray = 0;
	private int cNotBetray = 0;

	@Override
	public boolean decide(boolean[][] history) {
		if (cnt++ == 0)
			return false;
		if (history[Challenge.HISTORY - 1][0])
			cBetray++;
		else
			cNotBetray++;
		return !(cNotBetray >= cBetray);
	}

	@Override
	public void reset() {
		cnt = 0;
		cBetray = 0;
		cNotBetray = 0;
	}

	@Override
	public StrategyFactor getStrategyFactor() {
		return StrategyFactor.SOFT_STRATEGY;
	}
}