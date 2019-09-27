package com.sti.projectFlames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProjectInterface extends JFrame implements ActionListener{
	
	JButton button = new JButton("Check Relationship");
	JTextField partnerNameTField,yourNameTField;
	JLabel relationship,yourName,partnerName,error;
	JLabel relationshipDisplay,yourNameDisplay,partnerNameDisplay;
	GridBagConstraints c = new GridBagConstraints();
	public ProjectInterface() {
		setLayout(new GridBagLayout());
		
		c.gridx = 0;
		c.gridy = 1;
		c.ipady = 10;
		add(new JLabel("Your Name"),c);
		
		c.gridx = 2;
		add(new JLabel("Partner's Name"),c);
		
		yourNameTField = new JTextField(15);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		add(yourNameTField,c);
		
		partnerNameTField = new JTextField(15);
		c.gridx = 2;
		add(partnerNameTField,c);
		
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(25,10,10,10);
		add(new JLabel("FLAMES") , c);
		
		error = new JLabel("");
		c.gridy = 8;
		add(error, c);
		
		c.gridx = 1;
		c.gridy = 3;
		c.gridheight = 2;
		add(button,c);
		
		yourName = new JLabel();
		c.gridheight = 1;
		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 5;
		add(yourName,c);
		
		partnerName = new JLabel();
		c.gridy = 6;
		add(partnerName,c);
		
		relationship = new JLabel();
		c.gridy = 7;
		add(relationship,c);
		
		yourNameDisplay = new JLabel();
		c.gridx = 0;
		c.gridy = 5;
		add(yourNameDisplay , c);
		
		partnerNameDisplay = new JLabel();
		c.gridy = 6;
		add(partnerNameDisplay , c);
		
		relationshipDisplay = new JLabel();
		c.gridy = 7;
		add(relationshipDisplay , c);
		
		button.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String yourNameString = yourNameTField.getText().trim();
		String partnerNameString = partnerNameTField.getText().trim();
		
		if(yourNameString.length() != 0 && partnerNameString.length() != 0) {
			error.setText("");
			yourNameDisplay.setText("Your Name: ");
			partnerNameDisplay.setText("Partner's Name: ");
			relationshipDisplay.setText("Relationship: ");
			
			variables va = new variables();
			va.compareNames(yourNameString, partnerNameString);
			yourName.setText(va.yourName +" > " + va.yourNameSameChar + " = " + va.yourNameSameChar.length());	
			partnerName.setText(va.partnerName +" > "+ va.partnerNameSameChar + " = " + va.partnerNameSameChar.length());
			relationship.setText((va.yourNameSameChar.length()+va.partnerNameSameChar.length())+ " > "+ va.relationship); 
			
			switch(va.relationship) {
			case "Friends":
				relationship.setForeground(Color.yellow);break;	
			case "Lovers":
				relationship.setForeground(Color.red);break;	
			case "Angry":
				relationship.setForeground(Color.black);break;	
			case "Married":
				relationship.setForeground(Color.blue);break;
			case "Enemy":
				relationship.setForeground(Color.orange);break;	
			case "Sweet":
				relationship.setForeground(Color.pink);break;	
			default:
				relationship.setForeground(Color.black);break;
			}
		} else {
			error.setForeground(Color.red);
			error.setText("Error: No Input");
			yourName.setText("");
			partnerName.setText("");
			relationship.setText("");
			yourNameDisplay.setText("");
			partnerNameDisplay.setText("");
			relationshipDisplay.setText("");
		} 
	}
}
