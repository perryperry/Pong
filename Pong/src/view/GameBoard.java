package view;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.SwingUtilities;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;

public class GameBoard extends JPanel {

    Rectangle paddle1 = new Rectangle(100, 10);
    Rectangle paddle2 = new Rectangle(100, 10);
    private final int PIXEL_STEP = 20; // pixel number to move paddle for each key press
    private final int LEFT = 37;
    private final int RIGHT = 39;
    
    public GameBoard() {
    	
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.BLACK);

        JTextArea textControls = new JTextArea();
        this.add(textControls);
        
        textControls.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				
				int direction = e.getKeyCode();
				//System.out.println(e.getKeyCode());
			
				if(direction == LEFT)
					movePaddle1(paddle1.x - PIXEL_STEP);
				else if(direction == RIGHT)
					movePaddle1(paddle1.x + PIXEL_STEP);
				
			}

			@Override
			public void keyReleased(KeyEvent e) {}
        });
        
        
        addMouseMotionListener(new MouseAdapter(){
            public void mouseMoved(MouseEvent e){
            	movePaddle1(e.getX());
            }
        });

    }
    
    private void movePaddle1(int x){

        // Current square state, stored as final variables 
        // to avoid repeat invocations of the same methods.
        final int CURR_X = paddle1.x;
        final int CURR_Y = paddle1.y;
        final int CURR_W = paddle1.width;
        final int CURR_H = paddle1.height;
        

        if (CURR_X!=x) {

            // The square is moving, repaint background 
            // over the old square location. 
            this.repaint(CURR_X,CURR_Y,CURR_W,CURR_H);

            // Update coordinates.
            paddle1.x = x;
            //redSquare.setY(y);

            // Repaint the square at the new location.
            repaint(paddle1.x, this.getHeight() - paddle1.y, 
                    paddle1.width, 
                    paddle1.height);
        }
    }

    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        this.paintPaddle(g);
    } 
    
    public void paintPaddle(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(paddle1.x, this.getHeight() - paddle1.height, paddle1.width, paddle1.height);
        g.setColor(Color.BLACK);
        g.drawRect(paddle1.x, this.getHeight() - paddle1.height, paddle1.width, paddle1.height);    
    }
}


