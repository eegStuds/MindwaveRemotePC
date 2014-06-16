package mygui;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class CheckboxActionListener implements ActionListener {

	 LinkedList<JRadioButton> mCheckBoxs = new LinkedList<JRadioButton>();
	
	
   public CheckboxActionListener(LinkedList<JRadioButton> pCheckboxs){
	this.mCheckBoxs=pCheckboxs;
}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		StringBuilder sb = new StringBuilder();
	    sb.append("Selected Check Boxes: ");
	    
	    for (JRadioButton checkBox : mCheckBoxs) {
	        if (checkBox.isSelected()) {
	          sb.append(checkBox.getText()).append(' ');
	        }
	      }
	    
	    JOptionPane.showMessageDialog(null, sb);
		
		
	}


}


