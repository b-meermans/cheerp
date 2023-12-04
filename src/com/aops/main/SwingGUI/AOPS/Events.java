package com.aops.main.SwingGUI.AOPS;

import com.aops.main.SwingGUI.Listeners.KeyboardListener;

public class Events {    
    public static boolean isKeyDown(String key) {
        return KeyboardListener.isDown(key);
    }
}
