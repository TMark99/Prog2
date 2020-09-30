/**
 * 
 * @author mark
 * Az Absztrakt gyár programtervezési minta módot nyújt arra, hogy egységbe zárjuk közös témához kapcsolódó egyedi gyártó metódusok egy csoportját anélkül, hogy specifikálnák azok konkrét osztályait.
 * Normál használatban, a kliens szoftver létrehozza az absztrakt gyár egy konkrét implementációját, és aztán a gyár általános interfészét használja a témához kapcsolódó konkrét objektumok létrehozásához
 * Egy gyár, egy konkrét osztály helye a kódban, ahol az objektumok létrejönnek. Az absztrakt gyár minta használatának szándéka arra irányul, hogy elszigetelje egymástól az objektumok létrehozását azok használatától, 
 * és hogy egymással összefüggő objektumok családjait hozza létre anélkül, hogy azok konkrét osztályaitól függene.[1] Ez lehetővé teszi új származtatott típusok bevezetését, anélkül, hogy az ős osztályokat használó kódot meg kellene változtatni.
 *
 */
import java.io.*;     
interface Bank{  
        String getBankNeve();  
}  
/*Letrehozunk egy bankot*/
class OTP implements Bank{  
    private final String BNEV;  
    public OTP(){  
           BNEV="OTP BANK";  
   }  
   public String getBankNeve() {  
             return BNEV;  
   }  
}
/*Letrehozunk egy bankot*/
class Erste implements Bank{  
    private final String BNEV;  
    Erste(){  
             BNEV="ERSTE BANK";  
     }  
     public String getBankNeve() {  
               return BNEV;  
    }  
}
/*kiszmoljuk a torlesztot*/
abstract class Kolcson{  
	   protected double osszeg;  
	   abstract void gethitelosszeg(double osszeg);  
	   public void torlesztoszamolas(double hitel, int evek)  
	   { 
		   double torleszto;
		   int n;
		   n=evek*12;
		   osszeg=osszeg/1200;
		   torleszto=((osszeg*Math.pow((1+osszeg),n))/((Math.pow((1+osszeg),n))-1))*hitel;
		   System.out.println("Havi torleszto "+ torleszto +". A következő összegért: "+hitel);     
	   }  
}
/*letrehoz egy kolcsont*/
class Lakaskolcson extends Kolcson{  
    public void gethitelosszeg(double r){  
        osszeg=r;  
   }  
}
/*letrehoz egy kolcsont*/
class Valalkozoi extends Kolcson{  
    public void gethitelosszeg(double r){  
    	osszeg=r;  
     }
}

abstract class AbstractGyar{  
	  public abstract Bank getBank(String bank);  
	  public abstract Kolcson getKolcson(String loan);  
	}  
/*bankgyar*/
class BankFactory extends AbstractGyar{  
	   public Bank getBank(String bank){  
	      if(bank == null){  
	         return null;  
	      }  
	      if(bank.equalsIgnoreCase("OTP")){  
	         return new OTP();  
	      } else if(bank.equalsIgnoreCase("Erste")){  
	         return new Erste();  
	      }
	      return null;  
	   }  
	  public Kolcson getKolcson(String loan) {  
	      return null;  
	   }  
	}
/*kolcsongyar*/
class KolcsonFactory extends AbstractGyar{  
    public Bank getBank(String bank){  
         return null;  
   }  
    public Kolcson getKolcson(String hitel){  
    	if(hitel == null){  
    		return null;  
    	}  
    	if(hitel.equalsIgnoreCase("Lakas")){  
    		return new Lakaskolcson();  
    	} else if(hitel.equalsIgnoreCase("Valalkozo")){  
    		return new Valalkozoi();  
    	}
    	return null;  
    }
}
/*Gyar letrehozo*/
class FactoryCreator {  
    public static AbstractGyar getGyar(String valasztas){  
     if(valasztas.equalsIgnoreCase("Bank")){  
        return new BankFactory();  
     } else if(valasztas.equalsIgnoreCase("Kolcson")){  
        return new KolcsonFactory();  
     }  
     return null;  
  }  
}
public class AbstractFactory {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		  
	      System.out.print("Irja be a bank nevet: ");  
	      String banknev=br.readLine();  
	  
	System.out.print("\n");  
	System.out.print("Hitel tipusa (Lakás, Válalkozói) : ");  
	  
	String hitelneve=br.readLine();  
	AbstractGyar bankFactory = FactoryCreator.getGyar("Bank");  
	Bank b=bankFactory.getBank(banknev);  
	  
	System.out.print("\n");  
	System.out.print("Kamat %-ban: "+b.getBankNeve()+ ": ");  
	  
	double kamat=Double.parseDouble(br.readLine());  
	System.out.print("\n");  
	System.out.print("Osszeg: ");  
	  
	double osszeg=Double.parseDouble(br.readLine());  
	System.out.print("\n");  
	System.out.print("Evek száma: ");  
	int evek=Integer.parseInt(br.readLine());   
	  
	AbstractGyar KolcsonFactory = FactoryCreator.getGyar("Kolcson");  
	           Kolcson l=KolcsonFactory.getKolcson(hitelneve);  
	           l.gethitelosszeg(kamat);  
	           l.torlesztoszamolas(osszeg,evek);  
	  }
	}
