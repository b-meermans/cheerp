package com.aops.main.StudentCode;
import com.aops.main.SwingGUI.AOPS.*;

public class MyStage extends Stage{
    public MyStage() {
        super(400, 400, "background.jpg");
        
        addActor(new Balloon(), 50, 50);
        addActor(new Arrow(), 200, 100);
        addActor(new RightWalk(), 0, 150);
    }
}
