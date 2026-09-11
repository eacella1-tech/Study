package exams;

import java.util.ArrayList;

public class Exam03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList arr = new ArrayList();
		arr.add("Hello");
		arr.add("World");
		arr.add("Java");
		
		System.out.println(arr.size()); // 데이터 개수

		arr.remove(0);
		
		arr.add(1, "Kedu");
		
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		
		
		
	}

}
