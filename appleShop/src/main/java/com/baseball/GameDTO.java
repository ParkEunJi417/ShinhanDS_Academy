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
public class GameDTO {
	int game_no;
	int game_score;
	String game_outcome;
	Date game_date;
	int team_id;
	
	@Override
	public String toString() {
		return "경기번호:" + game_no + ", 점수:" + game_score + ", 결과:" + game_outcome
				+ ", 경기일정:" + game_date + ", 구단아이디:" + team_id;
	}
}
