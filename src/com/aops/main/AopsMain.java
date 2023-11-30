package com.aops.main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Set;
import java.util.TreeSet;

public class AopsMain extends JFrame {

    private int arrowX = 100;
    private int arrowY = 100;
    private double arrowAngle = 0; // in radians

    public AopsMain() {
        setTitle("Arrow Grid");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a custom JPanel to the frame
        ArrowPanel arrowPanel = new ArrowPanel();
        add(arrowPanel);

        // Add a key listener to handle arrow key events
        addKeyListener(new ArrowKeyListener());

        // Set focus on the panel to receive key events
        arrowPanel.setFocusable(true);
    }

	private class ArrowPanel extends JPanel {
		private BufferedImage arrowImage;
		private int arrowWidth = 20; // Set the width of the image
		private int arrowHeight = 20; // Set the height of the image

		public ArrowPanel() {
			try {
				// Load the arrow image from a file (replace "arrow.png" with your image file)
				// Assuming "images/arrow.png" is in the root of the JAR
				URL imageUrl = getClass().getResource("/images/arrow.png");



				arrowImage = ImageIO.read(imageUrl);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			// Add a key listener to the panel to handle arrow key events
			addKeyListener(new ArrowKeyListener());
	
			// Set focus on the panel to receive key events
			setFocusable(true);
			requestFocusInWindow();
	
			setPreferredSize(new Dimension(400, 400)); // Adjust the size as needed
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			// Draw the grid
			drawGrid(g);

			// Draw the arrow image
			drawArrow(g);
		}

		private void drawGrid(Graphics g) {
            int gridSize = 20;
            g.setColor(Color.LIGHT_GRAY);

            // Draw horizontal lines
            for (int y = 0; y <= getHeight(); y += gridSize) {
                g.drawLine(0, y, getWidth(), y);
            }

            // Draw vertical lines
            for (int x = 0; x <= getWidth(); x += gridSize) {
                g.drawLine(x, 0, x, getHeight());
            }
        }

		private void drawArrow(Graphics g) {
			if (arrowImage != null) {
				Graphics2D g2d = (Graphics2D) g;
		
				// Translate and rotate the arrow image
				int drawX = arrowX - arrowWidth / 2;
				int drawY = arrowY - arrowHeight / 2;
		
				g2d.translate(drawX + arrowWidth / 2, drawY + arrowHeight / 2);
				g2d.rotate(arrowAngle);
		
				// Draw the arrow image
				g2d.drawImage(arrowImage, -arrowWidth / 2, -arrowHeight / 2, arrowWidth, arrowHeight, null);

				// Reset transformations
				g2d.rotate(-arrowAngle);
				g2d.translate(-(drawX + arrowWidth / 2), -(drawY + arrowHeight / 2));
			} 
		}
	}


    // private class ArrowPanel extends JPanel {
	// 	public ArrowPanel() {
	// 		// ... (existing code)
	
	// 		// Add a key listener to the panel to handle arrow key events
	// 		addKeyListener(new ArrowKeyListener());
	
	// 		// Set focus on the panel to receive key events
	// 		setFocusable(true);
	// 		requestFocusInWindow();
	// 	}

    //     @Override
    //     protected void paintComponent(Graphics g) {
    //         super.paintComponent(g);

    //         // Draw the grid
    //         drawGrid(g);

    //         // Draw the arrow
    //         drawArrow(g);
    //     }

    //     private void drawGrid(Graphics g) {
    //         int gridSize = 20;
    //         g.setColor(Color.LIGHT_GRAY);

    //         // Draw horizontal lines
    //         for (int y = 0; y <= getHeight(); y += gridSize) {
    //             g.drawLine(0, y, getWidth(), y);
    //         }

    //         // Draw vertical lines
    //         for (int x = 0; x <= getWidth(); x += gridSize) {
    //             g.drawLine(x, 0, x, getHeight());
    //         }
    //     }

    //     private void drawArrow(Graphics g) {
    //         Graphics2D g2d = (Graphics2D) g;
    //         g2d.setColor(Color.BLUE);

    //         // Translate and rotate the arrow
    //         g2d.translate(arrowX, arrowY);
    //         g2d.rotate(arrowAngle);

    //         // Draw arrow body
    //         g2d.drawLine(-10, 0, 10, 0);

    //         // Draw arrowhead
    //         g2d.drawLine(10, 0, 7, -3);
    //         g2d.drawLine(10, 0, 7, 3);

    //         // Reset transformations
    //         g2d.rotate(-arrowAngle);
    //         g2d.translate(-arrowX, -arrowY);
    //     }
    // }

	private class ArrowKeyListener implements KeyListener {

		private Timer timer;
		private int stepSize = 5;
		private double rotationStep = Math.toRadians(5);
		private int lastKeyCode = KeyEvent.VK_UNDEFINED;
	
		public ArrowKeyListener() {
			// Initialize the timer to update arrow movement
			timer = new Timer(16, new ActionListener() { // 16 milliseconds for smooth movement
				@Override
				public void actionPerformed(ActionEvent e) {
					handleArrowKeys();
				}
			});
		}
	
		@Override
		public void keyPressed(KeyEvent e) {
			// Start the timer when a key is pressed
			if (!timer.isRunning()) {
				timer.start();
			}
	
			lastKeyCode = e.getKeyCode();
		}
	
		@Override
		public void keyReleased(KeyEvent e) {
			// Stop the timer when a key is released
			timer.stop();
			lastKeyCode = KeyEvent.VK_UNDEFINED;
		}
	
		@Override
		public void keyTyped(KeyEvent e) {
			// Unused
		}
	
		private void handleArrowKeys() {
			switch (lastKeyCode) {
				case KeyEvent.VK_UP:
					arrowX += stepSize * Math.cos(arrowAngle);
					arrowY += stepSize * Math.sin(arrowAngle);
					break;
				case KeyEvent.VK_DOWN:
					arrowX -= stepSize * Math.cos(arrowAngle);
					arrowY -= stepSize * Math.sin(arrowAngle);
					break;
				case KeyEvent.VK_LEFT:
					arrowAngle -= rotationStep;
					break;
				case KeyEvent.VK_RIGHT:
					arrowAngle += rotationStep;
					break;
			}
	
			// Repaint the panel to update the arrow's position and rotation
			repaint();
		}
	}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AopsMain arrowGrid = new AopsMain();
            arrowGrid.setVisible(true);
			arrowGrid.getContentPane().getComponent(0).requestFocusInWindow();
		});

		testJava();
    }

	public static void testJava() {
		System.out.println("\n\nStarting up!");
		System.out.println("Current JVM version - " + System.getProperty("java.version"));

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