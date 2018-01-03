package basicJDK;

import java.time.Instant;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date date1 = new Date();
		
		System.out.println(date1);
		
		Date date2 = new Date(100000);
		
		System.out.println(date2);
		
		date2.setTime(100000000);
		
		System.out.println(date2);
		
		System.out.println(date1.compareTo(date2));
		
		System.out.println(date1.after(date2));
		System.out.println(date1.before(date2));
		
		Instant instant1 = date1.toInstant();
		System.out.println(instant1);
		
		Instant instant2 = Instant.now();
		Date dateFromInstant = Date.from(instant2);
		System.out.println(instant2);
		System.out.println(dateFromInstant);
	}
}
