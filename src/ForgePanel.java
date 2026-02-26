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
    private CanvasPanel canvasPanel = new CanvasPanel();

    private Timer forgeTimer;

    private int ore = 0, ingot = 0, xp = 0;
    private boolean isForging = false;
    private int forgeProgress = 0;

    public ForgePanel() {

        forgeTimer = new Timer(50, e -> {
            //increment forgeProgress
            forgeProgress += 1;
            //push to CanvasPanel
            canvasPanel.setForgeProgress(forgeProgress);
            //when progress >= 100 stop and complete
            if(forgeProgress >= 100){
                forgeTimer.stop();
                forgeProgress = 0;
                canvasPanel.setForgeProgress(0);
                ingot--;
                xp += 10;
                canvasPanel.setXp(xp);
                isForging = false;
                status.setText("Sword complete! +10xp ");
            }
        });

        this.setLayout(new BorderLayout());
        this.add(status, BorderLayout.NORTH);

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
                if(ingot>=1 && !isForging){
                    forgeProgress = 0;
                    canvasPanel.setForgeProgress(0);
                    isForging = true;
                    status.setText("Forging...");
                    forgeTimer.start();
                } else if (ingot<1){
                    status.setText("You do not have enough ingots to forge.");
                } else {
                    status.setText("You are already forging.");
                }
            }
        });

    }
}
