package advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CollectionJava8 {
	public static void main(String[] args) {
		// Iterable forEach default method
		List<Integer> intList = Arrays.asList(12, 35, 7, 55);

		intList.forEach(System.out::println);

		List<Integer> testRemoveItem = new ArrayList<>();
		testRemoveItem.add(1);
		testRemoveItem.add(10);
		testRemoveItem.add(5);
		// Iterator<Integer> ite = testRemoveItem.iterator();
		// // Remove element in collection
		// while(ite.hasNext()) {
		// int value = ite.next();
		// if(value % 2 == 0) {
		// ite.remove();
		// }
		// }
		// System.out.println("AFTER REMOVE ITEW");
		// testRemoveItem.forEach(System.out::println);
		System.out.println("AFTER REMOVE ITEM==============");

		// Collection removeIf default method
		testRemoveItem.removeIf(i -> i % 2 == 0);
		testRemoveItem.forEach(System.out::println);

		System.out.println("AFTER REPLACE ALL================");
		// List replaceAll default method
		intList.replaceAll(i -> 2 * i);
		intList.forEach(System.out::println);

		System.out.println("AFTER SORT==================");
		// List sort defaut method
		intList.sort((i1, i2) -> i1 - i2);
		intList.forEach(System.out::println);

		// Map
		System.out.println("MAP==================");
		Map<Integer, String> map = new LinkedHashMap<>();
  		map.put(1, "aaaa");
  		map.put(20, "bbbb");
  		map.put(31, "cccc");
  		map.put(14, "dddd");
  		map.put(65, "aa");
		
  		map.forEach((key, value) -> System.out.println("Key: " + key + " Value: " + value));
  		
  		String value = map.getOrDefault(10, "No value for this key");
  		
  		System.out.println(value);
  		
  		// compute if present
  		map.computeIfPresent(1, (k, v) -> v + "!");
  		
  		map.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
  		
  		System.out.println();
  		
  		map.computeIfAbsent(100, k -> "new value");
  		map.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
  		
  		System.out.println();
  		
  		map.merge(1, " appended", (o, n) -> o.concat(n));
  		map.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
  		
  		System.out.println();
  		map.replaceAll((k, v) -> k + " " + v);
  		map.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
	}
}
