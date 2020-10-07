public abstract class Targy
{
	protected int ferohely;
	protected int csoport;
	
	public abstract void getHely() ;
		
	public abstract int getRand() ;
	
	public void eredmeny(String muvelet, String nev) {
		if (muvelet.equalsIgnoreCase("Felvesz"))
		{
			if(getRand() < csoport * ferohely)
System.out.println("Sikeresen felvetted a " + nev + " tárgyat a " + (int) (Math.random() * (csoport - 1) + 1 ) + ". csoportba.");
			else
				System.out.println("A kurzusok beteltek.");
			for(int i=1; i<=csoport; i++) {
				System.out.println(i+". csoport: " + ferohely + "/" + ferohely);
			}
		}
		else if(muvelet.equalsIgnoreCase("LEAD")) {
			System.out.println("Sikeresen leadtad a " + (int) (Math.random() * (csoport - 1) + 1 ) + ". " + nev + " csoport tárgyát.");
		}
		else 
			System.out.println("Nincs ilyen parancs. Próbáld újra.");
	}
	
}

