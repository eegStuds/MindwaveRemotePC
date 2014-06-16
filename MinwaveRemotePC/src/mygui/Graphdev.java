package mygui;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ChartDirector.*;

import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Graphdev extends JFrame implements DemoModule
{
    //
    // Data to draw the chart. In this demo, the data buffer will be filled by a data generator,
    // triggered to run by a timer every 250ms. We plot the last 240 samples.
    //
    private final int dataInterval = 250;
    private final int sampleSize = 240;
    private Date[] timeStamps = new Date[sampleSize];
    private double[] dataSeriesA = new double[sampleSize];
    private double[] dataSeriesB = new double[sampleSize];
    private double[] dataSeriesC = new double[sampleSize];

    // This is an internal variable used by the real time random number generator so it knows what
    // timestamp should be used for the next data point.
    private Date nextDataTime;

    // Will set to true at the end of initialization
    private boolean hasFinishedInitialization;

    //
    // Controls in the JFrame
    //
    private JButton runPB;
    private JButton freezePB;
    private JComboBox samplePeriod;
    private ChartViewer chartViewer1;
    private javax.swing.Timer dataRateTimer;
    private javax.swing.Timer chartUpdateTimer;
    private JTextField valueA;
    private JTextField valueB;
    private JTextField valueC;
	private XYChart c;
    private int chartwidth=600;
    private int chartheight=270;
    
    //
    // The main method to allow this demo to run as a standalone program.
    //
    public static void main(String args[])
    {
        Graphdev demo = new Graphdev();
        demo.setDefaultCloseOperation(EXIT_ON_CLOSE);
        demo.setupFrame();
        demo.setVisible(true);
    }

    //
    // Set up the JFrame
    //
    private void setupFrame()
    {
        if (hasFinishedInitialization)
        {
            // Just restart the chart update if already initialized
            runPB.doClick();
            return;
        }

        // Set JFrame title to name of this demo program
        setTitle(toString());
        setResizable(true);
        this.addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				int width=Graphdev.this.getWidth();
				int height=Graphdev.this.getHeight();
				update_chartwidth(width,height);
			}
			
			@Override
			public void componentMoved(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});

        if (getDefaultCloseOperation() != EXIT_ON_CLOSE)
        {
            // Stop chart updating when window is being closed
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) { freezePB.doClick(); }});
        }

        // Initialize the internal variable used by our random real time data generator.
        nextDataTime = new Date();
 
        // Font to use for user interface elements
        Font uiFont = new Font("Dialog", Font.PLAIN, 11);

        // Top label bar
        JLabel topLabel = new JLabel("Advanced Software Engineering");
        topLabel.setForeground(new Color(255, 255, 51));
        topLabel.setBackground(new Color(0, 0, 128));
        topLabel.setBorder(new javax.swing.border.EmptyBorder(2, 0, 2, 5));
        topLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        topLabel.setOpaque(true);
        getContentPane().add(topLabel, BorderLayout.NORTH);

        // Left panel
        JPanel leftPanel = new JPanel(null);
        leftPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        // Run push button
        runPB = new JButton("Run", new ImageIcon(getClass().getResource("/images/play.gif")));
        runPB.setHorizontalAlignment(SwingConstants.LEFT);
        runPB.setMargin(new Insets(5, 5, 5, 5));
        runPB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)    {
                runPB_Clicked();
            }});
        leftPanel.add(runPB).setBounds(1, 0, 138, 24);

        // Freeze push button
        freezePB = new JButton("Freeze", new ImageIcon(getClass().getResource("/images/pause.gif")));
        freezePB.setHorizontalAlignment(SwingConstants.LEFT);
        freezePB.setMargin(new Insets(5, 5, 5, 5));
        freezePB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)    {
                freezePB_Clicked();
            }});
        leftPanel.add(freezePB).setBounds(1, 24, 138, 24);

        // Update Period label
        leftPanel.add(new JLabel("Update Period (ms)")).setBounds(5, 60, 130, 20);

        // Update Period drop down list box
        samplePeriod = new JComboBox(new Object[] { "250", "500", "750", "1000", "1250", "1500",
            "1750", "2000" });
        samplePeriod.setSelectedItem("1000");
        samplePeriod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                samplePeriod_ValueChanged(evt);
            }});
        leftPanel.add(samplePeriod).setBounds(5, 80, 130, 20);

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

        // Chart Viewer
        chartViewer1 = new ChartViewer();
        chartViewer1.setBackground(new Color(255, 255, 255));
        chartViewer1.setOpaque(true);
        chartViewer1.setPreferredSize(new Dimension(616, 286));
        chartViewer1.setHorizontalAlignment(SwingConstants.CENTER);
        chartViewer1.addViewPortListener(new ViewPortAdapter() {
            public void viewPortChanged(ViewPortChangedEvent e) {
                chartViewer1_viewPortChanged(e);
            }
        });

        // Put the leftPanel on the left and chartViewer1 on the right
        getContentPane().add(leftPanel, BorderLayout.WEST);
        getContentPane().add(chartViewer1, BorderLayout.CENTER);

        // Set all UI fonts (except labels) to uiFont
        for (int i = 0; i < leftPanel.getComponentCount(); ++i)
        {
            Component c = leftPanel.getComponent(i);
            if (!(c instanceof JLabel))
                c.setFont(uiFont);
        }

        // The data generation timer for our random number generator
        dataRateTimer = new javax.swing.Timer(dataInterval, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dataRateTimer_Tick();
            }
        });

        // The chart update timer
        chartUpdateTimer = new javax.swing.Timer(
            Integer.parseInt((String)samplePeriod.getSelectedItem()), new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                chartUpdateTimer_Tick();
            }
        });

        // Layout the JFrame
        pack();
        hasFinishedInitialization = true;

        // Start collecting and plotting data
        dataRateTimer.start();
        runPB.doClick();
    }

    protected void update_chartwidth(int width, int height) {
		// TODO Auto-generated method stub
    	//c = new XYChart(600, 270, 0xf4f4f4, 0x000000, 1);
    	if(width>700 && height>400)
    	{
    		System.out.print(width);
    		System.out.println("    ");
    		System.out.println(height);
    		chartwidth=width-200;
    		chartheight=height-100;
    		//drawChart(chartViewer1, width-200, height-100);
    	//this.c.setSize(width-300, height-200);
    	//this.c.setPlotArea(55, 62, width-400, height-300, 0xffffff, -1, -1, 0xcccccc, 0xcccccc);
    	}
	}

	//
    // The data update routine. In this demo, it is invoked every 250ms to get new data.
    //
    private void dataRateTimer_Tick()
    {
        Date now = new Date();
        do
        {
            //
            // In this demo, we use some formulas to generate new values. In real applications,
            // it may be replaced by some data acquisition code.
            //
            double p = nextDataTime.getTime() / 1000.0 * 4;
            double dataA = 20 + Math.cos(p * 2.2) * 10 + 1 / (Math.cos(p) * Math.cos(p) + 0.01);
            double dataB = 150 + 100 * Math.sin(p / 27.7) * Math.sin(p / 10.1);
            double dataC = 150 + 100 * Math.cos(p / 6.7) * Math.cos(p / 11.9);

            // Now we shift the data into the array
            shiftData(dataSeriesA, dataA);
            shiftData(dataSeriesB, dataB);
            shiftData(dataSeriesC, dataC);
            shiftData(timeStamps, nextDataTime);

            // Update nextDataTime
            nextDataTime = new Date(nextDataTime.getTime() + dataInterval);;
        }
        while (nextDataTime.before(now));

        // We provide some visual feedback to the numbers generated, so you can see the
        // data being updated.
        valueA.setText("" + Math.round(dataSeriesA[dataSeriesA.length - 1] * 100) / 100.0);
        valueB.setText("" + Math.round(dataSeriesB[dataSeriesB.length - 1] * 100) / 100.0);
        valueC.setText("" + Math.round(dataSeriesC[dataSeriesC.length - 1] * 100) / 100.0);
    }

    //
    // Utility to shift a double value into an array
    //
    private void shiftData(double[] data, double newValue)
    {
        for (int i = 1; i < data.length; ++i)
            data[i - 1] = data[i];
        data[data.length - 1] = newValue;
    }

    //
    // Utility to shift a Data object into an array
    //
    private void shiftData(Date[] data, Date newValue)
    {
        for (int i = 1; i < data.length; ++i)
            data[i - 1] = data[i];
        data[data.length - 1] = newValue;
    }

    //
    // Run button is pressed - start chart update timer
    //
    private void runPB_Clicked()
    {
        runPB.setBackground(new Color(0x80, 0xff, 0x80));
        freezePB.setBackground(null);
        chartUpdateTimer.start();
    }

    //
    // Freeze button is pressed - stop chart update timer
    //
    private void freezePB_Clicked()
    {
        freezePB.setBackground(new Color(0x80, 0xff, 0x80));
        runPB.setBackground(null);
        chartUpdateTimer.stop();
    }

    //
    // Updates the chartUpdateTimer interval if the user selects another interval.
    //
    private void samplePeriod_ValueChanged(ActionEvent evt)
    {
        int period = Integer.parseInt(samplePeriod.getSelectedItem().toString());
        chartUpdateTimer.setDelay(period);
        chartUpdateTimer.setInitialDelay(period);
    }

    //
    // The chartUpdateTimer Tick event - this updates the chart periodicially by raising
    // viewPortChanged events.
    //
    private void chartUpdateTimer_Tick()
    {
        chartViewer1.updateViewPort(true, false);
    }

    //
    // The viewPortChanged event handler. In this example, it just updates the chart. If you
    // have other controls to update, you may also put the update code here.
    //
    private void chartViewer1_viewPortChanged(ViewPortChangedEvent e)
    {
        drawChart(chartViewer1, chartwidth , chartheight);
    }

    //
    // Draw the chart and display it in the given viewer.
    //
    private void drawChart(ChartViewer viewer,int width,int height)
    {
        // Create an XYChart object 600 x 270 pixels in size, with light grey (f4f4f4)
        // background, black (000000) border, 1 pixel raised effect, and with a rounded frame.
        c = new XYChart(width, height, 0xf4f4f4, 0x000000, 1);
        c.setRoundedFrame();

        // Re-cycle the resources of the existing chart, if any. This can improve performance
        // by reducing the frequency of garbage collections.
        c.recycle(chartViewer1.getChart());

        // Set the plotarea at (55, 62) and of size 520 x 175 pixels. Use white (ffffff)
        // background. Enable both horizontal and vertical grids by setting their colors to
        // grey (cccccc). Set clipping mode to clip the data lines to the plot area.
        c.setPlotArea(55, 62, width-80, height-95, 0xffffff, -1, -1, 0xcccccc, 0xcccccc);
        c.setClipping();

        // Add a title to the chart using 15 pts Times New Roman Bold Italic font, with a light
        // grey (dddddd) background, black (000000) border, and a glass like raised effect.
        c.addTitle("Field Intensity at Observation Satellite", "Times New Roman Bold Italic", 15
            ).setBackground(0xdddddd, 0x000000, Chart.glassEffect());

        // Add a legend box at the top of the plot area with 9pts Arial Bold font. We set the
        // legend box to the same width as the plot area and use grid layout (as opposed to
        // flow or top/down layout). This distributes the 3 legend icons evenly on top of the
        // plot area.
        LegendBox b = c.addLegend2(55, 33, 3, "Arial Bold", 9);
        b.setBackground(Chart.Transparent, Chart.Transparent);
        b.setWidth(520);

        // Configure the y-axis with a 10pts Arial Bold axis title
        c.yAxis().setTitle("Intensity (V/m)", "Arial Bold", 10);

        // Configure the x-axis to auto-scale with at least 75 pixels between major tick and 15
        // pixels between minor ticks. This shows more minor grid lines on the chart.
        c.xAxis().setTickDensity(75, 15);

        // Set the axes width to 2 pixels
        c.xAxis().setWidth(2);
        c.yAxis().setWidth(2);

        // Now we add the data to the chart
        Date lastTime = timeStamps[timeStamps.length - 1];
        if (lastTime != null)
        {
            // Set up the x-axis to show the time range in the data buffer
            c.xAxis().setDateScale(
                new Date(lastTime.getTime() - dataInterval * timeStamps.length), lastTime);

            // Set the x-axis label format
            c.xAxis().setLabelFormat("{value|hh:nn:ss}");

            // Create a line layer to plot the lines
            LineLayer layer = c.addLineLayer2();

            // The x-coordinates are the timeStamps.
            layer.setXData(timeStamps);

            // The 3 data series are used to draw 3 lines. Here we put the latest data
            // values as part of the data set name, so you can see them updated in the
            // legend box.
            layer.addDataSet(dataSeriesA, 0xff0000, "Alpha: <*bgColor=FFCCCC*>" +
                c.formatValue(dataSeriesA[dataSeriesA.length - 1], " {value|2} "));
            layer.addDataSet(dataSeriesB, 0x00cc00, "Beta: <*bgColor=CCFFCC*>" +
                c.formatValue(dataSeriesB[dataSeriesB.length - 1], " {value|2} "));
            layer.addDataSet(dataSeriesC, 0x0000ff, "Gamma: <*bgColor=CCCCFF*>" +
                c.formatValue(dataSeriesC[dataSeriesC.length - 1], " {value|2} "));
        }

        // Set the chart image to the ChartViewer
        chartViewer1.setChart(c);
    }

    //
    // Implementation of the DemoModule interface to allow this demo to run inside the
    // ChartDirectorDemo browser
    //

    // Name of demo program
    public String toString()
    {
        return "Simple Realtime Chart";
    }

    // Number of charts produced in this demo
    public int getNoOfCharts()
    {
        // This demo open its own frame instead of using the right pane of the ChartDirectorDemo
        // browser for display, so we just load the frame, then returns 0.
        setupFrame();
        setVisible(true);
        return 0;
    }

    // Main code for creating charts
    public void createChart(ChartViewer viewer, int index)
    {
        // Do nothing, as the ChartDirectorDemo browser right pane is not used.
    }
}