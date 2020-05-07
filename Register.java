import javafx.util.Pair;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Register extends JPanel {
    public static String chosenImage = "";

    public Register(int i, int i1){
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);

        Icon first = new ImageIcon(getResizedImage("waterfall.jpg"));
        JButton pic1 = new JButton(first);

        Icon second = new ImageIcon(getResizedImage("animal.jpg"));
        JButton pic2 = new JButton(second);

        Icon third = new ImageIcon(getResizedImage("beach.jpg"));
        JButton pic3 = new JButton(third);

        Icon fourth = new ImageIcon(getResizedImage("city.jpg"));
        JButton pic4 = new JButton(fourth);

        Icon fifth = new ImageIcon(getResizedImage("mountains.jpg"));
        JButton pic5 = new JButton(fifth);

        panel.add(pic1);
        panel.add(pic2);
        panel.add(pic3);
        panel.add(pic4);
        panel.add(pic5);

        pic1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

            }
        });
        pic2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

            }
        });
        pic3.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

            }
        });
        pic4.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

            }
        });
        pic5.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

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
