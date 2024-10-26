public class Solution {
    public static void main(String[] args) {
    	int[][] arr = {
    			{1, 1, 0, 0, 0}, 
    			{1, 1, 1, 1, 0},
    			{1, 0, 0, 0, 0},
    			{1, 1, 0, 0, 0},
    			{1, 1, 1, 1, 1}};
    	kWeakestRows(arr, 3);
    }
    
    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] arr = new int[k], ar = new int[mat.length], a = new int[mat.length];
        int count = 0;
        
        for(int i = 0; i < mat.length; i++)
        {
        	count = 0;
        	for(int j : mat[i])
        	{
        		if(j==1) count++;
        	}
        	ar[i] = count;
        	a[i] = i;
        }
        
        for(int i = 0; i < k; i++)
        {
        }

		return arr;
    }
}