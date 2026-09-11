import java.io.File;
import java.util.Scanner;

import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPFile;

public class Exam04 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		FTPClient ftp = new FTPClient();

		try {

			System.out.println("=== FTP Client Program ===");
			System.out.println();
			System.out.println("1. Connect FTP server");
			System.out.println("2. Exit Program");
			System.out.println();

			System.out.print(">>> ");
			int menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) {

				System.out.println("서버 IP를 입력하세요 : ");
				System.out.print(">>> ");
				String ip = sc.nextLine();

				System.out.println("서버 접속 포트를 입력하세요 : ");
				System.out.print(">>> ");
				int port = Integer.parseInt(sc.nextLine());

				System.out.println("Try to connect : "+ ip + "(port : "+ port+ ")");

				ftp.connect(ip, port);

				System.out.println("FTP Server is connected!");

				System.out.print("input id : ");
				System.out.print(">>> ");
				String id = sc.nextLine();

				System.out.print("input password : ");
				System.out.print(">>> ");
				String password = sc.nextLine();

				ftp.login(id, password);

				System.out.println("Login Success");

				while (true) {

					System.out.println();
					System.out.println("1. Upload File");
					System.out.println("2. Download File");
					System.out.println("3. Disconnect FTP server");
					System.out.println();

					System.out.print(">>> ");
					int select = Integer.parseInt(sc.nextLine());

					if (select == 1) {

						System.out.println("업로드할 파일명을 입력하세요");

						System.out.print(">>> ");
						String path = sc.nextLine();

						File file = new File(path);

						ftp.upload(file);

						System.out.println("Upload Complete!");
					}

					else if (select == 2) {

						System.out.println("Current Directory : /");
						FTPFile[] files =ftp.list();

						for (FTPFile file : files) {
							System.out.println(file.getName()+ "        "+ file.getSize()+ "Byte");}

						System.out.println("다운받을 파일을 입력하세요");

						System.out.print(">>> ");
						String fileName =sc.nextLine();

						System.out.println("다운받을 경로와 새로운 파일명을 입력하세요");
						System.out.print(">>> ");
						String path =sc.nextLine();
						File file =new File(path);

						ftp.download(fileName,file);
						System.out.println("Download Complete!");
					}
					else if (select == 3) {
						ftp.disconnect(true);
						System.out.println("FTP Server disconnected!");
						break;
					}
				}
			}
			else if (menu == 2) {
				System.out.println("Exit Program");
			}
		} catch (Exception e) {
			System.out.println("오류 : " + e.getMessage());
		} finally {

			sc.close();
		}
	}
}