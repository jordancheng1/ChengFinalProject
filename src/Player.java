import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {
    private final double MOVE_AMT = 0.5;
    private BufferedImage character;
    private double xCoord;
    private double yCoord;
    private int health;
    private String name;
    private int difficulty;

    public Player(String image, String name, int difficulty) {
        this.name = name;
        xCoord = 50;
        yCoord = 435;
        if (difficulty > 1) {
            health = 1;
        }
        else {
            health = 5;
        }
        try {
            character =  ImageIO.read(new File(image));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getxCoord() {
        return (int) xCoord;
    }

    public int getyCoord() {
        return (int) yCoord;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void moveRight() {
        if (xCoord + MOVE_AMT <= 1020) {
            xCoord += MOVE_AMT;
        }
    }

    public void moveLeft() {
        if (xCoord - MOVE_AMT >= 0) {
            xCoord -= MOVE_AMT;
        }
    }

    public BufferedImage getPlayerImage() {
        return character;
    }

    public Rectangle playerRect() {
        int imageHeight = getPlayerImage().getHeight();
        int imageWidth = getPlayerImage().getWidth();
        Rectangle rect = new Rectangle((int) xCoord, (int) yCoord, imageWidth, imageHeight);
        return rect;
    }
}
