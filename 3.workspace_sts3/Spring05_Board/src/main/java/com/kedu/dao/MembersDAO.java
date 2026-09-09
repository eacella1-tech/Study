package com.kedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.MembersDTO;

@Repository
public class MembersDAO {

	@Autowired
	private DataSource dbcp;

	public void insert(MembersDTO dto) throws Exception {

		String sql = "insert into members(id, pw, name, phone, email, zipcode, address1, address2, regdate) values(?, ? ,? ,? ,? ,? ,? ,? , CURRENT_TIMESTAMP)";

		try (Connection con = dbcp.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {

			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getPhone());
			pstat.setString(5, dto.getEmail());
			pstat.setString(6, dto.getZipcode());
			pstat.setString(7, dto.getAddress1());
			pstat.setString(8, dto.getAddress2());
			pstat.executeUpdate();
		}
	}

	public boolean idCheck(String id) throws Exception {

		String sql = "select count(*) from members where id = ?";

		try (Connection con = dbcp.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setString(1, id);
			try (ResultSet rs = pstat.executeQuery()) {
				rs.next();
				return rs.getInt(1) > 0;
			}
		}
	}
	public boolean login(String id, String pw) throws Exception {
		String sql = "select * from members where id = ? and pw = ?";
		
		try (Connection con = dbcp.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, id);
			pstat.setString(2, pw);
			try(ResultSet rs = pstat.executeQuery();){
				return rs.next();
			}
		}
		
	}
	public void withdraw(String id) throws Exception {
		String sql = "delete from members where id = ?";
		
		try(Connection con = dbcp.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, id);
			pstat.executeUpdate();
		}
	}
}
