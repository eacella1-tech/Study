package com.kedu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kedu.dto.GameDTO;

@Repository
public class GameDAO {

    @Autowired
    private JdbcTemplate jdbc;

    public int insertGame(GameDTO dto) {

        String sql = "insert into games values(games_seq.nextval,?,?,?,?)";

        return jdbc.update(sql,
                dto.getRegdate(),
                dto.getTime(),
                dto.getHome(),
                dto.getAway());
    }
}
