package basicJDK;

import java.util.Calendar;

public class CalendarTest {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		System.out.println(cal.getTime());
		
		cal.add(Calendar.MONTH, 2);
		
		System.out.println(cal.getTime());
		
		cal.add(Calendar.DAY_OF_MONTH, 10);
		
		System.out.println(cal.getTime());
		
		cal.set(Calendar.YEAR, 2017);
		
		System.out.println(cal.getTime());
		
		System.out.println(cal.getMaximum(Calendar.MONTH));
		
		System.out.println(cal.getMinimum(Calendar.MONTH));
		
		
	}
}
