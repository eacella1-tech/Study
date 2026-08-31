package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.MoviesDTO;

public class MoviesDAO {

	private Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "study";
		String password = "study";
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}

	public int addMovies(MoviesDTO dto) throws Exception {

		String sql = "insert into movies(id,title,genre) values(movies_seq.nextval,?,?)";

		try (Connection con = this.getConnection(); 
				PreparedStatement stat = con.prepareStatement(sql);) {
			stat.setString(1, dto.getTitle());
			stat.setString(2, dto.getGenre());
			return stat.executeUpdate();
		}

	}

	public ArrayList<MoviesDTO> selectAll() throws Exception {
		String sql = "select * from movies";
		try(Connection con = this.getConnection();
				PreparedStatement stat = con.prepareStatement(sql);
				ResultSet rs = stat.executeQuery();){
			ArrayList<MoviesDTO> list = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String genre = rs.getString(3);

				MoviesDTO dto = new MoviesDTO(id, title, genre);
				list.add(dto);
			}
			return list;
		}
	}

	public int updateMovies(MoviesDTO dto) throws Exception {

		String sql = "update movies set title = ? , genre = ? where id = ?";

		try (Connection con = this.getConnection(); 
				PreparedStatement stat = con.prepareStatement(sql);) {
			stat.setString(1, dto.getTitle());
			stat.setString(2, dto.getGenre());
			stat.setInt(3, dto.getId());
			return stat.executeUpdate();
		}
	}

	public int deleteMovies(int id) throws Exception {

		String sql = "delete from movies where id = ?";

		try (Connection con = this.getConnection(); 
				PreparedStatement stat = con.prepareStatement(sql);) {
			stat.setInt(1, id);
			return stat.executeUpdate();
		}
	}
	public ArrayList<MoviesDTO> searchMovies(String param) throws Exception {

		String sql = "select * from movies where title = ?";

		try(Connection con = this.getConnection();
				PreparedStatement stat = con.prepareStatement(sql);) {
			stat.setString(1, param);
			try(ResultSet rs = stat.executeQuery();) {
				ArrayList<MoviesDTO> list = new ArrayList<>();
				while(rs.next()) {
					int id = rs.getInt(1);
					String title = rs.getString(2);
					String genre = rs.getString(3);

					MoviesDTO dto = new MoviesDTO(id,title,genre);
					list.add(dto);
				}
				return list;
			}
		}
	}
}


//public class MovieDAO {
//	// CRUD 수정
//	
//	private ArrayList<MovieDTO> movies = new ArrayList<>();
//	
//	public void addMovie(MovieDTO dto) {
//		movies.add(dto);
//	}
//	public ArrayList<MovieDTO> getMovies() {
//		return this.movies;
//		
//	}
//	
//	public boolean isIdExist(int id) {
//		for(MovieDTO m : movies) {
//			if(m.getId() == id) {
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	public void updateMovie(MovieDTO dto) {
//		for(MovieDTO m : movies) {
//			if(m.getId() == dto.getId()) {
//				
//				m.setTitle(dto.getTitle());
//				m.setGenre(dto.getGenre());
//				break;
//			}
//		}
//	}
//	 public void deleteMovie(int id) {
//		 for(int i = 0; i < movies.size(); i++) {
//			 if(movies.get(i).getId() == id) {
//				 
//				 movies.remove(i);
//				 break;
//			 }
//		 }
//	 }
//
//}
