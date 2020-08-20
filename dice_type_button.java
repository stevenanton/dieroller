package version1;

import java.awt.*;
import java.awt.event.*;

public class dice_type_button extends Button implements ActionListener{

	public die_roller_frame d;
	
	public dice_type_button(String txt, int xpos, int ypos, int width, int height, die_roller_frame d) {
		super(txt);
		this.d = d;
		this.d.add(this);
		setBounds(xpos, ypos, width, height);
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String txt = ((dice_type_button) e.getSource()).getLabel();
		
		d.currDice.setText(txt);
	}

}
