package objpeldanyositas.Builder;

public class Program{  
	 public static void main(String args[]){  
		 CDEpito cdBuilder=new CDEpito();  
		 CDTipus cdType1=cdBuilder.buildSonyCD();  
	   cdType1.showItems();  
	  
	   CDTipus cdType2=cdBuilder.buildSamsungCD();  
	   cdType2.showItems();  
	 }  
	}