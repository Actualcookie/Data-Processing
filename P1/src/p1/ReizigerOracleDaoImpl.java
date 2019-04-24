/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tim
 * Aangezien 
 */

public class ReizigerOracleDaoImpl /*extends OracleDao*/ implements ReizigerDAO  {

    ArrayList<Reiziger> alleReizigers;
    
    @Override
    public List<Reiziger> findall() {
        return alleReizigers;
    }

    @Override
    /*Aanname:
        findByDate moet een lijst 
        van alle reizigers opleveren met geboortedatums gelijk aan gbdatum.
    */
    public List<Reiziger> findByDate(String gbdatum) {
        Date searchable = java.sql.Date.valueOf(gbdatum);
        ArrayList <Reiziger> gbdatummatch = new ArrayList();
        for(Reiziger rg : alleReizigers){
            if(rg.getGBDatum().equals(searchable)){
                gbdatummatch.add(rg);
            } 
        }
        return gbdatummatch;
    }

    @Override
    public Reiziger save(Reiziger reiziger) {
        alleReizigers.add(reiziger);
        return reiziger;
    }

    @Override
    /* Aanname:
        update zoekt naar een reiziger met een bepaalde identifier 
        "update" deze met nieuwe informatie.*/
    public Reiziger update(Reiziger reiziger) {
        Reiziger r = reiziger;
        for(Reiziger rg : alleReizigers){
            if(r.getID() == rg.getID()){
                alleReizigers.remove(rg);
                alleReizigers.add(r);
            }
        }
        return r;
    }

    @Override
    public boolean delete(Reiziger reiziger) {
        boolean deleted = false;
        if(alleReizigers.contains(reiziger)){
            alleReizigers.remove(reiziger);
            deleted = true;
        }        
        return deleted;
    }

    @Override
    public void closeConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
