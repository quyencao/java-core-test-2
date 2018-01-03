package Intermidiate;

public class OuterInnerClass {
	
	private int number = 100;
	
	private static int number2 = 102;
	
	private class InnerPrivateClass {
		
		private void print() {
			System.out.println("Inner Private Class access instance property: " + number);
			System.out.println("Inner Private Class access static property: " + number2);
		}
		
	}
	
	public class InnerClass {
		public void print() {
			System.out.println("Inner Class access instance property: " + number);
			System.out.println("Inner Class access instance property: " + number2);
		
			class MethodLocalClass {
				private void print() {
					System.out.println("Inside Method Class");
				}
			}
			
			MethodLocalClass mlc = new MethodLocalClass();
			mlc.print();
		}
	}
	
	
	public void displayInner() {
		InnerPrivateClass inner = new InnerPrivateClass();
		inner.print();
	}
}
