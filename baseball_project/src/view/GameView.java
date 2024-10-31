package view;

import java.util.List;

import dto.GameDTO;

public class GameView {

	// Overloading
	public static void display(List<GameDTO> gamelist) {
		System.out.println("=========경기 일정=========");

		for (GameDTO game : gamelist) {
			System.out.println(game);
		}
	}

	public static void display(String message) {
		System.out.println("[알림] "+message);
	}
}
