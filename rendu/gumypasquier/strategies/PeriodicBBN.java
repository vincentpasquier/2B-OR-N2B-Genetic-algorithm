package challenge.gumypasquier.strategies;

public class PeriodicBBN implements Strategy {
	private int cnt = 1;

	@Override
	public boolean decide(boolean[][] history) {
		return !((cnt++ % 3) == 0);
	}

	@Override
	public void reset() {
		cnt = 1;
	}
	@Override
	public StrategyFactor getStrategyFactor() {
		return StrategyFactor.HARD_STRATEGY;
	}
}
