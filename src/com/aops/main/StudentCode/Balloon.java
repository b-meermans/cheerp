package com.aops.main.StudentCode;
import com.aops.main.SwingGUI.AOPS.*;

public class Balloon extends Actor {
    public Balloon() {
        scale(30, 30);
    }

    public void act() {
        if (Events.isKeyDown("up")) {
            move(5);
        }
        if (Events.isKeyDown("left")) {
            turn(-0.1);
        }
        if (Events.isKeyDown("down")) {
            move(-2);
        }
        if (Events.isKeyDown("right")) {
            turn(0.1);
        }
    }
}
