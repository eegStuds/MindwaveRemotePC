import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;

import javax.comm.CommPortIdentifier;
import javax.comm.PortInUseException;
import javax.comm.SerialPort;
import javax.comm.SerialPortEvent;
import javax.comm.SerialPortEventListener;
import javax.comm.UnsupportedCommOperationException;

import mindwave.ThinkGear;




public class MindwaveTest {
	
	
	static CommPortIdentifier portId;
    static Enumeration portList;

    
    //InputStream inputStream;
    //SerialPort serialPort;
    //Thread readThread;

	
	private static int dv;
	static int re;
	
	
	public static void main(String[] args) {
		
		
		portList = CommPortIdentifier.getPortIdentifiers();
     System.out.println(portList);
     
        while (portList.hasMoreElements()) {
        	System.out.println("ff");
            portId = (CommPortIdentifier) portList.nextElement();
            System.out.println(portId.getName());
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                 if (portId.getName().equals("/dev/term/a")) {
			//                if (portId.getName().equals("/dev/term/a")) {
                    System.out.println("he"+portId.getName());
                }
            }
        }
        
		
		
		dv=ThinkGear.GetDriverVersion();
		re=ThinkGear.GetNewConnectionId();
		System.out.println("he");
		System.out.println(dv);
		System.out.println("he");
		System.out.println(re);
		int hre=ThinkGear.BAUD_9600;
		System.out.println(hre);
		//String s= '\.';
		int res=ThinkGear.Connect(re, "\\\\.\\COM13", hre, ThinkGear.STREAM_PACKETS);
		System.out.println(res);
		
		int read = ThinkGear.ReadPackets(re, -1);
		System.out.println(read);
		double de= ThinkGear.GetValue(re,5);
		System.out.println(de);
		System.out.println(ThinkGear.GetValueStatus(re, 1));
		
		
		
		
	}
	/*static {
        System.loadLibrary("thinkgear");
    }*/
	

}
