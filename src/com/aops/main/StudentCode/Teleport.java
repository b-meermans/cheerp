package com.aops.main.StudentCode;

import com.aops.main.SwingGUI.AOPS.*;
import com.aops.main.SwingGUI.Listeners.MouseListener;

public class Teleport extends Actor {
    public Teleport() {
        scale(15, 15);
    }

    public void act() {
        setLocation(MouseListener.getMouseX(), MouseListener.getMouseY());
    }
    
}
