package mygui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.CardLayout;

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
		setBounds(100, 100, 350, 100);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 6, 0, 0));
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.YELLOW);
		panel.add(panel1);
		panel1.setLayout(new CardLayout(12, 12));
		
		JLabel label1 = new JLabel("A");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setHorizontalTextPosition(SwingConstants.CENTER);
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		label1.setOpaque(true);
		label1.setBackground(Color.MAGENTA);
		panel1.add(label1, "name_29643309446770");
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.YELLOW);
		panel.add(panel2);
		panel2.setLayout(new CardLayout(12, 12));
		
		JLabel label2 = new JLabel("B");
		label2.setOpaque(true);
		label2.setHorizontalTextPosition(SwingConstants.CENTER);
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBackground(Color.MAGENTA);
		label2.setAlignmentX(0.5f);
		panel2.add(label2, "name_29733289531038");
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.YELLOW);
		panel.add(panel3);
		panel3.setLayout(new CardLayout(12, 12));
		
		JLabel label3 = new JLabel("C");
		label3.setOpaque(true);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setBackground(Color.MAGENTA);
		label3.setAlignmentX(0.5f);
		panel3.add(label3, "name_29787180630350");
		
		JPanel panel4 = new JPanel();
		panel4.setBackground(Color.YELLOW);
		panel.add(panel4);
		panel4.setLayout(new CardLayout(12, 12));
		
		JLabel label4 = new JLabel("D");
		label4.setOpaque(true);
		label4.setHorizontalTextPosition(SwingConstants.CENTER);
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setBackground(Color.MAGENTA);
		label4.setAlignmentX(0.5f);
		panel4.add(label4, "name_29861274644621");
		
		JPanel panel5 = new JPanel();
		panel5.setBackground(Color.YELLOW);
		panel.add(panel5);
		panel5.setLayout(new CardLayout(12, 12));
		
		JLabel label5 = new JLabel("E");
		label5.setOpaque(true);
		label5.setHorizontalTextPosition(SwingConstants.CENTER);
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		label5.setBackground(Color.MAGENTA);
		label5.setAlignmentX(0.5f);
		panel5.add(label5, "name_29897262957447");
		
		JPanel panel6 = new JPanel();
		panel6.setBackground(Color.YELLOW);
		panel.add(panel6);
		panel6.setLayout(new CardLayout(12, 12));
		
		JLabel label6 = new JLabel("F");
		label6.setOpaque(true);
		label6.setHorizontalTextPosition(SwingConstants.CENTER);
		label6.setHorizontalAlignment(SwingConstants.CENTER);
		label6.setBackground(Color.MAGENTA);
		label6.setAlignmentX(0.5f);
		panel6.add(label6, "name_29919233493901");
		
		JPanel paneltop = new JPanel();
		paneltop.setPreferredSize(new Dimension(10, 6));
		paneltop.setBackground(Color.LIGHT_GRAY);
		FlowLayout flowLayout = (FlowLayout) paneltop.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		contentPane.add(paneltop, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 6));
		panel_1.setBackground(Color.LIGHT_GRAY);
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setVgap(10);
		flowLayout_1.setHgap(10);
		contentPane.add(panel_1, BorderLayout.SOUTH);
	}

}
