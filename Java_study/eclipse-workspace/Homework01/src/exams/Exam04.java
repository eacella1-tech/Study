package exams;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Exam04 {
	public static void main(String[] args) throws Exception {

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "study";
		String pass = "study";

		String sql = "select * from movies";

		Connection con = DriverManager.getConnection(url, user, pass);
		PreparedStatement pstat = con.prepareStatement(sql);

		ResultSet rs = pstat.executeQuery();

		while (rs.next()) {

			int id = rs.getInt("id");
			String title = rs.getString("title");
			String genre = rs.getString("genre");
			System.out.println(id + " : " + title + " : " + genre);
		}

		con.close();
	}

}
