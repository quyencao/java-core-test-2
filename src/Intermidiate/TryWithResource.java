package Intermidiate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TryWithResource {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(new File("test.txt"))) {
		    while (scanner.hasNext()) {
		        System.out.println(scanner.nextLine());
		    }
		} catch (FileNotFoundException fnfe) {
		    fnfe.printStackTrace();
		}
		
		try(Scanner scanner = new Scanner(new File("test.txt"));
			PrintWriter pw = new PrintWriter(new File("testWrite.txt"))) {
			
			while(scanner.hasNext()) {
				pw.print(scanner.nextLine());
			}
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		
		try(MyAutoClosable mac = new MyAutoClosable()) {
			mac.doIt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

class MyAutoClosable implements AutoCloseable {

    public void doIt() {
        System.out.println("MyAutoClosable doing it!");
    }

    @Override
    public void close() throws Exception {
        System.out.println("MyAutoClosable closed!");
    }
}