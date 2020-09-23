package methods;

public class main {

	public static void main (String[]args)
	{
		methods meta = new methods();
		methods meta2 = new methods();
		
		System.out.println(meta.toString());
		System.out.println(meta.hashCode());
		
		System.out.println(meta.equals(meta2));//hash kodot hasonlítja össze
		System.out.println(meta.getClass());
		System.out.println(meta2.hashCode());
	}

}
