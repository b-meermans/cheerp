package com.aops.main.SwingGUI.GUI;

import javax.swing.*;
import com.aops.main.SwingGUI.Listeners.UpdateTimerListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiPanel extends JPanel {
    private StagePanel stagePanel;

    public GuiPanel() {
        setLayout(new BorderLayout());

        // Stage Panel
        stagePanel = new StagePanel();
        add(stagePanel, BorderLayout.CENTER);
        stagePanel.setFocusable(true);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        // Act Button
        JButton actButton = new JButton("Act");
        actButton.setFocusable(false);
        actButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stagePanel.act();
                stagePanel.repaint();
            }
        });

        // Start/Stop Button
        JButton startStopButton = new JButton("Start");
        startStopButton.setFocusable(false);
        startStopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateTimerListener updateTimerListener = stagePanel.getUpdateTimerListener();
                if (updateTimerListener.isRunning()) {
                    updateTimerListener.stop();
                    startStopButton.setText("Start");
                    actButton.setEnabled(true); 
                } else {
                    updateTimerListener.start();
                    startStopButton.setText("Stop");
                    actButton.setEnabled(false); 
                }
            }
        });

        // Reset Button
        JButton resetButton = new JButton("Reset");
        resetButton.setFocusable(false);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stagePanel.getUpdateTimerListener().stop();
                stagePanel.reset();
                startStopButton.setText("Start");
                actButton.setEnabled(true); 
            }
        });

        buttonPanel.add(actButton);
        buttonPanel.add(startStopButton);
        buttonPanel.add(resetButton);

        setPreferredSize(new Dimension(400, 400));
    }
}
