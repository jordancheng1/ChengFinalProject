//import javax.swing.*;
//import javax.swing.JFrame;
//
//public class WelcomeFrame extends JFrame implements Runnable {
//    private WelcomePanel w;
//    private Thread windowThread;
//
//    public WelcomeFrame(String display) {
//        super(display);
//        w = new WelcomePanel(w);
//        this.add(w);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setSize(1000, 1400);
//        this.setVisible(true);
//        startThread();
//    }
//
//    public void startThread() {
//        windowThread = new Thread(this);
//        windowThread.start();
//    }
//    public void run() {
//        while (true) {
//            w.repaint();
//        }
//    }
//}
