import javafx.util.Pair;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class Register extends JPanel {
    static int counter = 0;
    static int correctCounter = 0;
    public Register(int i, int i1){
        final JLabel imageLabel = loadImage("waterfall.jpg");

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.add(imageLabel, new GridBagConstraints());

        imageLabel.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                Point p = e.getPoint();
                counter++;
                checkCoordinates(p, counter);
                if(correctCounter == 3){
                    JOptionPane.showMessageDialog(null, "Correct password! Good job.");
                    counter = 0;
                    correctCounter = 0;
                }
                else {
                    if (counter >= 3) {
                        JOptionPane.showMessageDialog(null, "Incorrect password!");
                        counter = 0;
                        correctCounter = 0;
                    }
                }
                System.out.println(p.getX()+", "+p.getY());
            }
        });
        setLayout(new BorderLayout());
        add(panel);
    }

    public static JLabel loadImage(String fileName)
    {
        Image image = null;
        try
        {
            URL url = ContentPanel.class.getResource(fileName);
            image = ImageIO.read(url);
        }
        catch(Exception ioe)
        {
            System.out.println("read: " + ioe.getMessage());
        }
        return new JLabel(new ImageIcon(image));
    }

    private void checkCoordinates(Point p, int counter)
    {
        System.out.println(counter);
        Pair<Double, Double> firstPoint = new Pair<>(923.0, 921.0);
        Pair first = new Pair<>(firstPoint, 1);

        Pair<Double, Double> secondPoint = new Pair<>(1047.0, 690.0);
        Pair second = new Pair<>(secondPoint, 2);

        Pair<Double, Double> thirdPoint = new Pair<>(374.0, 818.0);
        Pair third = new Pair<>(thirdPoint, 3);

        double x = p.getX();
        double y = p.getY();
        if(counter == 1){
            if(Math.abs(x - firstPoint.getKey()) <= 30 && Math.abs(y - firstPoint.getValue()) <= 30){
                correctCounter++;
            }
        }
        else if(counter == 2){
            if(Math.abs(x - secondPoint.getKey()) <= 30 && Math.abs(y - secondPoint.getValue()) <= 30){
                correctCounter++;
            }
        }
        else{
            if(Math.abs(x - thirdPoint.getKey()) <= 30 && Math.abs(y - thirdPoint.getValue()) <= 30){
                correctCounter++;
            }
        }
        if(correctCounter == 3){
            System.out.println("Correct password!");
        }
    }
}
