package challenge.gumypasquier.strategies;

import challenge.Challenge;
import challenge.gumypasquier.util.Utilities;

public class NaiveProber implements Strategy {

	private int cnt = 0;
	private static final double BETRAY_PERCENTAGE = (1 / 8.);

	@Override
	public boolean decide(boolean[][] history) {
		if (cnt++ == 0)
			return false;
		return (history[Challenge.HISTORY - 1][0] || Utilities.getBooleanWithPercentage(BETRAY_PERCENTAGE));
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
