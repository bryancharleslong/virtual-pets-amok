package virtual.pets.amok;

public abstract class Robot extends Pet {

	private int oilNeed;

	public int getOilNeed() {
		return oilNeed;
	}

	Robot(String name, int unhealthy, int boredom, int oilNeed) {
		super(name, unhealthy, boredom);
		this.oilNeed = oilNeed;
	}

	public void oil() {
		oilNeed -= 20;
		if (oilNeed < 0) {
			oilNeed = 0;
		}
	}

	@Override
	public void tick() {
		super.tick();
		oilNeed++;
	}

	@Override
	public void changeHealth(boolean isDirty) {
		boolean isHealthy = true;
		if (boredom >= 50) {
			unhealthy++;
			isHealthy = false;
		}
		if (oilNeed >= 50) {
			unhealthy++;
			isHealthy = false;
		}
		if (isHealthy) {
			unhealthy--;
		}
		if (unhealthy < 0) {
			unhealthy = 0;
		}
	}

	@Override
	public String toString() {
		return "Name = " + String.format("%-" + 16 + "." + 16 + "s", name) + "\tSickness = " + unhealthy
				+ "\tBoredom = " + boredom + "\tNeed for oil = " + oilNeed + "\t";
	}
}
