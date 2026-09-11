// * 클래스를 잘 만드는 방법
// 1. 클래스를 구성하는 문법 요소?
// - 멤버 필드, 멤버메서드, 생성자, 중첩클래스
// 2. 클래스르 만들 때, 벤더사의 권고사안 ( "이렇게 클래스를 만드세요" 라는 지침 )
// 3. 정보은닉(public,private) -> Getter/Setter/Constructor -> this
// - 접근제한자 : public, private, protected, package
package classes;


public class Tv {
	private int channel;
	private int volume;
	
	public int getChannel() {
		return channel;
	}
	
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	public int getVolume() {
		return volume;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	
}
