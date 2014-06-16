package mygui;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class frametest implements ActionListener{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		frametest mFrametest=new frametest();
				mFrametest.setframe();	
				
			
	}


	private portframe frame;
	private String strr;
	
	public void setframe(){
		frame = new portframe(this);
		frame.addelements();
		frame.setVisible(true);
		
		
		System.out.println("dhdh");
		System.out.println("dhdhdh");
		System.out.println(this.strr);
	}
	
	public void closeframe(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton pButton =(JButton) e.getSource();
		frametest.this.strr=pButton.getText();
		frametest.this.exitnow();
	}
	
	
	protected void exitnow() {
		// TODO Auto-generated method stub
		this.frame.setVisible(false); //you can't see me!
		this.frame.dispose();
		System.out.println(strr);
	}

}
