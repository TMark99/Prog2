
abstract class car1{ //ez egy séma
	public abstract void getbrand();
	public void getcolor()
	{
		System.out.println("Black");
	}
}

class newcar1 extends car1{ //osztalyt csinálunk a séma alapján
	public void getbrand(){
		System.out.println("Audi A" + 4);
	}
}

public class abstract1{

	public static void main(String[] args) {
		newcar1 car= new newcar1(); //példányosítás
		car.getbrand();
		car.getcolor();
	}

}
