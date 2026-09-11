package quizs;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		while (true) {
			try {

				System.out.print("날짜를 입력하세요 (예: 2025년 12월 02일):");
				String day = sc.nextLine();

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
				Date date = sdf.parse(day);

				SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");
				String input = dayFormat.format(date);

				System.out.println(day + "은(는) " + input + "입니다.");
				break;

			} catch (Exception e) {
				System.out.println("잘못된 형식입니다.");
			}

		}
	}
}
