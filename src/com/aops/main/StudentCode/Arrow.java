package com.aops.main.StudentCode;

import com.aops.main.SwingGUI.AOPS.Actor;
import com.aops.main.SwingGUI.AOPS.Events;

public class Arrow extends Actor {
    private double velocityY = 0.0;
    private double velocityX = 0.0;


    public Arrow() {
        scale(40, 34);
    }

    public void act() {
        if (Events.isKeyDown("space")) {
            velocityY = -5;
        }
        if (Events.isKeyDown("left")) {
            velocityX -= 0.1;
        }
        if (Events.isKeyDown("right")) {
            velocityX += 0.1;
        }

        velocityX *= 0.95;
        velocityY += 0.1;

        setLocation(getX() + velocityX, getY() + velocityY);
    }
}
