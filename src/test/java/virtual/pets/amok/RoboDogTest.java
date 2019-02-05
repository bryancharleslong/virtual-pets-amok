package virtual.pets.amok;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class RoboDogTest {
	RoboDog underTest = new RoboDog("name", 10, 15, 20);
	// name, unhealthy, boredom, oilNeed
	
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
	public void getOilNeedReturn20() {
		int oilNeed = underTest.getOilNeed();
		assertThat(oilNeed,is(20));
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
	public void oilShouldDecreaseOilNeedBy20() {
		underTest.oil();
		int oilNeed = underTest.getOilNeed();
		assertThat(oilNeed,is(0));
	}
}
