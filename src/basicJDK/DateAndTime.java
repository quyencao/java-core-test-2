package basicJDK;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.swing.plaf.SliderUI;

public class DateAndTime {
	public static void main(String[] args) {
		// Instant is a point on the time line
		System.out.println("Instant");
		System.out.println(Instant.MAX);
		System.out.println(Instant.MIN);
		Instant now = Instant.now();
		System.out.println(now);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Instant end = Instant.now();
		
		System.out.println("Duration");
		//  Duration is time ellapsed
		System.out.println(Duration.between(now, end).toMillis());
		
		Duration duration = Duration.between(now, end);
		System.out.println(duration.plusMillis(1500).toMillis());
		
		// Local Date
		System.out.println("Local Date");
		LocalDate date = LocalDate.now();
		System.out.println(date);
		LocalDate date2 = LocalDate.of(1995, Month.JANUARY, 20);
		System.out.println(date2);
		LocalDate date3 = LocalDate.ofYearDay(2019, 50);
		System.out.println(date3);
		int year = date.getYear();
		int dayOfYear = date.getDayOfYear();
		boolean isLeap = date.isLeapYear();
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		String dayOfWeekName = dayOfWeek.name();
		
		// Period: amount time between to date
		System.out.println("Period");
		Period period = Period.between(date2, date);
		System.out.println(period.getYears());
		Period p = date2.until(LocalDate.now());
		System.out.println(p.getYears());
		
		// LocalTime
		System.out.println("Local Time");
		LocalTime midnight = LocalTime.MIDNIGHT;
		System.out.println(midnight);
		LocalTime lt = LocalTime.now();
		System.out.println(lt);
		LocalTime lt2 = LocalTime.of(10, 20); // 10:20
		System.out.println(lt2);
		LocalTime lt3 = LocalTime.ofSecondOfDay(12345);
		System.out.println(lt3);
		
		// Local Date Time
		System.out.println("Local Date Time");
		LocalDateTime ldt1 = LocalDateTime.of(date, lt);
		System.out.println(ldt1);
		LocalDateTime ldt2 = LocalDateTime.of(2016, Month.DECEMBER, 24, 12, 0);
		System.out.println(ldt2);
		LocalDateTime ldt3 = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
		System.out.println(ldt3);
		
		// Zone time
		System.out.println("Zone Date Time");
		Set<String> allZonesId = ZoneId.getAvailableZoneIds();
		System.out.println(allZonesId);
		ZonedDateTime zdt1 = ZonedDateTime.of(
				LocalDate.of(2017, 7, 20),
				LocalTime.of(8, 20),
				ZoneId.of("Asia/Ho_Chi_Minh"));
		
		ZonedDateTime zdt2 = zdt1.plusMonths(1);
				
		ZonedDateTime zdt2US = zdt2.withZoneSameInstant(ZoneId.of("Asia/Seoul"));
		
		System.out.println(zdt2US.getHour());
		
		ZonedDateTime zdt3 = ZonedDateTime.of(
				LocalDateTime.of(2018, 1, 3, 10, 20),
				ZoneId.of("Asia/Ho_Chi_Minh"));
		System.out.println(zdt3);
		
	}
}
