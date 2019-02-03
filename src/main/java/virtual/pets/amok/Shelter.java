package virtual.pets.amok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Shelter {

	private Map<Pet, Area> shelter = new HashMap<>();

	public void intake(Pet aPet, Area anArea) {
		if (aPet instanceof Canine && anArea instanceof Cage) {
			shelter.put(aPet, anArea);
		}
		if(aPet instanceof Feline&&anArea instanceof LitterBox) {
			shelter.put(aPet, anArea);
		}
	}

	public Collection<Pet> getPets() {
		return shelter.keySet();
	}

	public void adopt(Pet aPet) {
		shelter.remove(aPet);
		
	}

}
