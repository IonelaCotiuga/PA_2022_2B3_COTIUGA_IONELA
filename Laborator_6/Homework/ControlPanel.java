package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");


    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));

        exitBtn.addActionListener(this::exitGame);
        saveBtn.addActionListener(this::saveGame);
        loadBtn.addActionListener(this::loadGame);

        add(exitBtn);
        add(saveBtn);
        add(loadBtn);

    }
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void saveGame(ActionEvent e) {

    }

    private void loadGame(ActionEvent e) {

    }
}
