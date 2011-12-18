package challenge.gumypasquier.strategies;

import challenge.gumypasquier.util.Constants;

public class Spiteful implements Strategy {

	private boolean first = false;

	@Override
	public boolean decide(boolean[][] history) {
		if (history[Constants.HISTORY_ARRAY][0] && !first)
			first = true;
		return first;
	}

	@Override
	public void reset() {
		first = false;
	}
	
	@Override
	public StrategyFactor getStrategyFactor() {
		return StrategyFactor.HARD_STRATEGY;
	}
}
