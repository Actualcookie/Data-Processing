/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizigerDao {
	
    private List<Reiziger> reizigers = new ArrayList<>();
    OV_ChipkaartOracleDaoImpl ovdao = new OV_ChipkaartOracleDaoImpl();

    @Override
	public List<Reiziger> findAll() {
		Connection connection = super.getConnection();
		List<Reiziger> allereizigers = new ArrayList<>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * "
                                        + "FROM reiziger");
                        
			while (rs.next()) {
				Reiziger rei = new Reiziger();
				rei.setID(rs.getInt("reizigerid"));
				rei.setNaam(rs.getString("achternaam"));
				rei.setGBdatum(rs.getDate("gebortedatum"));
				List<OV_Chipkaart> OVChipkaarten = ovdao.findByReiziger(rei);
				for (OV_Chipkaart ov : OVChipkaarten) {
					rei.addMijnOvchipkaart(ov);
				}
				allereizigers.add(rei);

			}
			return allereizigers;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Reiziger> findByReizigerID(int ReizigerID) {
		Connection connection = super.getConnection();
		List<Reiziger> allereizigers = new ArrayList<>();
                
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * "
                                + "FROM reiziger "
                                + "WHERE reizigerId =" + ReizigerID);
                        
			while (rs.next()) {
				Reiziger rei = new Reiziger();
				rei.setID(rs.getInt("reizigerid"));
				rei.setNaam(rs.getString("achternaam"));
				rei.setGBdatum(rs.getDate("gebortedatum"));
				rei.setVoorletter(rs.getString("voorletters"));
				allereizigers.add(rei);
			}
			return allereizigers;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	};

	public List<Reiziger> findByGBdatum(String GBdatum) {
		Connection connection = super.getConnection();
		List<Reiziger> allereizigers = new ArrayList<>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * "
                                + "FROM reiziger "
                                + "WHERE gebortedatum ='" 
                                + GBdatum + "'");
                        
			while (rs.next()) {
				Reiziger rei = new Reiziger();
				rei.setID(rs.getInt("reizigerid"));
				rei.setNaam(rs.getString("achternaam"));
				rei.setGBdatum(rs.getDate("gebortedatum"));
				allereizigers.add(rei);

			}
			return allereizigers;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Reiziger save(Reiziger reiziger) {
		Connection connection = super.getConnection();
                int id = reiziger.getID();
                String vrltr = reiziger.getVoorletter();
                String nm = reiziger.getNaam();
                Date gb = reiziger.getGBdatum();
                
                String start = "INSERT INTO reiziger (REIZIGERID, VOORLETTERS, ACHTERNAAM, GEBORTEDATUM) VALUES(";
                String stat = start + id + ", '" + vrltr + "', '" + nm + "', '" + gb + "')";

		try {
                    PreparedStatement statement = connection.prepareStatement(stat);
                    statement.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reiziger;

	}

        @Override
	public Reiziger update(Reiziger reiziger) {
		Connection connection = super.getConnection();

		try {
			String statementstring = "UPDATE reiziger "
                                + "SET achternaam = '" + reiziger.getNaam()
				+ "', gebortedatum = ? " + "where reizigerId= "
				+ reiziger.getID();

			System.out.println(statementstring);

			PreparedStatement statement = connection.prepareStatement(statementstring);
			statement.setDate(1, new java.sql.Date(reiziger.getGBdatum().getTime()));
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reiziger;

	}

        @Override
	public boolean delete(Reiziger reiziger) {
		Connection connection = super.getConnection();
                boolean temp = false;

		try {
			Statement statement = connection.createStatement();
			statement.executeQuery("DELETE FROM reiziger where reizigerid = " + reiziger.getID());
                        temp = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

    @Override
    public void closeConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}