package gui;

import chiffre.ChiffreAlgorythm;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class ChiffreSelectionFrame extends JFrame {

    private JPanel contentPanel;

    public ChiffreSelectionFrame() throws HeadlessException {
        super("Chiffre Selection");
        contentPanel = new JPanel();
        initElements();
    }

    private void initElements() {


        String[] options = new String[]{"Ceasar", "Playfair", "Polybios", "Substitution"};
        JComboBox<String> chiffreSelect = new JComboBox<>(options);

        JLabel chiffreSelectLabel = new JLabel("Please Select a Chiffre Algorythm: ");
        chiffreSelectLabel.setLabelFor(chiffreSelect);

        contentPanel.add(chiffreSelectLabel);
        contentPanel.add(chiffreSelect);

        getContentPane().setSize(150, 100);
        getContentPane().add(contentPanel);
        getContentPane().setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
