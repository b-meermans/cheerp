package com.aops.main.SwingGUI.Listeners;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class KeyboardListener implements KeyListener {

    private static Set<Integer> pressedKeys = new HashSet<>();

    public static boolean isDown(String key) {
        try {
            int keyValue = KeyEvent.class.getField("VK_" + key.toUpperCase()).getInt(null);
            return pressedKeys.contains(keyValue);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
