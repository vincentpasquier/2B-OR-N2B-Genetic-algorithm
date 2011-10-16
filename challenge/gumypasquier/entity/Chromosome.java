package challenge.gumypasquier.entity;

import challenge.gumypasquier.util.AccessRandom;

public class Chromosome implements Comparable<Chromosome> {

	protected long chormosome;
	private short right = 0;
	private short wrong = 0;
	private boolean lastResponse;

	public Chromosome() {
		chormosome = AccessRandom.INSTANCE.getChromosome();
	}

	public Chromosome(Chromosome crossEntity) {
		
	}

	// TODO : check
	public boolean response(short history) {
		return ((chormosome & (1 << history)) == 0);
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
			if (AccessRandom.INSTANCE.getMutation(percent)) {
				if (response(i))
					chormosome = chormosome & ~(1 << i);
				else
					chormosome = chormosome & (1 << i);
			}
		}
	}

	@Override
	public int compareTo(Chromosome o) {
		return Double.compare(this.fitness(), o.fitness());
	}
}
