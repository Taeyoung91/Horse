import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.*;
import javax.swing.*;

public class View extends JFrame {
	Button button;
	Horse horse[];

	public View(Horse[] horse) {
		this.horse = horse;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		Container c = this.getContentPane();

		c.setBackground(Color.WHITE);
		setSize(1000, 800);
		setVisible(true);
		this.setResizable(false);
		
		ExecutorService exec = Executors.newCachedThreadPool();
		addKeyListener(new HorseMoveFasterKeyListener());
		addKeyListener(new HorseMoveSlowerKeyListener());
		addKeyListener(new HorseColorKeyStrategy());
		
		for (int i = 0; i < horse.length; i++) {
			add(horse[i].getHorse());
			horse[i].setY(i);
			horse[i].attach(new MovingObserver(horse[i]));
			horse[i].attach(new ColorObserver(horse[i]));
			horse[i].getHorse().setLocation(horse[i].getX(), horse[i].getY());
			horse[i].getHorse().setSize(188, 121);

			exec.execute(horse[i]);
		}
	}

	class HorseMoveFasterKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			char key = e.getKeyChar();

			switch (key) {
			case '1':
				horse[0].setMovingStrategy(movingLevelFasterControl(horse[0]));
				break;
			case '2':
				horse[1].setMovingStrategy(movingLevelFasterControl(horse[1]));
				break;
			case '3':
				horse[2].setMovingStrategy(movingLevelFasterControl(horse[2]));
				break;
			case '4':
				horse[3].setMovingStrategy(movingLevelFasterControl(horse[3]));
				break;
			case '5':
				horse[4].setMovingStrategy(movingLevelFasterControl(horse[4]));
				break;
			default:
				break;
			}
		}
	}

	class HorseMoveSlowerKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			char key = e.getKeyChar();

			switch (key) {
			case 'q':
				horse[0].setMovingStrategy(movingLevelSlowerControl(horse[0]));
				break;
			case 'w':
				horse[1].setMovingStrategy(movingLevelSlowerControl(horse[1]));
				break;
			case 'e':
				horse[2].setMovingStrategy(movingLevelSlowerControl(horse[2]));
				break;
			case 'r':
				horse[3].setMovingStrategy(movingLevelSlowerControl(horse[3]));
				break;
			case 't':
				horse[4].setMovingStrategy(movingLevelSlowerControl(horse[4]));
				break;
			default:
				break;
			}
		}
	}
	
	class HorseColorKeyStrategy extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			char key = e.getKeyChar();
			
			switch(key){
			case 'a':
				horse[0].setColorStrategy(colorLevelControl(horse[0]));
				break;
			case 's':
				horse[1].setColorStrategy(colorLevelControl(horse[1]));
				break;
			case 'd':
				horse[2].setColorStrategy(colorLevelControl(horse[2]));
				break;
			case 'f':
				horse[3].setColorStrategy(colorLevelControl(horse[3]));
				break;
			case 'g':
				horse[4].setColorStrategy(colorLevelControl(horse[4]));
				break;
			}
		}
	}

	public MovingStrategy movingLevelFasterControl(Horse horse) {
		int moveLevel = horse.getMovingStrategy().moveLevel();

		switch (moveLevel) {
		case 0:
			return new FastStrategy();
		case 1:
			return new FasterStrategy();
		case 2:
			return new FastestStrategy();
		default:
			return new FastestStrategy();
		}
	}

	public MovingStrategy movingLevelSlowerControl(Horse horse) {
		int moveLevel = horse.getMovingStrategy().moveLevel();

		switch (moveLevel) {
		case 0:
			return new SlowStrategy();
		case 1:
			return new SlowStrategy();
		case 2:
			return new FastStrategy();
		default:
			return new FasterStrategy();
		}
	}
	
	public ColorStrategy colorLevelControl(Horse horse){
		int colorLevel = horse.getColorStrategy().colorLevel();
		
		switch(colorLevel){
		case 0:
			return new RainbowStrategy();
		default:
			return new BlackStrategy();
		}
	}
}
