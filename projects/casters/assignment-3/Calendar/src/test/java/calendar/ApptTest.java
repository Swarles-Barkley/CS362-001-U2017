package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
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
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }
	/*
	 @Test
	  public void test02()  throws Throwable  {
		 Appt appt = new Appt(7, 32, 20, 06, -2, "swiggity swooty", "Im on my way");
		 assertFalse(appt.getValid());
	 }
	 */
	 @Test
	public void test03() throws Throwable {
	 	int [] arr = {4,5,6};
	 	int [] arr2 = null;
		Appt appt = new Appt(7, 32, 20, 06, 2016, "swiggity swooty", "Im on my way");
		 appt.setRecurrence(arr, Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);
		 assertEquals(Appt.RECUR_NUMBER_FOREVER, appt.getRecurNumber());
		 assertEquals(2, appt.getRecurIncrement());
		 assertTrue(appt.isRecurring());
		 assertEquals(arr, appt.getRecurDays());
		 appt.setRecurrence(arr2, Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);
		 assertEquals(Appt.RECUR_BY_MONTHLY, appt.getRecurBy());

	 }
	 @Test
	public void test04() throws Throwable {
	 	try {
			Appt appt1 = new Appt(7, 32, 20, 06, -2, "swiggity swooty", "Im on my way");
			Appt appt2 = new Appt(25, 32, 20, 06, 2016, "swiggity swooty", "Im on my way");
			Appt appt3 = new Appt(7, 61, 20, 06, 2016, "swiggity swooty", "Im on my way");
			Appt appt4 = new Appt(7, 32, 33, 06, 2016, "swiggity swooty", "Im on my way");
			Appt appt5 = new Appt(7, 32, 3, 13, 2016, "swiggity swooty", "Im on my way");
			Appt appt6 = new Appt(7, 32, 3, 14, 2016, "swiggity swooty", "Im on my way");
			assertFalse(appt1.getValid());
			System.out.println(appt1.toString());
			System.out.println(appt2.toString());
			assertFalse(appt2.getValid());
			assertFalse(appt3.getValid());
			assertFalse(appt4.getValid());
			assertFalse(appt5.getValid());
			assertFalse(appt6.getValid());

		}
		catch(Exception e){
			//throw new RuntimeException();
		}
	 }
	 @Test
	public void test05() throws Throwable{
	 	Appt appt1 = new Appt(2,2,2,02,1992, "hello", "world");
	 	appt1.setStartHour(25);
	 	assertEquals(25, appt1.getStartHour());
	 	appt1.setStartMinute(4);
	 	assertEquals(4, appt1.getStartMinute());
	 	appt1.setStartDay(4);
	 	assertEquals(4, appt1.getStartDay());
	 	appt1.setStartMonth(03);
	 	assertEquals(03, appt1.getStartMonth());
	 	appt1.setStartYear(1993);
	 	assertEquals(1993, appt1.getStartYear());
	 	appt1.setTitle("goodbye");
	 	assertEquals("goodbye", appt1.getTitle());
	 	appt1.setDescription("cruel world");
	 	assertEquals("cruel world", appt1.getDescription());
	 	assertFalse(appt1.getValid());
	 	appt1.setDescription(null);
	 	appt1.setTitle(null);
	 	assertEquals("", appt1.getDescription());
	 	assertEquals("", appt1.getTitle());
	 }
	 @Test
	public void test06() throws Throwable{
	 	Appt appt1 = new Appt(0,2,2,02,1992, "hello", "world");
	 	Appt appt2 = new Appt(13,2,2,02,1992, "hello", "world");
	 	System.out.println(appt1.toString());
	 	System.out.println(appt2.toString());
	 	assertTrue(appt1.getValid());
	 	assertTrue(appt2.getValid());
	 }
//add more unit tests as you needed
	
}
