package challenge.gumypasquier.strategies;

/**
 * Based on : http://web.mit.edu/mshashi/www/papers/cig06.pdf
 */
public interface Strategy {
	boolean decide(boolean[][] history);

	void reset();
	
	StrategyFactor getStrategyFactor();
}
