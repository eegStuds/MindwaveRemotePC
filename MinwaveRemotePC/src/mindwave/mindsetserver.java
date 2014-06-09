package mindwave;

import java.util.Date;
import java.io.*;
import java.net.*;

import com.illposed.osc.*;


public class mindsetserver{

	OSCPortIn receiver;
	OSCPortOut sender;
	OSCListener listener;
	String mindsettarget;

	int connectionId;

	String target;
	int connected;

	int disconnect;

	int count;

	InetAddress remotetarget;
	int remoteport;

	public mindsetserver(){
		System.out.println("Activating");
	}

	public int init(){
		try{
			count = 0;
			connectionId = ThinkGear.GetNewConnectionId();;
			receiver = new OSCPortIn(7777);
			target = "";
			connected = 0;
			disconnect = 0;
			remotetarget = InetAddress.getByName("localhost");
			remoteport = 7778;
			sender = new OSCPortOut(remotetarget, remoteport);

			listener = new OSCListener() {
				public void acceptMessage(java.util.Date time, OSCMessage message) {
					if(message.getAddress().equals("/connect")){
						Object args[] = message.getArguments();
						if(target.equals("")){
							System.out.println("Targetting " + args[0].toString());
							target = args[0].toString();
						}
					}
					else if(message.getAddress().equals("/disconnect")){
						System.out.println("Disconnect Requested");
						disconnect = 1;
					}
				}
			};
			receiver.addListener("/connect", listener);
			receiver.addListener("/disconnect", listener);
			receiver.startListening();

			return 1;
		}
		catch(Exception e){
			System.out.println("Couln't open a port: " + e.toString());
			return 0;
		}
	}

	public void runner(){
		while(true){
			try{
				Thread.sleep(1000);
				if(connected == 0){
					System.out.println("Not connected");
				}
				if(!target.equals("")){
					System.out.println("Have a target");
				}
				if(connected == 0 && !target.equals("")){
					System.out.println("Trying");
					if(ThinkGear.Connect(connectionId, "\\\\.\\" + target, ThinkGear.BAUD_9600, ThinkGear.STREAM_PACKETS) == 0){
						System.out.println("Connected to " + target);
						connected = 1;
						while(connected == 1){
							int temp = ThinkGear.ReadPackets(connectionId, 1);
							if(temp > 0){
								try{
									if(ThinkGear.GetValueStatus(connectionId, ThinkGear.DATA_MEDITATION) != 0){
										Object args[] = new Object[1];
										args[0] = (int)ThinkGear.GetValue(connectionId, ThinkGear.DATA_MEDITATION);
										System.out.println(Double.toString(ThinkGear.GetValue(connectionId, ThinkGear.DATA_MEDITATION)));
										OSCMessage msg = new OSCMessage("/1/Meditation", args);
										try {
											sender.send(msg);
										} catch (Exception e) {
											System.out.println("Couldn't send");
										}
									}
								}
								catch(Exception e){

								}
								try{
									if(ThinkGear.GetValueStatus(connectionId, ThinkGear.DATA_BATTERY) != 0){
										Object args[] = new Object[1];
										args[0] = (int)ThinkGear.GetValue(connectionId, ThinkGear.DATA_BATTERY);
										System.out.println(Double.toString(ThinkGear.GetValue(connectionId, ThinkGear.DATA_BATTERY)));
										OSCMessage msg = new OSCMessage("/1/Battery", args);
										try {
											sender.send(msg);
										} catch (Exception e) {
											System.out.println("Couldn't send");
										}
									}
								}
								catch(Exception e){

								}
								try{
									if(ThinkGear.GetValueStatus(connectionId, ThinkGear.DATA_POOR_SIGNAL) != 0){
										Object args[] = new Object[1];
										args[0] = (int)ThinkGear.GetValue(connectionId, ThinkGear.DATA_POOR_SIGNAL);
										System.out.println(Double.toString(ThinkGear.GetValue(connectionId, ThinkGear.DATA_POOR_SIGNAL)));
										OSCMessage msg = new OSCMessage("/1/Signal", args);
										try {
											sender.send(msg);
										} catch (Exception e) {
											System.out.println("Couldn't send");
										}
									}
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
							if(disconnect == 1){
								ThinkGear.Disconnect(connectionId);
								connected = 0;
								disconnect = 0;
								target = "";
								System.out.println("Disconnecting");
							}
						}


					}
					else{
						System.out.println("Failed Connecting");
					}
				}
				if(disconnect == 1){
					ThinkGear.Disconnect(connectionId);
					connected = 0;
					disconnect = 0;
					target = "";
					System.out.println("Disconnecting");
				}

			}
			catch(Exception e){
				System.out.println("Weird loop error");
			}
		}
	}

	public static void main(String[] args) {
		mindsetserver server = new mindsetserver();
		if(server.init() != 1){
			System.out.println("Quitting");
			System.exit(0);
		}
		server.runner();
	}
}