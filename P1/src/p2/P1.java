package p2;

import p1.*;


        
public class P1 {
        
    public static void main(String[] args) {
        ReizigerOracleDaoImpl rgdao = new ReizigerOracleDaoImpl();
        
        Reiziger rg1 = new Reiziger();
        rg1.setNaam("tim"); rg1.setGBDatum("1990-12-23");
        
        Reiziger rg2 = new Reiziger();
        rg2.setNaam("nm"); rg2.setGBDatum("1990-12-23");
        
        Reiziger rg3 = new Reiziger();
        rg3.setNaam("Iets");
        
        rgdao.save(rg2);
        rgdao.save(rg1);
        
        System.out.println(rgdao.findall());
        
        rg1.setNaam("Tim Schut");
        rg1.setNaam(null);
        rgdao.update(rg1);
        
        System.out.println(rgdao.findall());
        
        /* Test to make sure that there can't be copies of the same thing */
        rgdao.save(rg3);rgdao.save(rg1);rgdao.save(rg3);rgdao.save(rg1);
        rgdao.save(rg3);
        System.out.println(rgdao.findall());
        
        
        
       
        /* This is to test that something cannot be deleted multiple times at random */
         rgdao.delete(rg3); rgdao.delete(rg3); rgdao.delete(rg3); rgdao.delete(rg3);
        
        System.out.println(rgdao.findall());
        
        rgdao.save(rg3);
        
        System.out.println(rgdao.findByDate("1990-12-23"));
        
        rgdao.save(rg3);
        rgdao.update(rg1); 
        rg1.setNaam("Tim Schu"); 
        rgdao.save(rg1); 
        rg1.setNaam("Tim Schut!"); 
        rgdao.update(rg1);
        rgdao.save(rg1);
        System.out.println(rgdao.findall());
        
        /* Het nullen van een Reiziger object breekt alles. 
        Dat is goed om te weten, maar ik kan er niet zo snel wat tegen doen.*/
        /*Reiziger np3 = null;
        
        rgdao.save(np3);*/
        
        
        
        
            
    }
    
}
