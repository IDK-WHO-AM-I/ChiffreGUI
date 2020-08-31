import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CustomJFrame extends JFrame {

    private JPanel contentPanel = new JPanel();
    private GridBagConstraints gbc = new GridBagConstraints();

    public CustomJFrame(String title) throws IOException {
        super(title);

        setSize(750, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        contentPanel.setLayout(new GridBagLayout());

        addLabel("Enter Text:", 1, 1);
        JTextField textField = addTextField(75, 50, 2, 1, 2, 1);
        textField.setText("happy");
        JLabel image = addImage(createImage("happy"), 2, 2);
        JButton button = addButton("OK", 150, 50, 3, 2);
        JLabel label = addLabel("Heute bin ich happy!", 3, 1);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() instanceof JButton) {
                    label.setText("Heute bin ich " + textField.getText());
                    try {
                        image.setIcon(createImage(textField.getText()));
                    } catch (IOException e) {
                        image.setText("Image not found!");
                    }
                }
            }
        });

        this.getContentPane().add(contentPanel);
        contentPanel.setVisible(true);
        setVisible(true);
        setResizable(false);
    }

    private JPanel addPanel(int width, int height, int gridX, int gridY) {
        JPanel panel = new JPanel();
        panel.setVisible(true);
        panel.setSize(width, height);
        gbc.gridx = gridX;
        gbc.gridy = gridY;
        contentPanel.add(panel, gbc);
        return panel;
    }

    private JTextField addTextField(int width, int height, int gridX, int gridY, int gridWidth, int gridHeight) {
        JTextField textField = new JTextField();
        textField.setSize(width, height);
        textField.setVisible(true);
        gbc.gridx = gridX;
        gbc.gridy = gridY;
        contentPanel.add(textField, gbc);
        return textField;
    }

    private ImageIcon createImage(String filename) throws IOException {
        Image image = ImageIO.read(getClass().getResource(filename + ".png"));
        return new ImageIcon(image);
    }

    private JLabel addImage(ImageIcon imageIcon, int gridX, int gridY) {
        JLabel label = new JLabel(imageIcon);
        label.setVisible(true);
        gbc.gridx = gridX;
        gbc.gridy = gridY;
        contentPanel.add(label, gbc);
        return label;
    }

    private JButton addButton(String text, int width, int height, int gridX, int gridY) {
        JButton button = new JButton(text);
        button.setVisible(true);
        button.setSize(width, height);
        gbc.gridx = gridX;
        gbc.gridy = gridY;
        contentPanel.add(button, gbc);
        return button;
    }

    private JLabel addLabel(String text, int gridX, int gridY) {
        JLabel label = new JLabel(text);
        label.setVisible(true);
        gbc.gridx = gridX;
        gbc.gridy = gridY;
        contentPanel.add(label, gbc);
        return label;
    }


}
