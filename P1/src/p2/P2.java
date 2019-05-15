package p2;
        
import java.sql.Date;
import java.time.LocalDate;


public class P2 {
        
    public static void main(String[] args) {
        ReizigerOracleDaoImpl reizigerdao = new ReizigerOracleDaoImpl();
		OV_ChipkaartOracleDaoImpl ovdao = new OV_ChipkaartOracleDaoImpl();

		System.out.println(reizigerdao.getConnection());
		System.out.println(reizigerdao.findByReizigerID(2));
		System.out.println(ovdao.findByKaartnummer(46392));
                
                Date r1date = java.sql.Date.valueOf("1995-08-28");
                Reiziger r1 = new Reiziger(16, "TD", r1date ,"Schut");
                
                OV_Chipkaart chip1 = new OV_Chipkaart(68782, r1date , 2, 25);
                
                chip1.setReiziger(r1);
                ovdao.delete(chip1);
                
                System.out.println(ovdao.save(chip1));
                System.out.println("Nope");
                
                ovdao.delete(chip1);
                reizigerdao.delete(r1);
                
                System.out.println(reizigerdao.save(r1));

		System.out.println(ovdao.findAll());
    }
    
}
