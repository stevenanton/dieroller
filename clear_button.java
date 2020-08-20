package version1;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clear_button extends Button implements ActionListener{

	public die_roller_frame d;

	public clear_button(String txt, int xpos, int ypos, int width, int height, die_roller_frame d) {
		super(txt);
		this.d = d;
		this.d.add(this);
		setBounds(xpos, ypos, width, height);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String txt = ((clear_button) e.getSource()).getLabel();

		for (int i = 0; i < d.currRollLabels2.length; i++) {
			d.dice_to_roll[i] = new DiceRoll(Integer.parseInt(d.diceType[i]));
			d.currRollLabels2[i].setText(d.dice_to_roll[i].rolls+"");
						
		}
		d.totalSum = 0;
		//clear result labels from before
		for (int i = 0; i < d.resultRolls.length; i++) {
			if (!d.diceType[i].equals("00")) {
				if (Integer.parseInt(d.diceType[i])<10)
					d.resultRolls[i].setText("  d"+d.diceType[i]+": ");
				else
					d.resultRolls[i].setText("d"+d.diceType[i]+": ");
			}
			else
				d.resultRolls[i].setText("  % : ");
		}
		
		for (int i = 0; i < d.resultSums.length; i++) {
			d.resultSums[i].setText(""+0);
		}
		d.sumLabel.setText(""+d.totalSum);
	}
}


