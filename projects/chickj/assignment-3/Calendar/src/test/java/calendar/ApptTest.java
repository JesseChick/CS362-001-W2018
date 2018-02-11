package calendar;
/**
*  This class provides a basic set of test cases for the
*  Appt class.
*/
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
	/**
	* Test that the gets methods work as expected.
	*/
	@Test
	public void test01()  throws Throwable  {
		// Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		Appt appt = new Appt(0, 0, 1, 1, 2018, "first", "first day of the year");

		// assertions
		assertTrue(appt.getValid());
	}

	// Tests isValid
	@Test(expected=java.lang.ArrayIndexOutOfBoundsException.class)
	public void test02()  throws Throwable  {
		Appt appt = new Appt(0, 0, 1, 1, 2018, "first", "first day of the year");

		appt.setStartHour(-1);
		appt.setStartHour(30);
		appt.setStartHour(12);

		appt.setStartMinute(-1);
		appt.setStartMinute(66);
		appt.setStartMinute(30);

		appt.setStartDay(35);
		appt.setStartDay(20);

		appt.setStartMonth(-1);
		appt.setStartMonth(7);
		appt.setStartMonth(14);
		appt.setStartMonth(6);
	}

	// Tests recur stuff
	@Test
	public void test03()  throws Throwable  {
		Appt appt = new Appt(0, 0, 0, 1, 2017, "NY", "First moment of 2018");
		appt.setStartYear(2018);
		appt.setRecurrence(null, 0, 0, 1);
		int[] rdays = {3,4,5};
		appt.setRecurrence(rdays, 0, 0, 1);
		assertEquals(appt.getRecurDays(), rdays);
		// assertEquals(null, appt.getRecurDays());
		assertTrue(appt.isRecurring());
		assertEquals(0, appt.getRecurBy());
		assertEquals(1, appt.getRecurNumber());
		assertEquals(0, appt.getRecurIncrement());
	}
	//add more unit tests as you needed

	@Test
	public void test04()  throws Throwable  {
		Appt appt1 = new Appt(21, 30, 15, 01, 2018, "title", "desc");
		appt1.setDescription(null);
		appt1.setTitle(null);
		// assertEquals(appt1.toString(), null);
		Appt appt2 = new Appt(22, 29, 16, 02, 2017, "Kickback", "Hanging with the fellas.");

		assertEquals(appt2.compareTo(appt1), 1);


	}

}
