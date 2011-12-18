package challenge.gumypasquier.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import challenge.gumypasquier.entity.Chromosome;

public final class Utilities {

	private static Random random = new Random();

	private Utilities() {
		throw new AssertionError();
	}

	public static boolean[] getChromosome() {
		boolean[] chromosome = new boolean[Constants.HISTORY_LENGTH];
		for (int i = Constants.HISTORY_LENGTH - 1; i >= 0; i--)
			if (random.nextBoolean())
				chromosome[i] = true;
		return chromosome;
	}

	public static boolean getBooleanWithPercentage(final double percent) {
		return random.nextDouble() < percent;
	}

	public static boolean randomBoolean() {
		return random.nextBoolean();
	}

	public static int getOffsetHistory(final boolean[][] history) {
		int offset = 0;

		if (history[0][0]) {
			offset += 32;
		}

		if (history[0][1]) {
			offset += 16;
		}

		if (history[1][0]) {
			offset += 8;
		}

		if (history[1][1]) {
			offset += 4;
		}

		if (history[2][0]) {
			offset += 2;
		}

		if (history[2][1]) {
			offset += 1;
		}

		return offset;
	}

	public static boolean isDoubleCrossOver() {
		return getBooleanWithPercentage(Constants.DOUBLE_CROSS);
	}

	public static List<Chromosome> getChromosomeDoublyCrossed(final boolean[] first, final boolean[] second) {
		int[] cPoints = getDoubleCrossPoint();
		return getChromosomeCrossed(first, second, true, cPoints[0], cPoints[1]);
	}

	public static List<Chromosome> getChromosomeSinglyCrossed(final boolean[] first, final boolean[] second) {
		int crossPoint = random.nextInt(Constants.HISTORY_LENGTH);
		return getChromosomeCrossed(first, second, true, crossPoint, 0);
	}

	private static List<Chromosome> getChromosomeCrossed(final boolean[] first, final boolean[] second,
			final boolean dCrossed, final int firstCrossed, final int secondCrossed) {
		List<Chromosome> chromosomes = new ArrayList<Chromosome>(2);
		boolean[] firstCopy, secondCopy;
		firstCopy = first.clone();
		secondCopy = second.clone();
		for (int i = Constants.HISTORY_LENGTH - 1; i >= 0; i--) {
			if (((i < firstCrossed) && !dCrossed) || ((i < firstCrossed && i > secondCrossed) && dCrossed)) {
				boolean tmp = firstCopy[i];
				firstCopy[i] = secondCopy[i];
				secondCopy[i] = tmp;
			}
		}
		chromosomes.add(new Chromosome(firstCopy));
		chromosomes.add(new Chromosome(secondCopy));
		return chromosomes;
	}

	private static int[] getDoubleCrossPoint() {
		int firstCPoint, secondCPoint;
		firstCPoint = random.nextInt(Constants.HISTORY_LENGTH);
		do {
			secondCPoint = random.nextInt(Constants.HISTORY_LENGTH);
		} while (secondCPoint == firstCPoint);
		return new int[] { Math.max(firstCPoint, secondCPoint), Math.min(firstCPoint, secondCPoint) };
	}

	public static boolean[][] simulateHistory(boolean[][] workingHistory, final boolean responseUs,
			final boolean responseOpponent) {
		for (int j = 0; j < Constants.HISTORY_ARRAY; j++) {
			workingHistory[j][0] = workingHistory[j + 1][0];
			workingHistory[j][1] = workingHistory[j + 1][1];
		}
		workingHistory[Constants.HISTORY_ARRAY][0] = responseUs;
		workingHistory[Constants.HISTORY_ARRAY][1] = responseOpponent;
		return workingHistory;
	}

	public static int getRandomFittestIndex(final int initialPopulationSize) {
		return random.nextInt(initialPopulationSize);
	}
}
