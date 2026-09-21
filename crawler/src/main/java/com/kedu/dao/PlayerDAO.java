package com.kedu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kedu.dto.PlayerDTO;

@Repository
public class PlayerDAO {

    @Autowired
    private JdbcTemplate jdbc;

    public int insertPlayer(PlayerDTO dto) {

        String sql =
                "INSERT INTO players ("
                + "seq, player_name, team_name, ranking, batting_avg, "
                + "games, plate_appearances, at_bats, runs, hits, "
                + "doubles, triples, home_runs, total_bases, rbi, "
                + "stolen_bases, caught_stealing, walks, hit_by_pitch, "
                + "strikeouts, grounded_into_double_play, sacrifice_bunts, "
                + "sacrifice_flies, slugging_pct, on_base_pct, ops"
                + ") VALUES ("
                + "players_seq.nextval, "
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?"
                + ")";

        return jdbc.update(sql,
                dto.getPlayerName(),
                dto.getTeamName(),
                dto.getRanking(),
                dto.getBattingAvg(),
                dto.getGames(),
                dto.getPlateAppearances(),
                dto.getAtBats(),
                dto.getRuns(),
                dto.getHits(),
                dto.getDoubles(),
                dto.getTriples(),
                dto.getHomeRuns(),
                dto.getTotalBases(),
                dto.getRbi(),
                dto.getStolenBases(),
                dto.getCaughtStealing(),
                dto.getWalks(),
                dto.getHitByPitch(),
                dto.getStrikeouts(),
                dto.getGroundedIntoDoublePlay(),
                dto.getSacrificeBunts(),
                dto.getSacrificeFlies(),
                dto.getSluggingPct(),
                dto.getOnBasePct(),
                dto.getOps()
        );
    }
}