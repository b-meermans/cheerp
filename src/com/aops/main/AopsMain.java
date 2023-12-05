package com.aops.main;

import javax.swing.*;

import com.aops.main.JavaTesting.ExceptionTest;
import com.aops.main.JavaTesting.FileReadingTest;
import com.aops.main.JavaTesting.FileWritingTest;
import com.aops.main.JavaTesting.POJOTest;
import com.aops.main.SwingGUI.GUI.SwingRunner;

public class AopsMain extends JFrame {

	public static void main(String[] args) {
		// Swing with keyboard interaction and images
		System.out.println("\n*** Opening an interactive graphics (Swing) demo ***\n"); 
		SwingRunner.testSwing();

		// // Reading and writing to files
		// System.out.println("\n*** Reading from a File Test ***\n");
		// FileReadingTest.printContent("script.txt");		
		
		// // System.out.println("\n*** Writing to then reading from a file ***\n");
		// // FileWritingTest.addTimeStamp("writing.txt");
		// // FileReadingTest.printContent("writing.txt");		

		// // Reflection on classes tests - currently passing methods and fields, but failing on parameters
		// System.out.println("\n*** Reflection Test ***\n");
		// new POJOTest();

		// // Testing standard Java - ie: out of bounds and catching exceptions
		// System.out.println("\n*** Java vs Javascript Problems / Exceptions ***\n");
		// ExceptionTest.testJava();

		
    }
}