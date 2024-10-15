package com.shinhan.day11;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
@AllArgsConstructor

// 필수칼럼을 매개변수로 갖는 생성자 만들기 → 필수 칼럼에 final 붙여주면 됨
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(of="model")


public class CellPhone {
	final String model;
	double battery;

	/*public CellPhone(String model) {
		this.model = model;
	}*/

	void call(int time) {
		// 강제 Exception 발생
		// Exception ← RuntimeException ← IllegalArgumentException
		// Unchecked Exception : RuntimeException
		// → 처리하지 않으면 자동으로 throws IllegalArgumentException 문장 추가
		// Checked Exception : Exception
		if (time < 0) {
			throw new IllegalArgumentException("통화시간입력오류");
		}

		System.out.println("통화 시간 : " + time + "분");

		battery -= time * 0.5;

		if (battery < 0)
			battery = 0;
	}

	void charge(int time) {
		if (time < 0) {
			throw new IllegalArgumentException("충전시간입력오류");
		}

		System.out.println("충전 시간 : " + time + "분");

		battery += time * 3;

		if (battery > 100)
			battery = 100;
	}

	void printBattery() {
		System.out.printf("남은 배터리 양 : %.1f\n", battery);
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CellPhone other = (CellPhone) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CellPhone [model=").append(model).append(", battery=").append(battery).append("]");
		return builder.toString();
	}*/
}
