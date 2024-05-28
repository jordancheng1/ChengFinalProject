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

public class WelcomePanel extends JPanel implements MouseListener {
    private JFrame enclosingFrame;
    private BufferedImage select;
    private BufferedImage characterSelect;
    private BufferedImage character1;
    private Rectangle character1Button;
    private Rectangle selectButton;
    private double xCoord = 50;
    private double yCoord = 50;
    private String charName = "";
    private boolean charSelected;

    public WelcomePanel(JFrame frame) {
        enclosingFrame = frame;
        try {
            select = ImageIO.read(new File("src/SelectButton.png"));
            characterSelect = ImageIO.read(new File("src/CharacterSelect.png"));
            character1 = ImageIO.read(new File("src/Aang.png"));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        character1Button = new Rectangle(100, 0, character1.getWidth(), character1.getHeight());
        selectButton = new Rectangle(0, 100, select.getWidth(), select.getHeight());
        this.addMouseListener(this);
        charSelected = false;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (charSelected) {
            g.drawImage(select, 0, 100, null);
        }
//        g.drawImage(characterSelect, 100, 0, null);
        g.drawImage(character1, 100, 0, null);
        g.drawRect((int) character1Button.getX(), 100, (int) character1Button.getWidth(), (int) character1Button.getHeight());
    }

    public void mousePressed(MouseEvent e) {
        Point mouseClickLocation = e.getPoint();
        if (selectButton.contains(mouseClickLocation) && !charName.isEmpty()) {
//            MainFrame f = new MainFrame(charName);
            enclosingFrame.setVisible(false);
        }
        else if (character1Button.contains(mouseClickLocation)) {
            charName = "The Avatar";
            charSelected = true;
        }
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e){}
}
