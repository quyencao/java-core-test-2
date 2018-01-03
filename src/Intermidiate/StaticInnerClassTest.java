package Intermidiate;

public class StaticInnerClassTest {
	
	private static int data = 30;
	
	public static class InnerStaticClass {
		
		public void printData() {
			System.out.println(data);
			outerStaticMethod();
		}
		
		public static void printData2() {
			System.out.println(data);
			outerStaticMethod();
		}
		
	}
	
	public static void outerStaticMethod() {
		System.out.println("Outer static method");
	}
	
	public static void main(String[] args) {
		
		StaticInnerClassTest.InnerStaticClass obj = new StaticInnerClassTest.InnerStaticClass();
		
		obj.printData();
		
		StaticInnerClassTest.InnerStaticClass.printData2();
		
	}
	
}
