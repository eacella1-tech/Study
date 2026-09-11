import java.io.File;
import java.util.Scanner;

import it.sauronsoftware.ftp4j.FTPClient;

public class FTPClientReview {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.println("=== FTP Client Program ===");
		System.out.println("1. Connect Server");
		System.out.println("2. Exit Program");
		System.out.print(">> ");
		int menu = Integer.parseInt(sc.nextLine());

		while (true) {
			if (menu == 1) {

				FTPClient client = new FTPClient();
				while (true) {
					System.out.print("서버 IP를 입력하세요 : ");
					String ip = sc.nextLine();

					System.out.print("서버 접속 포트를 입력하세요 : ");
					int port = Integer.parseInt(sc.nextLine());
					System.out.println("서버 접속 시도 중...");

					try {
						client.connect(ip, port);
						System.out.println("접속 성공!");
						break;
					} catch (Exception e) {
						System.out.println("서버에 접속할 수 없습니다.");
						e.printStackTrace();
						continue;
					}
				}

				while (true) {
					System.out.print("ID : ");
					String id = sc.nextLine();

					System.out.print("PW : ");
					String pw = sc.nextLine();
					try {
						client.login(id, pw);
						System.out.println("로그인 성공!");
						break;
					} catch (Exception e) {
						System.out.println("ID 또는 PW를 확인해주세요.");
						e.printStackTrace();
					}
				}

				while (true) {
					System.out.println("1. Upload File");
					System.out.println("2. Download File");
					System.out.println("3. Disconnect");
					System.out.print(">> ");
					menu = Integer.parseInt(sc.nextLine());

					if (menu == 1) {
						while (true) {
							System.out.print("업로드 할 파일 이름 : ");
							String fileName = sc.nextLine();

							try {
								client.upload(new File(fileName));
								break;
							} catch (Exception e) {
								System.out.println("업로드에 실패했습니다.");
								e.printStackTrace();
							}
						}

					} else if (menu == 2) {

						while (true) {
							String[] fileNames = client.listNames();
							for (int i = 0; i < fileNames.length; i++) {
								System.out.println(fileNames[i]);
							}

							System.out.print("다운 받을 파일 이름 입력 : ");
							String target = sc.nextLine();
							try {
								client.download(target, new File(target));
								System.out.println("다운로드 완료");
							} catch (Exception e) {
								System.out.println("파일 다운로드 실패!");
								e.printStackTrace();
							}
						}
					} else if (menu == 3) {
						client.disconnect(true);
						break;
					} else {
						System.out.println("메뉴를 다시 확인해주세요.");
					}
				}

			} else if (menu == 2) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			} else {
				System.out.println("메뉴를 다시 확인해주세요.");

			}
		}
	}
}
