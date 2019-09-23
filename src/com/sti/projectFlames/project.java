package com.sti.projectFlames;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Scanner;

import javax.swing.WindowConstants;

public class project{
	
	public static void main(String[]args) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int windowSize = 500;
	    ProjectInterface pi = new ProjectInterface();
	    int windowMarginX = (screenWidth/2) - (windowSize/2);
		int windowMarginY = (screenHeight/2) - (windowSize/2);
		pi.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    pi.setBounds(windowMarginX, windowMarginY , windowSize, windowSize);
	    pi.setResizable(false);
	    pi.setVisible(true);
	}
}
