package com.baseball.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.baseball.service.GameDTO;
import com.baseball.util.DBUtil;
import com.baseball.util.DateUtil;

/**
 * Servlet implementation class ScrapingService
 */
@WebServlet("/ScrapingService")
public class ScrapingService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int result;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  System.setProperty("webdriver.chrome.driver", "C:\\shinhanDS\\install\\chromedriver\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  List<GameDTO> gamelist = new ArrayList<>();
		  int total = 0;
		  
		  try {
				// 셀레니움으로 웹 페이지 접근
				driver.get("https://www.koreabaseball.com/Schedule/Schedule.aspx");
				
				int x = 3000;
	            int y = 0;
	            driver.manage().window().setPosition(new Point(x, y));

	            driver.manage().window().maximize();
				
				WebElement selectYearElement = driver.findElement(By.id("ddlYear"));
				WebElement selectMonthElement = driver.findElement(By.id("ddlMonth"));
				WebElement selectSeriesElement = driver.findElement(By.id("ddlSeries"));

				Select selectYear = new Select(selectYearElement); // 추후 child 받아와서 처리
			    Select selectMonth = new Select(selectMonthElement); 
			    Select selectSeries = new Select(selectSeriesElement);
			    
			    selectSeries.selectByVisibleText("KBO 정규시즌 일정");
			    selectYear.selectByVisibleText("2024");

	            List<WebElement> optionsMonth = selectMonth.getOptions();
	            
	            for (WebElement month : optionsMonth) {
	                String monthText = month.getText();
	                System.out.println("----------▼"+monthText+"월▼----------");

	                selectMonth.selectByVisibleText(monthText);
	                Thread.sleep(5000);
	                
					// 셀레니움으로 가져온 HTML을 Jsoup으로 파싱
					Document doc = Jsoup.parse(driver.getPageSource());
					Elements baseballSchedule = doc.select("#tblScheduleList > tbody > tr");
					
					if (baseballSchedule.size() == 1) {
						Elements detailInfo = doc.select("#tblScheduleList > tbody > tr > td");
						if(detailInfo.size() == 1) {
							System.out.println("경기 없음");
							continue;
						}
					}

					String currentDay = null;
					for (Element Schedule : baseballSchedule) {
						GameDTO game = null;
						int team_id_a=0, team_score_a=0;
						int team_id_h=0, team_score_h=0;
						
						Element day = Schedule.selectFirst("td.day");
						Element vs = Schedule.selectFirst("td.play > em");
						Elements spans = vs.select("span");
						int numberOfSpans = spans.size();

						if (day != null) {
							if (currentDay == null || !currentDay.equals(day.text())) {
								currentDay = day.text();
							}
							currentDay = currentDay.split("\\(")[0]; // 04.02
							currentDay = "2024"+ "-" + currentDay.split("\\.")[0] + "-" + currentDay.split("\\.")[1];
						}
						
						if(numberOfSpans == 1) {
							continue;
						}
						
						Element time = Schedule.selectFirst("td.time");
						Element team_name_a = Schedule.selectFirst("td.play > span");
						Element team_score_a_ele = Schedule.selectFirst("td.play > em > span:nth-child(1)");
						Element team_name_h = Schedule.selectFirst("td.play > span:nth-child(3)");
						Element team_score_h_ele = Schedule.selectFirst("td.play > em > span:nth-child(3)");

						team_id_a = custionTeamId(team_name_a.text());
						team_id_h = custionTeamId(team_name_h.text());
						
						team_score_a = Integer.parseInt(team_score_a_ele.text());
						team_score_h = Integer.parseInt(team_score_h_ele.text());

						if (time != null) {
							game = GameDTO.builder()
												 .game_date(DateUtil.convertSqlDate(DateUtil.convertDate(currentDay)))
												 .team_score_a(team_score_a)
												 .team_id_a(team_id_a)
												 .team_score_h(team_score_h)
												 .team_id_h(team_id_h)
												 .build();
							gamelist.add(game);
						}
					}
					int result = insertGame(gamelist); 
					total += result;
					System.out.println(result+"건 저장");
					gamelist = new ArrayList<>();
	            }
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				driver.quit();
			}
		  System.out.println("총 "+total+"건 저장");		  
	}
	
	private int custionTeamId(String name) {
		int result = 0;
		
		switch (name.toUpperCase()) {
			case "KIA" -> result = 1;
			case "KT" -> result = 2;
			case "LG" -> result = 3;
			case "NC" -> result = 4;
			case "SSG" -> result = 5;
			case "두산" -> result = 6;
			case "롯데" -> result = 7;
			case "삼성" -> result = 8;
			case "키움" -> result = 9;
			case "한화" -> result = 10;
		}
		
		return result;
	}

	private int insertGame(List<GameDTO> gamelist) {
		String sql = "insert into game values(seq_gameNo.NEXTVAL,?,?,?,?,?)";
		conn = DBUtil.getConnection();

		try {
			st = conn.prepareStatement(sql);
			
			conn.setAutoCommit(false);

            for (GameDTO game:gamelist) {
                st.setInt(1, game.getTeam_id_a());
                st.setInt(2, game.getTeam_id_h());
                st.setInt(3, game.getTeam_score_a());
                st.setInt(4, game.getTeam_score_h());
                st.setDate(5, game.getGame_date());

                st.addBatch();
            }
            int[] updateCounts = st.executeBatch();

            conn.commit();
            //conn.rollback();

			result = updateCounts.length;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}

		return result;
	}
}
