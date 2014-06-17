import java.awt.Color;
import java.awt.event.*;
import java.util.Date;

import ChartDirector.*;
import mygui.Graphdev;
import mygui.Samplegui;


public class Guitest{

	public Samplegui mSamplegui;
	
	private javax.swing.Timer dataRateTimer;
    private javax.swing.Timer chartUpdateTimer;
    private Date nextDataTime;
    
    private final int dataInterval = 10;
    private final int sampleSize = 240;
    
    private Date[] timeStamps = new Date[sampleSize];
    private double[] dataAlpha = new double[sampleSize];
    private double[] dataBeta = new double[sampleSize];
    private double[] dataGamma = new double[sampleSize];

	private int chartwidth;

	private int chartheight;


	//private boolean hasFinishedInitialization;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Thread guiThread=new Thread(new Runnable() {
			public void run() {
				Guitest guitest=new Guitest();
				guitest.loadgui();
				guitest.setupGuiData();
				guitest.setstart();
			}
		});
		guiThread.start();
	}
	public Guitest(){
		mSamplegui=new Samplegui();
		//mSamplegui.setVisible(true);
	}

	protected void loadgui() {
		// TODO Auto-generated method stub
		
		mSamplegui.runPB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				runPB_clicked();
			}
		});
		
		mSamplegui.freezePB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				freezePB_Clicked();
				
			}
		});
		
		mSamplegui.samplePeriod.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				samplePeriod_ValueChanged(evt);
			}
		});
		mSamplegui.mcentrePanel.addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				int width=mSamplegui.mcentrePanel.getWidth();
				int height=mSamplegui.mcentrePanel.getHeight();
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
		
		mSamplegui.mChartviewer.addViewPortListener(new ViewPortAdapter(){
			public void  viewPortChanged(ViewPortChangedEvent e){
				chartViewer1_viewPortChanged(e);
			}
		});
		
		
	}
	
	protected void update_chartwidth(int width, int height) {
		// TODO Auto-generated method stub
		
		if(width>600 || height>400)
    	{
    		//System.out.print(width);
    		//System.out.println("    ");
    		//System.out.println(height);
    		chartwidth=width;
    		chartheight=height;
    	}
		
	}
	protected void setstart() {
		// TODO Auto-generated method stub
		//mSamplegui.pack();
        mSamplegui.hasFinishedInitialization = true;

        mSamplegui.setVisible(true);
        // Start collecting and plotting data
        dataRateTimer.start();
        //mSamplegui.runPB.doClick();
	}

	
	
   
	protected void setupGuiData(){
		nextDataTime = new Date();
		
		// The data generation timer for our random number generator
        dataRateTimer = new javax.swing.Timer(dataInterval, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dataRateTimer_Tick();
            }
        });


     // The chart update timer
        chartUpdateTimer = new javax.swing.Timer(
            Integer.parseInt((String)mSamplegui.samplePeriod.getSelectedItem()), new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                chartUpdateTimer_Tick();
            }
        });
        
       // mSamplegui.pack();
        //mSamplegui.hasFinishedInitialization = true;
        
        //dataRateTimer.start();
       // mSamplegui.runPB.doClick();
		
	}
	
	protected void chartViewer1_viewPortChanged(ViewPortChangedEvent e) {
		// TODO Auto-generated method stub
		drawChart(mSamplegui.mChartviewer, chartwidth , chartheight);
	}

	protected void samplePeriod_ValueChanged(ActionEvent evt) {
		// TODO Auto-generated method stub
		int period = Integer.parseInt(mSamplegui.samplePeriod.getSelectedItem().toString());
        chartUpdateTimer.setDelay(period);
        chartUpdateTimer.setInitialDelay(period);
	}

	protected void freezePB_Clicked() {
		// TODO Auto-generated method stub
		mSamplegui.freezePB.setBackground(new Color(0x80, 0xff, 0x80));
        mSamplegui.runPB.setBackground(null);
        chartUpdateTimer.stop();
	}

	protected void runPB_clicked() {
		// TODO Auto-generated method stub
		mSamplegui.runPB.setBackground(new Color(0x80, 0xff, 0x80));
        mSamplegui.freezePB.setBackground(null);
        chartUpdateTimer.start();
	}

	

	protected void chartUpdateTimer_Tick() {
		// TODO Auto-generated method stub
		mSamplegui.mChartviewer.updateViewPort(true, false);
	}
	
	//
    // The data update routine. In this demo, it is invoked every 250ms to get new data.
    //

	protected void dataRateTimer_Tick() {
		// TODO Auto-generated method stub
		
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
            shiftData(dataAlpha, dataA);
            shiftData(dataBeta, dataB);
            shiftData(dataGamma, dataC);
            shiftData(timeStamps, nextDataTime);

            // Update nextDataTime
            nextDataTime = new Date(nextDataTime.getTime() + dataInterval);
        }
        while (nextDataTime.before(now));

        // We provide some visual feedback to the numbers generated, so you can see the
        // data being updated.
       /* valueA.setText("" + Math.round(dataAlpha[dataAlpha.length - 1] * 100) / 100.0);
        valueB.setText("" + Math.round(dataBeta[dataBeta.length - 1] * 100) / 100.0);
        valueC.setText("" + Math.round(dataGamma[dataGamma.length - 1] * 100) / 100.0);
		*/
	}
	
	//
    // Utility to shift a double value into an array
    //
	private void shiftData(double[] data, double newValue) {
		// TODO Auto-generated method stub
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
	
    private void drawChart(ChartViewer chartViewer12,int width,int height) {
		// TODO Auto-generated method stub
		
		// Create an XYChart object 600 x 270 pixels in size, with light grey (f4f4f4)
        // background, black (000000) border, 1 pixel raised effect, and with a rounded frame.
        XYChart c = new XYChart(width, height, 0xf4f4f4, 0x000000, 1);
        //c.setRoundedFrame();
        

        // Re-cycle the resources of the existing chart, if any. This can improve performance
        // by reducing the frequency of garbage collections.
        c.recycle(chartViewer12.getChart());

        // Set the plotarea at (55, 62) and of size 520 x 175 pixels. Use white (ffffff)
        // background. Enable both horizontal and vertical grids by setting their colors to
        // grey (cccccc). Set clipping mode to clip the data lines to the plot area.
        c.setPlotArea(55, 62, width-80, height-95, 0xffffff, -1, -1, 0xcccccc, 0xcccccc);
        c.setClipping();

        // Add a title to the chart using 15 pts Times New Roman Bold Italic font, with a light
        // grey (dddddd) background, black (000000) border, and a glass like raised effect.
        c.addTitle("Mindwave Signals", "Times New Roman Bold Italic", 15
            ).setBackground(0xdddddd, 0x000000, Chart.glassEffect());

        // Add a legend box at the top of the plot area with 9pts Arial Bold font. We set the
        // legend box to the same width as the plot area and use grid layout (as opposed to
        // flow or top/down layout). This distributes the 3 legend icons evenly on top of the
        // plot area.
        LegendBox b = c.addLegend2(55, 33, 3, "Arial Bold", 9);
        b.setBackground(Chart.Transparent, Chart.Transparent);
        b.setWidth(520);

        // Configure the y-axis with a 10pts Arial Bold axis title
        c.yAxis().setTitle("Amplitide", "Arial Bold", 10);

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
            layer.addDataSet(dataAlpha, 0xff0000, "Alpha: <*bgColor=FFCCCC*>" +
                c.formatValue(dataAlpha[dataAlpha.length - 1], " {value|2} "));
            layer.addDataSet(dataBeta, 0x00cc00, "Beta: <*bgColor=CCFFCC*>" +
                c.formatValue(dataBeta[dataBeta.length - 1], " {value|2} "));
            layer.addDataSet(dataGamma, 0x0000ff, "Gamma: <*bgColor=CCCCFF*>" +
                c.formatValue(dataGamma[dataGamma.length - 1], " {value|2} "));
        }

        // Set the chart image to the ChartViewer
        chartViewer12.setChart(c);
		
	}
}
