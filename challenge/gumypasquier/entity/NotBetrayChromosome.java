package challenge.gumypasquier.entity;

import challenge.gumypasquier.util.Utilities;

public class NotBetrayChromosome extends Chromosome {

	public NotBetrayChromosome() {
		super.chromosome = Utilities.INSTANCE.getChromosome(false);
	}

	@Override
	public boolean response(short history) {
		return false;
	}
}
