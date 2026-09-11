package exams;

import classes.Car;
import classes.Person;
import classes.Tv;

public class Main {
	public static void main(String[] args) {

		Tv tv1 = new Tv();
		tv1.setChannel(30);
		System.out.println(tv1.getChannel());

		Tv tv2 = new Tv();
		tv2.setVolume(50);
		System.out.println(tv2.getVolume());

		tv1.setVolume(100);
		System.out.println(tv1.getVolume());
		System.out.println(tv1.getVolume() + tv2.getVolume());
		
		System.out.println("=====================================================================");
		Person person1 = new Person("김인혁", "010-0000-0000", 27);
		System.out.println(person1.getName() + " : " + person1.getContact() + " : " + person1.getAge());
		Person person2 = new Person("한재영", "010-1111-1111", 26);
		System.out.println(person2.getName() + " : " + person2.getContact() + " : " + person2.getAge());
		
		
	}

}
