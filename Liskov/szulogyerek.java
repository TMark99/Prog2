//a gyerek örökli, a szülő osztály fűggvényeit, de a szülő osztály nem tudja használni a gyerek osztály függvényeit
class szulo{
	public void write(){
		System.out.println("Szülő");
	}
}
class gyerek extends szulo{
	public void kiir() {
		System.out.println("Gyerek");
	}
}
public class szulogyerek {
	public static void main(String[] args) {
		szulo egy = new szulo();
		gyerek ketto = new gyerek();
		egy.write();
		ketto.kiir();
		ketto.write();
	}
}
