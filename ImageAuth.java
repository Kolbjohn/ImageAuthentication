import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ImageAuth {
    public static Map<String, ArrayList> sequences = new HashMap<>();
    static int totalClicks = 0;

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(new ContentPanel());
        f.setSize(400,200);
        f.setLocation(0,0);
        f.setResizable(false);
        f.setVisible(true);
    }


}