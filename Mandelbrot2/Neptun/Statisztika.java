public class Statisztika extends Targy
{
	public int getRand() {
		return (int) ((Math.random() * (100-70+1)) + 70);	
	}
	
	public void getHely() {	
		ferohely = 22;
		csoport = 4;
	}
	
}

