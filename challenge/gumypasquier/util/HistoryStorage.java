package challenge.gumypasquier.util;

import java.util.ArrayList;
import java.util.List;

public final class HistoryStorage {

	private static final int MAXIMUM_TURNS = 100;
	private List<Turn> turns;

	public HistoryStorage() {
		turns = new ArrayList<Turn>(MAXIMUM_TURNS);
	}

	public void store(boolean[][] history) {
		turns.add(new Turn(history));
	}

	public boolean getCorrectAnswer(int id) {
		return true;
	}

}
