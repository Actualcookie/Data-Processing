/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tim
 */
public class ProductDaoImpl extends OracleBaseDao implements ProductDao {

    @Override
    public List<Product> findAll() {
        Connection connection = super.getConnection();
        List<Product> producten = new ArrayList<>();
        String query = "select * from product";
        
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            Product p = new Product();
            
                try (ResultSet rs = statement.executeQuery()) {
                    
                        while (rs.next()) {
                                p.setProductNummer(rs.getInt("PRODUCTNUMMER"));
                                p.setProductNaam(rs.getString("PRODUCTNAAM"));
                                p.setBeschrijving(rs.getString("BESCHRIJVING"));
                                p.setPrijs(rs.getDouble("PRIJS"));
                                producten.add(p);
                        }
		}
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return producten;
    }
    
    public Product findByOVkaartnummer(int ovnmr){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product findByProductNummer(int prdnmr) {
        Connection connection = super.getConnection();
        Product pro = new Product();
        String query = "select * from product WHERE productnummer = '" + prdnmr + "'" ;
        
        try{
            PreparedStatement statement = connection.prepareStatement(query);
                try (ResultSet rs = statement.executeQuery()) {
                    
                    while (rs.next()) {
                            pro.setProductNummer(rs.getInt("PRODUCTNUMMER"));
                            pro.setProductNaam(rs.getString("PRODUCTNAAM"));
                            pro.setBeschrijving(rs.getString("BESCHRIJVING"));
                            pro.setPrijs(rs.getDouble("PRIJS"));
                    }
                }
            }
        catch(SQLException e){
            e.printStackTrace();
        }
        return pro;
        
    }

    @Override
    public Product save(Product prd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product update(Product prd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Product prd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Product> findProductByOvkaart(int ovkaart) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
