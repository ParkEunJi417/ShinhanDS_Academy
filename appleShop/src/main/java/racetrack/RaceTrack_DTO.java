package racetrack;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString

public class RaceTrack_DTO {
	//memeber
	String memeber_id;
	String member_pw;
	int member_index;
	int member_cash;
	
	//betting
	int betting_cash;
}
