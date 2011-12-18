package challenge.gumypasquier.strategies;

public enum StrategyFactor {
	HARD_STRATEGY(1), SOFT_STRATEGY(2);

	private double factor;

	StrategyFactor(double factor) {
		this.factor = factor;
	}

	public double getFactor() {
		return factor;
	}
}
