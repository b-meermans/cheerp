package com.aops.main.SwingGUI.GUI;

import javax.swing.*;

public class SwingRunner extends JFrame {
    public SwingRunner() {
        setTitle("AoPS GUI");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a custom JPanel to the frame
        GuiPanel guiPanel = new GuiPanel();
        add(guiPanel);
        setVisible(true);
    }

    public static void testSwing() {
        SwingUtilities.invokeLater(SwingRunner::new);
    }
}

