package challenge.gumypasquier.util;

import challenge.Challenge;

public final class Constants {

	public static final int HISTORY_ARRAY = Challenge.HISTORY - 1;
	public static final int NRMEMBERS_ARRAY = Challenge.NRMEMBERS - 1;
	public static final int HISTORY_LENGTH = 64;
	public static final double DOUBLE_CROSS = (1 / 8.);
	public static final int B_N = 10;
	public static final int B_B = 5;
	public static final int N_B = 0;
	public static final int N_N = 1;
	public static final double MUTATE_PERCENTAGE = (1 / 97.);
	public static final int INITIAL_POPULATION_SIZE = 20;
	public static final int NB_TURNS = 100;
	public static final int INITIAL_POPULATIONS = 10;
	public static final int TONE_DOWN_DELTA_OPPONENT = 2;

	private Constants() {
		throw new AssertionError();
	}

}
