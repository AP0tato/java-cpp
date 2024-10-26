import java.util.Arrays;

public class MergeSort{
	static int[] b = {}, b1 = {};
	
	public static void main(String...args) {
		int[] arr = {213, -214, 41253, 424, 412, -142};
		System.out.println(Arrays.toString(arr));
		arr = sort(arr);
		//System.out.println(Arrays.toString(arr));
	}
	
	private static int[] sort(int[] arr) {
		if(arr.length>2) return split(arr);
		else if(arr.length<=1) return arr;
		else {
			if(arr[0]>arr[1]) {
				int temp = arr[1];
				arr[1] = arr[0];
				arr[0] = temp;
				return arr;
			} else return arr;
		}
	}
	
	private static int[] split(int[] arr)  {
		final int HALF = arr.length/2;
		final int HALF_1 = arr.length%2==0?HALF:HALF+1;
		
		Thread t1 = new Thread() {
			public void run() {
				int[] a = new int[HALF];
				
				for(int i = 0; i < HALF; i++) a[i] = arr[i];
				
				a = sort(a);
				
				System.out.println("A: "+Arrays.toString(a));
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				int[] a = new int[HALF_1];
				
				for(int i = HALF; i < arr.length; i++) a[i-HALF] = arr[i];
				
				a = sort(a);
				
				System.out.println("B: "+Arrays.toString(a));
			}
		};
		
		t1.start();
		t2.start();
		
		return null;
	}
}
