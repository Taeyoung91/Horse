
public class RainbowStrategy extends ColorStrategy {

	@Override
	public String[] color() {
		String photo[] = {"rainbow1.png", "rainbow2.png", "rainbow3.png", "rainbow4.png", "rainbow5.png",
				"rainbow6.png", "rainbow7.png", "rainbow8.png", "rainbow9.png", "rainbow10.png", "rainbow11.png",
		};
		return photo;
	}

	@Override
	public int colorLevel() {
		return 1;
	}
	

}
