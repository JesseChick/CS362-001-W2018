package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {
	@Test
	public void test01()  throws Throwable  {
		CalDay defaultDay = new CalDay();
		assertFalse(defaultDay.isValid());
		// GregorianCalendar(int year, int month, int dayOfMonth, int hourOfDay, int minute)
		CalDay day1 = new CalDay(new GregorianCalendar(2018, 1, 4, 0, 0));
		assertTrue(day1.isValid());

		Appt appt1 = new Appt(0, 0, 1, 1, 2018, "first", "first day of the year");
		Appt appt2 = new Appt(0, 0, 2, 1, 2018, "second", "second day of the year");
		Appt appt3 = new Appt(0, 0, 3, 1, 2018, "third", "third day of the year");
		day1.addAppt(appt1);
		appt3.setStartHour(3);
		day1.addAppt(appt3);
		day1.addAppt(appt2);

		assertEquals(day1.getSizeAppts(), 3);
		assertEquals(day1.getDay(), 4);
		assertEquals(day1.getMonth(), 1);
		assertEquals(day1.getYear(), 2018);

		assertNull(defaultDay.iterator());
		day1.iterator();
	}
	@Test
	public void test02()  throws Throwable  {
		CalDay defaultDay = new CalDay();
		defaultDay.toString();

		CalDay day1 = new CalDay(new GregorianCalendar(2018, 1, 4, 0, 0));
		Appt appt1 = new Appt(0, 0, 1, 1, 2018, "first", "first day of the year");
		Appt appt2 = new Appt(0, 0, 2, 1, 2018, "second", "second day of the year");
		Appt appt3 = new Appt(0, 0, 3, 1, 2018, "third", "third day of the year");
		day1.addAppt(appt1);
		day1.addAppt(appt3);
		day1.addAppt(appt2);

		day1.toString();
	}
}
