package filehandle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import remoteapps.appkeydatabase.MappVLC;

public class HandlingFiles implements KeyListener{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandlingFiles pHandlingFiles =new HandlingFiles();
		pHandlingFiles.createkeydatabase();
		//Scanner mScanner= new Scanner(System.in);
		//mScanner.
		
	}

	private void createkeydatabase() {
		// TODO Auto-generated method stub
		MappVLC pMapping=new MappVLC();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getKeyCode()==KeyEvent.VK_A){
			System.out.println("a");
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
