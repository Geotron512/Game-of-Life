import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel{
    public Frame frame;
    public Cell[][] cells;
    public boolean running = false;
    private GridLayout layout = new GridLayout();
    public Grid(int w, int h, Frame f){
        super();
        layout = new GridLayout(h, w, 0, 0);
        setLayout(layout);
        frame = f;
        cells = new Cell[h][w];
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                cells[i][j] = new Cell(this);
                cells[i][j].addActionListener(frame.action);
                cells[i][j].addMouseListener(frame.hover);
                cells[i][j].setBorderPainted(false);
                cells[i][j].setBackground(new Color(255, 255, 255));
                add(cells[i][j]);
            }
        }
    }
}
