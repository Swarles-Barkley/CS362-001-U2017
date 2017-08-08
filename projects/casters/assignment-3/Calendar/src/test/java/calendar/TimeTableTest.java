//package java.calendar;
package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
	 	try {
			Calendar rightnow = Calendar.getInstance();
			//current month/year/date is today
			int thisMonth = rightnow.get(Calendar.MONTH) + 1;
			int thisYear = rightnow.get(Calendar.YEAR);
			int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
			GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
			GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
			tomorrow.add(Calendar.DAY_OF_MONTH, 3);
			LinkedList<Appt> appts = new LinkedList<Appt>();
			LinkedList<Appt> appts2 = new LinkedList<Appt>();
			LinkedList<CalDay> days = new LinkedList<CalDay>();
			int[] arr = {4,5,6};
			int[] pv = {};
			int[] pv2 = {2,1,0};
			TimeTable tt = new TimeTable();
			//tt.permute(appts, pv);
			//days = tt.getApptRange(appts, today, tomorrow);

			Appt appt1 = new Appt(23, 2, 10, 11, 2016, "hello", "world");
			Appt appt2 = new Appt(23, 2, thisDay, thisMonth, thisYear, "world", "hello");
			Appt appt3 = new Appt(23, 2, thisDay, thisMonth, thisYear, "hello", "world");
			Appt appt4 = new Appt(23, 2, thisDay, thisMonth, thisYear, "hello", "world");
			appt1.setRecurrence(arr, Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);
			appt2.setRecurrence(arr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_NEVER);
			appt3.setRecurrence(arr, Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);
			appt4.setRecurrence(arr, Appt.RECUR_BY_MONTHLY, -1, Appt.RECUR_NUMBER_FOREVER);
			appts.add(appt1);
			appts.add(appt2);
			appts.add(appt3);
			//appts.add(appt4);
            System.out.println(appt2.getValid());
			days = tt.getApptRange(appts, today, tomorrow);
			for(int i = 0; i<days.size(); i++){
			    System.out.println(days.get(i).toString());
            }
            assertEquals(3,days.size());
            System.out.println("trace");
			//appts = tt.deleteAppt(appts, appt4);
			days = tt.getApptRange(appts, today, tomorrow);
			assertEquals(4,appts.size()); //number stays the same since days doesn't have invalid appt (appt1)
            assertEquals(3, days.size());
            System.out.println("trace");
            assertNull(tt.deleteAppt(appts,appt4));
			appts = tt.permute(appts, pv2);
			assertEquals("world", appts.get(1).getTitle());
            assertEquals("hello", appts.get(2).getTitle());
		} catch (Exception e){
	 	    System.out.println(e);
	 		assert(false);
		}finally{

		}


	 }
	 @Test
    public void test02(){
         Calendar rightnow = Calendar.getInstance();
         boolean wascaught = false;
         //current month/year/date is today
         int thisMonth = rightnow.get(Calendar.MONTH) + 1;
         int thisYear = rightnow.get(Calendar.YEAR);
         int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
         GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
         GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
         tomorrow.add(Calendar.DAY_OF_MONTH, 3);
         LinkedList<Appt> appts = new LinkedList<Appt>();
         LinkedList<Appt> appts2 = new LinkedList<Appt>();
         LinkedList<CalDay> days = new LinkedList<CalDay>();
         int[] arr = {4,5,6};
         int[] pv = {};
         int[] pv2 = {2,1,0};
         TimeTable tt = new TimeTable();
         //tt.permute(appts, pv);
         //days = tt.getApptRange(appts, today, tomorrow);
        System.out.println("the day is " + thisDay);
         Appt appt1 = new Appt(23, 2, thisDay, thisMonth, thisYear, "hello", "world");
         Appt appt2 = new Appt(23, 2, thisDay, thisMonth, thisYear, "world", "hello");
         Appt appt3 = new Appt(23, 2, thisDay, thisMonth, thisYear, "hello", "world");
         Appt appt4 = new Appt(23, 2, thisDay, thisMonth, thisYear, "hello", "world");
         appt1.setRecurrence(arr, Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);
         appt2.setRecurrence(arr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_NEVER);
         appt3.setRecurrence(arr, Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);
         appt4.setRecurrence(arr, Appt.RECUR_BY_MONTHLY, -1, Appt.RECUR_NUMBER_FOREVER);
         appts.add(appt1);
         appts.add(appt2);
         appts.add(appt3);
         appts.add(appt4);
         try {
             days = tt.getApptRange(appts, tomorrow, today);
         }catch(Exception e){
             wascaught = true;
         }
         finally{
             System.out.println("asserting wascaught");
             assert(wascaught);
         }
     }
//add more unit tests as you needed
}
