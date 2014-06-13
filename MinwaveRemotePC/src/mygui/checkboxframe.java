package mygui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class checkboxframe extends JFrame implements ActionListener{

	public JPanel contentPane;
	private JPanel paneltop;
	private Samplegui pSamplegui;
	private JMenuItem mntmSave;
   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkboxframe frame = new checkboxframe();
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
	public checkboxframe() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 330);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu settingmenu = new JMenu("Settings");
		menuBar.add(settingmenu);
		
		JMenuItem mntmFile = new JMenuItem("file");
		settingmenu.add(mntmFile);
		
		mntmSave = new JMenuItem("save");
		mntmSave.addActionListener(this);
				
				
				/*new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//pSamplegui=new Samplegui();
				runSamplegui();
			}
		});*/
		settingmenu.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitnow();
			}
		});
		
		
		settingmenu.add(mntmExit);
		
		JMenu helpmenu = new JMenu("Help");
		menuBar.add(helpmenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	
		paneltop = new JPanel();
		FlowLayout flowLayout = (FlowLayout) paneltop.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(paneltop, BorderLayout.NORTH);
		
		JLabel lblSelectTheBrain = new JLabel("Select the Brain waves");
		paneltop.add(lblSelectTheBrain);
		
		JPanel panelcentral = new JPanel();
		contentPane.add(panelcentral, BorderLayout.WEST);
		GridBagLayout gbl_panelcentral = new GridBagLayout();
		gbl_panelcentral.columnWidths = new int[]{0, 0};
		gbl_panelcentral.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelcentral.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelcentral.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelcentral.setLayout(gbl_panelcentral);
		
		JRadioButton deltabtn = new JRadioButton("Delta");
		GridBagConstraints gbc_deltabtn = new GridBagConstraints();
		gbc_deltabtn.insets = new Insets(0, 0, 5, 0);
		gbc_deltabtn.gridx = 0;
		gbc_deltabtn.gridy = 0;
		panelcentral.add(deltabtn, gbc_deltabtn);
		
		JRadioButton thetabtn = new JRadioButton("Theta");
		GridBagConstraints gbc_thetabtn = new GridBagConstraints();
		gbc_thetabtn.insets = new Insets(0, 0, 5, 0);
		gbc_thetabtn.gridx = 0;
		gbc_thetabtn.gridy = 1;
		panelcentral.add(thetabtn, gbc_thetabtn);
		
		JRadioButton lowalphabtn = new JRadioButton("Low Alpha");
		GridBagConstraints gbc_lowalphabtn = new GridBagConstraints();
		gbc_lowalphabtn.insets = new Insets(0, 0, 5, 0);
		gbc_lowalphabtn.gridx = 0;
		gbc_lowalphabtn.gridy = 2;
		panelcentral.add(lowalphabtn, gbc_lowalphabtn);
		
		JRadioButton highalphabtn = new JRadioButton("High Alpha");
		GridBagConstraints gbc_highalphabtn = new GridBagConstraints();
		gbc_highalphabtn.insets = new Insets(0, 0, 5, 0);
		gbc_highalphabtn.gridx = 0;
		gbc_highalphabtn.gridy = 3;
		panelcentral.add(highalphabtn, gbc_highalphabtn);
		
		JRadioButton lowbetabtn = new JRadioButton("Low Beta");
		GridBagConstraints gbc_lowbetabtn = new GridBagConstraints();
		gbc_lowbetabtn.insets = new Insets(0, 0, 5, 0);
		gbc_lowbetabtn.gridx = 0;
		gbc_lowbetabtn.gridy = 4;
		panelcentral.add(lowbetabtn, gbc_lowbetabtn);
		
		JRadioButton highbetabtn = new JRadioButton("High Beta");
		GridBagConstraints gbc_highbetabtn = new GridBagConstraints();
		gbc_highbetabtn.insets = new Insets(0, 0, 5, 0);
		gbc_highbetabtn.gridx = 0;
		gbc_highbetabtn.gridy = 5;
		panelcentral.add(highbetabtn, gbc_highbetabtn);
		
		JRadioButton lowgammabtn = new JRadioButton("Low Gamma");
		GridBagConstraints gbc_lowgammabtn = new GridBagConstraints();
		gbc_lowgammabtn.insets = new Insets(0, 0, 5, 0);
		gbc_lowgammabtn.gridx = 0;
		gbc_lowgammabtn.gridy = 6;
		panelcentral.add(lowgammabtn, gbc_lowgammabtn);
		
		JRadioButton highgammabtn = new JRadioButton("High Gamma");
		GridBagConstraints gbc_highgammabtn = new GridBagConstraints();
		gbc_highgammabtn.gridx = 0;
		gbc_highgammabtn.gridy = 7;
		panelcentral.add(highgammabtn, gbc_highgammabtn);
		
		JPanel panelbottom = new JPanel();
		contentPane.add(panelbottom, BorderLayout.SOUTH);
		panelbottom.setLayout(new GridLayout(0, 1, 10, 5));
		
		JButton btnNewButton = new JButton("Submit");
		panelbottom.add(btnNewButton);
	}

	protected void runSamplegui() {
		// TODO Auto-generated method stub
		this.pSamplegui=new Samplegui();

	}

	protected void exitnow() {
		// TODO Auto-generated method stub
		this.setVisible(false); //you can't see me!
		this.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==mntmSave)
		{
			pSamplegui=new Samplegui();
		}
		
	}

}
