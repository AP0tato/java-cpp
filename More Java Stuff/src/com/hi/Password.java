package com.hi;

public class Password {
	
	private final String letters = "abcdefghijklmnopqrstuvwxyz";
	private final String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final String numbers = "1234567890";
	private String characters = "@?-_";
	
	public String createPassword(int min, int max, String characters) {
		this.characters = characters;
		return createPassword(min, max);
	}
	
	public String getChars() { return this.characters; }
	
	public String createPassword(int min, int max) {
		String p = "";
		
		int t = (int) Math.floor( (Math.random()*max+1) );
		
		while(t<min) { t += Math.floor( Math.random()*(max-t) ); }
		
		for(int i = 0; i < t; i++) {
			int temp;
			
			if(characters!="") temp = (int) Math.floor( Math.random()*4 );
			else temp = (int) Math.floor( Math.random()*3 );
			
			int temp1;
			
			switch(temp) {
				case 0:
					temp1 = (int) Math.floor( Math.random()*(letters.length()) );
					p += letters.charAt(temp1);
					break;
					
				case 1:
					temp1 = (int) Math.floor( Math.random()*(upperLetters.length()) );
					p += upperLetters.charAt(temp1);
					break;
					
				case 2:
					temp1 = (int) Math.floor( Math.random()*(numbers.length()) );
					p += numbers.charAt(temp1); 
					break;
					
				case 3:
					temp1 = (int) Math.floor( Math.random()*(characters.length()) );
					p += characters.charAt(temp1);
					break;
					
				default:
					break;
			}
		}
		
		return p;
	}
}
