package it.unibo.es3;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GUI extends JFrame implements KeyListener {
     
    private final List<JButton> cells = new ArrayList<>();
    private final Logics logics;
    
    public GUI(int width) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70*width, 70*width);
        
        this.logics = new LogicsImpl(width);
        JPanel panel = new JPanel(new GridLayout(width,width));
        this.getContentPane().add(panel);
        
        ActionListener al = e -> {
            var jb = (JButton)e.getSource();
        	jb.setText(String.valueOf(cells.indexOf(jb)));
        };
                
        for (int i = 0; i < width; i++){
            for (int j = 0; j < width; j++) {
                final JButton jb = new JButton();
                this.cells.add(jb);
                jb.addActionListener(al);
                panel.add(jb);
            }
        }

        this.setVisible(true);
        this.addKeyListener(this);
        this.setFocusable(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'c' || e.getKeyChar() == '>') {
            System.out.println("Typed " + e.getKeyChar());

            if (logics.toQuit()) {
                System.exit(1);

            } else {
                logics.getNextCells().forEach(cellNum -> {
                    this.cells.get(cellNum).setText("*");
                });
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        return;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        return;
    }
    
}