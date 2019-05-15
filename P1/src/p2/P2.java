package p2;
        
import java.sql.Date;
import java.time.LocalDate;


public class P2 {
        
    public static void main(String[] args) {
        ReizigerOracleDaoImpl reizigerdao = new p2.ReizigerOracleDaoImpl();
		OV_ChipkaartOracleDaoImpl ovdao = new OV_ChipkaartOracleDaoImpl();

		System.out.println(reizigerdao.getConnection());
		System.out.println(reizigerdao.findByReizigerID(2));
		System.out.println(ovdao.findByKaartnummer(46392));
                
                Date r1date = java.sql.Date.valueOf("1995-08-28");
                p3.Reiziger r1 = new p3.Reiziger(2, "TD", r1date ,"Schut");
                
                p3.OV_Chipkaart chip1 = new p3.OV_Chipkaart(62, r1date , 2, 25);
                chip1.setReiziger(r1);
                
                System.out.println(ovdao.save(chip1));
                
                
                
                
                System.out.println(reizigerdao.save(r1));
                
                
                
		System.out.println(ovdao.findAll());
    }
    
}
