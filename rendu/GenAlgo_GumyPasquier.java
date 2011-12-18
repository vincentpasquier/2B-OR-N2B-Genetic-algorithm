package challenge;

import challenge.gumypasquier.population.PopulationHandler;

public class GenAlgo_GumyPasquier implements GenAlgo {

	private static final String GROUP_NAME = "Gumy & Pasquier";

	private PopulationHandler pop;
	private int turn = 0;

	public GenAlgo_GumyPasquier() {
		pop = new PopulationHandler();
	}

	@Override
	public boolean decision(boolean[][] history) {
		boolean decided = pop.decide(history, turn++);
		return decided;
	}

	@Override
	public String getGroupName() {
		return GROUP_NAME;
	}
}
