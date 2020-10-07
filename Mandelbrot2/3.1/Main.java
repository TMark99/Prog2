public class Main {

	public static void main(String[] args) {
		Bankszamla szamla = new Bankszamla();
		Szemely kliens = new Szemely();
		kliens.AddAccount(szamla);
		szamla.Egyenleg(szamla.Osszeg);
		szamla.Lekeres();
		szamla.Egyenleg(szamla.Osszeg);
	}

}
