package version1;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class add_button extends Button implements ActionListener{

	public die_roller_frame d;
	
	public add_button(String txt, int xpos, int ypos, int width, int height, die_roller_frame d) {
		super(txt);
		this.d = d;
		this.d.add(this);
		setBounds(xpos, ypos, width, height);
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String txt = ((add_button) e.getSource()).getLabel();
		
		if (!d.currDice.getText().equals("%")) {
			String temp = d.currDice.getText().substring(1);
			int x = Integer.parseInt(temp);
			for (int i = 0; i < d.dice_to_roll.length; i++) {
				if (d.dice_to_roll[i].value==x)
				{
					d.dice_to_roll[i].increase(Integer.parseInt(d.currNumber.getText()));
					d.currRollLabels2[i].setText(d.dice_to_roll[i].rolls+"");
				}
				
			}
		}
		else {
			d.dice_to_roll[6].increase(Integer.parseInt(d.currNumber.getText()));
			System.out.println();
			d.currRollLabels2[6].setText(d.dice_to_roll[6].rolls+"");
		}
	}

}

