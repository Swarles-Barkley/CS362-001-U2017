package calendar;

import java.util.Calendar;
import java.util.Random;
import org.junit.Test;
import java.util.GregorianCalendar;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1;
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 System.out.println("Start CalDay testing...");
		 GregorianCalendar calendar = new GregorianCalendar(2017, 8, 17, 4, 31);
		 try{
		 	for(int iteration = 0; elapsed<TestTimeout; iteration++){
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
				//Construct a new Appointment object with the initial data
				Appt appt = new Appt(startHour,
						startMinute ,
						startDay ,
						startMonth ,
						startYear ,
						title,
						description);
				Appt appt2 = new Appt(startHour-1,
						startMinute ,
						startDay ,
						startMonth ,
						startYear ,
						title,
						description);
				//if(!appt.getValid())continue;
				CalDay today = new CalDay(calendar);
				today.addAppt(appt);
				today.addAppt(appt2);//NOTE: as discovered while building test cases, addAppt stores object *directly*, not as a copy.
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%100000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}
		 } catch(NullPointerException e){

		 }
		 
		 
	 }


	
}
