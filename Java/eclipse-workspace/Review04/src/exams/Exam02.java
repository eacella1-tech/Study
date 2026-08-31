package exams;

public class Exam02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] arr = new String[5];
		
		arr[0] = "Hello";
		arr[1] = "World";
		arr[2] = "Java";
	
		System.out.println(arr.length); //배열 크기
		
		arr[0] = arr[1];
		arr[1] = arr[2];
		arr[2] = null;
		
		
		arr[2] = arr[1];
		arr[1] = "Kedu";
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
	}

}
