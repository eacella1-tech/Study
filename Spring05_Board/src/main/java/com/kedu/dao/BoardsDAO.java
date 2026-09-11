package com.kedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.BoardsDTO;

@Repository
public class BoardsDAO {

	@Autowired
	private DataSource dbcp;

	public void insert(BoardsDTO dto) throws Exception {

		String sql = "insert into board (seq, title, contents, writer, view_count, write_date) values(board_seq.nextval, ? , ? , ? , 0, CURRENT_TIMESTAMP)";

		try(Connection con = dbcp.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);) {

			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getContents());
			pstat.setString(3, dto.getWriter());
			pstat.executeUpdate();
		}
	}
	public ArrayList<BoardsDTO> boardlist() throws Exception {

		String sql = "select * from board order by seq desc";

		try(Connection con = dbcp.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			ArrayList<BoardsDTO> list = new ArrayList<>();
			try(ResultSet rs = pstat.executeQuery();){


				while(rs.next()) {
					BoardsDTO dto = new BoardsDTO();

					dto.setSeq(rs.getInt("seq"));
					dto.setTitle(rs.getString("title"));
					dto.setContents(rs.getString("contents"));
					dto.setWriter(rs.getString("writer"));
					dto.setView_count(rs.getInt("view_count"));
					dto.setWrite_date(rs.getTimestamp("write_date"));
					list.add(dto);

				}
				return list;

			}

		}
	}
	
		public void update(BoardsDTO dto) throws Exception {
			
			String sql = "update board set title = ?, contents = ? where seq = ?";
			
			try(Connection con = dbcp.getConnection();
					PreparedStatement pstat = con.prepareStatement(sql);){
				pstat.setString(1, dto.getTitle());
				pstat.setString(2, dto.getContents());
				pstat.setInt(3, dto.getSeq());
				
				pstat.executeUpdate();
			}
		}
		public void delete(int seq) throws Exception {
			
			String sql = "delete from board where seq = ?";
			
			try (Connection con = dbcp.getConnection();
					PreparedStatement pstat = con.prepareStatement(sql);){
				pstat.setInt(1, seq);
				pstat.executeUpdate();
			}
		}
		
		public BoardsDTO detail(int seq) throws Exception {

			String sql = "select * from board where seq = ?";

			try (Connection con = dbcp.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);) {

				pstmt.setInt(1, seq);

				try (ResultSet rs = pstmt.executeQuery()) {
					BoardsDTO dto = new BoardsDTO();
					if (rs.next()) {
						dto.setSeq(rs.getInt("seq"));
						dto.setTitle(rs.getString("title"));
						dto.setWriter(rs.getString("writer"));
						dto.setContents(rs.getString("contents"));
						dto.setWrite_date(rs.getTimestamp("write_date"));
						dto.setView_count(rs.getInt("view_count"));
					}

					return dto;
				}
			}
		}
		public void viewCount(int seq) throws Exception {
			
			String sql = "update board set view_count = view_count + 1 where seq = ?";
			
			try(Connection con = dbcp.getConnection();
					PreparedStatement pstat = con.prepareStatement(sql);){
				
				pstat.setInt(1, seq);
				pstat.executeUpdate();
			}
			
		}
	}
