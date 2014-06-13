import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import remoteapps.KeyRunner;

public class CommandTest {

	public static void main(String[] args) {
	
		KeyRunner comRunner = new KeyRunner();
		int[] val= {KeyEvent.VK_Q,KeyEvent.VK_W,KeyEvent.VK_LEFT,KeyEvent.VK_R,KeyEvent.VK_T,KeyEvent.VK_Y};
		int[] val2= {KeyEvent.VK_M,KeyEvent.VK_N,KeyEvent.VK_RIGHT,KeyEvent.VK_J,KeyEvent.VK_F,KeyEvent.VK_Y};
		comRunner.addKeys(val);
		comRunner.addKeys(val2);
		
		int[] pstr = comRunner.getKeys(1);
		
		try {
            Robot robot = new Robot();
            // Create a three seconds delay.
            robot.delay(100);
                                     
            // Genering key press event for writing the QWERTY letters
           for(int i=0;i<pstr.length;i++)
            robot.keyPress(pstr[i]);
            
        } catch (AWTException e) {
            e.printStackTrace();
        }				
		System.out.println(pstr[2]);
		
		System.out.println(comRunner.getKey(2, 1));
		
	}
}