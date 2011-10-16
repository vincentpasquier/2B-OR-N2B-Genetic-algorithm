package challenge.gumypasquier.util;

import java.util.Random;

public final class AccessRandom {

	public static final AccessRandom INSTANCE = new AccessRandom();

	private Random random;

	private AccessRandom() {
		random = new Random();
	}

	public long getChromosome() {
		return random.nextLong();
	}

	public boolean getMutation(double percent) {
		return random.nextDouble() < percent;
	}
}
