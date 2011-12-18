package challenge.gumypasquier.population;

import java.util.Collections;
import java.util.List;

import challenge.gumypasquier.entity.Chromosome;
import challenge.gumypasquier.util.StaticFactory;
import challenge.gumypasquier.util.Constants;

public final class PopulationHandler {

	private List<Population> populations;

	private List<Chromosome> fittests;

	public PopulationHandler() {
		populations = StaticFactory.buildPopulation(Constants.INITIAL_POPULATIONS);
	}

	public boolean decide(boolean[][] history, int turn) {
		for (Population pop : populations) {
			pop.simulate(history);
			pop.evolve();
			pop.simulate(history);
		}
		fittests = StaticFactory.buildBestCandidates(populations);
		Collections.sort(fittests);
		Chromosome fittest = fittests.get(0);
		return fittest.response(history);
	}

}
