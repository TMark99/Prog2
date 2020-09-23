package objpeldanyositas.Builder;

import java.util.ArrayList;  
import java.util.List;  
public class CDTipus {  
             private List<Csomag> items=new ArrayList<Csomag>();  
             public void addItem(Csomag packs) {    
                    items.add(packs);  
             }  
             public void getCost(){  
              for (Csomag packs : items) {  
                        packs.price();  
              }   
             }  
             public void showItems(){  
              for (Csomag packing : items){  
             System.out.print("CD neve : "+packing.pack());  
             System.out.println(", Ar : "+packing.price());  
          }       
            }     
}
