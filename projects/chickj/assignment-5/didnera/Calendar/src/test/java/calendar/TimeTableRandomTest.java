package calendar;

import java.util.*;
import java.util.Random;

import org.junit.Test;
import static org.junit.Assert.*;

/**
* Random Test Generator  for TimeTable class.
*/
public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	* Return a randomly selected method to be tests !.
	*/
	public static String RandomSelectMethod(Random random) {
		String[] methodArray = new String[] {"deleteAppt", "getApptRange"};//{"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class
		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n]; // return the method name
	}

	/**
	* Generates random GregorianCalendar days
	*/
	public static GregorianCalendar RandomGCDay(Random random, int num) {
		// GregorianCalendar(int year, int month, int dayOfMonth, int hourOfDay, int minute)
		int year = 2018;
		int month;
		if (num == 0) {
			month = ValuesGenerator.getRandomIntBetween(random, 1, 9);
		} else if (num == 1) {
			month = ValuesGenerator.getRandomIntBetween(random, 1, 5);
		} else {
			month = ValuesGenerator.getRandomIntBetween(random, 7, 9);
		}
		int dayOfMonth = ValuesGenerator.getRandomIntBetween(random, 1, 29);
		return new GregorianCalendar(year, month, dayOfMonth);
	}

	/**
	* Generate Random Tests that tests TimeTable Class.
	*/
	@Test
	public void radnomtest() throws Throwable {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		System.out.println("Start testing...");
		// int tries=0;
		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {

				long randomseed = System.currentTimeMillis();
				Random random = new Random(randomseed);
				String methodName = TimeTableRandomTest.RandomSelectMethod(random);

				TimeTable tt = new TimeTable();
				LinkedList<Appt> appts = new LinkedList<Appt>();
				LinkedList<Appt> toDelete = new LinkedList<Appt>();

				for (int i=0; i<100; i++) {
					int startHour=ValuesGenerator.RandInt(random);
					int startMinute=ValuesGenerator.RandInt(random);
					int startDay=ValuesGenerator.RandInt(random);
					int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
					int startYear=2018;
					String title=ValuesGenerator.getString(random);
					String description=ValuesGenerator.getString(random);
					Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

					appts.add(appt);
					if (ValuesGenerator.RandInt(random) % 5 == 0) {
						toDelete.add(appt);
					}
				}

				// if (methodName.equals("deleteAppt")) { // for some reason this was causing problems...
				if (ValuesGenerator.RandInt(random) % 2 == 0) {
					if (ValuesGenerator.getRandomIntBetween(random, 0, 100) == 0) {
						if (elapsed % 2 == 0) {
							appts = tt.deleteAppt(null, null);
						} else {
							appts = tt.deleteAppt(appts, null);
						}
						continue;
					} else {
						for (int i=0; i<toDelete.size(); i++) {
							if (ValuesGenerator.getRandomIntBetween(random, 0, 100) == 0) {
								appts = tt.deleteAppt(appts, null);
							} else {
								appts = tt.deleteAppt(appts, toDelete.get(i));
							}
						}
					}
				} else {
				// else if (methodName.equals("getApptRange")) {
					for (int i=0; i<10; i++) {
						// tries++;
						int d1 = 1, d2 = 2;
						if (elapsed > 27000 && ValuesGenerator.getRandomIntBetween(random, 0, 100) == 0) {
							d1 = 0;
							d2 = 0;
						}
						GregorianCalendar day1 = RandomGCDay(random, d1);
						GregorianCalendar day2 = RandomGCDay(random, d2);
						tt.getApptRange(appts, day1, day2);
					}
				}

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration%10000)==0 && iteration!=0)
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}
		} catch (DateOutOfRangeException e) {}

		System.out.println("Done testing...");
	}
}
