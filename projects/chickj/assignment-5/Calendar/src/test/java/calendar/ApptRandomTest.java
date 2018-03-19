package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
* Random Test Generator  for Appt class.
*/

public class ApptRandomTest {
	private static final long TestTimeout = 3000;//60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	* Return a randomly selected method to be tests !.
	*/
	public static String RandomSelectMethod(Random random) {
		String[] methodArray = new String[] {"isValid", "setRecurDays"};//{"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class
		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n]; // return the method name
	}

	/**
	* Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	*/
	public static int RandomSelectRecur(Random random) {
		int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly
		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)

		return RecurArray[n]; // return the value of the  appointments to recur
	}

	/**
	* Return a randomly selected appointments to recur forever or Never recur  !.
	*/
	public static int RandomSelectRecurForEverNever(Random random) {
		int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER
		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)

		return RecurArray[n]; // return appointments to recur forever or Never recur
	}
	/**
	* Generate Random Tests that tests Appt Class.
	*/
	@Test
	//(expected=java.lang.ArrayIndexOutOfBoundsException.class)
	public void radnomtest()  throws Throwable  {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				int startHour=ValuesGenerator.RandInt(random);
				int startMinute=ValuesGenerator.RandInt(random);
				int startDay=ValuesGenerator.RandInt(random);;
				int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear=ValuesGenerator.RandInt(random);
				String title="Birthday Party";
				String description="This is my birthday party.";
				//Construct a new Appointment object with the initial data
				Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

				if(!appt.getValid()) continue;

				for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);

					if (methodName.equals("setTitle")){
						// String newTitle=(String) ValuesGenerator.getString(random);
						//
						// appt.setTitle(newTitle);
					} else if (methodName.equals("setRecurrence")){
						// int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						// int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						// int recur=ApptRandomTest.RandomSelectRecur(random);
						// int recurIncrement = ValuesGenerator.RandInt(random);
						// int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						//
						// appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
					} else if (methodName.equals("isValid")) {
            boolean badCase = false;

            startHour = ValuesGenerator.getRandomIntBetween(random, -5, 29);
            if (startHour < 0 || startHour > 23)
              badCase = true;
            appt.setStartHour(startHour);
            if (badCase)
              appt.setStartHour(12);

            badCase = false;
            startMinute = ValuesGenerator.getRandomIntBetween(random, -5, 65);
            if (startMinute < 0 || startMinute > 59)
              badCase = true;
            appt.setStartMinute(startMinute);
            if (badCase)
              appt.setStartMinute(30);

            badCase = false;
            int randMonthIdx = ValuesGenerator.getRandomIntBetween(random, 0, 11);
            int daysInMonth = CalendarUtil.NumDaysInMonth(2018, randMonthIdx);
            startDay = ValuesGenerator.getRandomIntBetween(random, -4, daysInMonth+5);
            // appt.setStartMonth(1);
            // startDay = ValuesGenerator.getRandomIntBetween(random, -4, 35);
            if (startDay < 1 || startDay > daysInMonth)
              badCase = true;
            appt.setStartDay(startDay);
            if (badCase)
              appt.setStartDay(15);

            // appt.setStartDay(-1);
            // appt.setStartDay(32);
            // appt.setStartDay(15);

						// appt.setStartHour(-1);
						// appt.setStartHour(24);
						// appt.setStartHour(12);
            //
						// appt.setStartMinute(-1);
						// appt.setStartMinute(60);
						// appt.setStartMinute(30);
            //
						// appt.setStartDay(-1);
						// appt.setStartDay(32);
						// appt.setStartDay(15);

						// appt.setStartMonth(-1);
						// appt.setStartMonth(13);
						// appt.setStartMonth(6);
					} else if (methodName.equals("setRecurDays")) {
						int sizeArray = ValuesGenerator.getRandomIntBetween(random, -1, 8);
						int[] recurDays = (sizeArray == -1) ? null : ValuesGenerator.generateRandomArray(random, sizeArray);
						appt.setRecurrence(recurDays, 0, 0, 0);
					}
				}

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration%10000)==0 && iteration!=0)
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}
		} catch (NullPointerException e) {}

		System.out.println("Done testing...");
	}
}