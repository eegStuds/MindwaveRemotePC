


import java.io.*;
import java.net.*;

public class mindset {

    public static void main(String[] args) {
		String host = "localhost";
      	int batteryport = 5590;
      	int signalport = 5591;
      	int attentionport = 5592;
      	int meditationport = 5593;
      	int deltaport = 5594;
      	int thetaport = 5595;
      	int alpha1port = 5596;
      	int alpha2port = 5597;
      	int beta1port = 5598;
      	int beta2port = 5599;
      	int gamma1port = 5600;
      	int gamma2port = 5601;
      	int rawport = 5602;


      	DatagramSocket dsocket = null;
      	InetAddress address = null;
      	try{
			address = InetAddress.getByName(host);
			dsocket = new DatagramSocket();
		}
		catch(Exception e){

		}

        int connectionId = ThinkGear.GetNewConnectionId();
        if(ThinkGear.Connect(connectionId, "\\\\.\\COM10", ThinkGear.BAUD_9600, ThinkGear.STREAM_PACKETS) != 0){
			System.out.println("Failed to connect");
		}
		else{
			System.out.println("Connected");
		}
		byte[] message;
		DatagramPacket packet;
		while(true){
			int temp = ThinkGear.ReadPackets(connectionId, -1);
			if(temp > 0){
				try{
					//System.out.println("Send");

					message = Double.toString(ThinkGear.GetValue(connectionId, ThinkGear.DATA_RAW)).getBytes();
					packet = new DatagramPacket(message, message.length, address, rawport);
					dsocket.send(packet);

					message = Double.toString(ThinkGear.GetValue(connectionId, ThinkGear.DATA_BATTERY)).getBytes();
					packet = new DatagramPacket(message, message.length, address, batteryport);
					dsocket.send(packet);

					message = Double.toString(ThinkGear.GetValue(connectionId, ThinkGear.DATA_POOR_SIGNAL)).getBytes();
					packet = new DatagramPacket(message, message.length, address, signalport);
					dsocket.send(packet);

					message = Double.toString(ThinkGear.GetValue(connectionId, ThinkGear.DATA_ATTENTION)).getBytes();
					packet = new DatagramPacket(message, message.length, address, attentionport);
					dsocket.send(packet);

					message = Double.toString(ThinkGear.GetValue(connectionId, ThinkGear.DATA_MEDITATION)).getBytes();
					packet = new DatagramPacket(message, message.length, address, meditationport);
					dsocket.send(packet);

					message = Double.toString(ThinkGear.GetValue(connectionId, ThinkGear.DATA_DELTA)).getBytes();
					packet = new DatagramPacket(message, message.length, address, deltaport);
					dsocket.send(packet);

					message = Double.toString(ThinkGear.GetValue(connectionId, ThinkGear.DATA_THETA)).getBytes();
					packet = new DatagramPacket(message, message.length, address, thetaport);
					dsocket.send(packet);

					message = Double.toString(ThinkGear.GetValue(connectionId, ThinkGear.DATA_ALPHA1)).getBytes();
					packet = new DatagramPacket(message, message.length, address, alpha1port);
					dsocket.send(packet);

					message = Double.toString(ThinkGear.GetValue(connectionId, ThinkGear.DATA_ALPHA2)).getBytes();
					packet = new DatagramPacket(message, message.length, address, alpha2port);
					dsocket.send(packet);

					message = Double.toString(ThinkGear.GetValue(connectionId, ThinkGear.DATA_BETA1)).getBytes();
					packet = new DatagramPacket(message, message.length, address, beta1port);
					dsocket.send(packet);

					message = Double.toString(ThinkGear.GetValue(connectionId, ThinkGear.DATA_BETA2)).getBytes();
					packet = new DatagramPacket(message, message.length, address, beta2port);
					dsocket.send(packet);

					message = Double.toString(ThinkGear.GetValue(connectionId, ThinkGear.DATA_GAMMA1)).getBytes();
					packet = new DatagramPacket(message, message.length, address, gamma1port);
					dsocket.send(packet);

					message = Double.toString(ThinkGear.GetValue(connectionId, ThinkGear.DATA_GAMMA2)).getBytes();
					packet = new DatagramPacket(message, message.length, address, gamma2port);
					dsocket.send(packet);
				}
				catch(Exception e){

				}
			}
			else{
				try{
					Thread.sleep(2);
				}
				catch(Exception e){

				}
			}
		}
		//ThinkGear.Disconnect(connectionId);
		//ThinkGear.FreeConnection(connectionId);
		//dsocket.close();
    }

}
