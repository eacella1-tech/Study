package exams;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Exam01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
//		long time = System.currentTimeMillis();
//		System.out.println(time);
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("YYYY년 MM월 dd일(E) hh:mm:ss");
//		String fomattedTime = sdf.format(time);
//		
//		System.out.println(fomattedTime);
		
		String fTime = "1997년 04월 02일";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		Date date = sdf.parse(fTime);
		System.out.println(date.getTime());
		
		String time = sdf.format(date);
		
		System.out.println(time);	
		


	}

}
