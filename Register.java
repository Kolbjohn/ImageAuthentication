import javafx.util.Pair;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Register extends JPanel {
    public static String chosenImage = "";

    public Register(JFrame jf){
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);

        Icon first = new ImageIcon(getResizedImage("waterfall.jpg"));
        JButton pic1 = new JButton(first);

        Icon second = new ImageIcon(getResizedImage("animal.jpg"));
        JButton pic2 = new JButton(second);

        Icon third = new ImageIcon(getResizedImage("beach.jpg"));
        JButton pic3 = new JButton(third);

        Icon fourth = new ImageIcon(getResizedImage("forest.jpg"));
        JButton pic4 = new JButton(fourth);

        Icon fifth = new ImageIcon(getResizedImage("newyork.jpg"));
        JButton pic5 = new JButton(fifth);

        panel.add(pic1);
        panel.add(pic2);
        panel.add(pic3);
        panel.add(pic4);
        panel.add(pic5);

        pic1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                chosenImage = "waterfall.jpg";
                JFrame f = new JFrame();
                f.setContentPane(new RegisterClicks(f));
                f.setSize(1920,1080);
                f.setLocation(0,0);
                f.setResizable(false);
                f.setVisible(true);
                jf.dispose();
            }
        });
        pic2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                chosenImage = "animal.jpg";
                JFrame f = new JFrame();
                f.setContentPane(new RegisterClicks(f));
                f.setSize(1920,1080);
                f.setLocation(0,0);
                f.setResizable(false);
                f.setVisible(true);
                jf.dispose();
            }
        });
        pic3.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                chosenImage = "beach.jpg";
                JFrame f = new JFrame();
                f.setContentPane(new RegisterClicks(f));
                f.setSize(1920,1080);
                f.setLocation(0,0);
                f.setResizable(false);
                f.setVisible(true);
                jf.dispose();
            }
        });
        pic4.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                chosenImage = "forest.jpg";
                JFrame f = new JFrame();
                f.setContentPane(new RegisterClicks(f));
                f.setSize(1920,1080);
                f.setLocation(0,0);
                f.setResizable(false);
                f.setVisible(true);
                jf.dispose();
            }
        });
        pic5.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                chosenImage = "newyork.jpg";
                JFrame f = new JFrame();
                f.setContentPane(new RegisterClicks(f));
                f.setSize(1920,1080);
                f.setLocation(0,0);
                f.setResizable(false);
                f.setVisible(true);
                jf.dispose();
            }
        });

        setLayout(new BorderLayout());
        add(panel);
    }

    private Image getResizedImage(String url){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img.getScaledInstance(350, 180,
                Image.SCALE_SMOOTH);
    }
}
