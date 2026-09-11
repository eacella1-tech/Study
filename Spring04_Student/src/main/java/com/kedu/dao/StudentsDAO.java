package com.kedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.StudentsDTO;

@Repository
public class StudentsDAO {

	@Autowired
	private DataSource dbcp;

	public void insert(StudentsDTO dto) throws Exception {

		String sql = "insert into students(id, name, kor, eng, math) values(students_seq.nextval, ? , ? , ? , ?)";

		try(Connection con = dbcp.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){

			pstat.setString(1, dto.getName());
			pstat.setInt(2, dto.getKor());
			pstat.setInt(3,  dto.getEng());
			pstat.setInt(4, dto.getMath());
			pstat.executeUpdate();

		}
	}
	public ArrayList<StudentsDTO> selectAll() throws Exception {

		String sql = "select * from students";

		try(Connection con = dbcp.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();) {
			ArrayList<StudentsDTO> list = new ArrayList<>();

			while(rs.next()) {
				StudentsDTO dto = new StudentsDTO();

				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMath(rs.getInt("math"));

				list.add(dto);
			}
			return list;

		}
	}
	public int updateStudents(StudentsDTO dto) throws Exception {
		String sql = "update students set name = ?, kor = ? , eng = ? , math = ? where id = ?";

		try(Connection con = dbcp.getConnection(); 
				PreparedStatement stat = con.prepareStatement(sql);) {
			stat.setString(1, dto.getName());
			stat.setInt(2, dto.getKor());
			stat.setInt(3, dto.getEng());
			stat.setInt(4, dto.getMath());
			stat.setInt(5, dto.getId());
			return stat.executeUpdate();
		}
	}
	public int deleteStudents(int id) throws Exception {
		String sql = "delete from students where id = ?";

		try(Connection con = dbcp.getConnection(); 
				PreparedStatement stat = con.prepareStatement(sql);) {
			stat.setInt(1, id);
			return stat.executeUpdate();
		}
	}
	public ArrayList<StudentsDTO> searchStudents(String param) throws Exception {

		String sql = "select * from students where name like ?";

		try(Connection con = dbcp.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql)) {

			pstat.setString(1, "%" + param + "%");

			ResultSet rs = pstat.executeQuery();

			ArrayList<StudentsDTO> list = new ArrayList<>();

			while(rs.next()) {

				StudentsDTO dto = new StudentsDTO();

				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMath(rs.getInt("math"));

				list.add(dto);
			}

			return list;
		}
	}


}


