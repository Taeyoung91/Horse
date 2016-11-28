
public class BlackStrategy extends ColorStrategy{
	
	@Override
	public String[] color(){
		String photo[] = {"black1.png", "black2.png", "black3.png", "black4.png", "black5.png", "black6.png",
				"black6.png", "black7.png", "black8.png", "black9.png", "black10.png", "black11.png"};
		
		return photo;
	}

	@Override
	public int colorLevel() {
		return 0;
	}
}

