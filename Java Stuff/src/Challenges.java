import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("unused")
public class Challenges {
	@SuppressWarnings("resource")
	public static void main(String...args)
	{
		Scanner in = new Scanner(System.in);
		
		//RegExp r = new RegExp("\\w+@[a-zA-Z]+(\\.\\w+)+");
		//System.out.println(r.isMatcher(in.nextLine()));
	}
}

class RegExp
{
	Pattern p;
	
	RegExp(String pattern)
	{
		this.p = Pattern.compile(pattern);
	}
	
	public boolean isMatcher(String s)
	{
		Matcher m = p.matcher(s);
		return m.find();
	}
}

class Node
{
	int val;
	Node next;
	Node(){}
	Node(int val){this.val=val;}
	Node(int val, Node next){this.val=val; this.next=next;}
}

class FreqStack {
	Stack<Integer> stack = new Stack<>();
	Map<Integer, Integer> freq = new HashMap<>();
	
    public FreqStack() {
    }
    
    public void push(int val) {
        stack.add(val);
        freq.put(val, freq.get(val)!=null?freq.get(val)+1:1);
        System.out.println(freq);
    }
    
    public int pop() {
        System.out.println(stack);
    	int max = 0, a = 0;
    	for(int i : freq.keySet())
    	{
            System.out.println(a);
    		if(freq.get(i)>=max) {max = freq.get(i); a = i;}
    	}
        freq.put(a, freq.get(a)-1);
    	return stack.remove(stack.lastIndexOf(a));
    }
}

class ExamRoom {
    List<Integer> arr = new ArrayList<>();
    public ExamRoom(int n) {
        
    }
    
    //public int seat() {
        //if(arr.size()==0) {arr.add(0); return 0;}
        //for(int i : arr)
        //{
            
        //}
    //}
    
    public void leave(int p) {
        
    }
}

class OrderedStream {
    String[] arr;
    List<String> ar = new ArrayList<>();
    
    public OrderedStream(int n) {
    	arr = new String[n];
    }
    
    public List<String> insert(int idKey, String value) {
    	arr[idKey] = value;
    	for(int i = idKey-1; i < arr.length; i++)
    	{
    		ar.add(arr[i]);
    	}
    	return ar;
    }
}