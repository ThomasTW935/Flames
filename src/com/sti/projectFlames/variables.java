package com.sti.projectFlames;

public class variables {
	String yourName;
	String partnerName;
	String relationship="";
	String yourNameSameChar;
	String partnerNameSameChar;
	boolean firstIsLessThanSecond = true;
	public void compareNames(String yourName, String partnerName) {
		this.yourName = yourName;
		this.partnerName = partnerName;
		String shortName = yourName.toLowerCase();
		String longName = partnerName.toLowerCase();
		if(yourName.length()>partnerName.length()) {
			shortName = partnerName;
			longName = yourName;
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
		
		if(firstIsLessThanSecond) {
			yourNameSameChar = shortNameChar;
			partnerNameSameChar = longNameChar;
		} else {
			yourNameSameChar = longNameChar;
			partnerNameSameChar = shortNameChar;
		}
	}
}
