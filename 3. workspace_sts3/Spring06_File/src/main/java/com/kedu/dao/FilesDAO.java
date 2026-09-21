package com.kedu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kedu.dto.FilesDTO;

@Repository
public class FilesDAO {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public int insert(FilesDTO dto) {
		
		String sql = "insert into files values(files_seq.nextval, ? , ? , sysdate, 0)";
		return jdbc.update(sql, dto.getOriname(), dto.getSysname());
		
	}
	public List<FilesDTO> selectAll() {
		String sql = "select * from files";
		
		return jdbc.query(sql, new BeanPropertyRowMapper<>(FilesDTO.class));
	}
}
