package mindwavedata.process;

public class BlinkProcess {
	
	public static int sBlinks;
	public static boolean sBlinkTracker;
	public static long tStartBlink,tStopBlink, tprevStopBlink;
	
	
	
	private boolean blinkDetected;
	private boolean blinkStart,blinkstop;
	
	//////////////////////set different length wrt neurosky//////////////
	private long tBlinkTHlow,tBlinkTHhigh;
	
	//////////////////////set different length using processfromEEG();//////////////
	private long tNextBlinkTH;
	
	private long tBlinkLenth;
	
	public void processfromEEG(double neuroskyEEGsignal){
		
		
		
			
		
	}
	
	//////////can be used in future////////////////
	///if(blinkStart==true && blinkstop==true)
	///tBlinkLenth = tStopBlink-tStartBlink;
	////////////////////////////////////////////////
	public void blinkdetect(){
		
		
		if(tBlinkLenth<tBlinkTHhigh && tBlinkLenth>tBlinkTHlow){
			blinkDetected=true;
			sBlinkTracker=false;
			updateBlinks();
		}else{
			blinkDetected=false;
			
			//////may change ////////
			sBlinkTracker=true;
			//////////////later////////////
		}
		
	}
	
	public void updateBlinks(){
		
		if(tStartBlink-tprevStopBlink<=tNextBlinkTH)
		{
			
			sBlinks=sBlinks+1;
		}else{
			sBlinks=1;
			sBlinkTracker=true;
		}
		
		
		tprevStopBlink=tStopBlink;
	}
	
	
	
}
