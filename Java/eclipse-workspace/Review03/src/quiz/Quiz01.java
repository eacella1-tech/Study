package quiz;

import java.util.Scanner;

import classes.Car;

public class Quiz01 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int count = 0;
		Car[] cars = new Car[3];
		
		while (true) {
			System.out.println(" ==== 자동차 관리 시스템 (CR - 배열 버전) ====");
			System.out.println("1. 신규 입력 (Create)");
			System.out.println("2. 자동차 목록 (CRED)");
			System.out.println("3. 종료");
			System.out.println("======================================");
			System.out.print("메뉴를 선택하세요 : ");
			String menu = sc.nextLine();

			if (menu.equals("1")) {
				if (count < 3) {
					System.out.print("모델명을 입력하세요: ");
					String model = sc.nextLine();
					

					System.out.print("가격(달러)을 입력하세요: ");
					int price = Integer.parseInt(sc.nextLine());
					
					cars[count] = new Car(model, price);
					System.out.println("=>" + "'" + model + "'" + "정보가 등록되었습니다. " + "(현재" + count + "/3개)");
					count++;
					
				} else {
					System.out.println("최대 개수를 초과했습니다.");
					continue;
				}

			} else if (menu.equals("2")) {
				System.out.println("---- 자동차 목록 ----");
				for (int i = 0; i < count; i++) {
					System.out.println((i + 1) + "." + cars[i].getModel() + " : " + cars[i].getPrice());
				}

			} else {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}

		}
	}
}
