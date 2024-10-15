package com.shinhan.day08.lab;

// Speaker : 구현 class로 반드시 추상 메서드를 구현할 의무
public class Speaker implements Volume {
	// 1.field
	int VolLevel = 0;

	// 2.일반메서드
	@Override
	public void volumeUp(int level) {
		VolLevel += level;

		if (VolLevel > 100)
			VolLevel = 100;
		System.out.println(getClass().getSimpleName() + "볼륨 올립니다. " + VolLevel);
	}

	@Override
	public void volumeDown(int level) {
		VolLevel -= level;

		if (VolLevel <= 0) 
			VolLevel = 0;
		System.out.println(getClass().getSimpleName() + "볼륨 올립니다. " + VolLevel);
	}

}
