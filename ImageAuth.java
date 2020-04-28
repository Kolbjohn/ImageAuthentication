import javax.swing.*;
import java.util.ArrayList;

public class ImageAuth {
    //public static ArrayList sequences = new ArrayList();

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(new ContentPanel(5,5));
        f.setSize(1920,1080);
        f.setLocation(0,0);
        f.setResizable(false);
        f.setVisible(true);
    }
}