package com.aops.main.SwingGUI.GUI;

import javax.swing.*;

public class SwingRunner extends JFrame {
    public SwingRunner() {
        setTitle("AoPS GUI");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a custom JPanel to the frame
        GuiPanel guiPanel = new GuiPanel();
        add(guiPanel);
    }

    public static void testSwing() {
        SwingUtilities.invokeLater(() -> {
            SwingRunner swingRunner = new SwingRunner();
            swingRunner.setVisible(true);
			swingRunner.getContentPane().getComponent(0).requestFocusInWindow();
		});
    }
}
