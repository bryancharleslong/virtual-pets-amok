package virtual.pets.amok;

public abstract class Pet {
	protected String name;
	protected int unhealthy;
	protected int boredom;

	public String getName() {
		return name;
	}

	public int getUnhealthy() {
		return unhealthy;
	}

	public int getBoredom() {
		return boredom;
	}

	public Pet(String name, int unhealthy, int boredom) {
		this.name = name;
		this.unhealthy = unhealthy;
		this.boredom = boredom;
	}

	public void play() {
		boredom -= 15;
		if (boredom < 0) {
			boredom = 0;
		}
	}

	protected void tick() {
		boredom++;
	}

	protected abstract void changeHealth(boolean isDirty);
	
	public abstract String toString();
}
