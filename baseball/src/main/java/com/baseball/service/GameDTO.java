package com.baseball.service;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@Builder
@ToString
public class GameDTO {
	int game_no;
	Date game_date;

	int team_score_a;		// 원정팀 점수
	int team_id_a;			// 원정팀 id
	
	int team_score_h;		// 홈팀 점수
	int team_id_h;			// 홈팀 id
}
