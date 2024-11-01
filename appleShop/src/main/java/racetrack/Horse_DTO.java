package racetrack;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString

public class Horse_DTO {
	//horse 필드
	int horse_id;
	String horse_name;
	
	public Horse_DTO(int horseId, String horseName) {
		this.horse_id = horseId;
		this.horse_name = horseName;
	}
}
