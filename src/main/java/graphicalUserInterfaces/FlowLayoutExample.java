package javaCodeGeeks;

/*
 * A Java swing FlowLayout example 
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.FlowLayout;

public class FlowLayoutExample {

	public static void main(String[] args) {
		// Create and set up a frame window
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Layout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Define new buttons with different width on help of the ---
		JButton jb1 = new JButton("Button 1");		
		JButton jb2 = new JButton("Button 2");
		JButton jb3 = new JButton("Button 3");				
		
		// Define the panel to hold the buttons	
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(jb1);
		panel.add(jb2);
		panel.add(jb3);
		
		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
	}

}

