import javafx.util.Pair;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;

class RegisterClicks extends JPanel {
    private static int counter = 0;
    static ArrayList<Pair<Double, Double>> sequence = new ArrayList<>();

    RegisterClicks(JFrame jf){
        sequence.clear();
        final JLabel imageLabel = loadImage(Register.chosenImage);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.add(imageLabel, new GridBagConstraints());

        imageLabel.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                Point p = e.getPoint();
                sequence.add(new Pair<>(p.getX(), p.getY()));
                counter++;
                if(counter == 3){
                    JOptionPane.showMessageDialog(null, "The password has been registered!");
                    counter = 0;
                    jf.dispose();
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
}
