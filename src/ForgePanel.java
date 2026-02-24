import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class ForgePanel extends JPanel {

    private JButton mineBtn = new JButton("Mine"),
        smeltBtn = new JButton("Smelt"),
        forgeBtn = new JButton("Forge");

    public ForgePanel() {

        this.setLayout(new BorderLayout());

        JLabel status = new JLabel("Ready");
        this.add(status, BorderLayout.NORTH);

        JPanel canvasPanel = new JPanel();
        this.add(canvasPanel, BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        this.add(buttons, BorderLayout.SOUTH);
        buttons.add(mineBtn);
        buttons.add(smeltBtn);
        buttons.add(forgeBtn);


    }
}
