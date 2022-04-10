package lab6;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Random;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    int rows, cols;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;
    int nrPlayer = 1;

    private HashMap<Integer, Integer> xValuesInters = new HashMap<>();

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
    }

    public void getImage() {
        frame.pack();
        BufferedImage img = new BufferedImage(1000, 600, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        this.paint(g2d);
        g2d.dispose();
        try {
            ImageIO.write(img, "png", new File("frame_2.png"));
        } catch(Exception e) {
            e.printStackTrace();
        }
        frame.dispose();
    }

    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        paintStones();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        paintGrid(g);
        paintSticks(g);
        //paintStones(g);
        //drawStone(getX(),getY());
    }

    private void paintStones(){
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Graphics2D g= (Graphics2D) getGraphics();
                int x=e.getX();
                int y=e.getY();

                /*for(Integer xValue : xValuesInters.keySet()){
                    if(x >= xValue && x <= xValuesInters.get(xValue)){
                        g.setColor(Color.PINK);
                        g.drawOval(xValue - stoneSize / 2 , y - stoneSize / 2 , stoneSize, stoneSize);
                        System.out.println("aici");
                    }
                }*/

                if(nrPlayer%2==0){
                    g.setColor(Color.BLUE);
                    g.drawOval(x - stoneSize / 2, y -stoneSize / 2, stoneSize, stoneSize);
                    g.fillOval(x - stoneSize / 2, y -stoneSize / 2, stoneSize, stoneSize);
                }else{
                    g.setColor(Color.RED);
                    g.drawOval(x - stoneSize / 2, y -stoneSize / 2, stoneSize, stoneSize);
                    g.fillOval(x - stoneSize / 2, y -stoneSize / 2, stoneSize, stoneSize);
                }
                nrPlayer++;
                //frame.canvas.repaint();
            }

        });

    }

    private void drawStone(int x, int y) {
        //TODO
        //Draw a filled oval in the offscreen image
    }

    private void paintSticks(Graphics2D g){
        //Get the current size of this component
        Dimension d = this.getSize();

        g.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        Random r = new Random();
        for (int row = 0; row < rows-1; row++) {
            for (int col = 0; col < cols-1; col++) {

                for(int i = 0; i<=10; i++){
                    int rowRand = r.nextInt(rows - 1) ;
                    int colRand = r.nextInt(cols - 1);

                    if(rowRand == row) {
                        int x = padX + col * cellWidth;
                        int y = padY + row * cellHeight;

                        g.setColor(Color.BLACK);
                        g.drawLine(x, y, x + cellWidth, y);
                    }
                    else if(colRand == col){
                        int x = padX + col * cellWidth;
                        int y = padY + row * cellHeight;

                        g.setColor(Color.BLACK);
                        g.drawLine(x, y, x , y + cellHeight);
                    }
                }
            }

        }

    }

    private void paintGrid(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            g.drawLine(x1, y1, x2, y2);
        }

        for (int column = 0; column < cols; column++) {
            int y1 = padY;
            int x1 = padX + column * cellWidth;
            int y2 = padY + boardHeight;
            int x2 = x1;
            g.drawLine(x1, y1, x2, y2);
        }

        //intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                g.setColor(Color.LIGHT_GRAY);
                g.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
                xValuesInters.put(x - stoneSize / 2, stoneSize);
            }
        }
    }

}
