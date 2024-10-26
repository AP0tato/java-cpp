package com.hi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mountains {
	private static Calc c = new Calc();
	private static int p;
	
	public static void main(String...args) {
		Scanner in = new Scanner(System.in);
		System.out.println(dyckPath(in.nextInt()));
		in.close();
	}
	
	public static int fact(int n) {
		if(n<2) return n;
		else return n*fact(n-1);
	}
	
	public static int catalan(int n) {
		return ( (fact(2*n)) / ( fact(n+1)*fact(n) ) );
	}
	
	private static List<String> dyckPath(int n) {
		List<String> arr = new ArrayList<>();
		if(n<=0) { arr.add("*"); return arr; }
		p = catalan(n);
		String s = "";
		
		for(int j = 0; j < n; j++) { s+="+1-1"; }
		arr.add(s);
		
		p-=1;
		
		arr = p1(arr, s, n);
		p-=(n-1);
		
		return arr;
	}
	
	private static List<String> p1(List<String> arr, String s, int n, int p, List<int[]> flipped) {
		char[] ar;
		int[] a1;
		String[] arr1;
		
		while(p>0) {
			ar = arr.get(0).toCharArray();
			a1 = new int[2];
			
			arr1 = new String[n-1];
			n -= 1;
			
			
			
			p -= 1;
		}
		
		return arr;
	}
	
	private static List<String> p1(List<String> arr, String s, int n) {
		char[] ar;
		List<int[]> flipped = new ArrayList<>();
		int[] a1;

		for(int i = 0; i < n-1; i++) {
			a1 = new int[2];
			ar = arr.get(0).toCharArray();
			
			if(flipped.size()>0) {
				/*
				 * arr = p1(arr, s, n, p, flipped);
				 * return arr;
				 */
				
				//First layer of flipping
				int min = Math.min(flipped.get(flipped.size()-1)[0], flipped.get(flipped.size()-1)[1])+4;
				int max = Math.max(flipped.get(flipped.size()-1)[0], flipped.get(flipped.size()-1)[1])+4;
				
				flip(ar, min);
				flip(ar, max);
				
				a1[0]=min;
				a1[1]=max;
				
				flipped.add(a1);
			} 
			else {
				flip(ar, 2);
				flip(ar, 4);
				
				a1[0]=2;
				a1[1]=4;
					
				flipped.add(a1);
			}
			if(c.parse(toStr(ar))==0) arr.add(toStr(ar));
		}
		
		return arr;
	}
	
	private static char[] flip(char[] ar, int i) {
		if(ar[i]=='+') ar[i]='-';
		else ar[i]='+';
		return ar;
	}
	
	private static String toStr(char[] arr) {
		String s = "";
		for(char i : arr) {
			s += i;
		}
		return s;
	}
}
