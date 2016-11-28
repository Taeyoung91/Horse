public class MoveHorse extends Thread {
	private Horse horse;
	private MovingStrategy movingStrategy;

	public MoveHorse(Horse horse, MovingStrategy movingStrategy) {
		this.horse = horse;
		this.movingStrategy = movingStrategy;
	}
	public void setMovingStrategy(MovingStrategy movingStrategy){
		this.movingStrategy = movingStrategy;
	}
	
	public void move(Horse horse) {
		if (horse.getX() > 1000) {
			horse.setX(-(horse.getHorse().getWidth()));
			//horse.setMovingStrategy(new Random().getRandomMovingStrategy());
		}
		horse.setX(horse.getX() + horse.getMovingStrategy().speed());
		horse.getHorse().setLocation(horse.getX(), horse.getY());
		try {
			Thread.sleep(horse.getMovingStrategy().thSleep());
		} catch (InterruptedException e) {
		}
	}

	public void run() {
		while (true)
			move(horse);
	}
}
