import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;

public class WelcomePanel extends JPanel {
    private JFrame enclosingFrame;
    private BufferedImage selectButton;
    private BufferedImage characterSelect;
    private BufferedImage character1;
    private double xCoord = 50;
    private double yCoord = 50;
    private String charName;
    private boolean charSelected = false;

    public WelcomePanel(JFrame frame) {
        enclosingFrame = frame;
        try {
            selectButton = ImageIO.read(new File("src/SelectButton.png"));
            characterSelect = ImageIO.read(new File("src/CharacterSelect.png"));
            character1 = ImageIO.read(new File("src/Aang.png"));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (charSelected) {
            g.drawImage(selectButton, 50, 50, null);
        }
        g.drawImage(characterSelect, 100, 0, null);
        g.drawImage(character1, 100, 0, null);
    }

    public void mouseReleased(MouseEvent e) {
        if (selectRect().contains(e.getPoint()) && !charName.isBlank()) {
            MainFrame f = new MainFrame(charName);
            enclosingFrame.setVisible(false);
        }
        else if (character1Rect().contains(e.getPoint())) {
            charName = "The Last Avatar";
            charSelected = true;
        }
    }

    public Rectangle selectRect() {
        int selectButtonHeight = selectButton.getHeight();
        int selectButtonWidth = selectButton.getWidth();
        return new Rectangle((int) xCoord, (int) yCoord, selectButtonWidth, selectButtonHeight);
    }

    public Rectangle character1Rect() {
        int character1Height = character1.getHeight();
        int character1Width = character1.getWidth();
        return new Rectangle((int) xCoord, (int) yCoord, character1Width, character1Height);
    }
}
