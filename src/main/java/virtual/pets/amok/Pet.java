package virtual.pets.amok;

public abstract class Pet {
	private String name;
	private int health;
	protected int boredom;

	public String getName(){
		return name;
	}
	public int getHealth() {
		return health;
	}
	public int getBoredom() {
		return boredom;
	}
	
	public Pet(String name, int health, int boredom) {
		this.name = name;
		this.health = health;
		this.boredom = boredom;
	}
	public void play() {
		boredom -=15;
		if(boredom<0) {
			
		}
	}
}
