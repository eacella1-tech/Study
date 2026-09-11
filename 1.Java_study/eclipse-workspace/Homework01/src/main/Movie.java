package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.MoviesDAO;
import dto.MoviesDTO;

public class Movie {
	public static void main(String[] args) {

		MoviesDAO dao = new MoviesDAO();
		Scanner sc = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("<< Netflix 영화 관리 시스템 >>");
				System.out.println("1. 신규 영화 등록");
				System.out.println("2. 영화 목록 출력");
				System.out.println("3. 영화 정보 수정");
				System.out.println("4. 영화 정보 삭제");
				System.out.println("5. 영화 검색(제목으로 검색)");
				System.out.println("0. 종료");
				System.out.print("메뉴를 선택하세요:");
				String menu = sc.nextLine();

				if (menu.equals("1")) {

					System.out.print("등록할 영화 제목을 입력하세요: ");
					String title = sc.nextLine();

					System.out.print("장르를 입력하세요: ");
					String genre = sc.nextLine();

					MoviesDTO dto = new MoviesDTO(0, title, genre);
					dao.addMovies(dto);

					System.out.println();
					System.out.println("'" + title + "' 영화가 등록되었습니다. ");
				} else if (menu.equals("2")) {

					ArrayList<MoviesDTO> movies = dao.selectAll();

					System.out.println("\n------- 영화 목록 -------");
					for (MoviesDTO movie : movies) {
						System.out.println(" | " + movie.getId() + " | " + movie.getTitle() + " - " + movie.getGenre());
					}
					if (movies.size() == 0) {
						System.out.println("등록되어 있는 영화가 없습니다.");
					}

				} else if (menu.equals("3")) {
					int id = 0;

					System.out.print("\n수정 할 영화의 ID:");
					id = Integer.parseInt(sc.nextLine());

					System.out.print("수정할 영화의 제목:");
					String title = sc.nextLine();

					System.out.print("수정할 영화의 장르:");
					String genre = sc.nextLine();

					MoviesDTO dto = new MoviesDTO(id, title, genre);
					dao.updateMovies(dto);
					System.out.println("수정이 완료되었습니다.");

				} else if (menu.equals("4")) {
					int id = 0;

					System.out.print("삭제하실 영화의 ID를 입력해주세요:");
					id = Integer.parseInt(sc.nextLine());
					dao.deleteMovies(id);
					System.out.print("삭제가 완료되었습니다.");

				} else if (menu.equals("5")) {
					System.out.print("검색하실 영화의 제목을 입력해주세요:");
					String searchTitle = sc.nextLine();
					ArrayList<MoviesDTO> title = dao.searchMovies(searchTitle);
					
					for(MoviesDTO m : title) {
						System.out.println(" | " + m.getId() + " | " + m.getTitle() + " - " + m.getGenre());
					}
					dao.searchMovies(searchTitle);
					
				} else if (menu.equals("0")) {
					System.out.println("\n프로그램을 종료합니다.");
					System.exit(0);
				} else {
					System.out.println("\n메뉴를 다시 확인해주세요.");
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