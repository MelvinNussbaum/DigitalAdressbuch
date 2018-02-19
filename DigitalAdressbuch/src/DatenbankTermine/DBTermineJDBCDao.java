package DatenbankTermine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBTermineJDBCDao implements DBTermineDao {

	private Connection con = null;

	public DBTermineJDBCDao(Connection connection) {
		con = connection;
	}

	public void insertTermine(DBTermine p) {
		try {
			String sql = "INSERT INTO termine (startzeit, endzeit, terminname, relevanz) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getStartzeit());
			ps.setString(2, p.getEndzeit());
			ps.setString(3, p.getTerminname());
			ps.setString(4, p.getRelevanz());
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Insert Complete.");
		}
	}

	public List<DBTermine> findTermineByName(DBTermine p) {
		try {
			List<DBTermine> persons = new ArrayList<DBTermine>();
			String sql = "SELECT * FROM termine where terminname = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getTerminname());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new DBTermine();
				p.setId(rs.getInt("id"));
				p.setStartzeit(rs.getString("startzeit"));
				p.setEndzeit(rs.getString("endzeit"));
				p.setTerminname(rs.getString("terminname"));
				p.setRelevanz(rs.getString("relevanz"));
				persons.add(p);}
			return persons;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	public List<DBTermine> getAllTermine() {
		try {
			List<DBTermine> termine = new ArrayList<DBTermine>();
			DBTermine p = null;
			String sql = "SELECT * FROM termine";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new DBTermine();
				p.setId(rs.getInt("id"));
				p.setStartzeit(rs.getString("startzeit"));
				p.setEndzeit(rs.getString("endzeit"));
				p.setTerminname(rs.getString("terminname"));
				p.setRelevanz(rs.getString("relevanz"));
				termine.add(p);}
			return termine;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public void deleteTermine(DBTermine p) {
		try {
			String sql = "DELETE FROM termine WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, p.getId());
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Delete Complete.");
		}
	}
	
	public void updateTermineStartzeit(DBTermine p) {
		try {
			String sql = "Update termine set startzeit = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getStartzeit());
			ps.setInt(2, p.getId());
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Update Startzeit Complete. ");
		}
	}
	public void updateTermineEndzeit(DBTermine p) {
		try {
			String sql = "Update termine set endzeit = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getEndzeit());
			ps.setInt(2, p.getId());
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Update endzeit Complete. ");
		}
	}
	public void updateTermineName(DBTermine p) {
		try {
			String sql = "Update termine set terminname = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getTerminname());
			ps.setInt(2, p.getId());
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Update Terminname Complete. ");
		}
	}
	public void updateTermineRelevanz(DBTermine p) {
		try {
			String sql = "Update termine set relevanz = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getRelevanz());
			ps.setInt(2, p.getId());
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			System.out.println("Update Relevanz Complete. ");
		}
	}
	
}