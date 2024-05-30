import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {
    private final double MOVE_AMT = 7.0;
    private BufferedImage right;
    private BufferedImage left;
    private double xCoord;
    private double yCoord;
    private int health;
    private int difficulty;
    private boolean facingRight;
    private boolean jump;
    private float airSpeed = 0f;
    private float gravity = 0.04f * 3;
    private float jumpSpeed = -2.25f * 3;
    private boolean inAir = false;

    public Player(String imageRight, String imageLeft, String difficulty) {
        xCoord = 50;
        facingRight = true;
        if (difficulty.equals("h")) {
            health = 1;
            yCoord = 495;
        }
        else if (difficulty.equals("m")){
            health = 3;
            yCoord = 565;
        }
        else if (difficulty.equals("e")) {
            health = 5;
            yCoord = 465;
        }
        try {
            right = ImageIO.read(new File(imageRight));
            left = ImageIO.read(new File(imageLeft));
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

    public void faceRight() {
        facingRight = true;
    }

    public void faceLeft() {
        facingRight = false;
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

    public void jump() {
        if (inAir) {
            if (yCoord + airSpeed < 750) {
                yCoord += airSpeed;
                airSpeed += gravity;
            }
            else {
                if (airSpeed > 0) {
                    resetInAir();
                }
            }
        }
        else {
            inAir = true;
        }
    }

    public void resetInAir() {
        inAir = false;
        airSpeed = 0;
    }

    public void moveDown() {
        if (yCoord + MOVE_AMT <= 655) {
            yCoord += MOVE_AMT;
        }
    }

    public void turn() {
        if (facingRight) {
            faceLeft();
        }
        else {
            faceRight();
        }
    }

    public BufferedImage getPlayerImage() {
        if (facingRight) {
            return right;
        }
        else {
            return left;
        }
    }

    public Rectangle playerRect() {
        int imageHeight = getPlayerImage().getHeight();
        int imageWidth = getPlayerImage().getWidth();
        Rectangle rect = new Rectangle((int) xCoord, (int) yCoord, imageWidth, imageHeight);
        return rect;
    }
}
