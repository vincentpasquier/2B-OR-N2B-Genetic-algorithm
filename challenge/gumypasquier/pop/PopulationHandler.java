package challenge.gumypasquier.pop;

import java.util.ArrayList;
import java.util.List;

public final class PopulationHandler {

	private static final int INITIAL_POPULATIONS = 10;

	private List<Population> populations;

	public PopulationHandler() {
		populations = new ArrayList<Population>(INITIAL_POPULATIONS);
	}

	public void generateNewPopulation() {
		populations.add(new Population());
	}

}
