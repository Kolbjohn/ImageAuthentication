import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Map;

public class ContentPanel extends JPanel {
    public ContentPanel(int rows, int columns){
        final JLabel imageLabel = loadImage();
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < columns; col++){
                gbc.gridx = row;
                gbc.gridy = col;

                Border border = null;
                if (row < rows-1) {
                    if (col < columns-1) {
                        border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
                    }
                } else {
                    if (col < columns-1) {
                        border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                    }
                }
                imageLabel.setBorder(border);
            }
        }
        panel.add(imageLabel, gbc);
        imageLabel.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                Point p = e.getPoint();
                System.out.println(p.getX()+", "+p.getY());
            }
        });
        setLayout(new BorderLayout());
        add(panel);
    }

    private Map<Rectangle[], Integer> getClickableRegions(JLabel label)
    {
        int w = label.getWidth();
        int h = label.getHeight();

        return null;
    }

    private JLabel loadImage()
    {
        String fileName = "waterfall.jpg";
        Image image = null;
        try
        {
            URL url = getClass().getResource(fileName);
            image = ImageIO.read(url);
        }
        catch(Exception ioe)
        {
            System.out.println("read: " + ioe.getMessage());
        }
        return new JLabel(new ImageIcon(image));
    }
}
