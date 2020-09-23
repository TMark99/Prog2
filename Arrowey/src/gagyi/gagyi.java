package gagyi;
//integer -128-tól 127-ig előre eltárolva vannak, ha ebben az intervalumban hivatkozunk
//számokra, akkor a memcím ugyan az, tehát a while-ban nem teljesül az utolsó feltétel
//ha a tartományon kivül veszünk értéket, akkor különböző lesz a két memcím
//teljesülnek a feltételek, tehát belép a végtelen ciklusba
public class gagyi
{
public static void main (String[]args)
{
Integer x = -130;
Integer t = -130;
/*System.out.println(Integer.MAX_VALUE);
System.out.println(Integer.MIN_VALUE);*/
System.out.println (x);
System.out.println (t);
while (x <= t && x >= t && t != x)
	System.out.println("Bent vagyok");
}
}
