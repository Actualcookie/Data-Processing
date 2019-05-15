/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2;

import java.util.List;

/**
 *
 * @author Tim
 */
public interface ReizigerDao {
    public List<Reiziger> findAll();
    
    public List<Reiziger> findByGBdatum(String GBDatum);
    
    public Reiziger save(Reiziger reiziger);
    
    public Reiziger update(Reiziger reiziger);
    
    public boolean delete(Reiziger reiziger);
    
    public void closeConnection();
}
