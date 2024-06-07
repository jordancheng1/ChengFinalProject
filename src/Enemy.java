import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Enemy {
    private int xCoord;
    private int yCoord;
    private BufferedImage image;
    private double MOVE_AMT;

    public Enemy(String difficulty) {
        int spawn = (int) (Math.random() * 2);
        if (spawn == 0) {
            xCoord = 50;
        }
        else {
            xCoord = 1100;
        }
        if (difficulty.equals("h")) {
            yCoord = 495;
        }
        else if (difficulty.equals("m")){
            yCoord = 565;
        }
        else if (difficulty.equals("e")) {
            yCoord = 465;
        }
        try {
            image = ImageIO.read(new File("src/.png"));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void moveRight() {
        if (xCoord + MOVE_AMT <= 1155) {
            xCoord += MOVE_AMT;
        }
    }

    public void moveLeft() {
        if (xCoord - MOVE_AMT >= 0) {
            xCoord -= MOVE_AMT;
        }
    }
    public BufferedImage getImage() {
        return image;
    }

    public Rectangle enemyRect() {
        int imageHeight = getImage().getHeight();
        int imageWidth = getImage().getWidth();
        Rectangle rect = new Rectangle(xCoord, yCoord, imageWidth, imageHeight);
        return rect;
    }
}
