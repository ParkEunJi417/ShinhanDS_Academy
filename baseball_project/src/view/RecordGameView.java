package view;

import java.util.List;

import dto.RecordGameDTO;

public class RecordGameView {
	
	public static void displayAll(List<RecordGameDTO> gamelist) {
		if(gamelist.size() > 0) {
			System.out.println("=========경기 기록=========");

			for (RecordGameDTO game : gamelist) {
				System.out.println(game);
			}
		} else {
			System.out.println("[알림] 해당 일자에 경기가 없습니다.");
		}	
	}
	
	public static void display(List<RecordGameDTO> gamelist) {
		if(gamelist.size() > 0) {
			System.out.println("=========경기 기록=========");

			for (RecordGameDTO game : gamelist) {
				System.out.println(game.toString().replace("경기번호:"+game.getGame_no()+", ",""));
			}
		} else {
			System.out.println("[알림] 해당 일자에 경기가 없습니다.");
		}	
	}
}
