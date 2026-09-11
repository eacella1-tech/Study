package exams;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Exam03 {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "study";
		String password = "study";
		String sql = "delete from movies where genre = ?";
		Connection con = DriverManager.getConnection(url,user,password);
		PreparedStatement stat = con.prepareStatement(sql);
		stat.setString(1, "판타지");
		int result = stat.executeUpdate();
		
		con.close();
	}

}
