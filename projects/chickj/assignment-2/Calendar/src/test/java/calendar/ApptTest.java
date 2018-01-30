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
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		// assertions
		assertTrue(appt.getValid());
		assertEquals(21, appt.getStartHour());
		assertEquals(30, appt.getStartMinute());
		assertEquals(15, appt.getStartDay());
		assertEquals(01, appt.getStartMonth());
		assertEquals(2018, appt.getStartYear());
		assertEquals("Birthday Party", appt.getTitle());
		assertEquals("This is my birthday party.", appt.getDescription());
	}

	// Tests isValid
	@Test(expected=java.lang.ArrayIndexOutOfBoundsException.class)
	public void test02()  throws Throwable  {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

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
		Appt appt = new Appt(0, 0, 0, 1, 2018, "NY", "First moment of 2018");
		appt.setRecurrence(null, 0, 0, 1);
		// assertEquals(null, appt.getRecurDays());
		assertTrue(appt.isRecurring());
		assertEquals(0, appt.getRecurBy());
		assertEquals(1, appt.getRecurNumber());
		assertEquals(0, appt.getRecurIncrement());
	}
	//add more unit tests as you needed

	@Test
	public void test04()  throws Throwable  {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		Appt appt2 = new Appt(22, 29, 16, 02, 2017, "Kickback", "Hanging with the fellas.");

		// appt1.compareTo(appt2);
		assertEquals(appt2.compareTo(appt1), 1);

	}

}
