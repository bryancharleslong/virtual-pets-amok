package virtual.pets.amok;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

public class ShelterTest {
	Shelter underTest = new Shelter();
	Dog dog = new Dog("doggy", 10, 15, 20, 25, false);
	Dog dog2 = new Dog("doggy2", 10, 15, 20, 25, true);
	Cat cat = new Cat("kitty", 10, 15, 20, 25);
	Cat cat2 = new Cat("kitty2", 10, 15, 20, 25);
	Cat cat3 = new Cat("three", 0, 0, 0, 0);
	RoboCat roboCat = new RoboCat("roggy", 10, 15, 10);
	RoboDog roboDog = new RoboDog("ritty", 10, 15, 25);

	@Test
	public void canIntakeDogIntoCage() {
		underTest.intake(dog);
		underTest.intake(roboDog);
		Collection<Pet> pets = underTest.getPets();
		assertThat(pets, containsInAnyOrder(dog, roboDog));
	}

	@Test
	public void cannotIntakeCatIntoCage() {
		underTest.intake(cat);
		underTest.intake(roboCat);
		Collection<Pet> pets = underTest.getPets();
		assertThat(pets, not(contains(cat)));
		assertThat(pets, not(contains(roboCat)));
	}

	@Test
	public void canIntakeCatsIntoLitterBoxArea() {
		underTest.intake(cat);
		underTest.intake(roboCat);
		Area areaA = underTest.getArea(cat);
		Area areaB = underTest.getArea(roboCat);
		assertTrue(areaA.equals(areaB));
	}

	@Test
	public void intakeCaninesGoToDifferentCages() {
		underTest.intake(dog);
		underTest.intake(roboDog);
		Area areaA = underTest.getArea(dog);
		Area areaB = underTest.getArea(roboDog);
		assertFalse(areaA.equals(areaB));

	}

	@Test
	public void canAdoptAPetOutOfShelter() {
		underTest.intake(cat);
		underTest.intake(dog);
		underTest.adopt(dog);
		Collection<Pet> pets = underTest.getPets();
		assertThat(pets, not(contains(dog)));
		assertThat(pets, contains(cat));
	}

	@Test
	public void litterBoxStartsWith0dirty() {
		underTest.intake(cat);
		int dirty = underTest.getLitterBoxDirty();
		assertThat(dirty, is(0));
	}

	@Test
	public void tickWithOneCatInLitterBoxIncreasesDirtyBy1() {
		underTest.intake(cat);
		underTest.intake(roboCat);
		underTest.intake(dog);
		underTest.intake(roboDog);
		underTest.tick();
		int dirty = underTest.getLitterBoxDirty();
		assertThat(dirty, is(1));
	}

	@Test
	public void tickWithTwoCatsInLitterBoxIncreasesDirtyBy2() {
		underTest.intake(cat);
		underTest.intake(roboCat);
		underTest.intake(dog);
		underTest.intake(cat2);
		underTest.tick();
		int dirty = underTest.getLitterBoxDirty();
		assertThat(dirty, is(2));
	}

	@Test
	public void twoTicksShouldIncreaseEachDogsCageDirtyBy2IfNotWalked() {
		underTest.intake(dog);
		underTest.intake(roboDog);
		underTest.intake(dog2);
		underTest.tick();
		underTest.tick();
		assertThat(underTest.getDirty(dog), is(2));
		assertThat(underTest.getDirty(roboDog), is(0));
		assertThat(underTest.getDirty(dog2), is(1));
	}

	@Test
	public void oilAllShouldReduceRobotsOilNeedBy20() {
		underTest.intake(cat);
		underTest.intake(roboCat);
		underTest.intake(roboDog);
		underTest.oilAll();
		assertThat(roboCat.getOilNeed(), is(0));
		assertThat(roboDog.getOilNeed(), is(5));
	}

	@Test
	public void tickShouldIncreaseOilNeedOfRobotsBy1() {
		underTest.intake(dog);
		underTest.intake(cat);
		underTest.intake(roboCat);
		underTest.intake(roboDog);
		underTest.tick();
		assertThat(roboCat.getOilNeed(), is(11));
		assertThat(roboDog.getOilNeed(), is(26));
	}

	@Test
	public void tickShouldIncreaseBoredomBy1() {
		underTest.intake(dog);
		underTest.intake(cat);
		underTest.intake(roboCat);
		underTest.intake(roboDog);
		underTest.tick();
		assertThat(cat.getBoredom(), is(16));
		assertThat(dog.getBoredom(), is(16));
		assertThat(roboCat.getBoredom(), is(16));
		assertThat(roboDog.getBoredom(), is(16));
	}

	@Test
	public void tickShouldIncreaseHungerAndThirstOfAnimalsby1() {
		underTest.intake(dog);
		underTest.intake(cat);
		underTest.intake(roboCat);
		underTest.intake(roboDog);
		underTest.tick();
		assertThat(cat.getHunger(), is(21));
		assertThat(cat.getThirst(), is(26));
		assertThat(dog.getHunger(), is(21));
		assertThat(dog.getThirst(), is(26));
	}

	@Test
	public void feedAllShouldDecreaseHungerBy15() {
		underTest.intake(dog);
		underTest.intake(cat);
		underTest.intake(roboCat);
		underTest.intake(roboDog);
		underTest.feedAll();
		assertThat(cat.getHunger(), is(5));
		assertThat(dog.getHunger(), is(5));
	}

	@Test
	public void waterAllShouldDecreaseThirstBy15() {
		underTest.intake(dog);
		underTest.intake(cat);
		underTest.intake(roboCat);
		underTest.intake(roboDog);
		underTest.waterAll();
		assertThat(cat.getThirst(), is(10));
		assertThat(dog.getThirst(), is(10));
	}

	@Test
	public void cleanLitterBoxShouldCleanTheLitterBox() {
		underTest.intake(cat);
		underTest.tick();
		underTest.tick();
		assertThat(underTest.getLitterBoxDirty(), is(2));
		underTest.emptyLitterBox();
		assertThat(underTest.getLitterBoxDirty(), is(0));
	}

	@Test
	public void cleanCageShouldReturnDirty0ForCage() {
		underTest.intake(dog);
		underTest.intake(dog2);
		underTest.intake(dog);
		underTest.intake(roboDog);
		underTest.intake(dog2);
		underTest.tick();
		underTest.tick();
		assertThat(underTest.getDirty(dog), is(2));
		underTest.cleanCage(dog);
		assertThat(underTest.getDirty(dog), is(0));
	}

	@Test
	public void animalUnhealthyDecreasesIfStatsBelow50() {
		underTest.intake(dog);
		underTest.intake(cat);
		underTest.intake(roboDog);
		underTest.intake(roboCat);
		underTest.tick();
		assertThat(dog.getUnhealthy(), is(9));
		assertThat(cat.getUnhealthy(), is(9));
		assertThat(roboDog.getUnhealthy(), is(9));
		assertThat(roboCat.getUnhealthy(), is(9));
	}

	@Test
	public void animalUnhealthyIncreasesForEachStatAbove50() {
		Dog hungryDog = new Dog("hungry", 10, 10, 70, 10, true);
		Cat thirstyCat = new Cat("thirsty", 10, 10, 10, 70);
		RoboDog oilDog = new RoboDog("oil", 10, 10, 70);
		RoboCat boredCat = new RoboCat("bored", 10, 70, 10);
		Cat sickCat = new Cat("sick", 10, 70, 70, 70);
		underTest.intake(hungryDog);
		underTest.intake(thirstyCat);
		underTest.intake(oilDog);
		underTest.intake(boredCat);
		underTest.intake(sickCat);
		underTest.tick();
		assertThat(hungryDog.getUnhealthy(), is(11));
		assertThat(thirstyCat.getUnhealthy(), is(11));
		assertThat(oilDog.getUnhealthy(), is(11));
		assertThat(boredCat.getUnhealthy(), is(11));
		assertThat(sickCat.getUnhealthy(), is(13));
	}

	@Test
	public void dogWithDirtyCageWillIncreaseUnhealthy() {
		underTest.intake(dog);
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		assertThat(dog.getUnhealthy(), is(2));
	}

	@Test
	public void catsWithDirtyLitterBoxWillIncreaseUnhealthy() {
		Shelter underTest2 = new Shelter();
		underTest2.intake(cat);
		underTest2.intake(cat2);
		underTest2.intake(cat3);
		underTest2.intake(roboCat);
		underTest2.intake(dog);
		underTest2.tick();
		System.out.println(cat.getUnhealthy());
		underTest2.tick();
		System.out.println(cat.getUnhealthy());
		underTest2.tick();
		System.out.println(cat.getUnhealthy());
		underTest2.tick();
		System.out.println(cat.getUnhealthy());
		underTest2.tick();
		System.out.println(cat.getUnhealthy());
		underTest2.tick();
		System.out.println(cat.getUnhealthy());
		underTest2.tick();
		System.out.println(cat.getUnhealthy());
		underTest2.tick();
		System.out.println(cat.getUnhealthy());
		underTest2.tick();
		System.out.println(cat.getUnhealthy());
		assertThat(cat.getUnhealthy(),is(5));
	}

}
