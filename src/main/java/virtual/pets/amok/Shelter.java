package virtual.pets.amok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Shelter {

	private Map<Pet, Area> shelter = new HashMap<>();
	private LitterBox litterBox = new LitterBox();

	public Area getArea(Pet aPet) {
		Area aPetArea = null;
		for (Entry<Pet, Area> entry : shelter.entrySet()) {
			if (entry.getKey().equals(aPet)) {
				aPetArea = entry.getValue();
			}
		}
		return aPetArea;
	}

	public void intake(Pet aPet) {
		if (aPet instanceof Canine) {
			Cage newCage = new Cage();
			shelter.put(aPet, newCage);
		} else if (aPet instanceof Feline) {
			shelter.put(aPet, litterBox);
		}
	}

	public Collection<Pet> getPets() {
		return shelter.keySet();
	}

	public void adopt(Pet aPet) {
		shelter.remove(aPet);
	}

	public int getLitterBoxDirty() {
		return litterBox.getDirty();
	}

	public void tick() {
		for (Entry<Pet, Area> entry : shelter.entrySet()) {
			Pet aPet = entry.getKey();
			Area anArea = entry.getValue();
			aPet.tick();
			boolean isDirty = anArea.isDirty();
			aPet.changeHealth(isDirty);
			if (aPet instanceof Cat) {
				anArea.tick();
			} else if (aPet instanceof Dog) {
				if (!((Dog) aPet).getWasWalked()) {
					anArea.tick();
				}
				((Dog) aPet).noLongerWalked();
			}
		}
	}

	public int getDirty(Pet aPet) {
		Area anArea = shelter.get(aPet);
		return anArea.getDirty();
	}

	public void oilAll() {
		Collection<Pet> pets = getPets();
		for (Pet aPet : pets) {
			if (aPet instanceof Robot) {
				((Robot) aPet).oil();
			}
		}

	}

	public void feedAll() {
		Collection<Pet> pets = getPets();
		for (Pet aPet : pets) {
			if (aPet instanceof Animal) {
				((Animal) aPet).feed();
			}
		}

	}

	public void waterAll() {
		Collection<Pet> pets = getPets();
		for (Pet aPet : pets) {
			if (aPet instanceof Animal) {
				((Animal) aPet).water();
			}
		}
	}

	public void walkAll() {
		Collection<Pet> pets = getPets();
		for (Pet aPet : pets) {
			if (aPet instanceof Canine) {
				((Canine) aPet).walk();
			}
		}
	}

	public void emptyLitterBox() {
		litterBox.clean();
	}

	public void cleanCage(Pet aPet) {
		Area aCage = shelter.get(aPet);
		aCage.clean();

	}

}
