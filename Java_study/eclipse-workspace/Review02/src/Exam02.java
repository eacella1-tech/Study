import java.awt.Robot;

public class Exam02 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Robot r = new Robot();
		
		
		for(int i = 0; i < 100; i++) {
			r.mouseMove(200+i, 300);
			r.delay(50);
		}
	}
}
	
