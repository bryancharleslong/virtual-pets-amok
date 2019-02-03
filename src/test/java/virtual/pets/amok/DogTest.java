package virtual.pets.amok;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

import org.junit.Test;

import virtual.pets.amok.Dog;

public class DogTest {

	Dog underTest = new Dog("name", 10, 15, 20, 25, false);

	// name, health, boredom, hunger, thirst, wasWalked
	@Test
	public void getNameShouldReturnName() {
		String name = underTest.getName();
		assertThat(name, is("name"));
	}

	@Test
	public void gethHealthShouldReturn10() {
		int health = underTest.getHealth();
		assertThat(health, is(10));
	}

	@Test
	public void getBoredomShouldReturn15() {
		int boredom = underTest.getBoredom();
		assertThat(boredom, is(15));
	}

	@Test
	public void getHungerSholdReturn() {
		int hunger = underTest.getHunger();
		assertThat(hunger, is(20));
	}

	@Test
	public void getThirstShouldReturn25() {
		int thirst = underTest.getThirst();
		assertThat(thirst, is(25));
	}

	@Test
	public void getWasWalkedShouldReturnFalse() {
		boolean wasWalked = underTest.getWasWalked();
		assertThat(wasWalked, is(false));
	}

	@Test
	public void getWasWalkShouldReturnTrueAfterWalk() {
		underTest.walk();
		boolean wasWalked = underTest.getWasWalked();
		assertThat(wasWalked, is(true));
	}

	@Test
	public void feedShouldDecreaseHungerBy10() {
		underTest.feed();
		int hunger = underTest.getHunger();
		assertThat(hunger, is(10));
	}

	@Test
	public void waterShouldDecreaseThirstBy10() {
		underTest.water();
		int thirst = underTest.getThirst();
		assertThat(thirst, is(15));
	}

	@Test
	public void walkShouldDecreaseBoredomBy7() {
		underTest.walk();
		int boredom = underTest.getBoredom();
		assertThat(boredom, is(8));
	}

	@Test
	public void playShouldDecreaseBoredomBy15() {
		underTest.play();
		int boredom = underTest.getBoredom();
		assertThat(boredom, is(0));

	}

	@Test
	public void dogShouldExtendAnimal() {
		assertThat(underTest, instanceOf(Animal.class));
	}

	@Test
	public void dogShouldImplementCanine() {
		assertThat(underTest, instanceOf(Canine.class));
	}

}
