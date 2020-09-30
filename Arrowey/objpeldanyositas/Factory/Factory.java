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
