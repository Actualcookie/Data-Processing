/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3;

/**
 *
 * @author Tim
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OV_ChipkaartOracleDaoImpl extends OracleBaseDao {
    
	public List<OV_Chipkaart> findAll() {
		Connection connection = super.getConnection();
		List<OV_Chipkaart> alleOVChipkaarten = new ArrayList<>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM ov_chipkaart");
			while (rs.next()) {
				OV_Chipkaart ov = new OV_Chipkaart();
				ov.setKaartnummer(rs.getInt("kaartnummer"));
				ov.setKlasse(rs.getInt("klasse"));
				ov.setGeldigTot(rs.getDate("geldigtot"));
				ov.setSaldo(rs.getBigDecimal("saldo"));
				alleOVChipkaarten.add(ov);

			}
			return alleOVChipkaarten;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<OV_Chipkaart> findByKaartnummer(int kaartnummer) {
		Connection connection = super.getConnection();
		List<OV_Chipkaart> alleOVChipkaarten = new ArrayList<>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM ov_chipkaart WHERE kaartnummer ='" + kaartnummer + "'");
			while (rs.next()) {
				OV_Chipkaart ov = new OV_Chipkaart();
				ov.setKaartnummer(rs.getInt("kaartnummer"));
				ov.setKlasse(rs.getInt("klasse"));
				ov.setGeldigTot(rs.getDate("geldigtot"));
				ov.setSaldo(rs.getBigDecimal("saldo"));
				alleOVChipkaarten.add(ov);

			}
			return alleOVChipkaarten;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean save(OV_Chipkaart OVChipkaart) {
		Connection connection = super.getConnection();
                
                boolean saved = false;
                
                int kaartnummer = OVChipkaart.getKaartnummer();
                int klasse = OVChipkaart.getKlasse();
                Number saldo = OVChipkaart.getSaldo();
                Date geldigdatum = OVChipkaart.getGeldigTot();
                
                if(OVChipkaart.getReiziger()== null)
                {
                    return saved;
                }   
                
                Reiziger id = OVChipkaart.getReiziger();
                String query = "insert into ov_chipkaart(kaartnummer, klasse, saldo,geldigtot, reizigerid) values("
					+ kaartnummer + "," + klasse  + "," + saldo
					+ ",To_date('" + geldigdatum + "','yyyy-mm-dd')," + id.getID()
					+ ")";
                
		try {
			Statement statement = connection.createStatement();
			
			System.out.println(query);
			statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return saved;

	}

	public List<OV_Chipkaart> findByReiziger(Reiziger ReizigerID) {
		Connection connection = super.getConnection();
		List<OV_Chipkaart> alleOVChipkaarten = new ArrayList<>();

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM ov_chipkaart WHERE reizigerId ='" + ReizigerID.getID() + "'");
			while (rs.next()) {
				OV_Chipkaart OV = new OV_Chipkaart();
				OV.setKaartnummer(rs.getInt("kaartnummer"));
				OV.setKlasse(rs.getInt("klasse"));
				OV.setGeldigTot(rs.getDate("geldigtot"));
				OV.setSaldo(rs.getBigDecimal("saldo"));
				alleOVChipkaarten.add(OV);

			}
			return alleOVChipkaarten;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	};

	public OV_Chipkaart update(OV_Chipkaart OVChipkaart) {
		Connection connection = super.getConnection();

		try {
			String statementString = "update ov_chipkaart set  klasse= " + OVChipkaart.getKlasse()
					+ ", geldigtot = To_date('" + OVChipkaart.getGeldigTot() + "','yyyy-mm-dd'), saldo = "
					+ OVChipkaart.getSaldo() + " where kaartnummer=" + OVChipkaart.getKaartnummer();

			System.out.println(statementString);

			PreparedStatement stmt = connection.prepareStatement(statementString);
			int a = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return OVChipkaart;

	}

	public OV_Chipkaart delete(OV_Chipkaart OVChipkaart) {
		Connection connection = super.getConnection();

		try {
			Statement stmt = connection.createStatement();
			stmt.executeQuery("delete from ov_chipkaart where kaartnummer = " + OVChipkaart.getKaartnummer());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return OVChipkaart;

	}
}
    

