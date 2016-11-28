
public class MovingObserver implements Observer {

	Horse horse;

	public MovingObserver(Horse horse) {
		this.horse = horse;
	}

	@Override
	public void update() {
		MovingStrategy movingStrategy = horse.getMovingStrategy();

		horse.getDraw().setMovingStrategy(movingStrategy);
		horse.getMove().setMovingStrategy(movingStrategy);
	}

}
