package com.aops.main.SwingGUI.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;


public class ImageLoader {
    private static final int DEFAULT_WIDTH = 10;
    private static final int DEFAULT_HEIGHT = 10;
    private static final Color DEFAULT_COLOR = Color.WHITE;


    public static Image loadImage(String imageName) {
        if (imageName == null) {
            return defaultImage();
        }

        try {
            URL imageUrl = ImageLoader.class.getResource("/images/" + imageName);
            return ImageIO.read(imageUrl);
        } catch (Exception e) {
            System.out.println("Image: " + imageName + " not found.");
            return defaultImage();
        }
    }

    private static Image defaultImage() {
        BufferedImage image = new BufferedImage(DEFAULT_WIDTH, DEFAULT_HEIGHT, BufferedImage.TYPE_INT_RGB);

        // Fill the image with black pixels
        Graphics g = image.getGraphics();
        g.setColor(DEFAULT_COLOR);
        g.fillRect(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        g.dispose();

        return image;
    }
}
