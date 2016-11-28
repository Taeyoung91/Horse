public class SlowStrategy extends MovingStrategy {
	public int speed() {
		return 16;
	}

	public int thSleep() {
		return 120;
	}

	public int moveLevel() {
		return 0;
	}
}