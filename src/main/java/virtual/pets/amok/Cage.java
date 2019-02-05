package virtual.pets.amok;

public class Cage extends Area {

	@Override
	protected boolean isDirty() {
		boolean isDirty = false;
		if(dirty>=10) {
			isDirty = true;
		}
		return isDirty;
	}
	

}
