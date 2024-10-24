package com.firstzone.dept;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
public class DeptDTO {
	int department_id;
	String department_name;
	int manager_id;
	int location_id;
}
