package calendar;
/**
*  This class provides a basic set of test cases for the
*  Appt class.
*/
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
	// ASSIGNMENT 2
	@Test
	public void test01()  throws Throwable  {
		// Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		Appt appt = new Appt(0, 0, 1, 1, 2018, "first", "first day of the year");
		assertTrue(appt.getValid());
	}

	// Tests isValid
	@Test(expected=java.lang.ArrayIndexOutOfBoundsException.class)
	public void test02()  throws Throwable  {
		Appt appt = new Appt(0, 0, 1, 1, 2018, "first", "first day of the year");

		appt.setStartHour(25);
		assertFalse(appt.getValid());
		appt.setStartHour(30);
		appt.setStartHour(12);

		appt.setStartMinute(-1);
		assertFalse(appt.getValid());
		appt.setStartMinute(66);
		appt.setStartMinute(30);

		appt.setStartDay(35);
		assertFalse(appt.getValid());
		appt.setStartDay(20);

		// appt.setStartYear(-1242);
		// assertFalse(appt.getValid());

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

	@Test
	public void test04()  throws Throwable  {
		Appt appt1 = new Appt(21, 30, 15, 01, 2018, "title", "desc");
		appt1.setDescription(null);
		appt1.setTitle(null);
		// assertEquals(appt1.toString(), null);
		Appt appt2 = new Appt(22, 29, 16, 02, 2017, "Kickback", "Hanging with the fellas.");

		assertEquals(appt2.compareTo(appt1), 1);
	}

	// ASSIGNMENT 3
	@Test
	public void test05() throws Throwable {
		Appt appt = new Appt(1, 1, 1, 1, 2018, "first", "first day of the year");
		assertEquals(appt.getTitle(), "first");
		assertEquals(appt.getDescription(), "first day of the year");

		int[] rdays = new int[0];
		appt.setRecurrence(rdays, Appt.RECUR_BY_MONTHLY, 1, Appt.RECUR_NUMBER_NEVER);
		assertEquals(appt.getRecurDays(), rdays);
		assertEquals(appt.getRecurBy(), Appt.RECUR_BY_MONTHLY);
		assertEquals(appt.getRecurIncrement(), 1);
		assertEquals(appt.getRecurNumber(), Appt.RECUR_NUMBER_NEVER);

		appt.setStartHour(23);
		assertTrue(appt.getValid());
	}
	@Test
	public void test06() throws Throwable {
		Appt appt = new Appt(1, 1, 1, 1, 2018, "first", "first day of the year");
		appt.setStartHour(23);
		assertTrue(appt.getValid());
		appt.setStartMinute(59);
		assertTrue(appt.getValid());
		appt.setStartMonth(12);
		assertTrue(appt.getValid());
		appt.setStartDay(CalendarUtil.NumDaysInMonth(appt.getStartYear(), appt.getStartMonth()-1));
		assertTrue(appt.getValid());

		String str = appt.toString();
		assertNotNull(str);
		// assertTrue(appt.getValid());
		appt.setStartHour(11);
		str = appt.toString();
		assertTrue(str.contains("am ,"));
		// appt.setStartHour(11);
		// str = appt.toString();
		// assertTrue(str.contains("-1"));
		appt.setStartHour(0);
		str = appt.toString();
		assertTrue(str.contains(" at 12"));
		// appt.setStartHour()

		appt.setStartHour(-1);
		appt.toString();
		// Appt bad = new Appt(-1,-1,-1,-1,2018, "asfd", "sfasdfa");
		// try {
		// 	bad.toString();
		// } catch (Exception e) {
		// 	assertTrue(e.getMessage().contains("Exception"));
		// }
	}
}
