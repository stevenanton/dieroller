package version1;

import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class roll_button extends Button implements ActionListener{

	public die_roller_frame d;
	
	public roll_button(String txt, int xpos, int ypos, int width, int height, die_roller_frame d) {
		super(txt);
		this.d = d;
		this.d.add(this);
		setBounds(xpos, ypos, width, height);
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String txt = ((roll_button) e.getSource()).getLabel();
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
		
		for (int i = 0; i < d.dice_to_roll.length; i++) {
			int indyTot = 0;
			while (d.dice_to_roll[i].rolls>0) {
				int rand = (int)(Math.random()*d.dice_to_roll[i].value)+1;
				d.dice_to_roll[i].rolls--;
				d.resultRolls[i].setText(d.resultRolls[i].getText() + rand + "  ");
				d.totalSum+=rand;
				indyTot += rand;
			}
			d.resultSums[i].setText(""+indyTot);
		}
		for (int i = 0; i < d.currRollLabels2.length; i++) {
			d.dice_to_roll[i] = new DiceRoll(Integer.parseInt(d.diceType[i]));
			d.currRollLabels2[i].setText(d.dice_to_roll[i].rolls+"");
						
		}
		
		d.sumLabel.setText(""+d.totalSum);
		

		
	}

}

