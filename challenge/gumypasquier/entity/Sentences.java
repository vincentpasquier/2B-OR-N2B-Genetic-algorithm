package challenge.gumypasquier.entity;

import challenge.gumypasquier.util.Constants;

/**
 * The {@code Sentences} enumeration stores the result depending on the history.
 */
public enum Sentences {
	BETRAY_VS_BETRAY(Constants.B_B, Constants.B_B), BETRAY_VS_NOT_BETRAY(Constants.N_B, Constants.B_N), NOT_BETRAY_VS_NOT_BETRAY(
			Constants.N_N, Constants.N_N), NOT_BETRAY_VS_BETRAY(Constants.B_N, Constants.N_B);
	private int monthUs;
	private int monthOpponent;

	private Sentences(int monthsUs, int monthOpponent) {
		this.monthUs = monthsUs;
		this.monthOpponent = monthOpponent;
	}

	public int getMonthUs() {
		return monthUs;
	}

	public int getMonthOpponent() {
		return monthOpponent;
	}

	/**
	 * Returns the {@code Sentences} according to the history.
	 * 
	 * @param history
	 *            the history to sentence from
	 * @return the {@code Sentences} to serve
	 */
	public static Sentences getSentence(boolean[][] history) {
		if (history[Constants.HISTORY_ARRAY][0] && history[Constants.HISTORY_ARRAY][1])
			return BETRAY_VS_BETRAY;

		else if (history[Constants.HISTORY_ARRAY][0] && !history[Constants.HISTORY_ARRAY][1])
			return BETRAY_VS_NOT_BETRAY;

		else if (!history[Constants.HISTORY_ARRAY][0] && history[Constants.HISTORY_ARRAY][1])
			return NOT_BETRAY_VS_BETRAY;

		else if (!history[Constants.HISTORY_ARRAY][0] && !history[Constants.HISTORY_ARRAY][1])
			return NOT_BETRAY_VS_NOT_BETRAY;

		return null;
	}
}
