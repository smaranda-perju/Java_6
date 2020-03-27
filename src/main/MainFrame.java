package main;

import javax.swing.*;
import java.awt.*;

/**
 * @MainFrame este constructorul Frame-ului
 * Setam titlul aplicatiei si initializam aplicatia
 * @init metoda initializeaza componentele aplicatiei si anume
 * panoul de configuratie (top), panoul de control (bottom) si canvasul (center)
 */
public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);

        this.add(configPanel, BorderLayout.NORTH);
        this.add(controlPanel, BorderLayout.SOUTH);
        this.add(canvas, BorderLayout.CENTER);

        pack();
    }
}
