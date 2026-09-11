package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

import dto.StudentsDTO;

public class StudentsDAO {

	public Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "study";
		String password = "study";
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}

	public int addStudents(StudentsDTO dto) throws Exception {

		String sql = "insert into students (id, name, kor, eng, math) values(students_seq.nextval, ?, ? , ? , ?)";

		try (Connection con = this.getConnection(); PreparedStatement stat = con.prepareStatement(sql);) {
			stat.setString(1, dto.getName());
			stat.setInt(2, dto.getKor());
			stat.setInt(3, dto.getEng());
			stat.setInt(4, dto.getMath());
			return stat.executeUpdate();
		}
	}
	public ArrayList<StudentsDTO> selectAll() throws Exception {
		String sql = "select * from students";

		try(Connection con = this.getConnection(); PreparedStatement stat = con.prepareStatement(sql); ResultSet rs = stat.executeQuery();) {
			ArrayList<StudentsDTO> list = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int kor = rs.getInt(3);
				int eng = rs.getInt(4);
				int math = rs.getInt(5);

				StudentsDTO dto = new StudentsDTO(id, name, kor, eng, math);
				list.add(dto);
			}
			return list;
		}
	}
	public int updateStudents(StudentsDTO dto) throws Exception {
		String sql = "update students set name = ?, kor = ? , eng = ? , math = ? where id = ?";

		try(Connection con = this.getConnection(); PreparedStatement stat = con.prepareStatement(sql);) {
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
		
		try(Connection con = this.getConnection(); PreparedStatement stat = con.prepareStatement(sql);) {
			stat.setInt(1, id);
			return stat.executeUpdate();
		}
	}
	public ArrayList<StudentsDTO> searchStudents(int param) throws Exception {
		String sql = "select * from students where id = ?";
		
		try(Connection con = this.getConnection(); PreparedStatement stat = con.prepareStatement(sql);) {
			stat.setInt(1, param);
			try(ResultSet rs = stat.executeQuery();) {
				ArrayList<StudentsDTO> list = new ArrayList<>();
				while(rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					int kor = rs.getInt(3);
					int eng = rs.getInt(4);
					int math = rs.getInt(5);
					
					StudentsDTO dto = new StudentsDTO(id, name, kor, eng, math);
					list.add(dto);
				}
				return list;
			}
		}
	}
	public boolean isIdExist(int id) throws Exception {
		String sql = "select * from students where id = ?";
		
		try(Connection con = this.getConnection(); PreparedStatement stat = con.prepareStatement(sql);) {
			stat.setInt(1, id);
			try(ResultSet rs = stat.executeQuery();) {
				return rs.next();
			}
			
		}
		
	}
}

//
//	ArrayList<StudentDTO> students = new ArrayList<>();
//
//	public void addStudents(StudentDTO dto) {
//		students.add(dto);
//
//	}
//
//	public ArrayList<StudentDTO> getStudents() {
//		return this.students;
//	}
//
//	public boolean isIdExist(int id) {
//		for (StudentDTO s : students) {
//			if (s.getId() == id) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	public void updateStudents(StudentDTO dto) {
//		for (StudentDTO s : students) {
//			if (s.getId() == dto.getId()) {
//				s.setKor(dto.getKor());
//				s.setEng(dto.getEng());
//				s.setMath(dto.getMath());
//				s.setRegdate(dto.getRegdate());
//				break;
//			}
//
//		}
//
//	}
//
//	public void deleteStudents(int id) {
//		for (int i = 0; i < students.size(); i++) {
//			if (students.get(i).getId() == id) {
//				students.remove(i);
//				break;
//			}
//		}
//	}
//
//	public ArrayList<StudentDTO> getSearchStudents(String name) {
//
//		ArrayList<StudentDTO> result = new ArrayList<>();
//
//		for (StudentDTO s : students) {
//			if (s.getName().contains(name)) {
//				result.add(s);
//			}
//		}
//		return result;
//	}
//}
