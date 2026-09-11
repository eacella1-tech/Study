package classes;

public class Person {

	private String name;
	private String contact;
	private int age;

	// 생성자 메서드에 규칙
	// 1. 메서드 이름은 클래스 이름과 동일해야만 한다.
	// 2. 생성자 메서드는 Return Data Type을 가지지 않는다.
	// 3. 생성자 메서드는 호출 시점이 고정되어 있다. ( 인스턴스가 생성되는 시점에 자동 호출 )
	// 4. 그 외 규칙은 모두 일반메서드와 동일하다. ( 매개변수 또는 오버로딩 등 ... )
	// 생성자는 인스턴스의 초기값을 세팅하는 용도로 사용한다.

	public Person() {}
	public Person(String name, String contact, int age) {
		this.name = name;
		this.contact = contact;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
