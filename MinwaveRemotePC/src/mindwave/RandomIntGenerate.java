package mindwave;

import java.util.Random;

public class RandomIntGenerate {
	
	double randomdata;
	Random mRandom;
	//double[] mdata;
	
	private final int dataInterval = 250;
    private final int sampleSize = 240;
    private double[] mdata ;
	
	public RandomIntGenerate(){
		mRandom=new Random(10);
		mdata = new double[sampleSize];
	}


	public void raanomgenrate(){
		// TODO Auto-generated method stub
		this.randomdata=100+(10-1)*mRandom.nextFloat();
		System.out.print(randomdata);
		shiftData(randomdata);
	}
	
	private void shiftData( double newValue) {
		// TODO Auto-generated method stub
		for (int i = 1; i < mdata.length; ++i)
            mdata[i - 1] = mdata[i];
        mdata[mdata.length - 1] = newValue;
        //System.out.print(mdata);
	}
	public void printlastdata(){
		System.out.println(mdata[mdata.length-1]);
	}

}
