package exams;

import java.util.Scanner;

class A {
	
}

class B extends A {
	
}


public class Exam04 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 다형성
		// 상속관계에 묶인 두 클래스 A , B
		// 상위클래스(A) 참조변수가(A a) 하위클래스(B) 인스턴스의 주소를 저장할 수 있는 성질
		
		Object o = new Exam01();
		o = new Scanner(System.in);
		o = 3.14;
		
		
		A a = new B();
		B b = new B();

	}

}
