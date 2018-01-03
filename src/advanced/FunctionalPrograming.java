package advanced;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
//import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionalPrograming {
	public static void main(String[] args) {
		
		// Currying
		System.out.println("Currying");
		
		Function<Integer, Function<Integer, Integer>> f1 = x -> y -> x + y;
		System.out.println(f1.apply(1).apply(2));
		
		Function<Integer, Integer> adder1 = f1.apply(1);
		System.out.println(adder1.apply(2));
		System.out.println(adder1.apply(3));
		System.out.println(adder1.apply(4));
		
		System.out.println("\nCompose Function");
		// Compose Function
		Function<Integer, Integer> time2 = t -> t * 2;
		Function<Integer, Integer> composeA = compose(adder1, time2);
		System.out.println(composeA.apply(10)); // 10 * 2 + 1
		
		System.out.println("\nHOF");
		// HOF
		List<Employee> employeeList = Arrays.asList(new Employee("Tom Jones", 45, 12000.00, Department.MARKETING),
				new Employee("Harry Major", 26, 20000.00, Department.LEGAL),
				new Employee("Ethan Hardy", 65, 30000.00, Department.LEGAL),
				new Employee("Nancy Smith", 22, 15000.00, Department.MARKETING),
				new Employee("Catherine Jones", 21, 18000.00, Department.HR),
				new Employee("James Elliot", 58, 24000.00, Department.OPERATIONS),
				new Employee("Frank Anthony", 55, 32000.00, Department.MARKETING),
				new Employee("Michael Reeves", 40, 45000.00, Department.OPERATIONS));
		
		// get list name
		System.out.println("\nList all names employees");
		List<String> names = map(employeeList, e -> e.getName());
		names.forEach(System.out::println);
		
		System.out.println("\nList employee has salary greater than 20000");
		List<Employee> emp = filter(employeeList, e -> e.getSalary() > 20000);
		emp.forEach(System.out::println);
		
		System.out.println("\nCaculate sum salary");
		double sum = reduce(map(employeeList, e -> e.getSalary()), (acc, u) -> acc + u, 0.0);
		System.out.println(sum);
		
		// Functor
		System.out.println("Functor");
		Functor<Integer> functor1 = new Functor<>(Arrays.asList(1,2));
		Collection<Integer> values = functor1.map(n -> n + 1)
			   .map(n -> n * 2)
			   .getValues();
		
		System.out.println(values);
		
		MayBe<Integer> functor2 = new MayBe<>(Arrays.asList(1,2, null));
		Collection<Integer> values2 = functor2.map(n -> n + 1)
			   .map(n -> n * 2)
			   .getValues();
		System.out.println(values2);
		
	}

	
	static <T, K, E> Function<T, E> compose(Function<K, E> f1, Function<T, K> f2) {
		return t -> f1.apply(f2.apply(t));
	}
	
	static <T, K> List<K> map(List<T> l,Function<T, K> f) {
		List<K> list = new LinkedList<>();
		for(T t: l) {
			list.add(f.apply(t));
		}
		
		return list;
	}
	
	static <T> List<T> filter(List<T> l, Predicate<T> pred) {
		List<T> list = new LinkedList<>();
		for(T t: l) {
			if(pred.test(t)) {
				list.add(t);
			}
		}
		
		return list;
	}
	
	static <T> T reduce(List<T> l, BinaryOperator<T> f, T start) {
		T result = start;
		for(T t: l) {
			result = f.apply(result, t);
		}
		
		return result;
	}
}

@FunctionalInterface
interface Function<T, U> {
	U apply(T t);
}

class Functor<T> {
	protected Collection<T> values;
	
	public Functor(Collection<T> t) {
		this.values = t;
	}
	
	public Functor<T> map(UnaryOperator<T> f) {
		Collection<T> values = new LinkedList<>();
		for(T t: this.values) {
			values.add(f.apply(t));
		}
		
		return new Functor<T>(values);
	}
	
	public Collection<T> getValues() {
		return this.values;
	}
}

class MayBe<T> extends Functor<T> {

	public MayBe(Collection<T> t) {
		super(t);
	}
	
	@Override
	public MayBe<T> map(UnaryOperator<T> f) {
		Collection<T> values = new LinkedList<>();
		for(T t: this.values) {
			if(t != null) {
				values.add(f.apply(t));
			} else {
				values.add(t);
			}
		}
		
		return new MayBe<T>(values);
	}
}