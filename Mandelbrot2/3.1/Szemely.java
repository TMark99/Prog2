import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Szemely
{

	public String Szemelyiszam;
	
	public String Nev;
	
	public Szemely(){
		super();
	}
	
	public void AddAccount(Bankszamla parameter) {
		System.out.println("Adja meg a szemelyi azonosító számát!");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			Szemelyiszam=br.readLine();
		} catch (IOException e) {
			System.out.println("Nem adott meg adatot");
		}
		System.out.println("Adja meg a nevét!");
		try {
			Nev=br.readLine();
		} catch (IOException e) {
			System.out.println("Nem adott meg adatot");
		}
		
	}
	
}

