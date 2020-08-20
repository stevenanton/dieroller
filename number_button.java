package version1;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class number_button extends Button implements ActionListener{

	public die_roller_frame d;
	
	public number_button(String txt, int xpos, int ypos, int width, int height, die_roller_frame d) {
		super(txt);
		this.d = d;
		this.d.add(this);
		setBounds(xpos, ypos, width, height);
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String txt = ((number_button) e.getSource()).getLabel();
		
		d.currNumber.setText(txt);
	}

}
