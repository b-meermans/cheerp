package com.aops.main.SwingGUI.AOPS;

import java.awt.Image;

import com.aops.main.SwingGUI.GUI.ImageLoader;

public abstract class Actor {
    private static final String DEFAULT_IMAGE = "arrow.png";

    Stage stage;
    private double x;
    private double y;
    private double angle;
    private int width;
    private int height;

    private Image image;

    public Actor() {
        this(0, 0, DEFAULT_IMAGE);
    }

    public Actor(String imageName) {
        this(0, 0, 0, imageName);
    }

    public Actor(double x, double y, String imageName) {
        this(x, y, 0, imageName);
    }

    public Actor(double x, double y, double angle, String imageName) {
        this.x  = x;
        this.y = y;
        this.angle = angle;

        image = ImageLoader.loadImage(imageName);

        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
    }

    public void act() {}

    public Stage getStage() {
        return stage;
    }

    public void move(double distance) {
        x += Math.cos(angle) * distance;
        y += Math.sin(angle) * distance;
    }

    public void turn(double degrees) {
        angle += degrees;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getAngle() {
        return angle % 360;
    }

    public Image getImage() {
        return image;
    }

    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void scale(int width, int height) {
        if (width > 0 && height > 0) {
            this.width = width;
            this.height = height;
        }
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
