package com.kedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.MoviesDTO;

@Repository
public class MoviesDAO {

	@Autowired
	private DataSource dbcp;

	public void insert(MoviesDTO dto) throws Exception {

		String sql = "insert into movies(id,title,genre) values(movies_seq.nextval,?,?)";

		try (Connection con = dbcp.getConnection();
				PreparedStatement stat = con.prepareStatement(sql);) {

			stat.setString(1, dto.getTitle());
			stat.setString(2, dto.getGenre());

			stat.executeUpdate();

		}
	}
	public ArrayList<MoviesDTO> selectAll() throws Exception {

		String sql = "select * from movies";

		try (Connection con = dbcp.getConnection();
				PreparedStatement stat = con.prepareStatement(sql);
				ResultSet rs = stat.executeQuery();){

			ArrayList<MoviesDTO> list = new ArrayList<>();

			while (rs.next()) {
				MoviesDTO dto = new MoviesDTO();
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setGenre(rs.getString("genre"));
				list.add(dto);

			}
			return list;
		}	

	}
	public int deleteMovies(int id) throws Exception {

		String sql = "delete from movies where id = ?";

		try (Connection con = dbcp.getConnection();
				PreparedStatement stat = con.prepareStatement(sql);) {
			stat.setInt(1, id);
			return stat.executeUpdate();
		}

	}
	public int updateMovies(MoviesDTO dto) throws Exception {

		String sql = "update movies set title = ? , genre = ? where id = ?";

		try (Connection con = dbcp.getConnection();
				PreparedStatement stat = con.prepareStatement(sql);){
			stat.setString(1, dto.getTitle());
			stat.setString(2, dto.getGenre());
			stat.setInt(3, dto.getId());
			return stat.executeUpdate();
		}

	}
}


