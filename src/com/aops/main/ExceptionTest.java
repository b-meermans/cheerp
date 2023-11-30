package com.aops.main;

import java.util.Set;
import java.util.TreeSet;

public class ExceptionTest {
    public static void testJava() {

		System.out.println();
		System.out.println("Test TreeSet");
		Set<String> names = new TreeSet<>();
		names.add("Joseph");
		names.add("Brian");
		System.out.println(names + " should be [Brian, Joseph]");


		System.out.println();
		System.out.println("Test memory management on wrapper objects and typecasting");

		// Testing primitives to objects (The Integer wrapper stores the first )

		System.out.println(((Integer)126 == (Integer)126) + " should be true (126)");
		System.out.println(((Integer)127 == (Integer)127) + " should be true (127)");
		System.out.println(((Integer)128 == (Integer)128) + " should be false (128)");	
		System.out.println(((Integer)129 == (Integer)129) + " should be false (129)");
		System.out.println(((Integer)(-126) == (Integer)(-126)) + " should be true (-126)");
		System.out.println(((Integer)(-127) == (Integer)(-127)) + " should be true (-127)");
		System.out.println(((Integer)(-128) == (Integer)(-128)) + " should be true (-128)");	
		System.out.println(((Integer)(-129) == (Integer)(-129)) + " should be false (-129)");
		

		System.out.println();
		System.out.println("Testing primitive limits on ints");

		int largest = Integer.MAX_VALUE + 1;
		System.out.println(largest + " should wrap to -2147483648");
		largest--;
		System.out.println(largest + " should wrap to 2147483647");


		System.out.println();
		System.out.println("Specific test for index -1, which seems to always return 73 for CheerpJ.");
		// This has been failing on CheerpJ. A single catch will work sometimes, but multiple catches fails. 
		// Getting to index -1 doesn't cause an exception, instead resulting in the value 73 each time.
		// What should occur here is 5, 4, 3, -1, -2, -3, -4, -5 should all print their index caused an exception. 
		int[] array = {3, 1, 4};
		try {
			System.out.println(array[-1] + " did not properly throw an index out of bounds exception.");	
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Successfully threw an index out of bounds exception at index -1.");
		}



		System.out.println();
		System.out.println("Testing OOBs and checked exceptions (only index 0, 1, and 2 should not cause an exception)");

		for (int i = 5; i >= -5; i--) {
			try {
				System.out.printf("Array at %d is %d%n", i, array[i]);
			} catch (Exception e) {
				System.out.printf("%d caused an exception.%n", i);
			}
		}


		System.out.println();
		System.out.println("Testing null pointer exceptions");
		String n = null;
		try {
			System.out.println(n.length() + " did not properly throw a null pointer exception.");	
		} catch (NullPointerException e) {
			System.out.println("Successfully caught the null pointer exception.");
		}


		System.out.println();
		System.out.println("Testing arithmetic exception");
		try {
			System.out.println(1 / 0 + " did not properly throw an arithmetic exception.");
		} catch (ArithmeticException e) {
			System.out.println("Successfully caught the arithmetic exception.");
		}


		System.out.println();
		System.out.println("Testing class cast exception");
		try {
			Object obj = 3;
			System.out.println((String)obj + " did not properly throw an arithmetic exception.");
		} catch (ClassCastException e) {
			System.out.println("Successfully caught the class cast exception.");
		}

	}
}
