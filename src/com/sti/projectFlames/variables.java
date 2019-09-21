package com.sti.projectFlames;

import java.util.ArrayList;

public class variables {
	String firstName;
	String secondName;
	String relationship="";
	String firstNameSameChar;
	String secondNameSameChar;
	boolean firstIsLessThanSecond = true;
	public void compareNames(String firstName, String secondName) {
		this.firstName = firstName;
		this.secondName = secondName;
		String shortName = firstName.toLowerCase();
		String longName = secondName.toLowerCase();
		if(firstName.length()>secondName.length()) {
			shortName = secondName;
			longName = firstName;
			this.firstIsLessThanSecond = false;
		}
		String shortNameSameChar= "";
		String longNameSameChar = "";
		boolean noSameChar = false;
		int index = 0;
		while(!noSameChar) {
			if(index == shortName.length()) {
				noSameChar = true;
				break;
			}
			String findChar = String.valueOf(shortName.charAt(index));
			if(longName.contains(findChar)) {
				shortNameSameChar += SeperateSameChar(shortName,findChar);
				longNameSameChar += SeperateSameChar(longName,findChar);
				shortName = shortName.replace(findChar, "");
				longName = longName.replace(findChar, "");
				index = 0;
			} else {
				index++;
			}
			
		}
		
		determineRelationship(shortNameSameChar, longNameSameChar);	
	}
	
	public String SeperateSameChar(String name, String findChar) {
		String sameChar="";
		for(int i = 0; i<name.length(); i++) {
			if(String.valueOf(name.charAt(i)).equals(findChar)) {
				sameChar += findChar;
			}
		}
		return sameChar;
	}
	
	public void determineRelationship(String shortNameChar, String longNameChar) {
		int shortNameValue = shortNameChar.length();
		int longNameValue = longNameChar.length();
		int totalValue = (shortNameValue+longNameValue);
		
		if(shortNameValue != 0) {
			switch(totalValue%6) {
				case 1: relationship = "Friends";break;
				case 2: relationship = "Lovers";break;
				case 3: relationship = "Angry";break;
				case 4: relationship = "Married";break;
				case 5: relationship = "Enemy";break;
				case 0: relationship = "Sweet";break;
			}
		} else {
			relationship = "You're not compatible!";
		}
		System.out.println("FLAMES");
		if(firstIsLessThanSecond) {
			System.out.println("First Name: "+firstName + " = "+shortNameChar + " = "+shortNameValue );
			System.out.println("Second Name: "+secondName + " = "+longNameChar + " = "+longNameValue);
			firstNameSameChar = shortNameChar;
			secondNameSameChar = longNameChar;
		} else {
			System.out.println("First Name: "+firstName + " = "+longNameChar + " = "+longNameValue );
			System.out.println("Second Name: "+secondName + " = "+shortNameChar + " = "+shortNameValue);
			firstNameSameChar = longNameChar;
			secondNameSameChar = shortNameChar;
		}
		System.out.println("Relationship: "+ totalValue + " = "+relationship);
	}
}
