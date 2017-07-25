package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.*;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	 /*NOTE: All code used to generate a standard Gregorian Calendar object (including the TimeZone object)
	  * was copied from Oracle documentation demonstrating the classes. It can be found here
	  * https://docs.oracle.com/javase/7/docs/api/java/util/GregorianCalendar.html
	  */
	  public void test01()  throws Throwable  {
		 // get the supported ids for GMT-08:00 (Pacific Standard Time)
		 String[] ids = TimeZone.getAvailableIDs(-8 * 60 * 60 * 1000);
		 // if no ids were returned, something is wrong. get out.
		 if (ids.length == 0)
			 System.exit(0);

		 // begin output
		 System.out.println("Current Time");

		 // create a Pacific Standard Time time zone
		 SimpleTimeZone pdt = new SimpleTimeZone(-8 * 60 * 60 * 1000, ids[0]);

		 // set up rules for Daylight Saving Time
		 pdt.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
		 pdt.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);

		 // create a GregorianCalendar with the Pacific Daylight time zone
		 // and the current date and time
		 GregorianCalendar calendar = new GregorianCalendar(pdt);
		 Date trialTime = new Date();
		 calendar.setTime(trialTime);
		 CalDay tmrw = new CalDay(calendar);
		 Appt appt1 = new Appt(7, 32, 20, 06, 2016, "swiggity swooty", "Im on my way");
		 Appt appt2 = new Appt(-1, 32, 20, 06, 2016, "swiggity swooty", "Im on my way");
		 Appt appt3 = new Appt(8, 32, 20, 06, 2016, "swiggity swooty", "Im on my way");
		 Appt appt4 = new Appt(7, 32, 20, 06, 2016, "swiggity swooty", "Im on my way");
		 Appt appt5 = new Appt(7, 32, 20, 06, 2016, "swiggity swooty", "Im on my way");
		 System.out.println("IT IS" + appt1.getValid());
		 tmrw.addAppt(appt1);
		 tmrw.addAppt(appt2);
		 tmrw.addAppt(appt3);
		 CalDay apocalypse = new CalDay();
		 assertFalse(apocalypse.isValid());
		 assertEquals(3, tmrw.getSizeAppts());
		 System.out.println(appt2.toString());
		 System.out.println(tmrw.toString());
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 // get the supported ids for GMT-08:00 (Pacific Standard Time)
		 String[] ids = TimeZone.getAvailableIDs(-8 * 60 * 60 * 1000);
		 // if no ids were returned, something is wrong. get out.
		 if (ids.length == 0)
			 System.exit(0);

		 // begin output
		 System.out.println("Current Time");

		 // create a Pacific Standard Time time zone
		 SimpleTimeZone pdt = new SimpleTimeZone(-8 * 60 * 60 * 1000, ids[0]);

		 // set up rules for Daylight Saving Time
		 pdt.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
		 pdt.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);

		 // create a GregorianCalendar with the Pacific Daylight time zone
		 // and the current date and time
		 GregorianCalendar calendar = new GregorianCalendar(pdt);
		 Date trialTime = new Date();
		 calendar.setTime(trialTime);
		 CalDay tmrw = new CalDay(calendar);
		 CalDay apocalypse = new CalDay();
		 System.out.println(apocalypse.toString());
		 assertNull(apocalypse.iterator());
		 System.out.println(tmrw.iterator().hasNext());
		 LinkedList<Appt> appts = new LinkedList<Appt>();
		 Appt appt1 = new Appt(13,2,2,02,1992, "hello", "world");
		 Appt appt2 = new Appt(13,2,2,02,1992, "hello", "world");
		 appts.add(appt1);
		 appts.add(appt2);
	 }
//add more unit tests as you needed	
}
