package challenge.gumypasquier.population;

import java.util.Collections;
import java.util.List;

import challenge.gumypasquier.entity.Chromosome;
import challenge.gumypasquier.entity.Sentences;
import challenge.gumypasquier.strategies.Strategy;
import challenge.gumypasquier.util.StaticFactory;
import challenge.gumypasquier.util.Constants;
import challenge.gumypasquier.util.Utilities;

public final class Population {

	private List<Chromosome> population;
	private List<Strategy> strategies;
	private static int sharedID = 0;
	private int id = sharedID++;

	public Population() {
		population = StaticFactory.buildChromosomes(Constants.INITIAL_POPULATION_SIZE);
		strategies = StaticFactory.buildStrategies();
		id++;
	}

	public void simulate(boolean[][] history) {
		boolean[][] workingHistory;
		for (Chromosome chromosome : population) {
			chromosome.reset();
			for (Strategy strat : strategies) {
				workingHistory = history.clone();
				for (int i = 0; i < Constants.NB_TURNS; i++) {
					boolean responseUs = chromosome.response(workingHistory);
					boolean responseOpponent = strat.decide(workingHistory);
					workingHistory = Utilities.simulateHistory(workingHistory, responseUs, responseOpponent);
					chromosome.setSentence(Sentences.getSentence(workingHistory), strat.getStrategyFactor());
				}
				strat.reset();
			}
		}
	}

	public Chromosome getFittestCandidate() {
		Collections.sort(population);
		return population.get(0);
	}

	public void evolve() {
		Collections.sort(population);
		List<Chromosome> newPopulation = StaticFactory.buildChromosomes(Constants.INITIAL_POPULATION_SIZE);
		for (int i = Constants.INITIAL_POPULATION_SIZE; i > 0; i -= 2) {
			newPopulation.addAll(Chromosome.crossOver(
					population.get(Utilities.getRandomFittestIndex(Constants.INITIAL_POPULATION_SIZE)),
					population.get(0)));
		}
		population.clear();
		population.addAll(newPopulation);
		for (Chromosome chromosome : population)
			chromosome.mutate(Constants.MUTATE_PERCENTAGE);
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("********************\n");
		str.append(String.format("Population {%d}%n", id));
		for (Chromosome chromosome : population)
			str.append(chromosome);
		return str.append("********************").toString();
	}
}
