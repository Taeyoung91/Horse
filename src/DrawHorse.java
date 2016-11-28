import javax.swing.ImageIcon;

public class DrawHorse extends Thread {
	private Horse horse;
	private MovingStrategy movingStrategy;
	private ColorStrategy colorStrategy;
	
	public DrawHorse(Horse horse, MovingStrategy movingStrategy) {
		this.horse = horse;
		this.movingStrategy = movingStrategy;
		horse.getHorse().setIcon(new ImageIcon("./img/1.png"));
	}
	
	public void setMovingStrategy(MovingStrategy movingStrategy){
		this.movingStrategy = movingStrategy;
	}
	public void setColorStrategy(ColorStrategy colorStrategy){
		this.colorStrategy = colorStrategy;
	}

	public void draw(Horse horse) {
		String[] path = horse.getColorStrategy().color();
		for (int i = 0; i < path.length; i++) {
			horse.getHorse().setIcon(new ImageIcon("./img/" + path[i]));
			try {
				Thread.sleep(horse.getMovingStrategy().thSleep());
			} catch (InterruptedException e) {
			}
		}

	}

	public void run() {
		while (true)
			draw(horse);
	}
}
