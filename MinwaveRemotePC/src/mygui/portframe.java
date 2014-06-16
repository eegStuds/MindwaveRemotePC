package mygui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;






import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Component;

import javax.swing.JScrollPane;

import java.awt.GridLayout;

public class portframe extends JFrame{
	
	static int i;

	public frametest mFrametest;
	private JPanel contentPane;

	private JPanel panelmain;

	

	private GridBagConstraints gbc_btnNewButton;

	private int r;

	private int c;

	
	private int buttonlength;

	private String strr;

	

	/**
	 * Launch the application.
	 */
	
	/*public static void main(String[] args) {
		
		
		//addportbuttons(i);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					portframe frame = new portframe(this);
					frame.addelements();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public void addelements() {
		// TODO Auto-generated method stub
		int j;
		for(j = 0;j<31;j++){
			
			addportbuttons(j);
	
		}
		
	}

	private void addportbuttons(int i2) {
		// TODO Auto-generated method stub
		
		//for(int j = 0;j++;j<=i2){
		//GridBagConstraints gbc_btnNewButton;
		
		JButton btn;
			btn = new JButton("port"+String.valueOf(i2));
			//btn.setMargin(null);
			btn.setName("btn"+(i2+1));
			
			//gbc_btnNewButton = new GridBagConstraints();
			//gbc_btnNewButton.fill= GridBagConstraints.HORIZONTAL;
			//gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
			r=buttonlength/4;
			c=buttonlength%4;
			buttonlength=buttonlength+1;
			//System.out.println(r);
			//System.out.println(c);
			//gbc_btnNewButton.gridwidth = 4;
			//gbc_btnNewButton.gridheight = 4;
			//gbc_btnNewButton.gridx=i2;
			//gbc_btnNewButton.gridy=c;
			gbc_btnNewButton.gridx=c;
			gbc_btnNewButton.gridy=r;
			gbc_btnNewButton.ipadx=20;
			gbc_btnNewButton.ipady=20;
			gbc_btnNewButton.weighty=10;
			gbc_btnNewButton.weightx=10;
			gbc_btnNewButton.insets = new Insets(0,0,10,10);
			panelmain.add(btn, gbc_btnNewButton);
			//btnj.setSize(25, 25);
			btn.addActionListener(this.mFrametest);
				
			//panelmain.add(btnj, gbc_btnNewButton);
	
	}
		


	/**
	 * Create the frame.
	 * @param frametest 
	 * @param pframetest 
	 */
	public portframe(frametest frametest) {
		mFrametest=frametest;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel paneltop = new JPanel();
		paneltop.setBackground(Color.YELLOW);
		contentPane.add(paneltop, BorderLayout.NORTH);
		
		JLabel lblSelectPortNumber = new JLabel("Select Port Number");
		lblSelectPortNumber.setHorizontalTextPosition(SwingConstants.LEFT);
		lblSelectPortNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectPortNumber.setOpaque(true);
		lblSelectPortNumber.setForeground(Color.RED);
		lblSelectPortNumber.setBackground(Color.GREEN);
		paneltop.add(lblSelectPortNumber);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		panelmain = new JPanel();
		panelmain.setAlignmentY(Component.TOP_ALIGNMENT);
		panelmain.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelmain.setBackground(Color.LIGHT_GRAY);
		
		scrollPane.setViewportView(panelmain);
		//contentPane.add(panelmain, BorderLayout.CENTER);
		
		
		GridBagLayout gbl_panelmain = new GridBagLayout();
		panelmain.setLayout(gbl_panelmain);
		gbc_btnNewButton = new GridBagConstraints();
		//gbc_btnNewButton.fill= GridBagConstraints.HORIZONTAL;
		/*JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 1;
		panelmain.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 4;
		panelmain.add(btnNewButton_1, gbc_btnNewButton_1);*/
		
		/*JButton btnNewButton = new JButton("New button");
		gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 1;*/
		//panelmain.add(btnNewButton, gbc_btnNewButton);
		
		/*JButton btnPort = new JButton("port");
		btnPort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panelmain.add(btnPort);*/
	}

	
}


