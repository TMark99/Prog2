
class car2{
	public void brand() {
		System.out.println("Audi A" + 4);
	}
	public void color() {
		System.out.println("black");
	}
}

public class normalclass {

	public static void main(String[] args) {
	car2 car = new car2();
	car.brand();
	car.color();
	}

}
