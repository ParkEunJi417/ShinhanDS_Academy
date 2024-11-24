package com.baseball.service;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class RecordPerDTO {
	
	int watch_no;			// 직관번호(watching)
	Date game_date;			// 경기일정(game)
	
	String team_name_a;		// 원정팀명
	int team_score_a;		// 원정팀 점수
	int team_id_a;			// 원정팀 id
	
	String team_name_h;		// 홈팀명
	int team_score_h;		// 홈팀 점수
	int team_id_h;			// 홈팀 id
	
	String teamname; 		// 응원팀명
	int teamid;				// 응원팀 id
	
	String color;			// 응원한 팀 승패에 따라 color 부여(servlet용)
	
	@Override
	public String toString() {
		return "직관번호:" + watch_no  + ", 경기일정:" + game_date + ", 매칭팀:" + team_name_a
				+ " vs " + team_name_h + ", 점수:" + team_score_a + ":" + team_score_h
				+", 응원한 팀:"+teamname;
	}
}
