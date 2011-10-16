package challenge.gumypasquier.util;

import java.util.Random;

public final class Utilities {

	private static final int HISTORY_LENGTH = 64;
	public static final Utilities INSTANCE = new Utilities();

	private Random random;

	private Utilities() {
		random = new Random();
	}

	public boolean[] getChromosome() {
		boolean[] chromosome = new boolean[HISTORY_LENGTH];
		for (int i = 0; i < chromosome.length; i++)
			if (random.nextBoolean())
				chromosome[i] = true;
		return chromosome;
	}

	public boolean[] getChromosome(boolean fill) {
		boolean[] chromosome = new boolean[HISTORY_LENGTH];
		if (!fill)
			return chromosome;
		for (int i = 0; i < chromosome.length; i++)
			if (fill)
				chromosome[i] = fill;
		return chromosome;
	}

	public boolean getMutation(double percent) {
		return random.nextDouble() < percent;
	}
}
