import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bankszamla {

	public String Szamlaszam;
	public int Osszeg = 60000;

	public Bankszamla() {
		super();
	}

	public void Egyenleg(int parameter) {
		System.out.println("Az on egyenlege:" + parameter);
	}

	public int Lekeres() {
		System.out.println("Írja be a kivenni kivánt összeget.");
		String levon;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			levon = br.readLine();
			int levonas = Integer.parseInt(levon);
			if (levonas < 0)
				System.out.println("Érvénytelen összeg");
			else if (levonas > Osszeg)
				System.out.println("Nem áll rendelkezésre elég összeg");
			else {
				Osszeg = Osszeg - levonas;
				System.out.println("Sikeres tranzakció");
			}
		} catch (IOException e) {
			System.out.println("Nem adott meg összeget");
		}

		return 0;
	}

}
