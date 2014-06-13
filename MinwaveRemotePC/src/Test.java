import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class Test {

	


	
		
		private static BufferedReader bufin;
		private static OutputStream out;

		public static void main(String[] args) throws Exception{
			
			
			InetAddress localhost = InetAddress.getByName("localhost");
			
		     Socket socket = new Socket(localhost, 8080);
		     
		     InputStream in = socket.getInputStream();
		     

	         bufin = new BufferedReader(new InputStreamReader(in));
	         out = socket.getOutputStream();
	         
	         
	         
	         /*Thread inputThread = new Thread(new Runnable() {
				
				public void run() {
					// TODO Auto-generated method stub
					{
			        	boolean ok = true;
			            while(ok) {
			              try {
			                System.out.println(bufin.readLine());           
			              }
			              catch (Exception e) {
			                System.out.println("Whoops: " + e.getMessage());
			                ok = false;
			              }
			            }
					}
				}
			});
	         */
	         
	         Thread inputThread = new Thread(new Runnable() {
				
				public void run() {
					// TODO Auto-generated method stub
					boolean ok = true;
		            while(ok) {
		              try {
		                System.out.println(bufin.readLine());           
		              }
		              catch (Exception e) {
		                System.out.println("Whoops: " + e.getMessage());
		                ok = false;
		              }
		            }
				}

			});
	         inputThread.setDaemon(true);
	         inputThread.start();
	         
	         Thread.sleep(200);
	         out.write("help \n".getBytes());
	         out.write("status \n".getBytes());
	         //Thread.sleep(200);
	         //out.write("volume 190 \n".getBytes());
	         //out.write("pause \n".getBytes());
	         Thread.sleep(200);
	         out.close();
	         in.close();
	         socket.close();
	         System.exit(0);
			/*Thread inputThread = new Thread(new Runnable()
	        {

	        @Override
	        public void run()
	           {
	        	boolean ok = true;
	            while(ok) {
	              try {
	                System.out.println(bufin.readLine());           
	              }
	              catch (Exception e) {
	                System.out.println("Whoops: " + e.getMessage());
	                ok = false;
	              }
	            } 
	           }
	        });
			inputThread.setDaemon(true);
	     inputThread.start();
	     
	     Thread.sleep(200);
	     out.write("help \n".getBytes());
	     Thread.sleep(200);
	     out.write("volume 190 \n".getBytes());
	     out.write("pause \n".getBytes());
	     Thread.sleep(200);
	     out.close();
	     in.close();
	     socket.close();
	     System.exit(0);
			*/
		}

	


}

