package challenge.gumypasquier.strategies;

public final class NotBetray implements Strategy {

	@Override
	public boolean decide(boolean[][] history) {
		return false;
	}

	@Override
	public void reset() {
	}

	@Override
	public StrategyFactor getStrategyFactor() {
		return StrategyFactor.HARD_STRATEGY;
	}
}
