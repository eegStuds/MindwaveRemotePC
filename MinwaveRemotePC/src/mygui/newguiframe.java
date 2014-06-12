package mygui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.cmu.relativelayout.Binding;
import edu.cmu.relativelayout.BindingFactory;
import edu.cmu.relativelayout.RelativeConstraints;
import edu.cmu.relativelayout.RelativeLayout;

import java.awt.FlowLayout;
import java.awt.Color;

public class newguiframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newguiframe frame = new newguiframe();
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
	public newguiframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new RelativeLayout());
		//setContentPane(contentPane);
		
		BindingFactory bff= new BindingFactory();
		//Binding leftEdge = bff.leftEdge();
		Binding topEdge11 = bff.topEdge();
		Binding bottomEdge11 = bff.bottomEdge();
		RelativeConstraints relaConstraintstop = new RelativeConstraints(topEdge11); 
		RelativeConstraints relaConstraintbottom = new RelativeConstraints(bottomEdge11);
		
		getContentPane().add(contentPane,relaConstraintstop);
		
	}

}
