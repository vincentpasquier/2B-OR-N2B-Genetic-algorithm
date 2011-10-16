package challenge.gumypasquier.entity;

import challenge.gumypasquier.util.Utilities;

public class BetrayChromosome extends Chromosome {

	public BetrayChromosome() {
		super.chromosome = Utilities.INSTANCE.getChromosome(true);
	}

	@Override
	public boolean response(short history) {
		return true;
	}
}