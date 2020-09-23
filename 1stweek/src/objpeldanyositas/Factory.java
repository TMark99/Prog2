package objpeldanyositas;
/*Ezzel a programtervezési mintával kiváltható a kódban elhelyezett számos ugyanolyan példányosító utasítás
 * A gyártófüggvény a nevében megadott osztály egy példányát adja vissza
 * 
 * 
 * 
 * az ősosztályban elhelyezett gyártómetódus írja le a gyártás algoritmusát, a gyermek osztály pedig eldönti, hogy mit kell gyártani. Ennek érdekében az algoritmus háromféle lépést tartalmazhat:

A gyártás közös lépései: Az ősosztályban elhelyezett konkrét metódusok, általában nem virtuálisak, illetve Java nyelven final metódusok.
A gyártás kötelező változó lépései. Ezek az ősosztályban elhelyezett absztrakt metódusok, amiket a gyermek felülír, amikor eldönti, mit kell gyártani. A gyermek osztályok itt hívják meg a termék konstruktorát.
A gyártás opcionális lépései: Hook metódusok az ősosztályban, tehát a metódus csak egy üres törzzsel rendelkezik. Ezeket az OCP elv megszegése nélkül felül lehet írni az opcionális lépések kifejtéséhez.

 */

import java.io.*;      
abstract class auto{  
         protected double ar;  
         abstract void getdarab();  
   
         public void szamol(int units){  
              System.out.println(units*ar);  
          }  
}

class  Audi extends auto{    
     public void getdarab(){  
         ar=8.50;              
    }  
}

class BMW extends auto{    
	    public void getdarab(){   
	        ar=7.50;  
	   }
}

class  Suzuki extends auto{  
	    	    public void getdarab(){   
	    	        ar=5.50;  
	    	   }
}

class Getautomarka{  
	       public auto getmarka(String planType){  
	            if(planType == null){  
	             return null;  
	            }  
	          if(planType.equalsIgnoreCase("Audi")) {  
	                 return new Audi();  
	               }   
	           else if(planType.equalsIgnoreCase("BMW")){  
	                return new BMW();  
	            }   
	          else if(planType.equalsIgnoreCase("Suzuki")) {  
	                return new Suzuki();  
	          }  
	      return null;  
	   }  
	}

public class Factory {

	public static void main(String[] args) throws IOException {
		Getautomarka rendeles = new Getautomarka();  
        
	      System.out.print("Adja meg melyik autót szeretné: ");  
	      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
	  
	      String markanev=br.readLine();  
	      System.out.print("Írja be hány darabot szeretne: ");  
	      int darab=Integer.parseInt(br.readLine());  
	  
	      auto p = rendeles.getmarka(markanev);  
	  
	       System.out.print(darab + " darab " + markanev + " ennyi millió Ft-ba kerül: ");
	           p.getdarab();  
	           p.szamol(darab);  
	            }  
	    }
