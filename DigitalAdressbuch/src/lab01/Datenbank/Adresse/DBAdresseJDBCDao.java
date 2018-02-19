package lab01.Datenbank.Adresse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBAdresseJDBCDao implements DBAdresseDao {

	private Connection con = null;

	public DBAdresseJDBCDao(Connection connection) {
		con = connection;
	}

	public void insertAdresse(DBAdresse p) {
		try {
			String sql = "INSERT INTO adresse (strasse, postleitzahl, ort, land) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getStrasse());
			ps.setString(2, p.getPostleitzahl());
			ps.setString(3, p.getOrt());
			ps.setString(4, p.getLand());
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Insert Complete.");
		}
	}

	public List<DBAdresse> findAdresseByName(DBAdresse p) {
		try {
			List<DBAdresse> termine = new ArrayList<DBAdresse>();
			String sql = "SELECT * FROM adresse where strasse = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getStrasse());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new DBAdresse();
				p.setId(rs.getInt("id"));
				p.setStrasse(rs.getString("strasse"));
				p.setPostleitzahl(rs.getString("postleitzahl"));
				p.setOrt(rs.getString("ort"));
				p.setLand(rs.getString("land"));
				termine.add(p);}
			return termine;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	public List<DBAdresse> getAllAdresse() {
		try {
			List<DBAdresse> adresse = new ArrayList<DBAdresse>();
			DBAdresse p = null;
			String sql = "SELECT * FROM adresse";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new DBAdresse();
				p.setId(rs.getInt("id"));
				p.setStrasse(rs.getString("strasse"));
				p.setPostleitzahl(rs.getString("postleitzahl"));
				p.setOrt(rs.getString("ort"));
				p.setLand(rs.getString("land"));
				adresse.add(p);}
			return adresse;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public void deleteAdresse(DBAdresse p) {
		try {
			String sql = "DELETE FROM adresse WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, p.getId());
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Delete Complete.");
		}
	}
	
	public void updateAdresseStrasse(DBAdresse p) {
		try {
			String sql = "Update adresse set strasse = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getStrasse());
			ps.setInt(2, p.getId());
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Update Strasse Complete. ");
		}
	}
	public void updateAdressePostleitzahl(DBAdresse p) {
		try {
			String sql = "Update adresse set postleitzahl = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getPostleitzahl());
			ps.setInt(2, p.getId());
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Update Postleitzahl Complete. ");
		}
	}
	public void updateAdresseOrt(DBAdresse p) {
		try {
			String sql = "Update adresse set ort = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getOrt());
			ps.setInt(2, p.getId());
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Update Ort Complete. ");
		}
	}
	public void updateAdresseLand(DBAdresse p) {
		try {
			String sql = "Update adresse set land = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getLand());
			ps.setInt(2, p.getId());
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Update Land Complete. ");
		}
	}
	
}