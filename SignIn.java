import javafx.util.Pair;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

class SignIn extends JPanel {
    private static int counter = 0;
    private static int correctCounter = 0;
    SignIn(JFrame jf){

        final JLabel imageLabel = loadImage(Register.chosenImage);

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
                    JOptionPane.showMessageDialog(jf, "Correct password! Good job.");
                    counter = 0;
                    correctCounter = 0;
                    jf.dispose();
                }
                else {
                    if (counter >= 3) {
                        JOptionPane.showMessageDialog(jf, "Incorrect password!");
                        counter = 0;
                        correctCounter = 0;
                    }
                }
            }
        });
        setLayout(new BorderLayout());
        add(panel);
    }

    private static JLabel loadImage(String fileName)
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
        assert image != null;
        return new JLabel(new ImageIcon(image));
    }

    private void checkCoordinates(Point p, int counter)
    {
        Pair<Double, Double> firstPoint = RegisterClicks.sequence.get(0);

        Pair<Double, Double> secondPoint = RegisterClicks.sequence.get(1);

        Pair<Double, Double> thirdPoint = RegisterClicks.sequence.get(2);

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
    }
}
