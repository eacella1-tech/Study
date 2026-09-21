//package com.kedu.crawler;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class KboCrawler {
//
//    public static void main(String[] args) throws Exception {
//    	for(int i=1; i<10; i++) { 
//        String url = "https://api-gw.sports.naver.com/schedule/games"
//                + "?upperCategoryId=kbaseball"
//                + "&fromDate=2026-09-1" + i 
//                + "&toDate=2026-09-1" + i;
//
//        URL requestUrl = new URL(url);
//
//        HttpURLConnection con = (HttpURLConnection) requestUrl.openConnection();
//
//        con.setRequestMethod("GET");
//        con.setRequestProperty("User-Agent", "Mozilla/5.0");
//
//        BufferedReader br = new BufferedReader(
//                new InputStreamReader(con.getInputStream(), "UTF-8")
//        );
//
//        String line;
//        StringBuilder result = new StringBuilder();
//
//        while ((line = br.readLine()) != null) {
//            result.append(line);
//        }
//
//        br.close();
//
//        System.out.println(result);
//    	}
//    }
//}
package com.kedu.crawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kedu.dao.GameDAO;
import com.kedu.dto.GameDTO;

@Controller
public class KboCrawler {
	
	@Autowired
	GameDAO dao;

	@RequestMapping("/games")
    public String games(GameDTO dto) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        for (int i = 1; i < 10; i++) {

            String url = "https://api-gw.sports.naver.com/schedule/games"
                    + "?upperCategoryId=kbaseball"
                    + "&fromDate=2026-09-1" + i
                    + "&toDate=2026-09-1" + i;

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

            // JSON ÆÄ½Ì
            JsonNode root = mapper.readTree(result.toString());

            JsonNode games = root.path("result").path("games");

            for (JsonNode game : games) {

                String date = game.path("gameDate").asText();
                String time = game.path("gameDateTime").asText().substring(11, 16);
                String home = game.path("homeTeamName").asText();
                String away = game.path("awayTeamName").asText();

                // KBO °æ±â¸¸ Ãâ·Â
                if (!home.equals("") && !away.equals("")) {
                	dao.insertGame(dto);
                	System.out.println("¿ìÇï");
                }
            }
        }
        
        return "home";
    }
}