package mygui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.cmu.relativelayout.Binding;
import edu.cmu.relativelayout.BindingFactory;
import edu.cmu.relativelayout.RelativeConstraints;
import edu.cmu.relativelayout.RelativeLayout;
import eu.hansolo.steelseries.gauges.Linear;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class Gaugehandle extends JFrame {

	protected Linear conce;
	private JTextField textField;
	private JTextField textField_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gaugehandle frame = new Gaugehandle();
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
	public Gaugehandle() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setResizable(true);
		//getContentPane().setLayout(null);
		
		
		
		JPanel paneltop = new JPanel(new RelativeLayout());
		//paneltop.setBounds(0, 0, 434, 75);
		getContentPane().add(paneltop);
		//paneltop.setLayout();
		
		textField_1 = new JTextField();
		//textField_1.setBounds(61, 11, 291, 53);
		//paneltop.add(textField_1);
		textField_1.setColumns(10);
		BindingFactory bf = new BindingFactory();
		
		Binding leftEdge = bf.leftEdge();
		Binding topEdge = bf.topEdge();
		Binding rightEdge = bf.rightEdge();
		Binding bottomEdge = bf.bottomEdge();
		//Binding aboveInputField = bf.above(inputField);
		//Binding leftOfUserList = bf.leftOf(userList);
		// RelativeConstraints has a constructor that takes an arbitrary number of bindings, like this:
		RelativeConstraints textField_1Constraints
		    = new RelativeConstraints();
		textField_1Constraints.addBindings(leftEdge, topEdge, rightEdge);

		
		
		
		JPanel panelleft = new JPanel(new RelativeLayout());
		//panelleft.setBounds(10, 86, 102, 165);
		//getContentPane().add(panelleft);
		//panelleft.setLayout(null);
		
		conce = new Linear();
		//conce.setBounds(0, 11, 92, 143);
		//panelleft.add(conce);
		
		RelativeConstraints conceConstraints
	    = new RelativeConstraints();
	conceConstraints.addBindings(leftEdge, bottomEdge);
		
		JPanel panelright = new JPanel(new RelativeLayout());
		//panelright.setBounds(122, 86, 302, 165);
		getContentPane().add(panelright);
		//panelright.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		//textPane.setBounds(10, 5, 282, 149);
		//panelright.add(textPane);
		
		RelativeConstraints Constraints
	    = new RelativeConstraints();
	conceConstraints.addBindings(rightEdge, bottomEdge)
		
		paneltop.add(textField_1, textField_1Constraints);
	}
}
