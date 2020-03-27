package main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @drawShape Prima data genereaza un numar random cu care se va calcula dimensiunea formei desenate, iar din
 * panoul de configurare va prelua numarul de muchii ale formei.
 * Dupa verifica ce a fost selectat in JComboBox si conform variantei selectate (random sau black)
 * va genera o culoare random (sau negru) la care se va adauga transparenta, dupa va seta culoarea si
 * va umple forma.
 */
public class DrawingPanel extends JPanel {
    Color color = new Color(1, 1, 1, 1);
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, W, H);
    }

    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }

    private void drawShape(int x, int y) {
        Random rand0 = new Random();
        int radius = rand0.nextInt(100) + 25;
        int sides = (Integer) this.frame.configPanel.sidesField.getValue();

        if (frame.configPanel.colorCombo.getSelectedIndex() == 0) {
            Random rand1 = new Random();
            Random rand2 = new Random();
            Random rand3 = new Random();
            float r = rand1.nextFloat();
            float g = rand2.nextFloat();
            float b = rand3.nextFloat();
            color = new Color(r, g, b, .5f);
        } else {
            color = new Color(0, 0, 0, .5f);
        }
        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }

    @Override
    public void update(Graphics g) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

}
