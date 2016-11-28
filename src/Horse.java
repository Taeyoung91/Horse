import javax.swing.JLabel;

public class Horse extends Subject implements Runnable {
	private JLabel horseLabel;
	private MovingStrategy mStrategy = new FastStrategy();
	private ColorStrategy cStrategy;
	private int x = 0, y = 0;
	private DrawHorse draw;
	private MoveHorse move;


	public void setMovingStrategy(MovingStrategy mStrategy) {
		this.mStrategy = mStrategy;
		notifyObservers();
	}

	public MovingStrategy getMovingStrategy() {
		return this.mStrategy;
	}
	
	public void setColorStrategy(ColorStrategy cStrategy){
		this.cStrategy = cStrategy;
		notifyObservers();
	}
	
	public ColorStrategy getColorStrategy(){
		return cStrategy;
	}

	public Horse() {
		horseLabel = new JLabel();
		draw = new DrawHorse(this, mStrategy);
		move = new MoveHorse(this, mStrategy);
	}

	public JLabel getHorse() {
		return horseLabel;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int index) {
		this.y = index * 150;
	}
	
	public DrawHorse getDraw(){
		return draw;
	}
	public MoveHorse getMove(){
		return move;
	}

	public void run() {
		move.start();
		draw.start();
	}

}
