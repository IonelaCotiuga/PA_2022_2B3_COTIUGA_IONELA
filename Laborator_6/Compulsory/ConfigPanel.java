package lab6;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinner;
    JSpinner spinner1;
    JButton createBtn = new JButton("Create");

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {

        label = new JLabel("Grid size:");
        spinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinner1 = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));

        add(label);
        add(spinner);
        add(spinner1);
        add(createBtn);
        createBtn.addActionListener(this::createGame);
    }

    private void createGame(ActionEvent e){
        frame.canvas.init((Integer) spinner.getValue(), (Integer) spinner1.getValue());
        this.frame.repaint();
    }

    public int getRows() {
        return (Integer) spinner.getValue();
    }

    public int getCols() {
        return (Integer) spinner1.getValue();
    }
}
