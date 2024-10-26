package com.hi;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String... args) {
		int a = 7;
		List<Integer> arr = new ArrayList<Integer>();
		
		arr.add(3);
		arr.add(4);
		arr.add(7);
		arr.add(5);
		arr.add(6);
		arr.add(2);
		arr.add(1);
		insertionSort2(a, arr);
		
	}
	//private static float root(double root, double num) { return (float) Math.pow(num, (double) 1/root); }
	
	public static void insertionSort2(int n, List<Integer> arr) {
		int tmp = 0;
		for(int i = 0, j = 0; i < n; i++) {
			j=i;
			while(j>0 && arr.get(j)<arr.get(j-1)) {
				tmp = arr.get(j);
				arr.remove(j);
				
				arr.add(j-1, tmp);
				j--;
			}
			
			for(int k : arr) System.out.print(k + " ");
			System.out.println();
		}
	}
	
	public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
		int tmp = arr.get(n-1);
		n-=2;
		while(n>-1) {
			if(arr.get(n)<tmp) break;
			arr.set(n+1, arr.get(n));
			for(int i : arr) System.out.print(i + " ");
			n--;
			System.out.println();
		}
		arr.set(n+1, tmp);
		for(int i : arr) System.out.print(i + " ");
    }
}
