package challenge.gumypasquier.strategies;

public class PeriodicBN implements Strategy {
	private int cnt = 0;

	@Override
	public boolean decide(boolean[][] history) {
		return ((cnt++ % 2) == 0);
	}

	@Override
	public void reset() {
		cnt = 0;
	}
	@Override
	public StrategyFactor getStrategyFactor() {
		return StrategyFactor.HARD_STRATEGY;
	}
}
