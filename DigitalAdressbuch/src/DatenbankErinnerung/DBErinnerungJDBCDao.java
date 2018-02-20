package DatenbankErinnerung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBErinnerungJDBCDao implements DBErinnerungDao {

	private Connection con = null;

	public DBErinnerungJDBCDao(Connection connection) {
		con = connection;
	}

	public void insertErinnerung(DBErinnerung p) {
		try {
			String sql = "INSERT INTO erinnerungen (zeit, datum, erinnerungsname, erledigt) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getZeit());
			ps.setString(2, p.getDatum());
			ps.setString(3, p.getErinnerungsname());
			ps.setBoolean(4, p.isErledigt());
			ps.executeUpdate();							/*Die Insertmethode, um eine Person in eine Datenbank hinzufügen können*/
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Insert Complete.");
		}
	}

	public List<DBErinnerung> findErinnerungByName(DBErinnerung p) {
		try {
			List<DBErinnerung> erinnerungen = new ArrayList<DBErinnerung>();
			String sql = "SELECT * FROM erinnerungen where erinnerungsname = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getErinnerungsname());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new DBErinnerung();
				p.setId(rs.getInt("id"));				/*Mit dieser Methode kann man nach einem Erinnerungsname suchen, danach werden alle dazugehörigen Attribute angezeigt*/
				p.setZeit(rs.getString("zeit"));
				p.setDatum(rs.getString("datum"));
				p.setErinnerungsname(rs.getString("erinnerungsname"));
				erinnerungen.add(p);}
			return erinnerungen;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	public List<DBErinnerung> getAllErinnerung() {
		try {
			List<DBErinnerung> erinnerungen = new ArrayList<DBErinnerung>();
			DBErinnerung p = null;
			String sql = "SELECT * FROM erinnerungen";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new DBErinnerung();
				p.setId(rs.getInt("id"));				/*Mit dieser Methode werden alle Erinnerungen aufgelistet*/
				p.setZeit(rs.getString("zeit"));
				p.setDatum(rs.getString("datum"));
				p.setErinnerungsname(rs.getString("erinnerungsname"));
				p.setErledigt(rs.getBoolean("erledigt"));
				erinnerungen.add(p);}
			return erinnerungen;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	public void deleteErinnerung(DBErinnerung p) {
		try {
			String sql = "DELETE FROM erinnerungen WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, p.getId());
			ps.executeUpdate();							/*Mit dieser Methode kann man eine Erinnerung löschen*/
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Delete Complete.");
		}
	}
	public void updateErinnerungZeit(DBErinnerung p) {
		try {
			String sql = "Update erinnerungen set zeit = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getZeit());
			ps.setInt(2, p.getId());					/*Mit dieser Methode kann man die Zeit einer Erinnerung bearbeiten / ändern*/
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Update Zeit Complete. ");
		}
	}
	public void updateErinnerungDatum(DBErinnerung p) {
		try {
			String sql = "Update erinnerungen set datum = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getDatum());
			ps.setInt(2, p.getId());
			ps.executeUpdate();							/*Mit dieser Methode kann man das Datum einer Erinnerung bearbeiten / ändern*/
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Update Datum Complete. ");
		}
	}
	public void updateErinnerungName(DBErinnerung p) {
		try {
			String sql = "Update erinnerungen set erinnerungsname = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getErinnerungsname());
			ps.setInt(2, p.getId());
			ps.executeUpdate();							/*Mit dieser Methode kann man den Namen einer Erinnerung bearbeiten / ändern*/
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Update Erinnerungsname Complete. ");
		}
	}
	public void updateErledigt(DBErinnerung p) {
		try {
			String sql = "Update erinnerungen set erledigt = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setBoolean(1, p.isErledigt());
			ps.setInt(2, p.getId());
			ps.executeUpdate();							/*Mit dieser Methode kann man den Namen einer Erinnerung bearbeiten / ändern*/
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Update erledigt Complete. ");
		}
	}
}