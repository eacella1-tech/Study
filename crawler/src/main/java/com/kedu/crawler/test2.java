package com.kedu.crawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kedu.dao.PlayerDAO;
import com.kedu.dto.PlayerDTO;

public class test2 {

    public static void main(String[] args) throws Exception {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("root-context.xml");

        PlayerDAO dao = context.getBean(PlayerDAO.class);

        String url = "\r\n"
        		+ "https://api-gw.sports.naver.com/statistics/categories/kbo/seasons/2026/players?teamCode=LT&sortField=hitterHra&sortDirection=desc&playerType=HITTER&gameType=REGULAR_SEASON";

        URL requestUrl = new URL(url);

        HttpURLConnection con =
                (HttpURLConnection) requestUrl.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Accept", "application/json");

        int responseCode = con.getResponseCode();

        System.out.println("응답 코드 : " + responseCode);

        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        con.getInputStream(),
                        "UTF-8"
                )
        );

        String line;
        StringBuilder result = new StringBuilder();

        while ((line = br.readLine()) != null) {
            result.append(line);
        }

        br.close();
        con.disconnect();

        ObjectMapper mapper = new ObjectMapper();

        JsonNode root =
                mapper.readTree(result.toString());

        System.out.println("================================");
        System.out.println("JSON 파싱 완료");
        System.out.println("================================");

        List<JsonNode> players = new ArrayList<>();

        findPlayers(root, players);

        System.out.println("찾은 선수 수 : " + players.size());

        int count = 0;

        for (JsonNode player : players) {

            PlayerDTO dto = new PlayerDTO();

            dto.setPlayerName(
                    player.path("playerName").asText()
            );

            dto.setTeamName(
                    player.path("teamName").asText()
            );

            dto.setRanking(
                    player.path("ranking").asInt()
            );

            dto.setBattingAvg(
                    player.path("hitterHra").asDouble()
            );

            dto.setGames(
                    player.path("hitterGameCount").asInt()
            );

            dto.setAtBats(
                    player.path("hitterAb").asInt()
            );

            dto.setRuns(
                    player.path("hitterRun").asInt()
            );

            dto.setHits(
                    player.path("hitterHit").asInt()
            );

            dto.setDoubles(
                    player.path("hitterH2").asInt()
            );

            dto.setTriples(
                    player.path("hitterH3").asInt()
            );

            dto.setHomeRuns(
                    player.path("hitterHr").asInt()
            );

            dto.setTotalBases(0);

            dto.setRbi(
                    player.path("hitterRbi").asInt()
            );

            dto.setStolenBases(
                    player.path("hitterSb").asInt()
            );

            dto.setCaughtStealing(0);

            dto.setWalks(
                    player.path("hitterBb").asInt()
            );

            dto.setHitByPitch(
                    player.path("hitterHp").asInt()
            );

            dto.setStrikeouts(
                    player.path("hitterKk").asInt()
            );

            dto.setGroundedIntoDoublePlay(0);

            dto.setSacrificeBunts(0);

            dto.setSacrificeFlies(0);

            dto.setSluggingPct(
                    player.path("hitterSlg").asDouble()
            );

            dto.setOnBasePct(
                    player.path("hitterObp").asDouble()
            );

            dto.setOps(
                    player.path("hitterOps").asDouble()
            );

            int resultCount = dao.insertPlayer(dto);

            System.out.println(
                    dto.getPlayerName()
                    + " / "
                    + dto.getTeamName()
                    + " / 타율 "
                    + dto.getBattingAvg()
                    + " → DB 저장 : "
                    + resultCount
            );

            count++;
        }

        System.out.println("================================");
        System.out.println("총 저장된 선수 : " + count);
        System.out.println("================================");
    }

    public static void findPlayers(
            JsonNode node,
            List<JsonNode> players) {

        if (node.isObject()) {

            if (node.has("playerName")
                    && node.has("playerId")
                    && node.has("teamName")) {

                players.add(node);
                return;
            }

            node.fields().forEachRemaining(entry -> {
                findPlayers(entry.getValue(), players);
            });
        }

        else if (node.isArray()) {

            for (JsonNode child : node) {
                findPlayers(child, players);
            }
        }
    }
}