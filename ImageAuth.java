import javax.swing.*;

public class ImageAuth {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(new ContentPanel(5,5));
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);
    }
}