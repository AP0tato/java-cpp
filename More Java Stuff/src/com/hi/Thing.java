package com.hi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Thing {
	public static void main(String...args) {
		Runtime r = new Runtime();
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		r.start();
		
		List<Integer> arr = factorize(n);
		int[] ar = mathThing1(arr, n);
		
		System.out.println(ar[0] + ", " + ar[1]);
		System.out.println("Runtime: "+r.stop()+"ms");
		
		in.close();
	}
	
	private static int[] mathThing1(List<Integer> arr, int n) {
		int[] ar = {0, 0};
		for(int i : arr) {
			int temp;
			for(int j = i+1; j < arr.size(); j++) {
				temp = arr.get(j);
				if(isInt(Math.sqrt( (i*i) + (temp*temp) )) && i*temp==n) {
					ar[0]=i;
					ar[1]=temp;
					return ar;
				}
			}
		}
		return ar;
	}
	
	private static boolean isInt(double a) {
		return a-Math.floor(a)==0?true:false;
	}
	
	private static List<Integer> factorize(int n) {
		List<Integer> arr = new ArrayList<>();
		
		for(int i = 1; i <= n/2; i++) {
			if(n%i==0) arr.add(i);
		}
		arr.add(n);
		
		return arr;
	}
}
