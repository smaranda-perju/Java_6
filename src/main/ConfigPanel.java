package main;

import javax.swing.*;

/**
 * Am adaugat atributul color pt a stabili optiunile posibile atunci cand se va selecta
 * culoarea obiectelor desenate (negru sau random).
 * In sidesField se va seta numarul de laturi pe care il va avea obicetul desenat in aplicatie
 *
 * @init In init se vor crea cele specificate mai sus
 */
public class ConfigPanel extends JPanel {
    String[] color = new String[]{"Random", "Black"};
    final MainFrame frame;
    JLabel sidesLabel; // we’re drawing regular polygons
    JSpinner sidesField; // number of sides
    JComboBox<String> colorCombo; // the color of the shape

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides
        colorCombo = new JComboBox<>(color);//create the colorCombo, containing the values: Random and Black

        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }
}
