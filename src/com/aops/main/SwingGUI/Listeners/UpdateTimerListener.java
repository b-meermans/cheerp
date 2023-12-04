package com.aops.main.SwingGUI.Listeners;

import javax.swing.*;

import com.aops.main.SwingGUI.GUI.StagePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateTimerListener {
    private static final int DELAY_MILLISECONDS = 20;
    private Timer timer; 

    public UpdateTimerListener(StagePanel stagePanel) {
        timer = new Timer(DELAY_MILLISECONDS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stagePanel.act();
                stagePanel.repaint();
            }
        });
    }

    public boolean isRunning() {
        return timer.isRunning();
    }

    public void stop() {
        timer.stop();
    }

    public void start() {
        timer.start();
    }
}
