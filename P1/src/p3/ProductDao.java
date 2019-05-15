/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tim
 */
public interface ProductDao {
        public List<Product> findAll();
	public Product findByProductNummer(int productNummer);
	public Product save(Product product);
	public Product update(Product reiziger);
	public boolean delete(Product reiziger);
	public void closeConnection();
	public ArrayList<Product> findProductByOvkaart(int ovkaart);
}
