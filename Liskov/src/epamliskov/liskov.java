package epamliskov;
class Vehicle{
	public Vehicle() {
		System.out.println("Vehicle");
	};
	public void start() {
		System.out.println("first");
	}
};
class Car extends Vehicle{
	public Car() {
		System.out.println("Car");
	}
	@Override
	public void start() {
		System.out.println("second");
	}
};
class Supercar extends Car{
	public Supercar()
	{
		System.out.println("Supercar");
	}
	@Override
	public void start() {
		System.out.println("third");
	}
};
public class liskov {

	public static void main(String[] args) {
		Vehicle firstVehicle = new Supercar();
		firstVehicle.start();
		System.out.println(firstVehicle instanceof Car);
		Car secondVehicle = (Car) firstVehicle;
		secondVehicle.start();
		System.out.println(secondVehicle instanceof Supercar);
		//Supercar thirdVehicle = new Vehicle();
		//thirdVehicle.start();
	}

}
