package com.sti.projectFlames2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;

import java.awt.*;

public class project extends JFrame{
	
	public void UserInterface() {
		Container con = this.getContentPane();
		
		JLabel title = new JLabel("FLAMES");
		con.add(title);
	}
	public static void main(String[]args) {
		variables va = new variables();
		Scanner s = new Scanner(System.in);
		//System.out.println("First Name <space> Second Name");
		//va.compareNames(s.next(),s.next());
		
		JFrame ui = new JFrame("FLAMES");
		ui.setBounds(500,100,500,500);
		ui.setVisible(true);
	}
}
