package challenge;

import challenge.gumypasquier.pop.PopulationHandler;

public class GenAlgo_GumyPasquier implements GenAlgo {

	private static final String GROUP_NAME = "Gumy & Pasquier";

	private PopulationHandler pop;
	private static int turn = 0;

	public GenAlgo_GumyPasquier() {
		pop = new PopulationHandler();
	}

	@Override
	public boolean decision(boolean[][] history) {
		if (((turn % 10) == 0) && (turn != 0))
			pop.generateNewPopulation();
		turn++;
		return false;
	}

	@Override
	public String getGroupName() {
		return GROUP_NAME;
	}

}
