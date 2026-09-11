package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.MusicsDAO;
import dto.MusicsDTO;

public class Melon {
	public static void main(String[] args) {

		MusicsDAO dao = new MusicsDAO();
		Scanner sc = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("<< Melon Music 관리 시스템 >>");
				System.out.println("1. 신규 음악 등록");
				System.out.println("2. 음악 목록 출력");
				System.out.println("3. 음악 정보 수정");
				System.out.println("4. 음악 정보 삭제");
				System.out.println("5. 음악 검색(가수명으로 검색)");
				System.out.println("0. 종료");
				System.out.print("메뉴를 선택해주세요>> ");
				String menu = sc.nextLine();

				if (menu.equals("1")) {
					System.out.print("신규 음악 제목을 입력하세요 : ");
					String title = sc.nextLine();

					System.out.print("신규 음악 가수를 입력하세요 : ");
					String singer = sc.nextLine();

					MusicsDTO dto = new MusicsDTO(0, title, singer);
					dao.addMusics(dto);

					System.out.println("'" + title + "'이(가) 등록되었습니다.");

				} else if (menu.equals("2")) {
					ArrayList<MusicsDTO> music = dao.selectAll();
					System.out.println("ID\tTitle\tSinger");
					for (MusicsDTO m : music) {
						System.out.println(m.getId() + "\t" + m.getTitle() + "\t" + m.getSinger());
					}
					if (music.size() == 0) {
						System.out.println("등록하신 음악이 없습니다.");
					}

				} else if (menu.equals("3")) {
					int target = 0;

					while (true) {
						try {
							System.out.print("수정할 음악 ID를 입력하세요 : ");
							target = Integer.parseInt(sc.nextLine());
						} catch (NumberFormatException e) {
							System.out.println("ID는 숫자로 입력해주세요.");
							continue;
						}
						if (!dao.isIdExist(target)) {
							System.out.println("존재하지 않는 ID입니다.");
							break;
						}

						System.out.print("수정하실 음악 제목을 입력하세요 :");
						String title = sc.nextLine();

						System.out.print("수정하실 음악 가수를 입력하세요 :");
						String singer = sc.nextLine();

						// System.out.print("수정하실 날짜를 입력해주세요(예:2012년 08월 15일) :");
						// String reg_date = sc.nextLine();

						MusicsDTO dto = new MusicsDTO(target, title, singer);
						dao.updateMusics(dto);

						System.out.println("수정이 완료되었습니다.");
						break;
					}

				} else if (menu.equals("4")) {

					int id = 0;

					while (true) {
						try {
							System.out.print("삭제하실 음악의 ID를 입력해주세요: ");
							id = Integer.parseInt(sc.nextLine());
						} catch (NumberFormatException e) {
							System.out.println("ID는 숫자로 입력해주세요.");
							continue;
							
						}
						if (!dao.isIdExist(id)) {
							System.out.println("존재하지 않는 ID입니다.");
							continue;
						}

						dao.deleteMusics(id);
						System.out.println("삭제가 완료되었습니다.");
						break;
					}
				} else if (menu.equals("5")) {
					System.out.print("검색하실 음악의 제목을 입력하세요 :");
					String searchTitle = sc.nextLine();

					ArrayList<MusicsDTO> title = dao.searchMusics(searchTitle);
					for (MusicsDTO m : title) {
						System.out.println(m.getId() + "\t" + m.getTitle() + "\t" + m.getSinger());
					}
				} else if (menu.equals("0")) {
					System.out.println("시스템을 종료합니다.");
					System.exit(0);
				} else {
					System.out.println("메뉴를 다시 확인해주세요.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("요청하신 기능을 수행하는 중 오류가 발생했습니다.");
				System.out.println("같은 오류가 반복되면 관리자에게 문의해주세요.");
				System.out.println("email : admin@merong.com");
			}
		}
	}
}