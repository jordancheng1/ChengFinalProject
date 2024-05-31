import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Animator {
    private ArrayList<BufferedImage> aangAttackFrames;
    public BufferedImage sprite;
    private volatile boolean running = false;
    private long beforeTime;
    private long previousTime;
    private long speed;
    private int frameAtPause;
    private int currentFrame;

    public Animator(ArrayList<BufferedImage> frames) {
        aangAttackFrames = frames;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public void update(long time) {
        if (running) {
            if (time - previousTime >= speed) {
                currentFrame++;
                try {
                    sprite = aangAttackFrames.get(frameAtPause);
                }
                catch (IndexOutOfBoundsException e ){
                    currentFrame = 0;
                    sprite = aangAttackFrames.get(currentFrame);
                }
                previousTime = time;
            }
        }
    }

    public void play() {
        running = true;
        previousTime = 0;
        frameAtPause = 0;
        currentFrame = 0;
    }

    public void stop() {
        running = false;
        previousTime = 0;
        frameAtPause = 0;
        currentFrame = 0;
    }

    public void pause() {
        frameAtPause = currentFrame;
        running = false;
    }

    public void resume() {
        currentFrame = frameAtPause;
        running = true;
    }
}
