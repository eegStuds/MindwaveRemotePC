package remoteapps.appkeydatabase;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Vector;

public class VlcMapping {
	
	
	List<Vector<Integer>> re;
	static public  String VlcSocketMap(int pCommand, int pStrength){
		System.out.println("Mapping between key and functions\n"
    			+ "key 1 : for Inc volume by fixed steps\n"
    			+ "key 2 : for Dec volume by fixes steps\n"
    			+ "key 3 : for Next \n"
    			+ "key 4 : for Previous\n"
    			+ "key 5 : for setVolume\n"
    			+ "key 6 : for fastforward\n"
    			+ "key 7 : for rewind\n"
    			+ "key 8: for pause...\n"
    			+ "key 9: for ..................\n"
				+ "key 10: for ............\n");
    	switch (pCommand) {
		case 1:
			return "volup 2\n"; 
		case 2:
			return "voldown 2\n";
		case 3:
			return "next\n";
		case 4:
			return "prev\n";
		case 5:
			return "voulme 100\n";
		case 6:
			return "fastforward\n" ;
		case 7:
			return "rewind\n";
		case 8:
			return "pause\n";
		default:
			return "status";
		}
	}
	
	static public Vector<Integer> VlcKeyMap(int pCommand, int pStrength){
		Vector<Integer> a = new Vector<Integer>(); //=null;
		System.out.println("Generating keys..............for" + pCommand + " "+ pStrength);
		switch (pCommand) {
		case 1://increse volume
			System.out.println("Generating keys for -volume increase");
			a.add(KeyEvent.VK_CONTROL );
			a.add(KeyEvent.VK_UP);
			return a;
		case 2://decrease volume
			System.out.println("Generating keys for -volume decrease");
			a.add(KeyEvent.VK_CONTROL );
			a.add(KeyEvent.VK_DOWN);
			return a;
		case 3://next
			System.out.println("Generating keys for -...............");
			a.add(KeyEvent.VK_N);
			return a;
		case 4://previous
			a.add(KeyEvent.VK_P);
			return a;
		case 5://set volume to 100
			return a;
		case 6://fast forward
			a.add(KeyEvent.VK_CONTROL );
			a.add(KeyEvent.VK_LEFT);
			return a;
		case 7://fast backward
			a.add(KeyEvent.VK_CONTROL );
			a.add(KeyEvent.VK_RIGHT);
			return a;
		case 8://slow forward
			a.add(KeyEvent.VK_SHIFT );
			a.add(KeyEvent.VK_LEFT);
			return a;
		case 9://slow backward
			a.add(KeyEvent.VK_SHIFT );
			a.add(KeyEvent.VK_LEFT);
			return a;
		case 10://   pause/paly
			a.add(KeyEvent.VK_SPACE );
			return a;
		case 11:// mute
			a.add(KeyEvent.VK_M );
			return a;
		default:
			return a;
		}
		
		
		//
	}

}
