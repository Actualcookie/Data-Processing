/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tim
 */
public class OracleDao {

    private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@//192.168.2.8:1521/xepdb1";
    private static final String DB_USER = "OVCASUS";
    private static final String DB_PASS = "ovcasus";
    private static Connection conn;
    
    protected boolean getConnection() throws SQLException {
        boolean connection = false;
        try {
            Class.forName(DB_DRIV).newInstance();
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            connection = true;
        } catch (InstantiationException ex) {
            Logger.getLogger(OracleDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(OracleDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex){
            Logger.getLogger(OracleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
       /*throw new UnsupportedOperationException("Not supported yet.");*/
    }
    
    public void closeConnection() throws SQLException{
       /* conn.close();*/
       throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
