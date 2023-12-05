package com.aops.main.StudentCode;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import com.aops.main.SwingGUI.AOPS.*;
import com.aops.main.SwingGUI.Listeners.MouseListener;

public class MyStage extends Stage{
    private int lastX;
    private int lastY;

    public MyStage() {
        super(800, 600, "background.jpg");
        
        addActor(new Balloon(), 50, 50);
        addActor(new Arrow(), 200, 100);
        addActor(new RightWalk(), 0, 150);
        addActor(new Teleport(), 300, 300);

    }

    // public void act() {
    //     int currentX = MouseListener.getMouseX();
    //     int currentY = MouseListener.getMouseY();
    //     drawLineOnImage(lastX, lastY, currentX, currentY);

    //     lastX = currentX;
    //     lastY = currentY;
    // }

    // public void drawLineOnImage(int x1, int y1, int x2, int y2) {
    //     Image image = super.getImage();

    //     BufferedImage bufferedImage = new BufferedImage(
    //         image.getWidth(null),
    //         image.getHeight(null),
    //         BufferedImage.TYPE_INT_ARGB
    //     );

        
    //     Graphics g = bufferedImage.getGraphics();
    //     g.drawImage(image, 0, 0, null);

    //     g.setColor(Color.RED);
    //     g.drawLine(x1, y1, x2, y2);
    //     g.dispose();
    //     super.setImage(bufferedImage);
    // }
}
