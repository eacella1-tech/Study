package exams;

import classes.Car;

public class Exam01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car car1 = new Car("80년식 티코", 300000);
		Car car2 = new Car("96년식 다마스", 500000);
		Car car3 = new Car("12년식 그렌져", 700000);

		System.out.println(car1.getModel() + " : " + car1.getPrice() + "원");
		System.out.println(car2.getModel() + " : " + car2.getPrice() + "원");
		System.out.println(car3.getModel() + " : " + car3.getPrice() + "원");
		System.out.println("=======================");

		// 배열로 바꾸고 for문 돌려서 출력
		Car[] cars = new Car[] { 
				new Car("Genesis", 50000), 
				new Car("Sonata", 40000), 
				new Car("Benz", 100000)
			};

		for (int i = 0; i < 3; i++) {
			System.out.println(cars[i].getModel() + " : " + cars[i].getPrice() + "원");
		}
	}
}
