package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.StudentsDAO;
import dto.StudentsDTO;

public class Student {

	public static void main(String[] args) {

		StudentsDAO dao = new StudentsDAO();
		Scanner sc = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("\n=== 학생 관리 시스템 ===");
				System.out.println("1. 학생 등록");
				System.out.println("2. 전체 조회");
				System.out.println("3. 학생 검색");
				System.out.println("4. 성적 수정");
				System.out.println("5. 정보 삭제");
				System.out.println("0. 종료");
				System.out.print("메뉴를 선택해주세요: ");

				String menu = sc.nextLine();

				// 1. 학생 등록
				if (menu.equals("1")) {

					try {
						System.out.print("등록하실 학생의 이름: ");
						String name = sc.nextLine();

						System.out.print("학생의 국어 점수: ");
						int kor = Integer.parseInt(sc.nextLine());

						System.out.print("학생의 영어 점수: ");
						int eng = Integer.parseInt(sc.nextLine());

						System.out.print("학생의 수학 점수: ");
						int math = Integer.parseInt(sc.nextLine());

						StudentsDTO dto = new StudentsDTO(0, name, kor, eng, math);

						dao.addStudents(dto);

						System.out.println("'" + name + "'이(가) 등록되었습니다.");

					} catch (NumberFormatException e) {

						System.out.println("번호와 점수는 숫자로 입력해주세요.");

					} catch (Exception e) {
						System.out.println("학생 등록 중 오류가 발생했습니다.");
					}

				} else if (menu.equals("2")) {

					try {
						ArrayList<StudentsDTO> student = dao.selectAll();
						System.out.println("\n--- 학생관리부 ---");
						System.out.println("ID\t이름\t국어점수\t영어점수\t수학점수\t합계\t평균");

						if (student.size() == 0) {
							System.out.println("등록된 학생이 없습니다.");

						} else {
							for (StudentsDTO s : student) {
								int sum = s.getKor() + s.getEng() + s.getMath();
								double avg = (double) sum / 3;
								String avgStr = String.format("%.2f", avg);

								System.out.println(s.getId() + "\t" + s.getName() + "\t" + s.getKor() + "점\t"
										+ s.getEng() + "점\t" + s.getMath() + "점\t" + sum + "점\t" + avgStr + "점");
							}
						}

					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("학생 조회 중 오류가 발생했습니다.");
					}

				} else if (menu.equals("3")) {

					try {
						System.out.print("검색하실 학생의 번호을 입력해주세요: ");
						int id = Integer.parseInt(sc.nextLine());

						ArrayList<StudentsDTO> result = dao.searchStudents(id);

						if (result.size() == 0) {

							System.out.println("검색된 학생이 없습니다.");

						} else {
							for (StudentsDTO s : result) {
								int sum = s.getKor() + s.getEng() + s.getMath();
								double avg = (double) sum / 3;
								String avgStr = String.format("%.2f", avg);

								System.out.println(s.getId() + "\t" + s.getKor() + "점\t" + s.getEng() + "점\t"
										+ s.getMath() + "점\t" + sum + "점\t" + avgStr + "점");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("학생 검색 중 오류가 발생했습니다.");
					}
				} else if (menu.equals("4")) {

					while (true) {
						int id = 0;

						try {
							System.out.print("수정하실 학생의 번호를 입력해주세요: ");
							id = Integer.parseInt(sc.nextLine());

							if (!dao.isIdExist(id)) {

								System.out.println("등록되지 않은 학생입니다.");
								continue;
							}
							System.out.println("수정하실 학생의 이름:");
							String name = sc.nextLine();

							System.out.print("수정하실 학생의 국어 점수: ");
							int kor = Integer.parseInt(sc.nextLine());

							System.out.print("수정하실 학생의 영어 점수: ");
							int eng = Integer.parseInt(sc.nextLine());

							System.out.print("수정하실 학생의 수학 점수: ");
							int math = Integer.parseInt(sc.nextLine());

							StudentsDTO dto = new StudentsDTO(id, name, kor, eng, math);

							dao.updateStudents(dto);

							System.out.println("수정이 정상적으로 완료되었습니다.");

							break;

						} catch (NumberFormatException e) {
							System.out.println("번호와 점수는 숫자로 입력해주세요.");
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("학생 정보 수정 중 오류가 발생했습니다.");
							break;
						}
					}

				} else if (menu.equals("5")) {
					while (true) {
						try {
							System.out.print("삭제할 학생의 번호를 입력해주세요: ");
							int id = Integer.parseInt(sc.nextLine());

							if (!dao.isIdExist(id)) {
								System.out.println("등록되지 않은 학생입니다.");
								continue;
							}

							dao.deleteStudents(id);
							System.out.println("삭제가 완료되었습니다.");
							break;
							
						} catch (NumberFormatException e) {
							System.out.println("학생 번호는 숫자로 입력해주세요.");
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("학생 삭제 중 오류가 발생했습니다.");
							break;
						}
					}
				} else if (menu.equals("0")) {
					System.out.println("프로그램을 종료하겠습니다.");
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