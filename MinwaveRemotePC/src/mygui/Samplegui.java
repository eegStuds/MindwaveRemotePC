package mygui;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import ChartDirector.*;

import java.awt.event.ActionEvent;

public class Samplegui extends JFrame implements DemoModule{

	public JPanel contentPane;
	public JPanel mleftPanel;
	//public JPanel mrightPanel;
	public JPanel mcentrePanel;
	public JPanel mtopPanel;
	
	public JPanel top_northPanel;
	public JPanel top_westPanel;
	public JPanel top_centrePanel;
	public JPanel left_northPanel;
	public JPanel left_southPanel;
	public JPanel left_centrePanel;
	
	
	
  	 ////////left_southpanel///////////
  	 
	public JButton runPB;
	public JButton freezePB;
	public JComboBox samplePeriod;
	
	
	
////////left_centralpanel///////////
	public JScrollPane signals_scrollPane;
public String[] signalsField={"al1","al2","bt1","bt2"};
public JTextField valueA;

/////////////centrepanel////////////////
public ChartViewer mChartviewer;
public JPanel left_scrollpanel;
public JProgressBar meditation_progressBar;
public JProgressBar attention_progressBar;
public JPanel left_blinkpanel;
public JLabel blinklabel_1;
public JLabel blinklabel_2;
public JLabel blinklabel_3;
public JLabel blinklabel_4;
public JLabel blinklabel_5;
public JLabel blinklabel_6;
public boolean hasFinishedInitialization;
	
	
	
	
	
	

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Samplegui frame = new Samplegui();
					frame.setupFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	///
	
	
	/**
	 * Create the frame.
	 */
	
	public Samplegui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		//setSize(1000, 600);
		
		setupFrame();
		//this.setVisible(true);
	}





public void setupFrame() {
	// TODO Auto-generated method stub
	//RelativeLayout r2=

	
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(5, 5));
	contentPane.setBackground(new Color(0.3f, 0.3f, 0.7f,0.4f));
	setContentPane(contentPane);
	setuppanel();
	addto_topPanel();
	addto_leftPanel();
	addto_centrePanel();
	//additemstoPanel();
}

public void setuppanel() {
	// TODO Auto-generated method stub
	
	mleftPanel = new JPanel();
	//mleftPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	mleftPanel.setPreferredSize(new Dimension(180, 20));
	mleftPanel.setBackground(new Color(0.9f, 0.3f, 0.3f,1.0f));
	contentPane.add(mleftPanel, BorderLayout.WEST);
	mleftPanel.setLayout(new BorderLayout(2, 2));
	
	
	mtopPanel=new JPanel();
	//mtopPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	mtopPanel.setPreferredSize(new Dimension(10, 100));
	mtopPanel.setBackground(new Color(0.2f, 0.3f, 0.9f,1.0f));
	contentPane.add(mtopPanel, BorderLayout.NORTH);
	mtopPanel.setLayout(new BorderLayout(2, 2));
	
	mcentrePanel = new JPanel();
	//centrePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	mcentrePanel.setBackground(new Color(0.8f, 0.9f, 0.3f,1.0f));
	mcentrePanel.setLayout(new BorderLayout(2, 2));
	contentPane.add(mcentrePanel, BorderLayout.CENTER);
	
	/*
	 ////////mleftPanel Parts///////////
	 */
	left_northPanel = new JPanel();
	left_northPanel.setPreferredSize(new Dimension(10, 20));
	left_northPanel.setBackground(new Color(0.2f, 0.9f, 0.9f,0.8f));
	mleftPanel.add(left_northPanel, BorderLayout.NORTH);
	left_northPanel.setLayout(new BorderLayout(2, 2));
	
	left_southPanel = new JPanel();
	left_southPanel.setPreferredSize(new Dimension(10, 200));
	left_southPanel.setBackground(new Color(0.2f, 0.9f, 0.3f,0.8f));
	left_southPanel.setLayout(new GridLayout(6, 1, 0, 0));
	mleftPanel.add(left_southPanel, BorderLayout.SOUTH);
	
	left_centrePanel = new JPanel();
	left_centrePanel.setBackground(new Color(0.2f, 0.9f, 0.3f,0.3f));
	mleftPanel.add(left_centrePanel, BorderLayout.CENTER);
	left_centrePanel.setLayout(new BorderLayout(2, 2));
	//left_centrePanel.setPreferredSize(new Dimension(60,40));;
	
	
	
	
	/*
	 ////////-:-:-:-:-:-///////////
	 */
	
	
	/*
	 ////////mtopPanel Parts///////////
	 */
	top_northPanel = new JPanel();
	top_northPanel.setPreferredSize(new Dimension(10, 20));
	top_northPanel.setBackground(new Color(0.2f, 0.9f, 0.9f,0.8f));
	top_northPanel.setLayout(new BorderLayout(2, 2));
	mtopPanel.add(top_northPanel, BorderLayout.NORTH);
	
	
	
	
	top_westPanel = new JPanel();
	top_westPanel.setPreferredSize(new Dimension(100, 10));
	top_westPanel.setBackground(new Color(0.2f, 0.9f, 0.3f,0.8f));
	top_westPanel.setLayout(new BorderLayout(2, 2));
	mtopPanel.add(top_westPanel, BorderLayout.WEST);
	
	
	top_centrePanel = new JPanel();
	top_centrePanel.setBackground(new Color(0.2f, 0.9f, 0.3f,0.3f));
	mtopPanel.add(top_centrePanel, BorderLayout.CENTER);
	/*
	 ////////-:-:-:-:-:-///////////
	 */
	
	
	
	/*
	 ////////mcentrePanel Parts///////////
	 */
	
	
	/*
	 ////////-:-:-:-:-:-///////////
	 */
	
	
}

public void addSignalsfield_toScrolllist(){
	
	
	signals_scrollPane = new JScrollPane();
	signals_scrollPane.setPreferredSize(new Dimension(2, 150));
 	left_centrePanel.add(signals_scrollPane, BorderLayout.CENTER);
 	
 	left_scrollpanel = new JPanel();
 	left_scrollpanel.setBackground(new Color(47, 79, 79));
 	signals_scrollPane.setViewportView(left_scrollpanel);
 	left_scrollpanel.setLayout(new GridLayout(7, 0, 0, 0));
 	
 	/*
 	 //////////////eye blink setup/////////////////////////
 	 */
 	
 	JLabel label = new JLabel("Eye Blink");
 	label.setMinimumSize(new Dimension(42, 8));
 	label.setPreferredSize(new Dimension(42, 8));
 	label.setForeground(new Color(222, 184, 135));
 	left_scrollpanel.add(label);
 	
 	left_blinkpanel = new JPanel();
 	left_blinkpanel.setForeground(Color.BLACK);
 	left_blinkpanel.setBackground(Color.BLACK);
 	left_scrollpanel.add(left_blinkpanel);
 	left_blinkpanel.setPreferredSize(new Dimension(160, 30));
 	left_blinkpanel.setLayout(new GridLayout(1, 6, 2, 5));
 	
 	blinklabel_1 = new JLabel("1");
 	blinklabel_1.setHorizontalAlignment(SwingConstants.CENTER);
 	blinklabel_1.setPreferredSize(new Dimension(16, 16));
 	blinklabel_1.setOpaque(true);
 	blinklabel_1.setBackground(Color.WHITE);
 	left_blinkpanel.add(blinklabel_1);
 	
 	blinklabel_2 = new JLabel("2");
 	blinklabel_2.setHorizontalAlignment(SwingConstants.CENTER);
 	blinklabel_2.setPreferredSize(new Dimension(16, 16));
 	blinklabel_2.setOpaque(true);
 	blinklabel_2.setBackground(Color.WHITE);
 	left_blinkpanel.add(blinklabel_2);
 	
 	blinklabel_3 = new JLabel("3");
 	blinklabel_3.setHorizontalAlignment(SwingConstants.CENTER);
 	blinklabel_3.setBackground(Color.WHITE);
 	blinklabel_3.setOpaque(true);
 	blinklabel_3.setPreferredSize(new Dimension(16, 16));
 	left_blinkpanel.add(blinklabel_3);
 	
 	blinklabel_4 = new JLabel("4");
 	blinklabel_4.setHorizontalAlignment(SwingConstants.CENTER);
 	blinklabel_4.setPreferredSize(new Dimension(16, 16));
 	blinklabel_4.setOpaque(true);
 	blinklabel_4.setBackground(Color.WHITE);
 	left_blinkpanel.add(blinklabel_4);
 	
 	blinklabel_5 = new JLabel("5");
 	blinklabel_5.setHorizontalAlignment(SwingConstants.CENTER);
 	blinklabel_5.setBackground(Color.WHITE);
 	blinklabel_5.setOpaque(true);
 	blinklabel_5.setPreferredSize(new Dimension(16, 16));
 	left_blinkpanel.add(blinklabel_5);
 	
 	blinklabel_6 = new JLabel("6");
 	blinklabel_6.setHorizontalAlignment(SwingConstants.CENTER);
 	blinklabel_6.setBackground(Color.WHITE);
 	blinklabel_6.setPreferredSize(new Dimension(16, 16));
 	blinklabel_6.setOpaque(true);
 	left_blinkpanel.add(blinklabel_6);
 	
 	///////////////////////////////////////
 	
 	JLabel label_2 = new JLabel("Attention");
 	label_2.setForeground(new Color(244, 164, 96));
 	left_scrollpanel.add(label_2);
 	
 	attention_progressBar = new JProgressBar();
 	attention_progressBar.setPreferredSize(new Dimension(146, 24));
 	left_scrollpanel.add(attention_progressBar);
 	
 	JLabel label_3 = new JLabel("Meditationtion");
 	label_3.setForeground(new Color(244, 164, 96));
 	left_scrollpanel.add(label_3);
 	
 	meditation_progressBar = new JProgressBar();
 	meditation_progressBar.setPreferredSize(new Dimension(146, 24));
 	left_scrollpanel.add(meditation_progressBar);
 	
 	
 	
 	
 	
 	/*
		//signal Label
	    //JLabel alphaLabel = 
	    //alphaLabel.setFont(uiFont);
	    JLabel label = new JLabel(signalsField[1]);
	    label.setForeground(new Color(255, 51, 51));
	    signals_scrollPane.add(label);

	    // signal value
	    valueA = new JTextField();
	    valueA.setText("eert");
	    valueA.setForeground(new Color(255, 255, 0));
	    valueA.setEditable(false);
	    signals_scrollPane.add(valueA);
*/
	
}

public void addto_topPanel(){
		
		/* top_northLabel = new JLabel("Advanced Software Engineering");
        top_northLabel.setForeground(new Color(255, 255, 51));
        top_northLabel.setBackground(new Color(0, 0, 128));
        top_northLabel.setBorder(new javax.swing.border.EmptyBorder(2, 0, 2, 5));
        top_northLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        top_northLabel.setOpaque(true);
       top_northPanel.add(top_northLabel, BorderLayout.NORTH);
       */
	
       JLabel top_northLabel = new JLabel("Advanced Software Engineering");
       top_northLabel.setForeground(new Color(255, 255, 51));
       
		top_northPanel.add(top_northLabel,BorderLayout.CENTER);
		 top_northLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		 
		JLabel top_westLabel = new JLabel("Apps");
		 top_westLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 top_westLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			top_westLabel.setForeground(new Color(255, 255, 0));
			//top_westLabel.setPreferredSize(new Dimension(180, 40));
			top_westPanel.add(top_westLabel,BorderLayout.CENTER);
			
			/*
			////////////top_centerpanel//////////////// 
			 */
		
		
	}

public void addto_leftPanel(){
    
    
	/*
	 ////////left_southpanel parts///////////
	 */
    
    runPB=new JButton("RUN");
    runPB.setIcon(new ImageIcon(Samplegui.class.getResource("/images/play.gif")));
    left_southPanel.add(runPB);
    
    
    
    freezePB=new JButton("Pause");
    freezePB.setIcon(new ImageIcon(Samplegui.class.getResource("/images/pause.gif")));
    left_southPanel.add(freezePB);
    
 // Update Period label
    left_southPanel.add(new JLabel("Update Period (ms)"));
    samplePeriod = new JComboBox(new Object[]{"20","40","50","100","200","250","500","750","1000"});
    samplePeriod.setSelectedItem("250");
    
    left_southPanel.add(samplePeriod);
    
    
    /*
	 ////////-:-:-:-:-:-///////////
	 */
    
    /*
	 ////////left_centralpanel parts///////////
	 */
    
   
	
	 
 	addSignalsfield_toScrolllist();
	
    
    /*
  	 ////////-:-:-:-:-:-///////////
  	 */
 	
 	/*
 	 ////////left_northpanel parts///////////
 	 */
 	
 	JLabel Signals_labels = new JLabel("Signals");
	Signals_labels.setHorizontalAlignment(SwingConstants.CENTER);
	Signals_labels.setForeground(new Color(255, 204, 102));
	left_northPanel.add(Signals_labels, BorderLayout.NORTH);
	
 	/*
 	 ////////-:-:-:-:-:-///////////
 	 */
 	
 	
    
    
    /*


    
 // Simulated Machine label
    leftPanel.add(new JLabel("Simulated Machine")).setBounds(5, 180, 130, 20);

    
 // Alpha Label
    JLabel alphaLabel = new JLabel("Alpha");
    alphaLabel.setFont(uiFont);
    leftPanel.add(alphaLabel).setBounds(5, 200, 60, 20);

    // Alpha value
    valueA = new JTextField();
    valueA.setEditable(false);
    leftPanel.add(valueA).setBounds(65, 200, 70, 20);

    // Beta label
    JLabel betaLabel = new JLabel("Beta");
    betaLabel.setFont(uiFont);
    leftPanel.add(betaLabel).setBounds(5, 220, 60, 20);

    // Beta value
    valueB = new JTextField();
    valueB.setEditable(false);
    leftPanel.add(valueB).setBounds(65, 220, 70, 20);

    // Gamma label
    JLabel gammaLabel = new JLabel("Gamma");
    gammaLabel.setFont(uiFont);
    leftPanel.add(gammaLabel).setBounds(5, 240, 60, 20);

    // Gamma value
    valueC = new JTextField();
    valueC.setEditable(false);
    leftPanel.add(valueC).setBounds(65, 240, 70, 20);
    
 // Total expected panel size
    leftPanel.setPreferredSize(new Dimension(140, 270));

    
	*/
		
	
	
}

public void addto_centrePanel(){
	/*
	// Chart Viewer
    chartViewer1 = new ChartViewer();
    chartViewer1.setBackground(new Color(255, 255, 255));
    chartViewer1.setOpaque(true);
   // chartViewer1.setPreferredSize(new Dimension(616, 286));
   //chartViewer1.setHorizontalAlignment(new );
    chartViewer1.setHorizontalAlignment(SwingConstants.CENTER);
    chartViewer1.addViewPortListener(new ViewPortAdapter() {
        public void viewPortChanged(ViewPortChangedEvent e) {
            chartViewer1_viewPortChanged(e);
        }
    });
	*/
	
	mChartviewer=new ChartViewer();
	mChartviewer.setBackground(SystemColor.inactiveCaptionBorder);
	//mChartviewer.setfu
	mChartviewer.setForeground(Color.DARK_GRAY);
	
	mcentrePanel.add(mChartviewer,BorderLayout.CENTER);

}





@Override
public int getNoOfCharts() {
	// TODO Auto-generated method stub
	return 0;
}




@Override
public void createChart(ChartViewer viewer, int index) {
	// TODO Auto-generated method stub
	
}

}
