package virtual.pets.amok;

public abstract class Animal extends Pet{

	private int hunger;
	private int thirst;
	
	public int getHunger() {
		return hunger;
	}
	
	public int getThirst() {
		return thirst;
	}

	public Animal(String name, int health, int boredom, int hunger, int thirst) {
		super(name, health, boredom);
		this.hunger = hunger;
		this.thirst = thirst;
		
	}
	public void feed() {
		hunger-=10;
		if(hunger<0) {
			hunger = 0;
		}
	}
	public void water() {
		thirst -=10;
		if(thirst<0) {
			thirst = 0;
		}
	}

}
