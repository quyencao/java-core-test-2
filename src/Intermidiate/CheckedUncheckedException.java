package Intermidiate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckedUncheckedException {
	private static Scanner scanner;

	public static void doSomething(boolean isThrowExeption) throws MyExeption {
		if(isThrowExeption) {
			throw new MyExeption("My Exception");
		}
		
		System.out.println("No exeption");
	}
	
	public static void main(String[] args) {
		try {
			doSomething(false);
		} catch (MyExeption e) {
			e.printStackTrace();
		}
		
		doSomething(false);
		
		try {
			scanner = new Scanner(new File("test.txt"));
			
			while(scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class MyExeption extends RuntimeException {

	private static final long serialVersionUID = -4126550521579970706L;

	public MyExeption(String s) {
        super(s);
    }
}