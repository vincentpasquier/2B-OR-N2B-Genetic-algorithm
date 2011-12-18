package challenge.gumypasquier.entity;

import java.util.List;

import challenge.gumypasquier.strategies.StrategyFactor;
import challenge.gumypasquier.util.Constants;
import challenge.gumypasquier.util.Utilities;

/**
 * The {@code Chromosome} class represents the solutions to a given history
 * input for the prisonner's dilemma.
 */
public final class Chromosome implements Comparable<Chromosome> {

	// Answers to a given input.
	private boolean[] chromosome;

	// Number of month we stay in prison.
	private int monthUs = 0;

	// Number of month the opponent stays in prison.
	private int monthOpponent = 0;

	/**
	 * Initializes a new random {@code Chromosome}.
	 */
	public Chromosome() {
		this(Utilities.getChromosome());
	}

	/**
	 * Initializes a new {@code Chromosome} with the given solutions.
	 * 
	 * @param chromosome
	 *            the solutions to history input
	 */
	public Chromosome(final boolean[] chromosome) {
		this.chromosome = chromosome;
	}

	/**
	 * Returns the answer to a given input.
	 * 
	 * @param history
	 *            the input of the game
	 * @return the answer to a given input.
	 */
	public boolean response(final boolean[][] history) {
		return (chromosome[Utilities.getOffsetHistory(history)]);
	}

	/**
	 * Mutates the {@code Chromosome} with a percentage for every answers.
	 * 
	 * @param percent
	 *            the percentage of mutation
	 */
	public void mutate(final double percent) {
		for (int i = Constants.HISTORY_ARRAY; i >= 0; i--) {
			if (Utilities.getBooleanWithPercentage(percent)) {
				chromosome[i] = !chromosome[i];
			}
		}
	}

	/**
	 * Creates a {@code List} of two {@code Chromosome} created from the given
	 * ones.
	 * 
	 * @param first
	 *            the first {@code Chromosome} to cross over
	 * @param second
	 *            the second {@code Chromosome} to cross over
	 * @return two {@code Chromosome} with genetic code from arguments
	 */
	public static List<Chromosome> crossOver(final Chromosome first, final Chromosome second) {
		if (Utilities.isDoubleCrossOver())
			return Utilities.getChromosomeDoublyCrossed(first.chromosome, second.chromosome);
		else
			return Utilities.getChromosomeSinglyCrossed(first.chromosome, second.chromosome);
	}

	/**
	 * Notice the {@code Chromosome} of his {@code Sentences} for the last turn.
	 * 
	 * <p>
	 * Stores the informations of the number of prison for us and the opponent
	 * to compare {@code Chromosome}.
	 * 
	 * @param sentence
	 * @param strategyFactor
	 */
	public void setSentence(final Sentences sentence, StrategyFactor strategyFactor) {
		this.monthUs += (sentence.getMonthUs() * strategyFactor.getFactor());
		this.monthOpponent += (sentence.getMonthOpponent() * strategyFactor.getFactor());
	}

	/**
	 * Compares the current {@code Chromosome} with the given one.
	 * 
	 * <p>
	 * Serves as a fitness function in the prisonner's dilemma.
	 * 
	 * <p>
	 * The goal is to use some kind of min-max function. We try to maximize the
	 * prison time of the opponent and minimize our time.
	 * 
	 * @param o
	 *            the {@code Chromosome} to compare to
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Chromosome o) {
		int deltaUs = Math.abs(monthUs - o.monthUs);
		int deltaOpponent = Math.abs(monthOpponent - o.monthOpponent);

		// This Chromosome tries to minimize our time of prison.
		if (deltaUs > deltaOpponent)
			return (o.monthUs - monthUs);
		// This Chromosome tries to maximaze the time of the opponent.
		else if (deltaUs < deltaOpponent)
			return (o.monthOpponent - monthOpponent);
		return 0;
	}

	/**
	 * Returns a representation of the {@code Chromosome} to displays its
	 * answers.
	 * 
	 * @return the representation of {@code Chromosome}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("{");
		for (int i = 0; i < Constants.HISTORY_LENGTH; i++)
			str.append(chromosome[i] ? " B, " : " N, ");
		return str.append("}").toString();
	}

	/**
	 * Resets the sentence to serve for a {@code Chromosome}
	 */
	public void reset() {
		monthOpponent = 0;
		monthUs = 0;
	}
}
