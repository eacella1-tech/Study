package com.kedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.BoardsDTO;
import com.kedu.dto.MembersDTO;
import com.kedu.dto.ReplyDTO;

@Repository
public class ReplyDAO {

	@Autowired
	private DataSource dbcp;

	public void addcomment(ReplyDTO dto) throws Exception {

		String sql = "insert into reply " + "(seq, writer, contents, parent_seq, write_date) "
				+ "values(reply_seq.nextval, ?, ?, ?, CURRENT_TIMESTAMP)";

		try (Connection con = dbcp.getConnection(); 
				PreparedStatement pstat = con.prepareStatement(sql)) {

			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getContents());
			pstat.setInt(3, dto.getParent_seq());

			pstat.executeUpdate();
		}
	}

	public ArrayList<ReplyDTO> selectByParentSeq(int parent_seq) throws Exception {

		String sql = "select * from reply where parent_seq = ? order by seq desc";

		try (Connection con = dbcp.getConnection(); 
				PreparedStatement pstat = con.prepareStatement(sql)) {

			pstat.setInt(1, parent_seq);

			try (ResultSet rs = pstat.executeQuery()) {

				ArrayList<ReplyDTO> list = new ArrayList<>();

				while (rs.next()) {

					ReplyDTO dto = new ReplyDTO();

					dto.setSeq(rs.getInt("seq"));
					dto.setWriter(rs.getString("writer"));
					dto.setContents(rs.getString("contents"));
					dto.setParent_seq(rs.getInt("parent_seq"));
					dto.setWrite_date(rs.getTimestamp("write_date"));

					list.add(dto);
				}

				return list;
			}
		}
	}

	public ReplyDTO selectOne(int seq) throws Exception {

		String sql = "select * from reply where seq = ?";

		try (Connection con = dbcp.getConnection(); 
				PreparedStatement pstat = con.prepareStatement(sql)) {

			pstat.setInt(1, seq);

			try (ResultSet rs = pstat.executeQuery()) {

				if (rs.next()) {

					ReplyDTO dto = new ReplyDTO();

					dto.setSeq(rs.getInt("seq"));
					dto.setWriter(rs.getString("writer"));
					dto.setContents(rs.getString("contents"));
					dto.setParent_seq(rs.getInt("parent_seq"));
					dto.setWrite_date(rs.getTimestamp("write_date"));

					return dto;
				}

				return null;
			}
		}
	}

	public void deletecomment(int seq) throws Exception {

		String sql = "delete from reply where seq = ?";

		try (Connection con = dbcp.getConnection(); 
				PreparedStatement pstat = con.prepareStatement(sql)) {

			pstat.setInt(1, seq);

			pstat.executeUpdate();
		}
	}

	public void updatecomment(ReplyDTO dto) throws Exception {

		String sql = "update reply set contents = ? where seq = ?";

		try (Connection con = dbcp.getConnection(); 
				PreparedStatement pstat = con.prepareStatement(sql)) {

			pstat.setString(1, dto.getContents());
			pstat.setInt(2, dto.getSeq());

			pstat.executeUpdate();
		}
	}
}
