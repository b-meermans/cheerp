package com.aops.main.SwingGUI.GUI;

import javax.swing.*;

import com.aops.main.StudentCode.MyStage;
import com.aops.main.SwingGUI.AOPS.Actor;
import com.aops.main.SwingGUI.AOPS.Stage;
import com.aops.main.SwingGUI.Listeners.KeyboardListener;
import com.aops.main.SwingGUI.Listeners.MouseListener;
import com.aops.main.SwingGUI.Listeners.UpdateTimerListener;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StagePanel extends JPanel {
    private static final List<Actor> actors = new ArrayList<>();

    private Stage stage;
    private UpdateTimerListener updateTimerListener;
    
    public StagePanel() {
        addListeners();
        setFocus();
        setPreferredSize(new Dimension(400, 400)); // Adjust the size as needed

        reset();
    }

    public void reset() {
        actors.clear();
        stage = new MyStage();
        repaint();
    }

    public static void addActor(Actor actor) {
        actors.add(actor);
    }

    public void act() {
        stage.act();
        for (Actor actor : actors) {
            actor.act();
        }
    }

    public UpdateTimerListener getUpdateTimerListener() {
        return updateTimerListener;
    }

    private void addListeners() {
        StagePanel myself = this;
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                addKeyListener(new KeyboardListener());
                setFocusable(true);
                updateTimerListener = new UpdateTimerListener(myself);
                addMouseListener(new MouseListener());
                addMouseMotionListener(new MouseListener());
            }
        });
    }

    private void setFocus() {
        setFocusable(true);
        requestFocus();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(stage.getImage(), 0, 0, getWidth(), getHeight(), this);

        // Draw the grid
        drawGrid(g);

        for (Actor actor : actors) {
            drawActor(g, actor);
        }
    }

    private void drawGrid(Graphics g) {
        int gridSize = 20;
        g.setColor(new Color(0, 0, 0, 10));

        // Draw horizontal lines
        for (int y = 0; y <= getHeight(); y += gridSize) {
            g.drawLine(0, y, getWidth(), y);
        }

        // Draw vertical lines
        for (int x = 0; x <= getWidth(); x += gridSize) {
            g.drawLine(x, 0, x, getHeight());
        }
    }

    public void drawActor(Graphics g, Actor actor) {
        if (actor.getImage() != null) {
            Graphics2D g2d = (Graphics2D) g;
    
            // Translate and rotate the arrow image
            double drawX = actor.getX() - actor.getWidth() / 2;
            double drawY = actor.getY() - actor.getHeight() / 2;
    
            g2d.translate(drawX + actor.getWidth() / 2, drawY + actor.getHeight() / 2);
            g2d.rotate(actor.getAngle());
    
            // Draw the arrow image
            g2d.drawImage(
                actor.getImage(), -actor.getWidth() / 2, -actor.getHeight() / 2, 
                actor.getWidth(), actor.getHeight(), null
            );

            // Reset transformations
            g2d.rotate(-actor.getAngle());
            g2d.translate(-(drawX + actor.getWidth() / 2), -(drawY + actor.getHeight() / 2));
        }
    }
}

