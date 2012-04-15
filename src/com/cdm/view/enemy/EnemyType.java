package com.cdm.view.enemy;

public enum EnemyType {
	SMALL_SHIP, TANK, BIG_SHIP, BIG_SHIP2, ROCKET, TRUCK, TANK2;

	public static final Float STRENGTH_THRESHOLD = 1.1f;
	public static final Float FACTOR = 0.4f;

	public static EnemyType random() {
		double r = Math.random();
		/*if (true)
			return TRUCK;*/
		if (r < 0.1)
			return TANK2;
		if (r < 0.2)
			return ROCKET;
		else if (r < 0.4)
			return TANK;
		else if (r < 0.6)
			return BIG_SHIP;
		else if (r < 0.8f)
			return TRUCK;
		else
			return SMALL_SHIP;
	}

	public float getEnergy(int levelNo) {
		return getStrength(levelNo);
	}

	public float getStrength(int levelNo) {
		float s = 1.0f;
		switch (this) {
		case SMALL_SHIP:
			s = 1.0f;
			break;
		case TANK:
			s = 1.5f;
			break;
		case BIG_SHIP:
			s = 2.5f;
			break;
		case ROCKET:
			s = 4.5f;
			break;
		case TRUCK:
			s = 3.5f;
			break;
		case TANK2:
			s = 6.0f;
			break;
		}
		return s * (1.0f + (levelNo - 1) * FACTOR);
	}
}
