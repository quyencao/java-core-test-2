package advanced;

import static java.util.stream.Collectors.toList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi {
	public static void main(String[] args) {
		List<Employee> employeeList = Arrays.asList(new Employee("Tom Jones", 45), new Employee("Harry Major", 25),
				new Employee("Ethan Hardy", 65), new Employee("Nancy Smith", 15),
				new Employee("Deborah Sprightly", 29));

		// get stream
		Stream<Employee> stream = employeeList.stream();

		stream.filter(e -> e.getAge() > 50).forEach(System.out::println);

		// reducing
		int sum = employeeList.stream().mapToInt(Employee::getAge).sum();
		System.out.println(sum);

		OptionalDouble avgAge = employeeList.stream().mapToInt(Employee::getAge).average();
		if (avgAge.isPresent()) {
			System.out.println(avgAge.getAsDouble());
		}

		// matching
		boolean a = employeeList.stream().allMatch(e -> e.getAge() < 66);

		System.out.println(a);
		boolean b = employeeList.stream().anyMatch(p -> p.getAge() >= 65);

		System.out.println(b);

		boolean c = employeeList.stream().noneMatch(p -> p.getAge() > 70);
		System.out.println(c);

		// mapping
		System.out.println("MAPPING=====================");
		List<String> employeeName = employeeList.stream().map(Employee::getName).collect(toList());

		employeeName.forEach(System.out::println);

		// Flatmap Stream<String[]> -> Stream<String>
		String[][] data = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };

		Stream<String[]> streamData = Arrays.stream(data);

		Stream<String> flatMapStream = streamData.flatMap(p -> Arrays.stream(p));

		flatMapStream.forEach(System.out::println);

		int[] intArray = { 1, 2, 3, 4, 5, 6 };
		Stream<int[]> streamArr = Stream.of(intArray);

		IntStream intStream = streamArr.flatMapToInt(i -> Arrays.stream(i));

		intStream.forEach(System.out::println);

		// findAny findFirst
		System.out.println("FIND=========================");
		Optional<Employee> findAnyEmployee = employeeList.stream().filter(e -> e.getAge() > 30).skip(1).findAny();

		if (findAnyEmployee.isPresent()) {
			System.out.println(findAnyEmployee.get());
		}

		Optional<Employee> findFirstEmployee = employeeList.stream().filter(e -> e.getAge() < 25).findFirst();

		if (findFirstEmployee.isPresent()) {
			System.out.println(findFirstEmployee.get());
		}

		// collector
		// partition collector
		Map<Boolean, List<Employee>> employeePartition = employeeList.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() > 30));

		employeePartition.forEach((key, empList) -> System.out.println(key + " " + empList));

		// counting collector
		Map<Boolean, Long> employeePartitionCount = employeeList.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() > 30, Collectors.counting()));
		employeePartitionCount.forEach((key, count) -> System.out.println(key + " " + count));

		// groupBy collector
		employeeList = Arrays.asList(new Employee("Tom Jones", 45, 12000.00, Department.MARKETING),
				new Employee("Harry Major", 26, 20000.00, Department.LEGAL),
				new Employee("Ethan Hardy", 65, 30000.00, Department.LEGAL),
				new Employee("Nancy Smith", 22, 15000.00, Department.MARKETING),
				new Employee("Catherine Jones", 21, 18000.00, Department.HR),
				new Employee("James Elliot", 58, 24000.00, Department.OPERATIONS),
				new Employee("Frank Anthony", 55, 32000.00, Department.MARKETING),
				new Employee("Michael Reeves", 40, 45000.00, Department.OPERATIONS));

		Map<Department, List<Employee>> employeeInDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		employeeInDepartment.forEach((d, emplist) -> System.out.println(d + " " + emplist));

		System.out.println("MAX SALARY IN EACH DEPARTMENT");
		Map<Department, Optional<Employee>> maxSalaryInDepartment = employeeList.stream().collect(Collectors.groupingBy(
				Employee::getDepartment, Collectors.maxBy((e1, e2) -> (int) (e1.getSalary() - e2.getSalary()))));

		maxSalaryInDepartment.forEach((d, e) -> {
			if (e.isPresent()) {
				System.out.println(d + " " + e);
			}
		});
	}

}

enum Department {
	HR, OPERATIONS, LEGAL, MARKETING
}

class Employee {
	private String name;
	private Integer age;
	private Double salary;
	private Department department;

	public Employee(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Employee(String name, Integer age, Double salary, Department department) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String toString() {
		return "Employee Name: " + this.name + "  Age:" + this.age + " Salary: " + this.salary;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}