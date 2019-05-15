package p3;
        
public class P3 {
        
    public static void main(String[] args) {
        ReizigerOracleDaoImpl reizigerdao = new ReizigerOracleDaoImpl();
		OV_ChipkaartOracleDaoImpl ovdao = new OV_ChipkaartOracleDaoImpl();

		System.out.println(reizigerdao.getConnection());
		System.out.println(reizigerdao.findByReizigerID(2));
		System.out.println(ovdao.findByKaartnummer(46392));

		System.out.println(ovdao.findAll());
    }
    
}
