package exams;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Exam02 {
	public static void main(String[] args) throws Exception {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "study";
		String password = "study";
		String sql = "UPDATE movies SET title = ?, genre = ? WHERE id = ?";
		Connection con = DriverManager.getConnection(url,user,password);
		PreparedStatement stat = con.prepareStatement(sql);
		stat.setString(1, "오디세이");
		stat.setString(2, "판타지");
		stat.setInt(3, 1005);
		int result = stat.executeUpdate();
		
		con.close();
	}

}
