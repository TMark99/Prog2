import java.util.ArrayList;

public class GetTargynev
{
	public Targy getnev(String nev) {
		ArrayList<String> targyak = new ArrayList<String>();
		targyak.add("statisztika");
		targyak.add("prog2");
		targyak.add("Szamitastudomany");
		
		String vantargy = null;
		
		for(String i : targyak) {
			if(nev.equalsIgnoreCase(i))
				vantargy = nev;
		}
		if(vantargy != null) {
			if(nev.equalsIgnoreCase("PROG2")) {
				return new Prog2();
			}
			else if(nev.equalsIgnoreCase("STATISZTIKA")) {
				return new Statisztika();
			}
			else if(nev.equalsIgnoreCase("SZAMITASTUDOMANY")) {
				return new Szamitastudomany();
			} 
		} else {	
			System.out.println("Helytelen tárgynév vagy mûvelet.");	
		}
		return null;
	}
}

