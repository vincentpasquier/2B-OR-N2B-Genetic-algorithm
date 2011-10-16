package challenge.gumypasquier.pop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import challenge.gumypasquier.entity.Chromosome;

public final class Population {
	private static final int INITIAL_POPULATION_SIZE = 40;
	private List<Chromosome> population;

	private double median;

	public Population() {
		population = new ArrayList<Chromosome>(INITIAL_POPULATION_SIZE);
	}

	public void sort() {
		Collections.sort(population);
		if ((population.size() % 2) == 1) {
			median = population.get(((population.size() + 1) / 2) - 1).fitness();
		} else {
			double up = population.get((population.size() / 2) - 1).fitness();
			double low = population.get((population.size() / 2)).fitness();
			median = (low + up) / 2.0;
		}
	}

	public double fitness() {
		return median;
	}

}
