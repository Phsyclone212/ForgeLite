import javax.swing.*;

public class ForgeFrame extends JFrame {

    public ForgeFrame() {

        setSize(560, 560);
        setTitle("ForgeLite");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ForgePanel panel = new ForgePanel();
        this.add(panel);
        setVisible(true);
    }

}
