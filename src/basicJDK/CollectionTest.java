package basicJDK;

import java.util.ArrayDeque;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionTest {
	public static void main(String[] args) {
		System.out.println("List");
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		
		System.out.println(list1);
		System.out.println(list1.get(0)); // O(1)
		
		List<Integer> list2 = new LinkedList<>();
		list2.add(1);
		list2.add(3);
		System.out.println(list2);
		System.out.println(list2.get(0)); // O(n)
		
		System.out.println("SET");
		// Unsorted Set
		Set<Integer> set1 = new HashSet<>();
		set1.add(1);
		set1.add(1);
		set1.add(50);
		set1.add(32);
		set1.add(2);
		set1.add(10);
		System.out.println(set1);
		
		Set<Integer> set2 = new LinkedHashSet<>();
		set2.add(1);
		set2.add(1);
		set2.add(50);
		set2.add(32);
		set2.add(2);
		set2.add(10);
		System.out.println(set2);
		
		// Sorted Set
		Set<Integer> set3 = new TreeSet<>();
		set3.add(1);
		set3.add(1);
		set3.add(50);
		set3.add(32);
		set3.add(2);
		set3.add(10);
		System.out.println(set3);
		
		Set<Person> set4 = new HashSet<>();
		Person p1 = new Person("AAA", 20);
		Person p2 = new Person("AAA", 21);
		set4.add(p1);
		set4.add(p2);
		set4.add(p1);
		System.out.println(set4);
		
		// Queue
		System.out.println("Queue");
		System.out.println("Priority Queue");
		PriorityQueue<String> queue1 = new PriorityQueue<>(16, 
				(s1, s2) -> s1.length() - s2.length());
		
		queue1.add("ffff");
		queue1.add("aaa");
		queue1.add("b");
		queue1.add("cc");
		queue1.add("eeee");
		queue1.add("dddd");
		
//		 System.out.println(queue1.peek());
		
		while(!queue1.isEmpty()) {
			System.out.println(queue1.poll());
		}
		
		System.out.println("Array Deque");
		
		ArrayDeque<String> deque = new ArrayDeque<>();
		deque.add("aaa");
		deque.addFirst("bbb");
		deque.addLast("ccc");
//		System.out.println(deque.getFirst());
		while(!deque.isEmpty()) {
			System.out.println(deque.poll());
		}
		
		System.out.println("Array Deque as a stack");
		ArrayDeque<String> deque2 = new ArrayDeque<>();
		deque2.push("aaa");
		deque2.push("bbb");
		deque2.push("ccc");
		while(!deque2.isEmpty()) {
			System.out.println(deque2.pop());
		}
		
		
		System.out.println("Map");
  		Map<Integer, String> map1 = new HashMap<>();
  		
  		map1.put(1, "aaaa");
  		map1.put(20, "bbbb");
  		map1.put(31, "cccc");
  		map1.put(14, "dddd");
  		map1.put(65, "aa");
  		
  		displayMap(map1);
  		
  		Map<Integer, String> map2 = new LinkedHashMap<>();
  		map2.put(1, "aaaa");
  		map2.put(20, "bbbb");
  		map2.put(31, "cccc");
  		map2.put(14, "dddd");
  		map2.put(65, "aa");
	
  		displayMap(map2);
  		
  		Map<Integer, String> map3 = new TreeMap<>();
  		map3.put(1, "aaaa");
  		map3.put(20, "bbbb");
  		map3.put(31, "cccc");
  		map3.put(14, "dddd");
  		map3.put(65, "aa");
	
  		displayMap(map3);
	}
	
	public static <K, V> void displayMap(Map<K, V> map) {
		System.out.println("MAP");
		Iterator<K> ite = map.keySet().iterator();
  		while(ite.hasNext()) {
  			K key = ite.next();
  			System.out.println(key + " " + map.get(key));
  		}
	}
}

class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		return age;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this == obj;
	}
	
	@Override
	public String toString() {
		return "Person " + this.name + " is " + this.age + " years old"; 
	}
}
