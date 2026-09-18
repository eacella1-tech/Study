package com.kedu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kedu.dto.FilesDTO;
import com.kedu.dto.ReplyDTO;

@Repository
public class FilesDAO {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public int insert(FilesDTO dto) {
	    String sql = "insert into files values(files_seq.nextval, ?, ?, sysdate, ?)";

	    return jdbc.update(sql,
	            dto.getOriname(),
	            dto.getSysname(),
	            dto.getParent_seq()
	    );
	}
	public List<FilesDTO> selectByParentSeq(int Parent_seq) {
		String sql = "select * from files where parent_seq = ? order by seq desc";
		
		return jdbc.query(sql, new BeanPropertyRowMapper<>(FilesDTO.class), Parent_seq);
	}
}
