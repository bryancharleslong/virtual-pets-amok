package virtual.pets.amok;

public abstract class Robot extends Pet {

	private int oilNeed;
	
	public int getOilNeed(){
		return oilNeed;
	}

	Robot(String name, int health, int boredom,int oilNeed){
		super(name, health, boredom);
		this.oilNeed = oilNeed;
	}
	
	public void oil(){
		oilNeed-=20;
		if(oilNeed<0) {
			oilNeed = 0;
		}
	}
}
