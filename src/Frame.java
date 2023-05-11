import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Frame extends JFrame{
    private JToolBar toolbar = new JToolBar(JToolBar.HORIZONTAL);
    private Grid grid = new Grid(50, 50, this);
    private JButton pp = new JButton("Run");
    private JButton reset = new JButton("Reset");
    private BorderLayout layout = new BorderLayout();
    MouseListener hover = new MouseAdapter() {

        public void mouseEntered(java.awt.event.MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(191, 191, 191));
        }

        public void mouseExited(java.awt.event.MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(255, 255, 255));
        }
    };
    ActionListener action = (e) -> {
        JButton b = (JButton) e.getSource();
        if(b == pp){
            if(!grid.running){
                grid.running = true;
                pp.setText("Pause");
            }
            else{
                grid.running = false;
                pp.setText("Run");
            }
        }
    };
    public Frame(){
        super("Conway's Game of Life");
        setSize(640, 680);
        try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}catch(Exception exc){System.out.println(exc.getMessage()+"\n"+exc.getCause());}
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(layout);
        add(grid, "Center");
        toolbar.add(pp);
        pp.addActionListener(action);
        toolbar.add(reset);
        reset.addActionListener(action);
        add(toolbar, "South");
        setVisible(true);
    }
}
