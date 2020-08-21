package version1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class die_roller_frame extends Frame{
	
	public final int FRAME_WIDTH = 500;
	public final int FRAME_HEIGHT = 600;
	
	public int totalSum = 0;
	
	public String[] diceType = {"4", "6", "8", "10", "12", "20", "00"};
	public String[] numRolls = {"1", "2", "3", "4", "5", "6", "7"};
	public String rollButton = "Roll";
	public String clearButton = "Clear";
	
	Label title = new Label("Mr. Anton's FLAWLESS Dice Roller", Label.CENTER);
	Label diceSelector = new Label("Select Dice Type", Label.CENTER);
	Label currDiceTitle = new Label("Current Dice Type", Label.CENTER);
	Label currDice = new Label("d20", Label.CENTER);
	Label numberOfRolls = new Label("Number of Times", Label.CENTER);
	Label currNumber = new Label("1", Label.CENTER);
	Label selectAmount = new Label("Select # of Rolls", Label.CENTER); 
	Label currentRoll = new Label("Current Full Roll", Label.CENTER);
	Label results = new Label("Roll Results", Label.CENTER);
	Label indyDice = new Label("Individual Dice Rolls", Label.CENTER);
	Label indyAvgs = new Label("Dice Type Sums", Label.CENTER);
	Label totalAmt = new Label("Sum of All", Label.CENTER);
	Label sumLabel = new Label("0", Label.CENTER);
	
	
	
	public Label[] currRollLabels = new Label[diceType.length];
	public Label[] currRollLabels2 = new Label[diceType.length];
	public Label[] resultRolls = new Label[diceType.length];
	public Label[] resultSums = new Label[diceType.length];
			
	public add_button ab = null;
	public clear_button cl = null;
	public roll_button rb = null;
	
	//add button to add current to full roll
	//roll button
	//clear button
	
	
	
	//tracks how many of each dice type needs to be rolled.
	public DiceRoll[] dice_to_roll = new DiceRoll[diceType.length];
	
	public dice_type_button[] dice_type_arr = new dice_type_button[diceType.length];
	public number_button[] num_button_arr = new number_button[numRolls.length];
	
	
	public die_roller_frame(String text) {
		super(text);
		this.setResizable(false);
		for (int i = 0; i < dice_to_roll.length; i++)
			dice_to_roll[i] = new DiceRoll(Integer.parseInt(diceType[i]));
		
		this.setBackground(Color.ORANGE);
		title.setBounds(0, 30, FRAME_WIDTH, 30);
		title.setBackground(Color.BLACK);
		title.setForeground(Color.ORANGE);
		add(title);
		diceSelector.setBounds(10, 70, 100, 30);
		diceSelector.setBackground(Color.BLACK);
		diceSelector.setForeground(Color.ORANGE);
		add(diceSelector);
		currDiceTitle.setBounds(200, 70, 100, 30);
		currDiceTitle.setBackground(Color.BLACK);
		currDiceTitle.setForeground(Color.ORANGE);
		add(currDiceTitle);
		currDice.setBounds(200, 100, 100, 30);
		currDice.setBackground(Color.ORANGE);
		currDice.setForeground(Color.BLACK);
		add(currDice);
		numberOfRolls.setBounds(200, 150, 100, 30);
		numberOfRolls.setBackground(Color.BLACK);
		numberOfRolls.setForeground(Color.ORANGE);
		add(numberOfRolls);
		currNumber.setBounds(200, 180, 100, 30);
		currNumber.setBackground(Color.ORANGE);
		currNumber.setForeground(Color.BLACK);
		add(currNumber);
		selectAmount.setBounds(390, 70, 100, 30);
		selectAmount.setBackground(Color.BLACK);
		selectAmount.setForeground(Color.ORANGE);
		add(selectAmount);
		currentRoll.setBounds(110, 280, 280, 30);
		currentRoll.setBackground(Color.BLACK);
		currentRoll.setForeground(Color.ORANGE);
		add(currentRoll);
		results.setBounds(10, 380, 480, 30);
		results.setBackground(Color.BLACK);
		results.setForeground(Color.ORANGE);
		add(results);
		indyDice.setBounds(10, 410, 250, 30);
		indyDice.setBackground(Color.BLACK);
		indyDice.setForeground(Color.ORANGE);
		add(indyDice);
		indyAvgs.setBounds(260, 410, 125, 30);
		indyAvgs.setBackground(Color.BLACK);
		indyAvgs.setForeground(Color.ORANGE);
		add(indyAvgs);
		totalAmt.setBounds(385, 410, 125, 30);
		totalAmt.setBackground(Color.BLACK);
		totalAmt.setForeground(Color.ORANGE);
		add(totalAmt);
		sumLabel.setBounds(385, 440, 125, 30);
		sumLabel.setBackground(Color.ORANGE);
		sumLabel.setForeground(Color.BLACK);
		add(sumLabel);
		
		int labelX = 110;
		for (int i = 0; i < currRollLabels.length; i++) {
			if (!diceType[i].equals("00"))
				currRollLabels[i] = new Label("d"+diceType[i], Label.CENTER);
			else
				currRollLabels[i] = new Label("%", Label.CENTER);
			currRollLabels[i].setBounds(labelX, 310, 280/7, 30);
			labelX += 280/7;
			currRollLabels[i].setBackground(Color.BLACK);
			currRollLabels[i].setForeground(Color.ORANGE);
			add(currRollLabels[i]);
		}
		
		int labelX2 = 110;
		for (int i = 0; i < currRollLabels2.length; i++) {
			currRollLabels2[i] = new Label(""+0, Label.CENTER);
			currRollLabels2[i].setBounds(labelX2, 340, 280/7, 30);
			labelX2 += 280/7;
			currRollLabels2[i].setBackground(Color.ORANGE);
			currRollLabels2[i].setForeground(Color.BLACK);
			add(currRollLabels2[i]);
		}
		
		int labelY = 440;
		for (int i = 0; i < resultRolls.length; i++) {
			if (!diceType[i].equals("00")) {
				if (Integer.parseInt(diceType[i])<10)
					resultRolls[i] = new Label("  d"+diceType[i]+": ", Label.LEFT);
				else
					resultRolls[i] = new Label("d"+diceType[i]+": ", Label.LEFT);
			}
			else
				resultRolls[i] = new Label("  % : ", Label.LEFT);
			resultRolls[i].setBounds(10, labelY, 250, 20);
			labelY += 20;
			resultRolls[i].setBackground(Color.ORANGE);
			resultRolls[i].setForeground(Color.BLACK);
			add(resultRolls[i]);
		}
		
		int avgY = 440;
		for (int i = 0; i < resultSums.length; i++) {
			resultSums[i] = new Label(""+0, Label.CENTER);
			resultSums[i].setBounds(260, avgY, 125, 20);
			avgY += 20;
			resultSums[i].setBackground(Color.ORANGE);
			resultSums[i].setForeground(Color.BLACK);
			add(resultSums[i]);
		}
		
		int buttonX = 40;
		int tempY = 100;
		int buttonSize = 30;
		
		for (int i = 0; i < dice_type_arr.length; i++) {
			if (!diceType[i].equals("00"))
				dice_type_arr[i] = new dice_type_button("d"+diceType[i], buttonX, tempY, buttonSize, buttonSize, this);
			else
				dice_type_arr[i] = new dice_type_button("%", buttonX, tempY, buttonSize, buttonSize, this);
			tempY += buttonSize+5;
		}
		
		int numButtonX = 420;
		int numTempY = 100;
		int numButtonSize = 30;
		
		for (int i = 0; i < numRolls.length; i++) {
			num_button_arr[i] = new number_button(numRolls[i], numButtonX, numTempY, numButtonSize, numButtonSize, this);
			numTempY += numButtonSize+5;
		}
		
		ab = new add_button("Add", 200, 230, 100, 30, this);
		cl = new clear_button("Clear", 10, 345, 100, 30, this);
		rb = new roll_button("Roll", 390, 345, 100, 30, this);
		
		
		
		addWindowListener(new WindowAdapter()
		{
		public void windowClosing(WindowEvent ev)
		{System.exit(0);}
		});

		setLayout(null);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setVisible(true);
	}
}
