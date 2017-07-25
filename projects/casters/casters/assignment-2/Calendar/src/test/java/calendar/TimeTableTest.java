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
			int[] pv2 = {0,1,2,3};
			TimeTable tt = new TimeTable();
			//tt.permute(appts, pv);
			//days = tt.getApptRange(appts, today, tomorrow);

			Appt appt1 = new Appt(23, 2, 25, 10, 2017, "hello", "world");
			Appt appt2 = new Appt(23, 2, 25, 10, 2017, "hello", "world");
			Appt appt3 = new Appt(-23, 2, 25, 10, 2017, "hello", "world");
			Appt appt4 = new Appt(23, 2, 25, 07, 2017, "hello", "world");
			appt1.setRecurrence(arr, Appt.RECUR_BY_MONTHLY, -1, Appt.RECUR_NUMBER_FOREVER);
			appt2.setRecurrence(arr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_NEVER);
			appt3.setRecurrence(arr, Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);
			appt4.setRecurrence(arr, Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);
			appts.add(appt1);
			appts.add(appt2);
			appts.add(appt3);
			appts.add(appt4);
			days = tt.getApptRange(appts, today, tomorrow);
			tt.deleteAppt(appts, appt4);
			tt.permute(appts, pv2);
		} catch (Exception e){
	 		System.out.println(e);
		}finally{

		}


	 }
//add more unit tests as you needed
}
