import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


class ContentPanel extends JPanel {

    ContentPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBackground(Color.WHITE);

        JButton button = new JButton("Sign In");

        JButton button2 = new JButton("Register");

        panel.add(Box.createRigidArea(new Dimension(80,0)));
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(30,0)));
        panel.add(button2);

        button.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                if(Register.chosenImage.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please register first!");
                    return;
                }
                JFrame f = new JFrame();
                f.setTitle("Sign In");
                f.setContentPane(new SignIn(f));
                f.setSize(1920,1080);
                f.setLocation(0,0);
                f.setResizable(false);
                f.setVisible(true);
            }
        });

        button2.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                JFrame f = new JFrame();
                f.setTitle("Registration");
                f.setContentPane(new Register(f));
                f.setSize(1920,600);
                f.setLocation(0,0);
                f.setResizable(false);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });

        setLayout(new BorderLayout());
        add(panel);
    }
}
