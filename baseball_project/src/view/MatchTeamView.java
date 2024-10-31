package view;

import java.util.List;

import dto.GameDTO;
import dto.RecordGameDTO;

public class MatchTeamView {

	public static void display(RecordGameDTO game) {
		System.out.printf("원정팀번호:"+game.getTeam_id_a()+", 원정팀명:"+game.getTeam_name_a()+"\n");
		System.out.printf("홈팀번호:"+game.getTeam_id_h()+", 홈팀명:"+game.getTeam_name_h()+"\n");
	}
}
