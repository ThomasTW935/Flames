package com.sti.projectFlames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProjectInterface extends JFrame implements ActionListener{
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public int screenWidth = screenSize.width;
	public int screenHeight = screenSize.height;
	public int windowSize = 500;
	
	JButton button = new JButton("Check Relationship");
	JTextField partnerName,yourName;
	JLabel relationship,firstName,secondName;
	public ProjectInterface() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 1;
		c.ipady = 10;
		add(new JLabel("Your Name"),c);
		
		c.gridx = 2;
		add(new JLabel("Partner's Name"),c);
		
		yourName = new JTextField(15);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		add(yourName,c);
		
		partnerName = new JTextField(15);
		c.gridx = 2;
		add(partnerName,c);
		
		c.anchor = GridBagConstraints.PAGE_START;
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(25,10,10,10);
		add(new JLabel("FLAMES") , c);
		
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 3;
		c.gridheight = 2;
		add(button,c);
		
		firstName = new JLabel("First Name");
		c.gridheight = 1;
		c.gridy = 5;
		add(firstName,c);
		
		secondName = new JLabel("Second Name");
		c.gridy = 6;
		add(secondName,c);
		
		relationship = new JLabel("Relationship");
		c.gridy = 7;
		add(relationship,c);
		
		button.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String yourNameString = yourName.getText();
		String partnerNameString = partnerName.getText();
		variables va = new variables();
		va.compareNames(yourNameString, partnerNameString);
		firstName.setText("First Name: " +va.firstName +" > " + va.firstNameSameChar + " = " + va.firstNameSameChar.length());	
		secondName.setText("Second Name: " +va.secondName +" > "+ va.secondNameSameChar + " = " + va.secondNameSameChar.length());
		relationship.setText("Result = " +( va.firstNameSameChar.length()+va.secondNameSameChar.length())+ " > "+ va.relationship); 
		switch(va.relationship) {
		case "Friends":
			relationship.setForeground(Color.yellow);break;	
		case "Lovers":
			relationship.setForeground(Color.red);break;	
		case "Angry":
			relationship.setForeground(Color.black);break;	
		case "Marriage":
			relationship.setForeground(Color.blue);break;
		case "Enemy":
			relationship.setForeground(Color.orange);break;	
		case "Sweet":
			relationship.setForeground(Color.pink);break;	
		}
	}
	
}
