package com.baseball;

import java.sql.Date;

import com.firstzone.emp.EmpDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@Builder
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
		return "경기번호:" + game_no + ", 경기일정:" + game_date + ", 매칭팀:" + team_name_a
				+ " vs " + team_name_h + ", 점수:" + team_score_a + ":" + team_score_h;
	}	
}
