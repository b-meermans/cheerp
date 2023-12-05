package com.aops.main.SwingGUI.AOPS;

import java.awt.Image;

import com.aops.main.SwingGUI.GUI.ImageLoader;
import com.aops.main.SwingGUI.GUI.StagePanel;

public abstract class Stage {
    private int width;
    private int height;
    private Image image;

    public Stage() {
        this(800, 600);
    }

    public Stage(int width, int height) {
        this(width, height, null);
    }

    public Stage(int width, int height, String imageName) {
        this.width = width;
        this.height = height;
        
        loadImage(imageName);
    }

    public void act() {}

    public void addActor(Actor actor, double x, double y) {
        StagePanel.addActor(actor);
        actor.setLocation(x, y);
        actor.stage = this;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Image getImage() {
        return image;
    }

    private void loadImage(String imageName) {
        image = ImageLoader.loadImage(imageName);
    }

    public void setImage(Image image) {
        this.image = image;
    }

}
