package racetrack;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString
public class Betting_DTO {
	
	//필드
	int batting_id;
	String member_id;
	int horse_id;
	double betting_cash;
	Date betting_date;
	
	// 생성자
	public Betting_DTO(int batting_id, String member_id, int horse_id, double betting_cash, Date betting_date) {
		super();
		this.batting_id = batting_id;
		this.member_id = member_id;
		this.horse_id = horse_id;
		this.betting_cash = betting_cash;
		this.betting_date = betting_date;
	}
	
	
}
