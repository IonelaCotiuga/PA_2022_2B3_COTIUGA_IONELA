package lab8;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Frame extends JFrame {
    public Frame() throws SQLException {
        initComponents();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Frame();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initComponents() throws SQLException {
        Database.createConnection();
        JFrame frame = new JFrame("Name");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel testPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                Graphics2D g2d = (Graphics2D) grphcs;

                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(Color.BLACK);

                SphericalMercator s = new SphericalMercator();

                try {
                    var citiesDAO = new CitiesDAO();
                    int nrCities = citiesDAO.getNrCities();
                    for(int id = 1; id <= nrCities; id++){
                        int x = (int) s.xAxisProjection(citiesDAO.findLatitude(id));
                        int y = (int) s.yAxisProjection(citiesDAO.findLongitude(id));
                        g2d.drawOval(x,y,10,10);
                        g2d.drawString(citiesDAO.findCity(id), x, y);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(1000, 1000);
            }
        };

        frame.add(testPanel);
        frame.pack();
        frame.setVisible(true);
    }

}