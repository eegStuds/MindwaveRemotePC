


import java.net.*;

public class mindsetb {

    public static void main(String[] args) {
		String host = "localhost";
      	int batteryport = 5603;
      	int signalport = 5604;
      	int attentionport = 5605;
      	int meditationport = 5606;
      	int deltaport = 5607;
      	int thetaport = 5608;
      	int alpha1port = 5609;
      	int alpha2port = 5610;
      	int beta1port = 5611;
      	int beta2port = 5612;
      	int gamma1port = 5613;
      	int gamma2port = 5614;
      	int rawport = 5615;


      	DatagramSocket dsocket = null;
      	InetAddress address = null;
      	try{
			address = InetAddress.getByName(host);
			dsocket = new DatagramSocket();
		}
		catch(Exception e){

		}

        int connectionId = ThinkGear.GetNewConnectionId();
        if(ThinkGear.Connect(connectionId, "\\\\.\\COM13", ThinkGear.BAUD_9600, ThinkGear.STREAM_PACKETS) != 0){
			System.out.println("Failed to connect");
		}
		else{
			System.out.println("Connected");
		}
		byte[] message;
		double readdataval;
		DatagramPacket packet;
		while(true){
			int temp = ThinkGear.ReadPackets(connectionId, -1);
			if(temp > 0){
				try{
					//System.out.println("Send");
					readdataval=ThinkGear.GetValue(connectionId, ThinkGear.DATA_RAW);

					System.out.print(readdataval);
					System.out.print("  /DATA_RAW/  ");

					
					readdataval=ThinkGear.GetValue(connectionId, ThinkGear.DATA_BATTERY);
					
					System.out.print(readdataval);
					System.out.print("  /DATA_BATTERY/  ");


					readdataval=ThinkGear.GetValue(connectionId, ThinkGear.DATA_POOR_SIGNAL);
					
					System.out.print(readdataval);
					System.out.print("  /DATA_POOR_SIGNAL/  ");


					readdataval=ThinkGear.GetValue(connectionId, ThinkGear.DATA_ATTENTION);
					
					System.out.print(readdataval);
					System.out.print("  /DATA_ATTENTION/  ");

					
					readdataval=ThinkGear.GetValue(connectionId, ThinkGear.DATA_MEDITATION);
					
					System.out.print(readdataval);
					System.out.print("  /DATA_MEDITATION/  ");

					
					readdataval=ThinkGear.GetValue(connectionId, ThinkGear.DATA_DELTA);
					
					System.out.print(readdataval);
					System.out.print("  /DATA_DELTA/  ");

					
					readdataval=ThinkGear.GetValue(connectionId, ThinkGear.DATA_THETA);
					
					System.out.print(readdataval);
					System.out.print("  /DATA_THETA/  ");

					
					readdataval=ThinkGear.GetValue(connectionId, ThinkGear.DATA_ALPHA1);
					
					System.out.print(readdataval);
					System.out.print("  /DATA_ALPHA1/  ");

					
					readdataval=ThinkGear.GetValue(connectionId, ThinkGear.DATA_ALPHA2);
					
					System.out.print(readdataval);
					System.out.print("  /DATA_ALPHA2/  ");

					
					readdataval=ThinkGear.GetValue(connectionId, ThinkGear.DATA_BETA1);
					
					System.out.print(readdataval);
					System.out.print("  /DATA_BETA1/  ");

					
					readdataval=ThinkGear.GetValue(connectionId, ThinkGear.DATA_BETA2);
					
					System.out.print(readdataval);
					System.out.print("  /DATA_BETA2/  ");

					
					readdataval=ThinkGear.GetValue(connectionId, ThinkGear.DATA_GAMMA1);
					
					System.out.print(readdataval);
					System.out.print("  /DATA_GAMMA1/  ");

					
					readdataval=ThinkGear.GetValue(connectionId, ThinkGear.DATA_GAMMA2);
					
					System.out.print(readdataval);
					System.out.println("  /DATA_GAMMA2/  ");
					/*
					 * message = Double.toString(readdataval).getBytes();
					packet = new DatagramPacket(message, message.length, address, gamma2port);
					dsocket.send(packet);
					
					 */
				}
				catch(Exception e){

				}
			}
			else{
				try{
					Thread.sleep(2);
				}
				catch(Exception e){
					e.printStackTrace();

				}
			}
		}
		//ThinkGear.Disconnect(connectionId);
		//ThinkGear.FreeConnection(connectionId);
		//dsocket.close();
    }

}
