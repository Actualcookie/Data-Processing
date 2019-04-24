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

    ArrayList<Reiziger> alleReizigers = new ArrayList();
    
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
           if(searchable != null && rg.getGBDatum() != null){
                if(rg.getGBDatum().equals(searchable)){
                    gbdatummatch.add(rg);
                } 
           }
        }
        return gbdatummatch;
    }

    @Override
    public Reiziger save(Reiziger reiziger) {
        
        this.update(reiziger);
        Reiziger r = this.copyReiziger(reiziger);
        
        
        if(!alleReizigers.contains(r)){
            alleReizigers.add(r);
        } 
        
        return r;
    }

    @Override
    /* Aanname:
        update zoekt naar een reiziger met een bepaalde identifier 
        en "update" deze met nieuwe informatie.*/
    public Reiziger update(Reiziger reiziger) {
        Reiziger r = new Reiziger();
        if(reiziger == null)
        {
            return r;
        }
        for(Reiziger rg : alleReizigers){
            if(reiziger.getID() == rg.getID()){
                rg.setGBDatum(reiziger.getGBDatum());
                rg.setNaam(reiziger.getNaam());
                r = this.copyReiziger(reiziger);
                break;
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
    
    private Reiziger copyReiziger(Reiziger reiziger){

        Reiziger r = new Reiziger();
        if(reiziger == null){
            return r;
        }
        r.setID(reiziger.getID());
        r.setGBDatum(reiziger.getGBDatum());
        r.setNaam(reiziger.getNaam());
        return r;
    }
    
    
    
}
