package challenge.gumypasquier.util;

import java.util.ArrayList;
import java.util.List;

import challenge.gumypasquier.entity.Chromosome;
import challenge.gumypasquier.population.Population;
import challenge.gumypasquier.strategies.Betray;
import challenge.gumypasquier.strategies.HardMajority;
import challenge.gumypasquier.strategies.HardTitForTat;
import challenge.gumypasquier.strategies.NaiveProber;
import challenge.gumypasquier.strategies.NotBetray;
import challenge.gumypasquier.strategies.Pavlov;
import challenge.gumypasquier.strategies.PeriodicBBN;
import challenge.gumypasquier.strategies.PeriodicBN;
import challenge.gumypasquier.strategies.PeriodicNNB;
import challenge.gumypasquier.strategies.Random;
import challenge.gumypasquier.strategies.SoftMajority;
import challenge.gumypasquier.strategies.Spiteful;
import challenge.gumypasquier.strategies.Strategy;
import challenge.gumypasquier.strategies.SuspicousTitForTat;
import challenge.gumypasquier.strategies.TitForTat;
import challenge.gumypasquier.strategies.TitForTwoTats;

/**
 *
 */
public final class StaticFactory {

	//
	private StaticFactory() {
		throw new AssertionError();
	}

	/**
	 * @return
	 */
	public static List<Strategy> buildStrategies() {
		List<Strategy> list = new ArrayList<Strategy>();
		list.add(new Betray());
		list.add(new HardMajority());
		list.add(new HardTitForTat());
		list.add(new NaiveProber());
		list.add(new NotBetray());
		list.add(new Pavlov());
		list.add(new PeriodicBBN());
		list.add(new PeriodicBN());
		list.add(new PeriodicNNB());
		list.add(new Random());
		list.add(new SoftMajority());
		list.add(new Spiteful());
		list.add(new SuspicousTitForTat());
		list.add(new TitForTat());
		list.add(new TitForTwoTats());
		return list;
	}

	/**
	 * @param number
	 * @return
	 */
	public static List<Population> buildPopulation(int number) {
		List<Population> populations = new ArrayList<Population>(number);
		for (; number >= 0; number--) {
			populations.add(new Population());
		}
		return populations;
	}

	/**
	 * @param initialPopulationSize
	 * @return
	 */
	public static List<Chromosome> buildEmptyPopulation(int initialPopulationSize) {
		return new ArrayList<Chromosome>(initialPopulationSize);
	}
	
	/**
	 * @param size
	 * @return
	 */
	public static List<Chromosome> buildChromosomes(int size) {
		List<Chromosome> chromosomes = new ArrayList<Chromosome>(size);
		for (; size >= 0; size--)
			chromosomes.add(new Chromosome());
		return chromosomes;
	}

	/**
	 * @param populations
	 * @return
	 */
	public static List<Chromosome> buildBestCandidates(List<Population> populations) {
		List<Chromosome> fittestCandidates = new ArrayList<Chromosome>(Constants.INITIAL_POPULATIONS);
		for (Population population : populations) {
			fittestCandidates.add(population.getFittestCandidate());
		}
		return fittestCandidates;
	}

}
