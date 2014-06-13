package mygui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

public class transparentframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					transparentframe frame = new transparentframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public transparentframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel1 = new JPanel();
		contentPane.add(panel1);
		
		JPanel panel2 = new JPanel();
		contentPane.add(panel2);
		
		JPanel panel3 = new JPanel();
		contentPane.add(panel3);
		
		JPanel panel4 = new JPanel();
		contentPane.add(panel4);
		
		JPanel panel5 = new JPanel();
		contentPane.add(panel5);
		
		JPanel panel6 = new JPanel();
		contentPane.add(panel6);
	}

}
