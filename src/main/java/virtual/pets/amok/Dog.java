package virtual.pets.amok;

public class Dog extends Animal implements Canine{

	private boolean wasWalked;

	public boolean getWasWalked() {
		return wasWalked;
	}
	
	public Dog(String name, int unhealthy, int boredom, int hunger, int thirst, boolean wasWalked) {
		super(name, unhealthy, boredom, hunger, thirst);
		this.wasWalked = wasWalked;
	}
	
	@Override
	public void walk() {
		boredom -=7;
		if(boredom<0) {
			boredom = 0;
		}
		
		wasWalked = true;
	}
	
	public void noLongerWalked() {
		wasWalked = false;
	}
}
