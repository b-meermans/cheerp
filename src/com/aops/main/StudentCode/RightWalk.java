package com.aops.main.StudentCode;

import com.aops.main.SwingGUI.AOPS.Actor;

public class RightWalk extends Actor {
    public RightWalk() {
        super("ScratchCat.png");
        scale(50, 50);
    }

    public void act() {
        setLocation(getX() + 1, getY());
        if (getX() > getStage().getWidth()) {
            setLocation(0, getY());
        }
    }
    
}
