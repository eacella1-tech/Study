package exams;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Exam01 {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "study";
		String password = "study";
		String sql = "insert into movies values(movies_seq.nextval,?,?)";
		Connection con = DriverManager.getConnection(url,user,password);
		PreparedStatement stat = con.prepareStatement(sql);
		stat.setString(1, "범죄도시");
		stat.setString(2, "스릴러");
		int result = stat.executeUpdate();
		
		con.close();
	}
}
