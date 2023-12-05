package com.aops.main.SwingGUI.Listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {
    private static int x;
    private static int y;

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    public static int getMouseX() {
        return x;
    }

    public static int getMouseY() {
        return y;
    }
}
