import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import view.GameBoard;

public class PongMain 
{

	public static void main(String[] args) 
	{
		//This avoids race conditions by placing the GUI action handling on the EventDispatchThread
		 SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                initGUI(); 
	            }
	     });
	}
	
	//create and launch gui
	private static void initGUI()
	{
		GameBoard board = new GameBoard();
		System.out.println("Created GUI on EDT? "+ SwingUtilities.isEventDispatchThread());
		JFrame f = new JFrame("Pong");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		f.add(board);
		f.setSize(500,700);
		f.setVisible(true);
		f.setResizable(false);
	}
	
}
