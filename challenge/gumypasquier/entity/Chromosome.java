package challenge.gumypasquier.entity;

import challenge.gumypasquier.util.Utilities;

public class Chromosome implements Comparable<Chromosome> {

	protected boolean[] chromosome;
	private short right = 0;
	private short wrong = 0;
	private boolean lastResponse;

	public Chromosome() {
		chromosome = Utilities.INSTANCE.getChromosome();
	}

	public Chromosome(Chromosome crossEntity) {

	}

	public boolean response(short history) {
		return (chromosome[history]);
	}

	public void judge(boolean rightAnswer) {
		if (rightAnswer == lastResponse)
			right++;
		else
			wrong++;
	}

	public double fitness() {
		return (right / (double) (right + wrong));
	}

	public Chromosome crossOver(Chromosome crossEntity) {
		return new Chromosome(crossEntity);
	}

	public void mutate(double percent) {
		for (short i = Long.SIZE; i >= 0; i--) {
			if (Utilities.INSTANCE.getMutation(percent)) {
				chromosome[i] = !chromosome[i];
			}
		}
	}

	@Override
	public int compareTo(Chromosome o) {
		return Double.compare(this.fitness(), o.fitness());
	}
}
