package Intermidiate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GenericTest {
	public static <E> E min(List<E> l, Comparator<E> c) {
		E min = l.get(0);
		
		for(E e: l) {
			if(c.compare(e, min) < 0) {
				min = e;
			}
		}
		return min;
	}
	
	public static <E extends Number & Comparable<E>> E max(E x, E y, E z) {
		E max = x;
		
		if(y.compareTo(max) > 0) {
			max = y;
		}
		
		if(z.compareTo(max) > 0) {
			max = z;
		}
		
		return max;
	}
	
	public static <T extends Comparable<T>> int countGreaterThan(List<T> l, T e) {
		int count = 0;
		for(T t: l) {
			if(t.compareTo(e) > 0) {
				count++;
			}
		}
		return count;
	}
	
	public static void print(List<?> l) {
		for(Object o: l) {
			System.out.println(o);
		}
	}
	
	public static double sum(List<? extends Number> l) {
		double s = 0.0;
		for(Number n: l) {
			s += n.doubleValue();
		}
		return s;
	}
	
	public static void main(String[] args) {
		System.out.println(min(Arrays.asList(5,3,20), (i1, i2) -> Integer.compare(i1, i2)));
		System.out.println(max(1,2,3));
//		System.out.println(max("A", "B", "C"));
		System.out.println(countGreaterThan(Arrays.asList(1,2,5,8), 2));
		System.out.println("Unbounded Wildcard");
		print(Arrays.asList(1,2,4));
		System.out.println("Upper Bounded Wildcard");
		System.out.println(sum(Arrays.asList(1,1.4,7f)));
		
		List<Integer> intList = new ArrayList<>();
//		List<Number> numList = intList; // error
		List<? extends Number> numList = intList;
		
		System.out.println(numList);
		
		Pair<Integer> pair = new Pair<>(2, 1);
		pair.print();
		
	}
}

class Pair<T extends Comparable<T>> {

    private T t1;
    private T t2;
    
    public Pair(T first, T last) {
    	if(first.compareTo(last) == 1) {
    		t1 = last;
    		t2 = first;
    	} else {
    		t1 = first;
    		t2 = last;
    	}
    }

    public void print() {
        System.out.println(t1 + " " + t2);
    }

}

