package virtual.pets.amok;

public abstract class Area {
	
	protected int dirty = 0;
	
	protected int getDirty(){
		return dirty;
	}

	protected void tick() {
		dirty++;
	}
	protected void clean() {
		dirty = 0;
	}

	protected abstract boolean isDirty();

}
