package com.kedu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kedu.dto.MembersDTO;

@Repository
public class MembersDAO {

	@Autowired
	private JdbcTemplate jdbc;

	public int insert(MembersDTO dto) {
		String sql = "insert into members(id, pw, name, phone, email, zipcode, address1, address2, regdate) values(?, ? ,? ,? ,? ,? ,? ,? , CURRENT_TIMESTAMP)";
		return jdbc.update(sql, dto.getId(), dto.getPw(), dto.getName(), dto.getPhone(), dto.getEmail(), dto.getZipcode(), dto.getAddress1(), dto.getAddress2());
	}

	public MembersDTO selectOne(String id) {
		String sql = "select * from members where id = ?";
		try {
			return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(MembersDTO.class), id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public int update(MembersDTO dto) {
		String sql = "update members set name = ?, phone = ?, email = ?, zipcode = ?, address1 = ?, address2 = ? where id = ?";
		return jdbc.update(sql, dto.getName(), dto.getPhone(), dto.getEmail(), dto.getZipcode(), dto.getAddress1(), dto.getAddress2(),dto.getId());
	}

	public boolean IdCheck(String id) {
		String sql = "select count(*) from members where id = ?";
		return jdbc.queryForObject(sql, Integer.class, id) > 0;

	}

	public boolean login(String id, String pw) {
		String sql = "select count(*) from members where id = ? and pw = ?";
		return jdbc.queryForObject(sql, Integer.class, id, pw) > 0;
	}

	public int withdraw(String id) {
		String sql = "delete from members where id = ?";
		return jdbc.update(sql, id);
	}
}

//	@Autowired
//	private DataSource dbcp;
//
//	public void insert(MembersDTO dto) throws Exception {
//
//		String sql = "insert into members(id, pw, name, phone, email, zipcode, address1, address2, regdate) values(?, ? ,? ,? ,? ,? ,? ,? , CURRENT_TIMESTAMP)";
//
//		try (Connection con = dbcp.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
//
//			pstat.setString(1, dto.getId());
//			pstat.setString(2, dto.getPw());
//			pstat.setString(3, dto.getName());
//			pstat.setString(4, dto.getPhone());
//			pstat.setString(5, dto.getEmail());
//			pstat.setString(6, dto.getZipcode());
//			pstat.setString(7, dto.getAddress1());
//			pstat.setString(8, dto.getAddress2());
//			pstat.executeUpdate();
//		}
//	}
//
//	public MembersDTO selectOne(String id) throws Exception {
//
//		String sql = "select * from members where id = ?";
//		
//		try (Connection con = dbcp.getConnection();
//				PreparedStatement pstat = con.prepareStatement(sql)) {
//			pstat.setString(1, id);
//			try (ResultSet rs = pstat.executeQuery()) {
//				if (rs.next()) {
//					MembersDTO dto = new MembersDTO();
//
//					dto.setId(rs.getString("id"));
//					dto.setPw(rs.getString("pw"));
//					dto.setName(rs.getString("name"));
//					dto.setPhone(rs.getString("phone"));
//					dto.setEmail(rs.getString("email"));
//					dto.setZipcode(rs.getString("zipcode"));
//					dto.setAddress1(rs.getString("address1"));
//					dto.setAddress2(rs.getString("address2"));
//					dto.setRegdate(rs.getTimestamp("regdate"));
//
//					return dto;
//				}
//
//				return null;
//			}
//		}
//	}
//	public void update(MembersDTO dto) throws Exception {
//		
//		String sql = "update members set name = ?, phone = ?, email = ?, zipcode = ?, address1 = ?, address2 = ? where id = ?";
//		
//		try (Connection con = dbcp.getConnection();
//				PreparedStatement pstat = con.prepareStatement(sql);) {
//			pstat.setString(1, dto.getName());
//			pstat.setString(2, dto.getPhone());
//			pstat.setString(3, dto.getEmail());
//			pstat.setString(4, dto.getZipcode());
//			pstat.setString(5, dto.getAddress1());
//			pstat.setString(6, dto.getAddress2());
//			pstat.setString(7, dto.getId());
//			
//			pstat.executeUpdate();
//		}
//	
//	}
//
//	public boolean idCheck(String id) throws Exception {
//
//		String sql = "select count(*) from members where id = ?";
//
//		try (Connection con = dbcp.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
//			pstat.setString(1, id);
//			try (ResultSet rs = pstat.executeQuery()) {
//				rs.next();
//				return rs.getInt(1) > 0;
//			}
//		}
//	}
//
//	public boolean login(String id, String pw) throws Exception {
//		String sql = "select * from members where id = ? and pw = ?";
//
//		try (Connection con = dbcp.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
//			pstat.setString(1, id);
//			pstat.setString(2, pw);
//			try (ResultSet rs = pstat.executeQuery();) {
//				return rs.next();
//			}
//		}
//
//	}
//
//	public void withdraw(String id) throws Exception {
//		String sql = "delete from members where id = ?";
//
//		try (Connection con = dbcp.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
//			pstat.setString(1, id);
//			pstat.executeUpdate();
//		}
//	}
//}
