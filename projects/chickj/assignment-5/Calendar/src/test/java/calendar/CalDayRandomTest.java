package calendar;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
* Random Test Generator  for CalDay class.
*/
public class CalDayRandomTest {
	private static final long TestTimeout = 3000;//60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=10;

	/**
	* Generate Random Tests that tests CalDay Class.
	*/
	@Test
	public void radnomtest()  throws Throwable  {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis();
				Random random = new Random(randomseed);

				GregorianCalendar gCal = new GregorianCalendar();
				CalDay day = new CalDay(gCal);

				for (int i = 0; i < NUM_TESTS; i++) {
					int startHour=ValuesGenerator.RandInt(random);//getRandomIntBetween(random, 1, 11);
					int startMinute=ValuesGenerator.RandInt(random);
					int startDay=ValuesGenerator.RandInt(random);
					int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
					int startYear=ValuesGenerator.RandInt(random);
					String title="Appt";
					String description="Appointment";
					Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
					day.addAppt(appt);
				}

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration%100000)==0 && iteration!=0)
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}
		} catch (NullPointerException e) {}

		System.out.println("Done testing...");
	}
}
