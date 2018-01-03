package advanced;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lambda {
	public static void main(String[] args) {
		Condition<Integer> cond = t -> t > 10;
		System.out.println(cond.test(10));
		System.out.println(cond.test(20));

		List<Integer> list = Arrays.asList(4, 5, 3, 1, 0);

		// list.sort(new Comparator<Integer>() {
		//
		// @Override
		// public int compare(Integer o1, Integer o2) {
		// // TODO Auto-generated method stub
		// return o1 - o2;
		// }
		//
		// });

		list.sort((o1, o2) -> o1 - o2);
		list.forEach(item -> System.out.println(item));

		// default method and static method in interface
		Condition<Integer> negate = cond.negate();
		System.out.println(negate.test(10));
		System.out.println(negate.test(15));
		System.out.println(negate.test(9));

		System.out.println("===========AND============");
		Condition<Integer> and = cond.and(t -> t < 15);
		System.out.println(and.test(12));
		System.out.println(and.test(9));
		System.out.println(and.test(16));

		System.out.println("===========STATIC METHOD========");
		Condition<Integer> staticMethod = Condition.isEqual(1);
		System.out.println(staticMethod.test(1));

		// Predicate Interface
		Predicate<Integer> pred = t -> t > 10;
		System.out.println(pred.test(10));

		// Function Interface
		Function<String, String[]> split = str -> str.split(" ");
		System.out.println(Arrays.toString(split.apply("this is a test")));
		Function<String, String> join = split.andThen((arrStr) -> String.join("-", arrStr));
		System.out.println(join.apply("this is a test"));

		// Method Reference
		// Equivalent to the lambda
		// <ClassName> :: <method>
		BinaryOperator<Integer> sum = (a, b) -> a + b;
		System.out.println(sum.apply(1, 2));
		// method reference
		BinaryOperator<Integer> sumRef = Integer::sum;
		System.out.println(sumRef.apply(1, 2));

		Function<String, String> upcase = String::toUpperCase;
		System.out.println(upcase.apply("test"));
		
//		Function<String, Integer> f = str -> str.length();
//		Function<String, Integer> f2 = f.compose(i -> i - 1).before(str -> str + "!");
//		Function<String, Integer> f3 = f.before(str -> str + "!");
//		System.out.println(f2.apply("Quyen"));
//		System.out.println(Function.identity().apply(1));
		
		Consumer<String> s = System.out::println;
		s.andThen(p -> System.out.println(p.length())).accept("Quyen");
	
		Condition<String> c1 = Condition.isEqual("Yes");
		System.out.println(c1.test("Yes"));
	}
}

@FunctionalInterface
interface Condition<T> {
	public boolean test(T t);

	default Condition<T> negate() {
		return t -> !test(t);
	}

	default Condition<T> and(Condition<T> other) {
		return t -> test(t) && other.test(t);
	}
	
	default Condition<T> or(Condition<T> other) {
		return t -> test(t) || other.test(t);
	}

	static <E> Condition<E> isEqual(E target) {
		return t -> t.equals(target);
	}
}

// @FunctionalInterface
//interface Function<T, U> {
//	U apply(T t);
//	
//	default <K> Function<T, K> compose(Function<U, K> f) {
//		return t -> f.apply(apply(t));
//	}
//	
//	default <K> Function<K, U> before(Function<K, T> f) {
//		return t -> apply(f.apply(t));
//	}
//	
//	static <Z> Function<Z, Z> identity() {
//		return t -> t;
//	}
//}

@FunctionalInterface
interface Consumer<T> {
	void accept(T t);
	
	default Consumer<T> andThen(Consumer<T> after) {
		return t -> {
			accept(t);
			after.accept(t);
		};
	}
}

@FunctionalInterface
interface Supplier<T> {
	T get();
}

