package virtual.pets.amok;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class CatTest {
	Cat underTest = new Cat("name", 10, 15, 20, 25);

	// name, unhealthy, boredom, hunger, thirst
	@Test
	public void getNameShouldReturnName() {
		String name = underTest.getName();
		assertThat(name, is("name"));
	}

	@Test
	public void gethHealthShouldReturn10() {
		int health = underTest.getUnhealthy();
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
	public void feedShouldDecreaseHungerBy15() {
		underTest.feed();
		int hunger = underTest.getHunger();
		assertThat(hunger, is(5));
	}

	@Test
	public void waterShouldDecreaseThirstBy15() {
		underTest.water();
		int thirst = underTest.getThirst();
		assertThat(thirst, is(10));

	}

	@Test
	public void playShouldDecreaseBoredomBy15() {
		underTest.play();
		int boredom = underTest.getBoredom();
		assertThat(boredom, is(0));

	}
	@Test
	public void shouldBeExtentionOfAnimal() {
		assertThat(underTest,instanceOf(Animal.class));
	}

}
