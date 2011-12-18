package challenge.gumypasquier.strategies;

import challenge.gumypasquier.util.Utilities;

public class Random implements Strategy {

	@Override
	public boolean decide(boolean[][] history) {
		return Utilities.randomBoolean();
	}

	@Override
	public void reset() {
	}
	
	@Override
	public StrategyFactor getStrategyFactor() {
		return StrategyFactor.HARD_STRATEGY;
	}
}
