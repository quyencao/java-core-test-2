package Intermidiate;

import Intermidiate.Day;

public class EnumTest {
	
	private Day day;
	
	public EnumTest(Day day) {
		this.day = day;
	}
	
	public void printMessages() {
		switch(this.day) {
			case MONDAY:
	            System.out.println("Mondays are bad.");
	            break;     
	        case FRIDAY:
	            System.out.println("Fridays are better.");
            break;
			case SATURDAY: case SUNDAY:
                System.out.println("Weekends are best.");
                break;
            default:
                System.out.println("Midweek days are so-so.");
                break;	
		}
	} 
	
	public static void main(String[] args) {
		
		EnumTest day1 = new EnumTest(Day.MONDAY);
		
		EnumTest day2 = new EnumTest(Day.FRIDAY);
		
		EnumTest day3 = new EnumTest(Day.SUNDAY);
		
		day1.printMessages();
		
		day2.printMessages();
		
		day3.printMessages();
		
		for(Day d: Day.values()) {
			System.out.println(d + " " + d.getValue());
		}
		
	}
}

