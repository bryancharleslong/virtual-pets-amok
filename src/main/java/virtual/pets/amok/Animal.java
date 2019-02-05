package virtual.pets.amok;

public abstract class Animal extends Pet {

	private int hunger;
	private int thirst;

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public Animal(String name, int unhealthy, int boredom, int hunger, int thirst) {
		super(name, unhealthy, boredom);
		this.hunger = hunger;
		this.thirst = thirst;
	}

	public void feed() {
		hunger -= 15;
		if (hunger < 0) {
			hunger = 0;
		}
	}

	public void water() {
		thirst -= 15;
		if (thirst < 0) {
			thirst = 0;
		}
	}

	@Override
	public void tick() {
		super.tick();
		hunger++;
		thirst++;
	}

	@Override
	public void changeHealth(boolean isDirty) {
		boolean isHealthy = true;
		if (isDirty) {
			unhealthy++;
			isHealthy = false;
		}
		if (hunger >= 50) {
			unhealthy++;
			isHealthy = false;
		}
		if (thirst >= 50) {
			unhealthy++;
			isHealthy = false;
		}
		if (boredom >= 50) {
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
				+ "\tBoredom = " + boredom + "\tHunger = " + hunger + "\tThirst = " + thirst;
	}

}
