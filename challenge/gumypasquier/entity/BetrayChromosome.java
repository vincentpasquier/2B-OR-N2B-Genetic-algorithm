package challenge.gumypasquier.entity;

public class BetrayChromosome extends Chromosome {

	public BetrayChromosome() {
		super.chormosome = Long.MIN_VALUE;
	}

	@Override
	public boolean response(short history) {
		return true;
	}
}