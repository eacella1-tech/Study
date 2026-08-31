package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.MusicsDTO;

public class MusicsDAO {

	private Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "study";
		String password = "study";
		Connection con = DriverManager.getConnection(url,user,password);
		return con;
	}

	public int addMusics(MusicsDTO dto) throws Exception {

		String sql = "insert into musics(id,title,singer) values(musics_seq.nextval, ?,?)";

		try(Connection con = this.getConnection();
				PreparedStatement stat = con.prepareStatement(sql);) {
			stat.setString(1, dto.getTitle());
			stat.setString(2, dto.getSinger());
			return stat.executeUpdate();
		}
	}
	public ArrayList<MusicsDTO> selectAll() throws Exception {

		String sql = "select * from musics";

		try(Connection con = this.getConnection();
				PreparedStatement stat = con.prepareStatement(sql);
				ResultSet rs = stat.executeQuery();){
			ArrayList<MusicsDTO> list = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String singer = rs.getString(3);

				MusicsDTO dto = new MusicsDTO(id, title, singer);
				list.add(dto);
			}
			return list;
		}
	}
	public int updateMusics(MusicsDTO dto) throws Exception {
		String sql = "update musics set title = ?, singer = ? where id = ?";

		try(Connection con = this.getConnection();
				PreparedStatement stat = con.prepareStatement(sql);) {
			stat.setString(1, dto.getTitle());
			stat.setString(2, dto.getSinger());
			stat.setInt(3, dto.getId());

			return stat.executeUpdate();
		}
	}
	public int deleteMusics(int id) throws Exception {
		String sql = "delete from musics where id = ?";

		try(Connection con = this.getConnection();
				PreparedStatement stat = con.prepareStatement(sql);) {
			stat.setInt(1, id);
			return stat.executeUpdate();
		}
	}
	public ArrayList<MusicsDTO> searchMusics(String param) throws Exception {
		String sql = "select * from musics where singer = ?";

		try(Connection con = this.getConnection();
				PreparedStatement stat = con.prepareStatement(sql);) {
			stat.setString(1, param);
			try(ResultSet rs = stat.executeQuery();) {
				ArrayList<MusicsDTO> list = new ArrayList<>();
				while(rs.next()) {
					int id = rs.getInt(1);
					String title = rs.getString(2);
					String singer = rs.getString(3);
					
					MusicsDTO dto = new MusicsDTO(id, title , singer);
					list.add(dto);
				}
				return list;
			}
		}
	}
	public boolean isIdExist(int id) throws Exception {
		String sql = "select * from musics where id = ?";
		
		try(Connection con = this.getConnection();
				PreparedStatement stat = con.prepareStatement(sql);) {
			stat.setInt(1, id);
			
			try(ResultSet rs = stat.executeQuery()) {
				return rs.next();
			}
		}
	}
}
//	ArrayList<MusicsDTO> musics = new ArrayList<>();
//	
//	public void addMusic(MusicsDTO dto) {
//		musics.add(dto);
//	}
//	public ArrayList<MusicsDTO> getMusic() {
//		return this.musics;
//		
//	}
//	
//	public boolean isIdExist(int id) {
//		for(MusicsDTO m : musics) {
//			if(m.getId() == id) {
//				return true;
//			}
//		}
//		return false;
//	}
//	public void updateMusic(MusicsDTO dto) {
//		for(MusicsDTO m : musics) {
//			if(m.getId() == dto.getId()) {
//				m.setTitle(dto.getTitle());
//				m.setSinger(dto.getSinger());
//				m.setReg_date(dto.getReg_date());
//				break;
//			}
//		}
//		
//	}
//	public void deleteMusic(int id) {
//		for(int i = 0; i < musics.size(); i++) {
//			if(musics.get(i).getId() == id) {
//				musics.remove(i);
//				break;
//			}
//		}
//	}
//}
