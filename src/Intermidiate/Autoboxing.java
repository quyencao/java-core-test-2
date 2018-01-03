package Intermidiate;

import java.util.ArrayList;
import java.util.List;

public class Autoboxing {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		// autoboxing
		list.add(1);
		list.add(2);
		
		int value = list.get(0); // unboxing
		System.out.println(value);
		
		// unboxing
		for(int i: list) {
			System.out.println(i);
		}
	}
}
