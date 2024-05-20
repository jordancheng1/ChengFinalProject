import javax.swing.*;

public class WelcomeFrame {
    private WelcomePanel panel;

    public WelcomeFrame() {
        JFrame frame = new JFrame("CHARACTER SELECT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);

        panel = new WelcomePanel(frame);
        frame.add(panel);

        frame.setVisible(true);
    }
}
