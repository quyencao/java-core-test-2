package Intermidiate;

import Intermidiate.OuterInnerClass;

public class InnerClassTest {

	
	
	public static void main(String[] args) {
		OuterInnerClass outer = new OuterInnerClass();
		
		outer.displayInner();
		
		OuterInnerClass.InnerClass inner = outer.new InnerClass();
		
		inner.print();
	}
	
}
