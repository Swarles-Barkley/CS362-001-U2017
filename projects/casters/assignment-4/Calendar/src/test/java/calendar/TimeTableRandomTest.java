package calendar;

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Random;
import java.util.LinkedList;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1;
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 System.out.println("Start TimeTable testing...");
		 GregorianCalendar calendar = new GregorianCalendar(2017, 8, 17, 4, 31);
		 GregorianCalendar tomorrow = new GregorianCalendar(2017, 9, 27, 5, 32);
		 LinkedList<Appt> throwaway = new LinkedList<Appt>();
		 TimeTable tt = new TimeTable();
		 try{
		 	tt.getApptRange(throwaway, tomorrow, calendar);
		 }
		 catch(DateOutOfRangeException e){

		 }
		 try{
		 	for(int iteration = 0; elapsed<TestTimeout; iteration++){
				LinkedList<Appt> throwaway2 = new LinkedList<Appt>();
				long randomseed =System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				int startHour=ValuesGenerator.getRandomIntBetween(random, 0, 30);
				int startMinute=ValuesGenerator.RandInt(random);
				int startDay=ValuesGenerator.RandInt(random);;
				int startMonth=ValuesGenerator.RandInt(random);;
				int startYear=ValuesGenerator.RandInt(random);
				String title="Birthday Party";
				String description="This is my birthday party.";
				LinkedList<CalDay> days = new LinkedList<CalDay>();
				//Construct a new Appointment object with the initial data
				Appt appt = new Appt(startHour,
						startMinute ,
						startDay ,
						startMonth ,
						startYear ,
						title,
						description);
				int[] anArray={2,3,4};
				appt.setRecurrence( anArray, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
				Appt appt2 = new Appt(startHour-1,
						startMinute ,
						startDay ,
						startMonth ,
						startYear ,
						title,
						description);
				Appt appt3 = new Appt(-1,
						startMinute ,
						startDay ,
						startMonth ,
						startYear ,
						title,
						description);
				//if(!appt.getValid())continue;
				CalDay today = new CalDay(calendar);
				tt.deleteAppt(today.getAppts(), appt);
				throwaway2.add(appt3);
				tt.getApptRange(throwaway2, calendar, tomorrow);
				today.addAppt(appt);
				today.addAppt(appt2);
				today.addAppt(appt3);
				days = tt.getApptRange(today.getAppts(), calendar, tomorrow);
				tt.deleteAppt(today.getAppts(), appt);
				tt.deleteAppt(today.getAppts(), appt3);
				tt.deleteAppt(null, appt);
				tt.deleteAppt(today.getAppts(), null);

		 		elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
				if((iteration%10000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}
		 }catch(NullPointerException e){

		 }
	 }


	
}
