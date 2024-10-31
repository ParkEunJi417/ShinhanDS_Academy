package view;

import java.util.List;

import dto.RecordGameDTO;
import dto.RecordPerDTO;

public class RecordPerView {

	public static void displayAll(List<RecordPerDTO> recordlist) {

		if (recordlist.size() > 0) {
			System.out.println("=========직관 기록=========");

			for (RecordPerDTO record : recordlist) {
				System.out.println(record);
			}
		} else {
			System.out.println("[알림] 직관 기록이 없습니다.");
		}
	}
	
	public static void display(List<RecordPerDTO> recordlist) {

		if (recordlist.size() > 0) {
			System.out.println("=========직관 기록=========");

			for (RecordPerDTO record : recordlist) {
				System.out.println(record.toString().replace("직관번호:"+record.getWatch_no()+", ",""));
			}
		} else {
			System.out.println("[알림] 직관 기록이 없습니다.");
		}
	}

	public static void display(double avg) {
		System.out.println("직관 승률:" + String.format("%.2f",avg * 100)+"%");
	}
}
