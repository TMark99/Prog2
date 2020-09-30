class Madar{
	public void repul()
	{
		System.out.println(super.getClass().getSimpleName() + " repül");
	};
}

class Sas extends Madar{};
class Golya extends Madar{}; 
class Pingvin extends Madar{};

public class liskov
{
	public static void main(String[] args)
	{
		Madar madar = new Madar();
		Sas sas = new Sas();
		Golya golya = new Golya();
		Pingvin pingvin = new Pingvin();
		sas.repul();
		golya.repul();
		pingvin.repul();
	}
}
