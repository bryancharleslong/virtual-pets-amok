package virtual.pets.amok;

public class LitterBox extends Area {

	@Override
	protected boolean isDirty() {
		boolean isDirty = false;
		if (dirty >= 20) {
			isDirty = true;
		}
		return isDirty;
	}

}
