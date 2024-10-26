package main;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Wordle {
	private final static String PATH = "/Users/Ali/eclipse-workspace/Wordle?/src/Words.txt";
	private static List<String> words = new ArrayList<>();
	private static FileReader r;
	
	public Wordle() throws IOException {
		Thread t = new Thread() {
			public void run() {
				try {
					loadWords();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		t.start();
	}
	
	public void start() throws InterruptedException {
		int rnd = (int) (Math.random()*words.size());
		final String WORD = words.get(rnd); 
		int guesses = 6;
		String input = "_____";
		
		Scanner in = new Scanner(System.in);
		
		while(guesses>0) {
			print(WORD, input);
			
			System.out.print("Enter Guess: ");
			input = in.nextLine();
			
			if(input.length()!=5) {
				System.out.println(("Not a 5 letter word\n"));
				input = "_____";
				guesses++;
			}
			
			if(input.equals(WORD)) {
				print(WORD, input);
				break;
			}
			
			guesses--;
		}
		
		String opt;
		System.out.println("The word was "+WORD+"\nDo you want to play again?"+Color.BRIGHT_GREEN+" Y"+Color.DEFAULT+"/"+Color.BRIGHT_RED+"N"+Color.DEFAULT);
		opt = in.nextLine();
		
		if(opt.toLowerCase().equals("y")) start();
		else in.close();
		
	}
	
	private static void print(String w, String s) throws InterruptedException {
		List<Character> word = new ArrayList<Character>();
		for(char i : w.toCharArray()) word.add(i);
		
		List<Character> c = new ArrayList<Character>();
		for(char i : s.toCharArray()) c.add(i);
		
		HashMap<Character, Integer> count = new HashMap<>();
		for(char i : word) count.put(i, occurences(word, i));
		
		int j = 0;
		
		System.out.print("[ ");
		for(char i : c) {
			Thread.sleep(100);
			if(c.get(j)==word.get(j)) System.out.print(Color.GREEN+i+Color.DEFAULT+" ");
			else if(word.contains(i)&&(count.get(i)>0)) {
				count.put(i, count.get(i)-1);
				System.out.print(Color.BRIGHT_YELLOW+i+Color.DEFAULT+" ");
			}
			else System.out.print(i+" ");
			j++;
		}
		System.out.println("]\n");
	}
	
	private static int occurences(List<Character> w, char c) {
		int count = 0;
		for(char i : w) if(i==c) count++;;
		return count;
	}
	
	private static void loadWords() throws IOException {
		r = new FileReader(PATH);
		r.ready();
		int i;
		String s = "";
		
		while((i=r.read())!=-1) {
			if(i==10) {
				words.add(s);
				s="";
			} else s+=(char)i;
		}
		r.close();
	}
	
	public void addWords(String s) {
		if(s.length()==5) {
			try {
				BufferedWriter br = new BufferedWriter(
						new FileWriter(PATH, true));
				br.write(s.toLowerCase()+"\n");
				br.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(s.length()!=0) System.out.println("Word is to big or too small. Must be 5 letters long");
	}
}
