package mindwavedata.process;



public class EyebrowProcess {
	
	public static int sEyebrow;
	public static boolean sEyebrowtracker;
	private boolean eyebrowDetected;
	private boolean eyebrowstart,eyebrowstop;
	
	/////////////////////set different length wrt neurosky//////////////////////////////
	private long tEyebrowTHlow,tEyebrowTHhigh;
	
/////////////////////set different length wrt processfromEEG//////////////////////////////
	private long tNextEyebrowTH;
	
	
	public static long tStarEyebrow,tStopEyebrow,tprevStopEyebrow;
	private long tEyebrowlength;
	
	public void proessfromEEG(double neuroskyEEGsignal){
		
		
		
	}
	
	
	///////////////////can be used in future////////////////////
	//if(eyebrowstart==true && eyebrowstop==true)
	//tEyebrowlength=tStopEyebrow-tStarEyebrow;

	
	public void eyebrowdetect(){
		
		
			
			if(tEyebrowlength < tEyebrowTHhigh && tEyebrowlength > tEyebrowTHlow){
				eyebrowDetected = true;
				sEyebrowtracker= false;
				updateEyebrows();
				
				
			}else{
				eyebrowDetected= false;
				
				//////////////may change///////////////////
				sEyebrowtracker=true;
				//////////////later///////////////////////
				}
		
	
	}
	
	public void updateEyebrows(){
		
		if(tStarEyebrow-tprevStopEyebrow<=tNextEyebrowTH)
		{
			sEyebrow=sEyebrow+1;
		}else{
			sEyebrow=1;
			sEyebrowtracker=true;
		}
			
			tprevStopEyebrow=tStopEyebrow;
		
	}
	
	
}
