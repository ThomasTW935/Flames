package com.sti.projectFlames;

import java.awt.Dimension;
import java.util.Scanner;

import javax.swing.WindowConstants;

public class project{
	
	public static void main(String[]args) {
		//variables va = new variables();
		//Scanner s = new Scanner(System.in);
		//System.out.println("First Name <space> Second Name");
		//va.compareNames(s.next(),s.next());
	    ProjectInterface pi = new ProjectInterface();
	    int windowMarginX = (pi.screenWidth/2) - (pi.windowSize/2);
		int windowMarginY = (pi.screenHeight/2) - (pi.windowSize/2);
		pi.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    pi.setBounds(windowMarginX, windowMarginY , pi.windowSize, pi.windowSize);
	    pi.setResizable(false);
	    pi.setVisible(true);
	}
}
