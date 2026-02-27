import javax.swing.*;
import java.awt.*;

public class CanvasPanel extends JPanel {
    private int forgeProgress;
    private int xp;
    private static final int PAD = 20;
    private static final int BAR_HEIGHT = 20;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int p = Math.max(0, Math.min(forgeProgress, 100));
        int barW = getWidth() - PAD * 2;
        int fillW = (int)(barW * (p / 100f));
        // progress bar
        g.drawRect(PAD, 20, barW, BAR_HEIGHT);
        g.setColor(Color.BLUE);
        g.fillRect(PAD+1,21, fillW, BAR_HEIGHT-1);
        // xp bar
        g.setColor(Color.BLACK);
        g.drawRect(PAD, 50, barW, BAR_HEIGHT);
        g.setColor(Color.GREEN);
        int xpClamp = Math.max(0, Math.min(xp, 50));
        int xpFillW = (int)(barW * (xpClamp / 50f));
        g.fillRect(PAD+1,51, xpFillW, BAR_HEIGHT-1);

    }

    public void setForgeProgress(int p){
        this.forgeProgress = p;
        repaint();
    }

    public void setXp(int xp){
        this.xp = xp;
        repaint();
    }
}
