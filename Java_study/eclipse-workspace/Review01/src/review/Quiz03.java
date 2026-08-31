package review;

public class Quiz03 {
	
//	public static int[] makeArray(int a, int b, int c, int d, int e) {
//		
//		int[] arr = new int[] {a,b,c,d,e};
//		return arr;
//	}
	
	public static int[] makeArray(int... param) {
		return param;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = makeArray(1, 2, 3, 4, 5);
		System.out.println(arr[0]); // 1
		System.out.println(arr[4]); // 5 
		
	}
}
