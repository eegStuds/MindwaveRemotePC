package mygui.userinterface;


import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;






import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class checkboxframe extends JFrame {

	public JPanel contentPane;
	private JPanel paneltop;
	//private Samplegui pSamplegui;
	private JMenuItem mntmSave;
	//protected CheckboxActionListener mCheckboxActionListener;
   public LinkedList<JRadioButton> pCheckBoxs = new LinkedList<JRadioButton>();
	protected String[] Rbuttnames= {"Delta","theta","low alpha","high alpha" , "low beta","high beta","low gamma", "high gamma"};
	public JButton checksubButton; 
   
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
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 330);
		
		/*JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu settingmenu = new JMenu("Settings");
		menuBar.add(settingmenu);
		
		JMenuItem mntmFile = new JMenuItem("file");
		settingmenu.add(mntmFile);
		
		mntmSave = new JMenuItem("save");
		
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
		*/
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
		
		
		for(int i=0;i<8;i++){
			
			JRadioButton btn = new JRadioButton(Rbuttnames[i]);
	        //btn.setText(btn+Rbuttnames[i]);
			GridBagConstraints gbc_deltabtn = new GridBagConstraints();
			gbc_deltabtn.insets = new Insets(0, 0, 5, 0);
			gbc_deltabtn.gridx = 0;
			gbc_deltabtn.gridy = i;
			panelcentral.add(btn, gbc_deltabtn);
			
			pCheckBoxs.add(btn);
			
		}
		
		
		
		JPanel panelbottom = new JPanel();
		contentPane.add(panelbottom, BorderLayout.SOUTH);
		panelbottom.setLayout(new GridLayout(0, 1, 10, 5));
		
		checksubButton = new JButton("Submit");
		
		panelbottom.add(checksubButton);
		
		//CheckboxActionListener al = new CheckboxActionListener();
		
	}

	/*protected void runSamplegui() {
		// TODO Auto-generated method stub
		this.pSamplegui=new Samplegui();

	}*/

	protected void exitnow() {
		// TODO Auto-generated method stub
		this.setVisible(false); //you can't see me!
		this.dispose();
	}

	/*@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==mntmSave)
		{
			pSamplegui=new Samplegui();
		}
		
	}*/

}
