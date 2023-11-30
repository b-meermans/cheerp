package com.aops.main;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SwingTest extends JFrame {

    private int arrowX = 100;
    private int arrowY = 100;
    private double arrowAngle = 0; // in radians

    public SwingTest() {
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
		private JLabel timeLabel;

		public ArrowPanel() {
			timeLabel = new JLabel();
			timeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
			updateTime();

			Timer timer = new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					updateTime();
				}
			});
			timer.start();

			add(timeLabel);


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

		private void updateTime() {
			// Update the time label with the current time
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			String currentTime = dateFormat.format(new Date());
			timeLabel.setText("Current Time: " + currentTime);
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
    

    public static void testSwing() {
            SwingUtilities.invokeLater(() -> {
            SwingTest arrowGrid = new SwingTest();
            arrowGrid.setVisible(true);
			arrowGrid.getContentPane().getComponent(0).requestFocusInWindow();
		});
    }
}
