import java.util.ArrayList;
import java.util.List;

public class Solution1 {

	public static void main(String[] args) {
		int a = 0;
		for(int i = 1; i <= 150; i++)
		{
			if( (i%3!=0||i%7!=0) ) a+=i;
		}
		System.out.println(a);
	}
	
	public static boolean squareIsWhite(String coordinates) {
		List<Character> arr = new ArrayList<>() {
		private static final long serialVersionUID = 1L;

			{
        		add('a');
        		add('b');
        		add('c');
        		add('d');
        		add('e');
        		add('f');
        		add('g');
        		add('h');
        	}
        };
        return (((arr.indexOf(coordinates.charAt(0))+1)+Integer.parseInt(String.valueOf(coordinates.charAt(1))))%2==1);
    }
	
	public static int f(int m, int n)
	{
		if(n>1) return f(m+2, n-3);
		else return m+1;
	}
	
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
