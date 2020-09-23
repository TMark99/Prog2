package objpeldanyositas.Builder;

public class CDEpito {  
    public CDTipus buildSonyCD(){   
    	CDTipus cds=new CDTipus();  
       cds.addItem(new Sony());  
       return cds;  
}  
public CDTipus buildSamsungCD(){  
	CDTipus cds=new CDTipus();  
cds.addItem(new Samsung());  
return cds;  
}  
}
