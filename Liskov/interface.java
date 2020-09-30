

interface car{ //ez egy séma
	public void getbrand();
	public void getcolor();
}

class newcar implements car{ //osztalyt csinálunk a séma alapján
	public void getbrand(){
		System.out.println("Audi A" + 4);
	}
	public void getcolor() {
		System.out.println("Black");
	}
}

public class inetface {

	public static void main(String[] args) {
		newcar car= new newcar(); //példányosítás
		car.getbrand();
		car.getcolor();
	}

}
