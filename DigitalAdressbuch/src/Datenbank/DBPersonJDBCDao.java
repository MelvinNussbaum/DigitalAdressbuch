package Datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBPersonJDBCDao implements DBPersonDao {

	private Connection con = null;

	public DBPersonJDBCDao(Connection connection) {
		con = connection;
	}

	public void insertPerson(DBPerson p) {
		try {
			String sql = "INSERT INTO person (vorname, nachname, geschlecht, telefonnummer, geburtstag, email, notizen) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getVorname());
			ps.setString(2, p.getNachname());
			ps.setString(3, p.getGeschlecht());
			ps.setString(4, p.getTelefonnummer());
			ps.setString(5, p.getGeburtstag());
			ps.setString(6, p.getEmail());
			ps.setString(7, p.getNotizen());
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		finally {
			System.out.println("Insert Complete. ");
		}
	}

	public DBPerson findPersonById(String vorname) {
		try {
			DBPerson p = null;
			String sql = "SELECT * FROM person WHERE vorname = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vorname);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
			p = new DBPerson();
			p.setId(rs.getInt("id"));
				p.setVorname(rs.getString("vorname"));
				p.setNachname(rs.getString("nachname"));
				p.setGeschlecht(rs.getString("geschlecht"));
				p.setTelefonnummer(rs.getString("telefonnummer"));
				p.setGeburtstag(rs.getString("geburtstag"));
				p.setEmail(rs.getString("email"));
				p.setNotizen(rs.getString("notizen"));
			} else {
				// throw new PersonNotFoundException();
			}
			return p;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	public List<DBPerson> getAllPersons() {
		try {
		  List<DBPerson> persons = new ArrayList<DBPerson>();
			DBPerson p = null;
			String sql = "SELECT * FROM person";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				p = new DBPerson();
				p.setId(rs.getInt("id"));
				p.setVorname(rs.getString("vorname"));
				p.setNachname(rs.getString("nachname"));
				p.setGeschlecht(rs.getString("geschlecht"));
				p.setTelefonnummer(rs.getString("telefonnummer"));
				p.setGeburtstag(rs.getString("geburtstag"));
				p.setEmail(rs.getString("email"));
				p.setNotizen(rs.getString("notizen"));
				persons.add(p);
			}
			return persons;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	public void updatePerson(DBPerson p) {
		try {
			String sql = "update person "
					+ " set notizen= spielt gerne Basketball, GZUZ"
					+ "where id = 2";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}	
			System.out.println("Update Complete. ");		
	}
}