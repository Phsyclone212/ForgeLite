import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgePanel extends JPanel {

    private JLabel status = new JLabel("Ready");
    private JButton mineBtn = new JButton("Mine"),
        smeltBtn = new JButton("Smelt"),
        forgeBtn = new JButton("Forge");

    private int ore = 0, ingot = 0, xp = 0;

    public ForgePanel() {

        this.setLayout(new BorderLayout());
        this.add(status, BorderLayout.NORTH);

        JPanel canvasPanel = new JPanel();
        this.add(canvasPanel, BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        this.add(buttons, BorderLayout.SOUTH);
        buttons.add(mineBtn);
        buttons.add(smeltBtn);
        buttons.add(forgeBtn);

        mineBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //60% pass 40% fail rate
                if(Math.random()>.4){
                    ore++;
                    status.setText("You successfully mined some ore. You have: "+ore+".");
                } else {
                    status.setText("You failed to mine any ore.");
                }
            }
        });

        smeltBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ore>=1){
                    ore--;
                    ingot++;
                    status.setText("You successfully smelt an ingot. Ores: "+ore+" Ingots: "+ingot);
                } else {
                    status.setText("You do not have any ore to smelt.");
                }
            }
        });

        forgeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ingot>=1){
                    //will forge after we implement that
                    status.setText("The anvil isn't ready for forging right now.");
                } else {
                    status.setText("You do not have enough ingots to forge.");
                }
            }
        });

    }
}
