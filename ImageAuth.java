import javax.swing.*;

public class ImageAuth {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("Image Authentication");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(new ContentPanel());
        f.setSize(350,150);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setVisible(true);
    }
}