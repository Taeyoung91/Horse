public class Random {
	public MovingStrategy getRandomMovingStrategy() {
		int random = (int) (Math.random() * 4);

		switch (random) {
		case 1:
			return new FastStrategy();
		case 2:
			return new FasterStrategy();
		case 3:
			return new FastestStrategy();
		default:
			return new SlowStrategy();
		}
	}
	
	public ColorStrategy getRandomColorStrategy(){
		int random = (int) (Math.random() * 2);
		
		if(random == 1)
			return new BlackStrategy();
		else
			return new RainbowStrategy();
		
	}
}
