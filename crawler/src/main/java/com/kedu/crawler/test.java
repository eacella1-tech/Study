package com.kedu.crawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kedu.dao.GameDAO;
import com.kedu.dto.GameDTO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext context =
				new ClassPathXmlApplicationContext("root-context.xml");

		GameDAO dao = context.getBean(GameDAO.class);

		ObjectMapper mapper = new ObjectMapper();

		for (int i = 1; i < 30; i++) {

			if(i<10) {
				String url = "https://api-gw.sports.naver.com/schedule/games"
						+ "?upperCategoryId=kbaseball"
						+ "&fromDate=2026-09-0" + i
						+ "&toDate=2026-09-0" + i;
				URL requestUrl = new URL(url);
				HttpURLConnection con = (HttpURLConnection) requestUrl.openConnection();

				con.setRequestMethod("GET");
				con.setRequestProperty("User-Agent", "Mozilla/5.0");

				BufferedReader br = new BufferedReader(
						new InputStreamReader(con.getInputStream(), "UTF-8")
						);

				String line;
				StringBuilder result = new StringBuilder();

				while ((line = br.readLine()) != null) {
					result.append(line);
				}

				br.close();

				// JSON 파싱
				JsonNode root = mapper.readTree(result.toString());

				JsonNode games = root.path("result").path("games");

				for (JsonNode game : games) {

					int seq = 0;
					String regdate = game.path("gameDate").asText();
					String time = game.path("gameDateTime").asText().substring(11, 16);
					String home = game.path("homeTeamName").asText();
					String away = game.path("awayTeamName").asText();
					GameDTO dto = new GameDTO(seq,regdate,time,home,away);
					// KBO 경기만 출력
					if (!home.equals("") && !away.equals("")) {
						dao.insertGame(dto);
						System.out.println("우헬");
					}
				}
			} else {
				String url = "https://api-gw.sports.naver.com/schedule/games"
						+ "?upperCategoryId=kbaseball"
						+ "&fromDate=2026-09-" + i
						+ "&toDate=2026-09-" + i;
				URL requestUrl = new URL(url);
				HttpURLConnection con = (HttpURLConnection) requestUrl.openConnection();

				con.setRequestMethod("GET");
				con.setRequestProperty("User-Agent", "Mozilla/5.0");

				BufferedReader br = new BufferedReader(
						new InputStreamReader(con.getInputStream(), "UTF-8")
						);

				String line;
				StringBuilder result = new StringBuilder();

				while ((line = br.readLine()) != null) {
					result.append(line);
				}

				br.close();

				// JSON 파싱
				JsonNode root = mapper.readTree(result.toString());

				JsonNode games = root.path("result").path("games");

				for (JsonNode game : games) {

					int seq = 0;
					String regdate = game.path("gameDate").asText();
					String time = game.path("gameDateTime").asText().substring(11, 16);
					String home = game.path("homeTeamName").asText();
					String away = game.path("awayTeamName").asText();
					GameDTO dto = new GameDTO(seq,regdate,time,home,away);
					// KBO 경기만 출력
					if (!home.equals("") && !away.equals("")) {
						dao.insertGame(dto);
						System.out.println("시발련아");
					}
				}
			}


			
		}
	}

}
