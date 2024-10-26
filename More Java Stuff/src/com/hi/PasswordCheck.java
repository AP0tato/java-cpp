package com.hi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheck {
	
	private Password pc = new Password();
	
	private String pw;
	private Pattern p = Pattern.compile("([a-zA-Z0-9]("+pc.getChars()+")?){8,}");
	private Matcher m;
	
	public PasswordCheck(String pw) {
		this.pw = pw;
	}
	
	public PasswordCheck(String pw, String reqs) {
		this.pw = pw;
		p = Pattern.compile(reqs);
	}
	
	public boolean isAllowed() {
		m = p.matcher(this.pw);
		return m.matches();
	}
	
}
