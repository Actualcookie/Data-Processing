/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2;

import p1.*;
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
public class OracleBaseDao {
    
    private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@//192.168.2.8:1521/xepdb1";
    private static final String DB_USER = "OVCASUS";
    private static final String DB_PASS = "ovcasus";
    private static Connection conn;
    
    public OracleBaseDao() {
		try {
			if (conn == null) {
				conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    public Connection getConnection() {

		return conn;

	}

    public void CloseConnection() throws SQLException {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
}
