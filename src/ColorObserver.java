public class ColorObserver implements Observer{

	Horse horse;
	
	public ColorObserver(Horse horse){
		this.horse = horse;
	}
	@Override
	public void update() {
		ColorStrategy colorStrategy = horse.getColorStrategy();
		
		horse.getDraw().setColorStrategy(colorStrategy);
	}

}
