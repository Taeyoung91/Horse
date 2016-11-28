
public class Client {

	public static void main(String[] args) {
		Random r = new Random();

		Horse[] horse = { new Horse(), new Horse(), new Horse(), new Horse(), new Horse() };

		for (int i = 0; i < horse.length; i++) {
			horse[i].setMovingStrategy(r.getRandomMovingStrategy());
			horse[i].setColorStrategy(r.getRandomColorStrategy());
		}
		new View(horse);
	}

}