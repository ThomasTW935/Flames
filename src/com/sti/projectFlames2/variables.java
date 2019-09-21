package com.sti.projectFlames2;

import java.util.ArrayList;

public class variables {
	String firstName;
	String secondName;
	
	public void compareNames(String firstName, String secondName) {
		this.firstName = firstName;
		this.secondName = secondName;
		String shortName = firstName;
		String longName = secondName;
		if(firstName.length()>secondName.length()) {
			shortName = secondName;
			longName = firstName;
		}
		String nameSameChar= "";
		for(int i = 0; i<shortName.length(); i++) {
			String findChar = String.valueOf(shortName.charAt(i));
			if(longName.contains(findChar)) {
				nameSameChar += findChar;
				longName = newLongName(longName, findChar);
			}
		}
		determineRelationship(nameSameChar);	
	}
	
	public String newLongName(String longName, String removeChar) {
		ArrayList<Character> arrayList = new ArrayList<Character>();
		for(char c : longName.toCharArray()) {
			arrayList.add(c);
		}
		arrayList.remove(longName.indexOf(removeChar));
		String newLongName="";
		for(char c : arrayList) {
			newLongName = newLongName + c;
		}
		return newLongName;
	}
	
	public void determineRelationship(String nameSameChar) {
		int nameValue = nameSameChar.length();
		int computeComparison = nameValue*2;
		String relationship="";
		if(nameValue != 0) {
			switch(computeComparison%6) {
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
		System.out.println(relationship);
		System.out.println("First Name: "+firstName + " = "+nameSameChar + " = "+nameValue );
		System.out.println("Second Name: "+secondName + " = "+nameSameChar + " = "+nameValue);
		System.out.println("Relationship: "+ computeComparison + " = "+relationship);
	}
}
