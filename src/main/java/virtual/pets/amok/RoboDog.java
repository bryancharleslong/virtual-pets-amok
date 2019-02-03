package virtual.pets.amok;

public class RoboDog extends Robot implements Canine {

	public RoboDog(String name, int health, int boredom, int oilNeed) {
		super(name, health, boredom, oilNeed);
	}

	@Override
	public void walk() {
		boredom -=7;
		if(boredom<0) {
			boredom = 0;
		}

	}

}
