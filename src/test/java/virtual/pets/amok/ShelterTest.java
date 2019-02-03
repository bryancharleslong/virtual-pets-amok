package virtual.pets.amok;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.util.Collection;

import org.junit.Test;

public class ShelterTest {
	Shelter underTest = new Shelter();
	Dog dog = new Dog("doggy", 10, 15, 20, 25, false);
	Cat cat = new Cat("kitty", 10, 15, 20, 25);
	RoboCat roboCat = new RoboCat("roggy", 10, 15, 20);
	RoboDog roboDog = new RoboDog("ritty", 10, 15, 20);
	Cage cage = new Cage();
	Cage cageA = new Cage();
	LitterBox litterBox = new LitterBox();
	
	@Test
	public void canIntakeDogIntoCage() {
		underTest.intake(dog,cage);
		underTest.intake(roboDog, cage);
		Collection<Pet> pets = underTest.getPets();
		assertThat(pets,containsInAnyOrder(dog,roboDog));
	}
	@Test
	public void cannotIntakeCatIntoCage() {
		underTest.intake(cat,cage);
		underTest.intake(roboCat, cage);
		Collection<Pet> pets = underTest.getPets();
		assertThat(pets,not(contains(cat)));
		assertThat(pets,not(contains(roboCat)));
	}
	@Test
	public void canIntakeCateIntoLitterBoxArea() {
		underTest.intake(cat,litterBox);
		underTest.intake(roboCat, litterBox);
		Collection<Pet> pets = underTest.getPets();
		assertThat(pets,containsInAnyOrder(cat,roboCat));
	}
	@Test
	public void cannotIntakeDogIntoLitterBox() {
		underTest.intake(dog,litterBox);
		underTest.intake(roboDog, litterBox);
		Collection<Pet> pets = underTest.getPets();
		assertThat(pets,not(contains(dog)));
		assertThat(pets,not(contains(roboDog)));
	}
	@Test
	public void canAdoptAPetOutOfShelter() {
		underTest.intake(cat,litterBox);
		underTest.intake(dog,cage);
		underTest.adopt(dog);
		Collection<Pet> pets = underTest.getPets();
		assertThat(pets,not(contains(dog)));
		assertThat(pets,contains(cat));
	}
	
	
}
