import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Neptun {
	public static void main(String[] args) throws IOException {
		GetTargynev targyMelyik = new GetTargynev();
		BufferedReader targyfelvetel = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Tárgyfelvétel\n");
		System.out.println("Ha végeztél ird be az 'exit' kilcsszót.");
		boolean fut;

		do {

			System.out.println("Ird be egy tárgy nevét ( prog2, statisztak, szamitastudomany ) : ");
			String targynev;
			try {
				targynev = targyfelvetel.readLine();
				System.out.println("Felvesz vagy Lead?: ");
				String muvelet = targyfelvetel.readLine();
				
				Targy t = (Targy) targyMelyik.getnev(targynev);

				if(t != null)
				{
					t.getRand();
					t.getHely();
					t.eredmeny(muvelet, targynev);
				}
				else
					System.out.println("Érvénytelen tárgynév");
				System.out.println(
						"Ha nem akarsz további mûveleteket végezni\nird be az 'exit' kulcsszót egyébként nyomj entert:");
				String exit = targyfelvetel.readLine();
				if (exit.equalsIgnoreCase("EXIT"))
					fut = false;
				else
					fut = true;
			} catch (IOException e) {
				System.out.println("Érvénytelen utasítás");
			}
			System.out.println(
					"Ha nem akarsz további mûveleteket végezni\nird be az 'exit' kulcsszót egyébként nyomj entert:");
			String exit = targyfelvetel.readLine();
			if (exit.equalsIgnoreCase("EXIT"))
				fut = false;
			else
				fut = true;
		} while (fut == true);

		System.out.println("A tárgyfelvétel megtörtént.");
	}

}
