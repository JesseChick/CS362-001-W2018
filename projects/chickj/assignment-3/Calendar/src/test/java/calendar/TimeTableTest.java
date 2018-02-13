package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

// TIMEOUT ERRORS ARE OCCURRING. FIND TEST STUFF TO GET INTO PRIVATE METHODS TO TRY AND CUT DOWN ON RUNTIME AND IMPROVE COVERAGE.

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {
	@Test(expected=DateOutOfRangeException.class)
	public void test01() throws Throwable  {
		TimeTable tt = new TimeTable();
		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(new Appt(0, 0, 1, 1, 2018, "first", "first day of the year"));
		appts.add(new Appt(0, 0, 2, 1, 2018, "second", "second day of the year"));
		appts.add(new Appt(0, 0, 3, 1, 2018, "third", "third day of the year"));

		LinkedList<CalDay> days = tt.getApptRange(appts, new GregorianCalendar(2018, 1, 1), new GregorianCalendar(2018, 1, 8));
    // assertNotEquals(days.size(), 0);
		LinkedList<CalDay> badDays = tt.getApptRange(appts, new GregorianCalendar(2018, 1, 15), new GregorianCalendar(2018, 1, 8));
		// appts.add(new Appt(34, 0, 3, 20, 2018, "third", "third day of the year"));
		// badDays = tt.getApptRange(appts, new GregorianCalendar(2018, 1, 1), new GregorianCalendar(2018, 1, 8));


	}
	@Test
	public void test02() throws Throwable  {

		// STILL NEEDS WORK

		// TimeTable tt = new TimeTable();
		// Appt appt = new Appt(0, 0, 1, 1, 2018, "first", "first day of the year");
		// int[] rdays = {3,5,7};
		// appt.setRecurrence(rdays, 0, 0, 0);
		// LinkedList<GregorianCalendar> gcal = getApptOccurences(appt, new GregorianCalendar(2018, 1, 1), new GregorianCalendar(2018, 1, 8));
	}
	@Test // deleteAppt
	public void test03() throws Throwable  {
		TimeTable tt = new TimeTable();
		LinkedList<Appt> appts = new LinkedList<Appt>();

		Appt appt2 = new Appt(0, 0, 2, 1, 2018, "second", "second day of the year");
		Appt appt4 = new Appt(0, 0, 4, 1, 2018, "forth", "forth day of the year");
		appts.add(new Appt(0, 0, 1, 1, 2018, "first", "first day of the year"));
		appts.add(appt2);
		appts.add(new Appt(0, 0, 3, 1, 2018, "third", "third day of the year"));
		appts.add(appt4);

		Appt badappt = new Appt(-1, 21, 1, 6, 2018, "", "");
		assertFalse(badappt.getValid());
		assertNull(tt.deleteAppt(appts, badappt));

		appts = tt.deleteAppt(appts, appt2);
		appts = tt.deleteAppt(appts, appt4);

		assertNull(tt.deleteAppt(null, null));
		assertNull(tt.deleteAppt(appts, null)); // won't make a difference because of short circuiting.
		assertNull(tt.deleteAppt(null, appt2));


	}
	@Test(expected=java.lang.IllegalArgumentException.class)
	public void test04() throws Throwable  {
		TimeTable tt = new TimeTable();
		LinkedList<Appt> appts = new LinkedList<Appt>();

    Appt appt1 = new Appt(0, 0, 1, 1, 2018, "first", "first day of the year");
		Appt appt2 = new Appt(0, 0, 2, 1, 2018, "second", "second day of the year");
    Appt appt3 = new Appt(0, 0, 3, 1, 2018, "third", "third day of the year");
		// Appt appt4 = new Appt(0, 0, 4, 1, 2018, "forth", "forth day of the year");
		appts.add(appt1);
		appts.add(appt2);
		appts.add(appt3);
		// appts.add(appt4);

		int[] permutation = {1, 0, 2};
		appts = tt.permute(appts, permutation);

		appts = tt.deleteAppt(appts, appt2);
		appts = tt.permute(appts, permutation);

    // int[] perm = {1, 0};
    // LinkedList<Appt> pappt = tt.permute(appts, perm);
    // appts = tt.deleteAppt(appts, appt1);
    // appts = appts.add(appt1);
    // assertEquals(pappt, appts);

    int[] p = new int[1];
    p[0] = 0;

    appts = tt.deleteAppt(appts, appt1);
    appts = tt.permute(appts, p);

	}

}
