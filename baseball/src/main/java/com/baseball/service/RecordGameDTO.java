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
public class RecordGameDTO {
	
	int game_no;		// 경기번호(game)
	Date game_date;		// 경기일정(game)
	
	String team_name_a;	// 원정팀명
	int team_score_a;	// 원정팀 점수
	int team_id_a;		// 원정팀 id
	
	String team_name_h;	// 홈팀명
	int team_score_h;	// 홈팀 점수
	int team_id_h;		// 홈팀 id
	
	@Override
	public String toString() {
		return team_name_a + " vs " + team_name_h;
	}

	
	
	
}
