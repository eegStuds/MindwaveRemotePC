import mindwave.RandomIntGenerate;


public class RandomValueTest {

	protected RandomIntGenerate ranti;
	public RandomValueTest(){
		ranti = new RandomIntGenerate();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomValueTest rValueTest=new RandomValueTest();
		//rValueTest.setup();
		rValueTest.runner();

		   
	}
	public void setup(){
		
	}

	private void runner() {
		// TODO Auto-generated method stub
		while(true){
		ranti.raanomgenrate();
		System.out.print("  //   ");
		ranti.printlastdata();
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
