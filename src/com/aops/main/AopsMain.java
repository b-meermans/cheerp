package com.aops.main;

public class AopsMain {
    public static void main(String[] args) {
		// Swing with keyboard interaction and images
		SwingTest.testSwing();

		// Reflection on classes tests - currently passing methods and fields, but failing on parameters
		new POJOTest();

		// Testing standard Java - ie: out of bounds and catching exceptions
		ExceptionTest.testJava();
    }
}